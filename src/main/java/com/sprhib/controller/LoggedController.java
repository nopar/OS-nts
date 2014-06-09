package com.sprhib.controller;

import com.sprhib.model.Odber;
import com.sprhib.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/logged")
public class LoggedController {

//    @Autowired
//    private EntityService<Odber> odberService;

    @RequestMapping(value = { "/", "", "/index" }, method = RequestMethod.GET)
    public ModelAndView mainPage() {        

        ModelAndView model = new ModelAndView();
        model.setViewName("home");

        return model;
    }
    
   

    @RequestMapping(value = "/dsds", method = RequestMethod.GET)
    public ModelAndView freePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("home");

        return model;

    }

        

}
