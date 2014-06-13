package com.sprhib.controller;

import com.sprhib.model.Kraj;
import com.sprhib.model.Pouzivatelia;

import com.sprhib.model.Stat;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.model.ZaznamDarcu;
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
@RequestMapping(value="/logged/darca")
public class LoggedDarcaController {
 
//    @Autowired
//    private EntityService<ZaznamDarcu> zaznamService;
//    
//    @Autowired
//    private EntityService<Pouzivatelia> pouzivateliaService;
//    
    @Autowired
    private EntityVyjazdovyOdberService<VyjazdovyOdber> vyjazdovyOdberService;
    @RequestMapping(value = "/poznamky", method = RequestMethod.GET)
    public ModelAndView darcaPoznamky() {
        ModelAndView modelAndView = new ModelAndView("darca/poznamky");
        
//        List<ZaznamDarcu> zaznamy = zaznamService.getEntites();
        //List<Pouzivatelia> zaznamy = pouzivateliaService.getEntites();
        
        
       
        
       // modelAndView.addObject("zaznamy", zaznamy);
        
        return modelAndView;
    }   
    
}
