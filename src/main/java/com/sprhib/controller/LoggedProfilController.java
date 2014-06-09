package com.sprhib.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/logged/profil")
public class LoggedProfilController {


    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public ModelAndView profilPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("default/profil");

        return model;
    }
    
   
    @RequestMapping(value = "/odber/historia", method = RequestMethod.GET)
    public ModelAndView odberHistoryPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("darca/moje_odbery");

        return model;
    }
    
//    @RequestMapping(value = "/odber/pocitadlo", method = RequestMethod.GET)
//    public ModelAndView odberPocitadloPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.setViewName("darca/pocitadlo_odberov");
//
//        return model;
//    }
    
    @RequestMapping(value = "/odber/najblizsie", method = RequestMethod.GET)
    public ModelAndView odberPripomienkovacPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("darca/pripomienkovac");

        return model;
    }
    
    @RequestMapping(value = "/passw_rst", method = RequestMethod.GET)
    public ModelAndView passwResetPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("darca/reset_hesla");

        return model;
    }        

}
