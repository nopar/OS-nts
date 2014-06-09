package com.sprhib.controller;

import com.sprhib.model.Odber;
import com.sprhib.service.EntityOdberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @Autowired
    private EntityOdberService<Odber> odberService;

//        domovska stranka pre neprihlaseneho
	@RequestMapping(value = { "/", "/welcome**", "" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(
                @RequestParam(value = "error", required = false) String error,
                @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Formular - Databázová Autentifikácia");
		model.addObject("message", "Toto je hlavná stránks!");
                
                 if (error != null) {
			model.addObject("error", "Nesprávne meno alebo heslo!");
		}

		if (logout != null) {
			model.addObject("msg", "Boli ste úspešne odhlásený.");
		}
                
		model.setViewName("non_logged_home");
		return model;

	}

//        prihlasenie
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Nesprávne meno alebo heslo!");
		}

		if (logout != null) {
			model.addObject("msg", "Boli ste úspešne odhlásený.");
		}
		model.setViewName("login");

		return model;

	}
        
          ///pocitadlo
        @RequestMapping(value = "/logged/profil/odber/pocitadlo/{id}", method = RequestMethod.GET)
	public ModelAndView pocitadloOdberovPage(
                @PathVariable Integer id ) {
            
            ModelAndView model = new ModelAndView();  
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
//            User user = SecurityContextHolder.getContext().getAuthentication().;
            
            if (id != null) {
                Integer pocet = odberService.getKonkretny(id);
                System.out.println("pocet :" + pocet);
                model.addObject("pocet", pocet);
                
               // Integer pocetNovy = pouzivateliaService.getKonkretny(id);
               // System.out.println("pocetNovy :" + pocetNovy);
            }
            
            //
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().
                    getAuthentication().getPrincipal();
            System.out.println(userDetails.getPassword());
            System.out.println(userDetails.getUsername());
            System.out.println(userDetails.isEnabled());
            

		
		model.setViewName("darca/pocitadlo_odberov");
		return model;
	}
        

        //rst pocitadlo odberov
        @RequestMapping(value = "/rest/poc/{id}", method = RequestMethod.GET)
        @ResponseBody
	public Integer restPocitadloOdberovPage(
                @PathVariable Integer id ) {
            
            ModelAndView model = new ModelAndView();  
           
            
            if (id != null) {
                Integer pocet = odberService.getKonkretny(id);
                System.out.println("pocet :" + pocet);
                return odberService.getKonkretny(id);
              
            }
            else{
                return 0;                
            }
		
		
	}
        
        
//        toto tu je iba na ukazku aby som najjednoduchsie demonstroval sec
        @RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");

		return model;

	}
        
        @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
                
		model.setViewName("admin");

		return model;

	}
        
//        pre mapu
        @RequestMapping(value = "/mapa", method = RequestMethod.GET)
	public ModelAndView mapaPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("default/mapa");

		return model;

	}
        
        
	//pre 404 access denied page
	@RequestMapping(value = "**", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("errors/404");
		return model;

	}
        
        

}