package com.sprhib.controller;

import com.google.gson.Gson;
import com.sprhib.model.Odber;
import com.sprhib.model.Stat;
import com.sprhib.service.EntityOdberService;
import com.sprhib.service.EntityService;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/rest")
public class RestController {
	
	@Autowired
	private EntityService<Stat> statService;
        
        @Autowired
	private EntityOdberService<Odber> odberService;
                   
	
	@RequestMapping(value = "/getStaty",method = RequestMethod.GET)
        @ResponseBody
        public List<Stat> getEntites(){
            return statService.getEntites();
        }
        
        
   //rst pocitadlo odberov
        @RequestMapping(value = "/poc/{nick}", method = RequestMethod.GET)
        @ResponseBody
	public Integer restPocitadloOdberovPage(
                @PathVariable String nick ) {
            
            ModelAndView model = new ModelAndView();  
           
            
            if (nick != null) {
                Integer pocet = odberService.getKonkretny(nick);
               // System.out.println("pocet :" + pocet);
                return pocet;
            }
            else{
                return 0;                
            }
	}

           
	
	@RequestMapping(value = "/getMojeOdbery/{nick}",method = RequestMethod.GET)
        @ResponseBody
        public String getMojeOdbery(
        @PathVariable String nick ){
     
            List<String> foo = new ArrayList();
            Integer userID = odberService.getUserIDfromNick(nick);
            List<Odber> mojeOdbery = odberService.getMojeOdberyHistory(userID);
        
         String output = "";
         int times = 0;
        int size = mojeOdbery.size();
        output = "[";
        for(Odber i : mojeOdbery){
            output += "{";
                output += "\"";
                    output += "datum";
                output += "\"";
                        output += ":";
                output += "\"";
                    output += i.getDatum().toString(); 
                output += "\"";
                
            output += ",";
            
                output += "\"";
                    output += "objem";
                output += "\"";
                        output += ":";
                output += "\"";
                    output += i.getObjem().toString(); 
                output += "\"";
                
            output += ",";
            
                output += "\"";
                    output += "poznamka";
                output += "\"";
                        output += ":";
                output += "\"";
                    output += i.getPoznamka(); 
                output += "\"";
            output += "}";
            
            
            if(size-1 != times){
                output += ",";
            }
        times++;
        }
        output += "]";
        
            System.out.println("JSON MOJ :" + output);
        
//            JSONObject responseDetailsJson = new JSONObject();
//            JSONArray jsonArray = new JSONArray();
            
         
            
//             // create a new Gson instance
//            Gson gson = new Gson();
//            // convert your list to json
//            String jsonCartList = gson.toJson(mojeOdbery);
//            // print your generated json
//            System.out.println("jsonCartList: " + jsonCartList);
//          
     

         //  System.out.println("json moj :" + foo);
     //   String json = new Gson().toJson(foo);
            
       
        
            return output;
        }
}
