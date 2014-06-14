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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
    
   
     @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute Pouzivatelia user) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");
        
        Map<String, Object> model = new HashMap<String, Object>();
        
        List<Nastavenie> nast = nastavenieService.getEntites();
        List<KrvnaSkupina> krv = krvnaSkupinaService.getEntites();
        List<Mesto> mesto = mestoService.getEntites();
        modelAndView.addObject("nast", nast);
        modelAndView.addObject("krv", krv);
        modelAndView.addObject("mesto", mesto);
        
        
        pouzivateliaService.addEntity(user);
        
        
        List<Pouzivatelia> users = pouzivateliaService.getEntites();
       // List<Pouzivatelia> vyjazdy = vyjazdovyOdberService.getEntites();
        
        modelAndView.addObject("users", users);

        String message = "Vyjazd pridaný.";
        modelAndView.addObject("message", message);

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
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/add-user");
        
        modelAndView.addObject("user", new Pouzivatelia());
        return modelAndView;
    }

   

    
    
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

        String message = "Pouťívateľ úspešne upravený.";
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
