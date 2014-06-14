package com.sprhib.controller;

import com.sprhib.model.Adresa;
import com.sprhib.model.Kraj;
import com.sprhib.model.KrvnaSkupina;
import com.sprhib.model.Mesto;
import com.sprhib.model.Nastavenie;
import com.sprhib.model.Pouzivatelia;

import com.sprhib.model.Stat;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.service.EntityNastavenieService;
import com.sprhib.service.EntityService;
import com.sprhib.service.EntityVyjazdovyOdberService;
import static java.lang.ProcessBuilder.Redirect.to;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/logged/lekar")
public class LoggedLekarController {
 
    @Autowired
    private EntityService<Kraj> krajService;
    
    @Autowired
    private EntityService<Pouzivatelia> pouzivateliaService;
    
    @Autowired
    private EntityNastavenieService<Nastavenie> nastavenieService;
    
    @Autowired
    private EntityService<KrvnaSkupina> krvnaSkupinaService;
    
    @Autowired
    private EntityService<Mesto> mestoService;
    
    @Autowired
    private EntityService<Adresa> adresaService;
    
    
    @Autowired
    private EntityVyjazdovyOdberService<VyjazdovyOdber> vyjazdovyOdberService;
    
   
    
//    
//    @Autowired
//    private SendEmailController emailController;
    
    
     @RequestMapping(value = "/notify", method = RequestMethod.GET)
    public ModelAndView mailSender() {
        ModelAndView modelAndView = new ModelAndView("default/mailsender");
        
         
         //emailController.sendMail("novotny.patrick@gmail.com", "Test Subject", "Testing body");
        /*
        String from = "novotny.patrick@gmail.com";
        String to = "novotny.patrick@gmail.com";
        String subject = "test";
        String msg = "sprava msg";
       
        //creating message  
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom(from);  
        message.setTo(to);  
        message.setSubject(subject);  
        message.setText(msg);  
        //sending message  
        mailSender.send(message);   
        //emailController.sendMail("novotny.patrick@gmail.com", "test", "sprava msg");
        */
        
         final String username = "novotny.patrick@gmail.com";
         final String password = "agcglxkzilecidaz";

         Properties props = new Properties();
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.port", "587");

         Session session = Session.getInstance(props,
                 new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(username, password);
                     }
                 });

         try {

             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress("novotny.patrick@gmail.com"));
             message.setRecipients(Message.RecipientType.TO,
                     InternetAddress.parse("novotny.patrick@gmail.com"));
             message.setSubject("Testing Subject");
             message.setText("Dear Mail Crawler,"
                     + "\n\n No spam to my email, please!");

             Transport.send(message);

             System.out.println("Done");

         } catch (MessagingException e) {
             throw new RuntimeException(e);
         }
        
        
        
        System.out.println("success");  
        return modelAndView;
    }
    
    
    
    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    public ModelAndView mailSendering() {
        ModelAndView modelAndView = new ModelAndView("default/mailsender");
        
        

        return modelAndView;
    }
   
    
    
     @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView addingUser(
            @ModelAttribute Pouzivatelia user) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");
        
        pouzivateliaService.addEntity(user);
        
                  
       List<Nastavenie> nast = nastavenieService.getEntites();
        List<KrvnaSkupina> krv = krvnaSkupinaService.getEntites();
        List<Mesto> mesto = mestoService.getEntites();
        List<Pouzivatelia> users = pouzivateliaService.getEntites();
        modelAndView.addObject("nast", nast);
        modelAndView.addObject("krv", krv);
        modelAndView.addObject("mesto", mesto);
        modelAndView.addObject("users", users);
        
        
        String message = "Používatľ bol pridaný.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }
    
    
      @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/add-user");
        
        List<Nastavenie> nast = nastavenieService.getEntites();
        List<KrvnaSkupina> krv = krvnaSkupinaService.getEntites();
        List<Mesto> mesta = mestoService.getEntites();
        List<Adresa> adresy = adresaService.getEntites();
        
        Nastavenie nove = new Nastavenie();
         nove.setKraj(true);
        nove.setMojeOdbery(true);
        nove.setUrgentnePripady(true);
        nove.setVyjazdoveOdbery(true);        
        nastavenieService.addEntity(nove);
        
        
        modelAndView.addObject("nast", nast);
        modelAndView.addObject("krv", krv);
        modelAndView.addObject("mesta", mesta);
        modelAndView.addObject("adresy", adresy);
        
        modelAndView.addObject("nove", nove);
        modelAndView.addObject("user", new Pouzivatelia());
        
        return modelAndView;
    }
    
    
    
    
    
     @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
    
    
    //ODBEROVE MIESTA        
    @RequestMapping(value = "/vyjazd/add", method = RequestMethod.GET)
    public ModelAndView addVyjazdPage() {
        ModelAndView modelAndView = new ModelAndView("vyjazd/add-vyjazd");
        
        modelAndView.addObject("vyjazd", new VyjazdovyOdber());
        return modelAndView;
    }

    @RequestMapping(value = "/vyjazd/add", method = RequestMethod.POST)
    public ModelAndView addingVyjazd(@ModelAttribute VyjazdovyOdber vyjazd) {
        ModelAndView modelAndView = new ModelAndView("home");
        
        
        System.out.println(vyjazd.getDatum());
        vyjazdovyOdberService.addEntity(vyjazd);
        
        
       // List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        //modelAndView.addObject("vyjazdy", vyjazdy);

        String message = "Vyjazd pridaný.";
        //modelAndView.addObject("message", message);

        return modelAndView;
    }

    
    
    @RequestMapping(value = "/vyjazd/list")
    public ModelAndView listOfVyjazds() {
        ModelAndView modelAndView = new ModelAndView("vyjazd/list-vyjazd");

        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);

        return modelAndView;
    }

    
    
    @RequestMapping(value = "/vyjazd/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editVyjazdPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("vyjazd/edit-vyjazd");
        
        VyjazdovyOdber vyjazd = vyjazdovyOdberService.getEntity(id);
        
        modelAndView.addObject("vyjazd", vyjazd);
        return modelAndView;
    }

    
    
    @RequestMapping(value = "/vyjazd/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingVyjazd(
            @ModelAttribute VyjazdovyOdber vyjazd, 
            @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");

        vyjazdovyOdberService.updateEntity(vyjazd);
        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);

        String message = "Stat was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/vyjazd/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteVyjazd(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("vyjazd/list-vyjazd");
        
        vyjazdovyOdberService.deleteEntity(id);
        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);
        System.out.println("dfdfgbf");
        
        String message = "Stat was successfully deleted.";
        modelAndView.addObject("message", message);
        
        return modelAndView;
    }   
    //END ODBEROVE MIESTA
    
    
    
    
    
    
    //ODBEROVE MIESTA        
  

   

    
    
    @RequestMapping(value = "/user/list")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");

        
        
        List<Pouzivatelia> users = pouzivateliaService.getEntites();
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    
    
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/edit-user");
        
        Pouzivatelia user = pouzivateliaService.getEntity(id);
        List<Nastavenie> nast = nastavenieService.getEntites();
        List<KrvnaSkupina> krv = krvnaSkupinaService.getEntites();
        List<Mesto> mesta = mestoService.getEntites();
        List<Adresa> adresy = adresaService.getEntites();
        
        
        modelAndView.addObject("nast", nast);
        modelAndView.addObject("krv", krv);
        modelAndView.addObject("mesta", mesta);
        modelAndView.addObject("adresy", adresy);
        
        
        
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    
    
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingUser(@ModelAttribute Pouzivatelia user, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");

        pouzivateliaService.updateEntity(user);
        
        List<Pouzivatelia> users = pouzivateliaService.getEntites();
        modelAndView.addObject("users", users);

        String message = "Používateľ úspešne upravený.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");
        
        vyjazdovyOdberService.deleteEntity(id);
        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);
        System.out.println("dfdfgbf");
        
        String message = "Stat was successfully deleted.";
        modelAndView.addObject("message", message);
        
        return modelAndView;
    }   
    //END ODBEROVE MIESTA
    
}
