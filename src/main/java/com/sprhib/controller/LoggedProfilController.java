package com.sprhib.controller;


import com.sprhib.model.Odber;
import com.sprhib.service.EntityOdberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    
    @Autowired
    private EntityOdberService<Odber> odberService;
   
    @RequestMapping(value = "/odber/historia", method = RequestMethod.GET)
    public ModelAndView odberHistoryPage() {
        
        ModelAndView model = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();

        String logNickSend = userDetails.getUsername();
        Integer userID = odberService.getUserIDfromNick(logNickSend);
        
        

        model.setViewName("darca/moje_odbery");

        return model;
    }
    
    
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
