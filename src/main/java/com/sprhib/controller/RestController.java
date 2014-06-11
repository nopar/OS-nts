package com.sprhib.controller;

import com.sprhib.model.Odber;
import com.sprhib.model.Stat;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.service.EntityOdberService;
import com.sprhib.service.EntityService;
import java.util.List;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        @PathVariable String nick ) throws JSONException{

            Integer userID = odberService.getUserIDfromNick(nick);
            List<Odber> mojeOdbery = odberService.getMojeOdberyHistory(userID);
            StringBuilder output = new StringBuilder();
            int times = 0;
            int size = mojeOdbery.size();
            

            output.append("[");
            for(Odber i : mojeOdbery){
                output.append("{");
                    output.append("\"");
                        output.append("datum");
                    output.append("\"");
                            output.append(":");                        
                    output.append("\"");
                        output.append(i.getDatum().toString());
                    output.append("\"");

                output.append(",");

                    output.append("\"");
                        output.append("objem");
                    output.append("\"");
                            output.append(":");
                    output.append("\"");
                        output.append(i.getObjem().toString());
                    output.append("\"");

                output.append(",");

                    output.append("\"");
                        output.append("poznamka");
                    output.append("\"");
                            output.append(":");
                    output.append("\"");
                        if(i.getPoznamka() != null){
                            output.append(i.getPoznamka());
                        }else output.append("");
                    output.append("\"");
                output.append("}");


                if(size-1 != times){
                    output.append(",");
                }
            times++;
            }
            output.append("]");

            System.out.println("JSON MOJ :" + output);
                return output.toString();
            }
}
