package com.sprhib.controller;

import com.sprhib.model.Kraj;
import com.sprhib.model.Pouzivatelia;

import com.sprhib.model.Stat;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.service.EntityService;
import com.sprhib.service.EntityVyjazdovyOdberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private EntityVyjazdovyOdberService<VyjazdovyOdber> vyjazdovyOdberService;

    //ODBEROVE MIESTA        
    @RequestMapping(value = "/vyjazd/add", method = RequestMethod.GET)
    public ModelAndView addVyjazdPage() {
        ModelAndView modelAndView = new ModelAndView("vyjazd/add-vyjazd");
        
        modelAndView.addObject("vyjazd", new VyjazdovyOdber());
        return modelAndView;
    }

    @RequestMapping(value = "/vyjazd/add", method = RequestMethod.POST)
    public ModelAndView addingVyjazd(@ModelAttribute VyjazdovyOdber vyjazd) {
        ModelAndView modelAndView = new ModelAndView("vyjazd/list-vyjazd");
        
        vyjazdovyOdberService.addEntity(vyjazd);
        
        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);

        String message = "Vyjazd pridaný.";
        modelAndView.addObject("message", message);

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
        
        modelAndView.addObject("vyjazd", new VyjazdovyOdber());
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute VyjazdovyOdber vyjazd) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");
        
        vyjazdovyOdberService.addEntity(vyjazd);
        
        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);

        String message = "Vyjazd pridaný.";
        modelAndView.addObject("message", message);

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
        
        VyjazdovyOdber vyjazd = vyjazdovyOdberService.getEntity(id);
        
        modelAndView.addObject("vyjazd", vyjazd);
        return modelAndView;
    }

    
    
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingUser(@ModelAttribute VyjazdovyOdber vyjazd, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("pouzivatelia/list-user");

        vyjazdovyOdberService.updateEntity(vyjazd);
        
        List<VyjazdovyOdber> vyjazdy = vyjazdovyOdberService.getEntites();
        modelAndView.addObject("vyjazdy", vyjazdy);

        String message = "Stat was successfully edited.";
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
