package com.sprhib.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/info")
public class InfoController {

    @RequestMapping(value = "/priprava", method = RequestMethod.GET)
    public ModelAndView pripravaPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("info/priprava-na-darovanie");

        return model;

    }

    @RequestMapping(value = "/pred-darovanim", method = RequestMethod.GET)
    public ModelAndView predDarovanimPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("info/pred-tym-ako-darujete");

        return model;

    }

    @RequestMapping(value = "/proces", method = RequestMethod.GET)
    public ModelAndView procesPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("info/proces-darovania");

        return model;

    }
    
    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public ModelAndView faqPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("info/faq");

        return model;

    }
    
    @RequestMapping(value = "/kontakt", method = RequestMethod.GET)
    public ModelAndView kontaktPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("info/kontakt");

        return model;

    }
    
     @RequestMapping(value = "/pravne-info", method = RequestMethod.GET)
    public ModelAndView pravneInfoPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("info/pravne-info");

        return model;

    }
}
