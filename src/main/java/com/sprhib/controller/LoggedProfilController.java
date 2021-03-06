package com.sprhib.controller;


import com.sprhib.model.Adresa;
import com.sprhib.model.Kraj;
import com.sprhib.model.KrvnaSkupina;
import com.sprhib.model.Mesto;
import com.sprhib.model.Nastavenie;
import com.sprhib.model.Odber;
import com.sprhib.model.Pouzivatelia;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.service.EntityNastavenieService;
import com.sprhib.service.EntityOdberService;
import com.sprhib.service.EntityPouzivateliaService;
import com.sprhib.service.EntityService;
import com.sprhib.service.EntityVyjazdovyOdberService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/logged/profil")
public class LoggedProfilController {
    
   // @Autowired
   // private EntityService<Nastavenie> nastavenieService;
    
    @Autowired
    private EntityOdberService<Odber> odberService;
    
     @Autowired
    private EntityService<Pouzivatelia> pouzivateliaService;
     
     @Autowired
     private EntityNastavenieService<Nastavenie> nastavenieService;
     
      @Autowired
    private EntityService<Kraj> krajService;
    
    @Autowired
    private EntityService<KrvnaSkupina> krvnaSkupinaService;
    
    @Autowired
    private EntityService<Mesto> mestoService;
    
    @Autowired
    private EntityService<Adresa> adresaService;
    
    
    @Autowired
    private EntityVyjazdovyOdberService<VyjazdovyOdber> vyjazdovyOdberService;
    


    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public ModelAndView profilPage() {
        ModelAndView model = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        String logNickSend = userDetails.getUsername();
        Integer userID = odberService.getUserIDfromNick(logNickSend);
        
        List<String> menakrajov = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
  
        //--->
        List<Pouzivatelia> mojeNastavenie = nastavenieService.getPouzivatelaList(userID);
        int idNastavenia = 0;
        for(Pouzivatelia s : mojeNastavenie){
                idNastavenia = s.getIdNastavenie().getIdNastavenie();
            }
        model.addObject("idNastavenia", idNastavenia);
        
        Nastavenie object = nastavenieService.getEntity(idNastavenia);
        model.addObject("object", object);
        
        List<Nastavenie> konkretneNastavenie = nastavenieService.getMojeSetings(idNastavenia);
        for (Nastavenie s : konkretneNastavenie) {
            

            if (s.getMojeOdbery() == true) {
                menakrajov.add("zapnuté");
                model.addObject("odber", "zapnuté");
            } else {
                menakrajov.add("vypnuté");
                model.addObject("odber", "vypnuté");
            }
            
            
            if (s.getVyjazdoveOdbery() == true) {
                menakrajov.add("zapnuté");
                model.addObject("vyjazd", "zapnuté");
            } else {
                menakrajov.add("vypnuté");
                model.addObject("vyjazd", "vypnuté");
            }
            
        
            if (s.getUrgentnePripady() == true) {
                menakrajov.add("zapnuté");
                model.addObject("urgent", "zapnuté");
            } else {
                menakrajov.add("vypnuté");
                model.addObject("urgent", "vypnuté");
            }
            
            
           if (s.getKraj() == true) {
                menakrajov.add("zapnuté");
                model.addObject("kraj", "zapnuté");
            } else {
                menakrajov.add("vypnuté");
                model.addObject("kraj", "vypnuté");
            }
           
        }
        
      
            
            for(String s : menakrajov){
                list.add(s);
                System.out.println("PATO :: :" + s.toString());
            }
        model.addObject("list", list); 
        
        //<---
        model.setViewName("default/profil");
        return model;
    }
    
    @RequestMapping(value = { "/{id}", "{id}" }, method = RequestMethod.POST)
    public ModelAndView profilAddingPage(
            @ModelAttribute Nastavenie object,
            @PathVariable Integer id) {
        
        ModelAndView model = new ModelAndView();
        
        nastavenieService.updateEntity(object);
        List<Nastavenie> stats = nastavenieService.getEntites();
        
        model.addObject("message", "Nastavenia zmenené!"); 
        
      
        model.setViewName("default/profil");
        return model;
    }
    
    
   
    @RequestMapping(value = "/odber/historia", method = RequestMethod.GET)
    public ModelAndView odberHistoryPage() {
        
        ModelAndView model = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        String logNickSend = userDetails.getUsername();
        Integer userID = odberService.getUserIDfromNick(logNickSend);
       
        List<Odber> mojeOdbery = odberService.getMojeOdberyHistory(userID);
        int pocet = mojeOdbery.size();

        model.addObject("pocet", pocet); 
        model.addObject("mojeOdbery", mojeOdbery);
        model.setViewName("darca/moje_odbery");

        return model;
    }
    
    
    @RequestMapping(value = "/odber/najblizsie", method = RequestMethod.GET)
    public ModelAndView odberPripomienkovacPage() {
        ModelAndView model = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        String logNickSend = userDetails.getUsername();
        Integer userID = odberService.getUserIDfromNick(logNickSend);
        
        List<Odber> mojeOdbery = odberService.getLastOdber(userID);
        Date timestamp, povodny;
        Date currentDate = new Date();
        timestamp = mojeOdbery.get(0).getDatum();
        
        
        System.out.println("timestamp moj: " + timestamp);
        povodny = timestamp;
        
        int daysPause = 0;
        if(pouzivateliaService.getEntity(userID).getPohlavie() == 'M'){
            daysPause = 30+31+30;
            System.out.println("si muz");
        }
        else{
            daysPause = 30+31+30+31;
            System.out.println("si zena");
        }
        
   
        Calendar c = Calendar.getInstance();
        c.setTime(timestamp);
        c.add(Calendar.DATE, daysPause);
        timestamp = c.getTime();
        
//        System.out.println("NEXT : " + timestamp);
//        System.out.println("DATE : " + timestamp.getDate());
//        System.out.println("MESIAC : " + timestamp.getMonth());
//        System.out.println("DEN : " + timestamp.getDay());
        
        model.addObject("datumd", timestamp.getDate());
        model.addObject("mesiac", timestamp.getMonth());
        model.addObject("den", timestamp.getDay());
        
        final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
                
     
       Calendar cal = Calendar.getInstance();
        Calendar date = (Calendar) cal.clone();
        long daysBetween = 0;
        int rozdielDni = (int)((timestamp.getTime() - currentDate.getTime()) / (1000*60*60*24l));
        model.addObject("daysBetween", rozdielDni);
        System.out.println("moj pocet: " + rozdielDni);
        
        model.setViewName("darca/pripomienkovac");
        return model;
    }
    
    @RequestMapping(value = "/passw_rst", method = RequestMethod.GET)
    public ModelAndView passwResetPage() {
        ModelAndView model = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        String logNickSend = userDetails.getUsername();
        Integer userID = odberService.getUserIDfromNick(logNickSend);
        
        
        Pouzivatelia user = pouzivateliaService.getEntity(userID);
        List<Nastavenie> nast = nastavenieService.getEntites();
        List<KrvnaSkupina> krv = krvnaSkupinaService.getEntites();
        List<Mesto> mesta = mestoService.getEntites();
        List<Adresa> adresy = adresaService.getEntites();
        
        
        String finall, output = user.getDatumNarodenia().toString();
        
        
        finall = output.substring(8, 10) + "/" + output.substring(5, 7) + "/" + output.substring(0, 4);
        
        
       // System.out.println("finall " + finall);
        
        model.addObject("finall", finall);
        model.addObject("nast", nast);
        model.addObject("krv", krv);
        model.addObject("mesta", mesta);
        model.addObject("adresy", adresy);
        
        model.addObject("user", user);
        
        model.setViewName("darca/reset_hesla");
        return model;
    }  
    
     @RequestMapping(value = "/passw_rst/{id}", method = RequestMethod.POST)
    public ModelAndView passwResetChangedPage(
            @ModelAttribute Pouzivatelia user,
            @PathVariable Integer id) {
        ModelAndView model = new ModelAndView();
        
        pouzivateliaService.updateEntity(user);
        
        List<Pouzivatelia> users = pouzivateliaService.getEntites();
        model.addObject("users", users);
        
        String message = "Heslo zmenené.";
        
     
        model.addObject("message", message);
        model.setViewName("home");
        return model;
    }  
    


}
