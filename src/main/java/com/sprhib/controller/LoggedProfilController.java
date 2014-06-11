package com.sprhib.controller;


import com.sprhib.model.Kraj;
import com.sprhib.model.Nastavenie;
import com.sprhib.model.Odber;
import com.sprhib.model.Pouzivatelia;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.service.EntityOdberService;
import com.sprhib.service.EntityService;
import com.sprhib.service.EntityNastavenieService;
import java.util.ArrayList;
import java.util.List;
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
    
   // @Autowired
   // private EntityService<Nastavenie> nastavenieService;
    
    @Autowired
    private EntityOdberService<Odber> odberService;
    
     @Autowired
    private EntityService<Pouzivatelia> pouzivateliaService;
     
     @Autowired
     private EntityNastavenieService<Nastavenie> nastavenieService;


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
        //String kraj_s, odber_s, urgent_s, vyjazd_s = "";
        List<String> menakrajov = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
  
        //--->
        List<Pouzivatelia> mojeNastavenie = nastavenieService.getPouzivatelaList(userID);
        int idNastavenia = 0;
        for(Pouzivatelia s : mojeNastavenie){
                idNastavenia = s.getIdNastavenie().getIdNastavenie();
            }
        
        List<Nastavenie> konkretneNastavenie = nastavenieService.getMojeSetings(idNastavenia);
        for (Nastavenie s : konkretneNastavenie) {
            

            if (s.getMojeOdbery() == true) {
                menakrajov.add("zapnuté");
            } else {
                menakrajov.add("vypnuté");
            }
            
            if (s.getVyjazdoveOdbery() == true) {
                menakrajov.add("zapnuté");
            } else {
                menakrajov.add("vypnuté");
            }

            if (s.getUrgentnePripady() == true) {
                menakrajov.add("zapnuté");
            } else {
                menakrajov.add("vypnuté");
            }

           if (s.getKraj() == true) {
                menakrajov.add("zapnuté");
            } else {
                menakrajov.add("vypnuté");
            }
        }
        
      
            
            for(String s : menakrajov){
                list.add(s);
                System.out.println("PATO :: :" + s.toString());
            }
        
        
        //<---
        
        //List<Pouzivatelia> pouzivatel = pouzivateliaService.get
        /*
        if (mojeNastavenie.getKraj() == true) {
            menakrajov.add("zapnuté");
        } else {
            menakrajov.add("vypnuté");
        }

        if (mojeNastavenie.getMojeOdbery() == true) {
            menakrajov.add("zapnuté");
        } else {
            menakrajov.add("vypnuté");
        }

        if (mojeNastavenie.getUrgentnePripady() == true) {
            menakrajov.add("zapnuté");
        } else {
            menakrajov.add("vypnuté");
        }

        if (mojeNastavenie.getVyjazdoveOdbery() == true) {
            menakrajov.add("zapnuté");
        } else {
            menakrajov.add("vypnuté");
        }


            System.out.println("- :" + mojeNastavenie.getKraj());
            System.out.println("- :" + mojeNastavenie.getMojeOdbery());
            System.out.println("- :" + mojeNastavenie.getUrgentnePripady());
            System.out.println("- :" + mojeNastavenie.getVyjazdoveOdbery());
        
            
            for(String s : menakrajov){
                list.add(s);
                System.out.println("s :" + s.toString());
            }
        */
        
        model.addObject("list", list); 
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
