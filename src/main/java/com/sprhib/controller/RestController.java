package com.sprhib.controller;

import com.sprhib.model.Kraj;
import com.sprhib.model.Mesto;
import com.sprhib.model.Nastavenie;
import com.sprhib.model.Odber;
import com.sprhib.model.Pouzivatelia;
import com.sprhib.model.Stat;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.service.EntityNastavenieService;
import com.sprhib.service.EntityOdberService;
import com.sprhib.service.EntityService;
import com.sprhib.service.EntityVyjazdovyOdberService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    @Autowired
    private EntityVyjazdovyOdberService<VyjazdovyOdber> vyjazdovyOdberService;
    
    @Autowired
    private EntityNastavenieService<Nastavenie> nastavenieService;
//profil
    
    @RequestMapping(value = "/nastavenie/{nick}", method = RequestMethod.GET)
    @ResponseBody
    public List<Boolean> getMojeNastavenie(
            @PathVariable String nick ) {
        Integer userID = odberService.getUserIDfromNick(nick);
        
        List<Pouzivatelia> userList = nastavenieService.getPouzivatelaList(userID);
        int idNastavenia = 0;
        for(Pouzivatelia s : userList){
                idNastavenia = s.getIdNastavenie().getIdNastavenie();
            }
        
        List<Boolean> menakrajov = new ArrayList<Boolean>();
        List<Boolean> list = new ArrayList<Boolean>();
        List<Nastavenie> konkretneNastavenie = nastavenieService.getMojeSetings(idNastavenia);
        
        for (Nastavenie s : konkretneNastavenie) {
            menakrajov.add(s.getMojeOdbery());
            menakrajov.add(s.getVyjazdoveOdbery());
            menakrajov.add(s.getUrgentnePripady());
            menakrajov.add(s.getKraj());            
        }
        
        for(Boolean s : menakrajov){
                list.add(s);
                System.out.println("PATO :: :" + s.toString());
            }
        
        System.out.println("userid :" + userID);
        return list;
    }
    
   
    
    
        @RequestMapping(value = "/kalendar",method = RequestMethod.GET)
        @ResponseBody
        public String getRestkalendarAkcii() throws JSONException, UnsupportedEncodingException, IOException{

            List<VyjazdovyOdber> akcie = vyjazdovyOdberService.getVyjazdyOdDnes();
            StringBuilder output = new StringBuilder();
            int times = 0;
            int size = akcie.size();
            
            
            output.append("[");
            for(VyjazdovyOdber i : akcie){
                Kraj krajID = i.getIdKraj();
                
                output.append("{");
                    //NAZOV
                    output.append("\"");
                        output.append("nazov");
                    output.append("\"");
                            output.append(":");                        
                    output.append("\"");
                        if(i.getNazov() != null){
                            output.append(i.getNazov());
                        }else output.append("");
                    output.append("\"");

                output.append(",");

                    //DATUM
                    output.append("\"");
                        output.append("datum");
                    output.append("\"");
                            output.append(":");
                    output.append("\"");
                        if(i.getDatum().toString()!= null){
                            output.append(i.getDatum().toString());
                        }else output.append("");
                    output.append("\"");

                output.append(",");

                    //ADRESA
                    output.append("\"");
                        output.append("adresa");
                    output.append("\"");
                            output.append(":");
                    output.append("\"");
                        if(i.getAdresa()!= null){
                            output.append(i.getAdresa());
                        }else output.append("");
                    output.append("\"");
                    
                output.append(",");
                
                    //ZACIATOK
                    output.append("\"");
                        output.append("cas_zaciatok");
                    output.append("\"");
                            output.append(":");                        
                    output.append("\"");
                        if(i.getCasZaciatku().toString()!= null){
                            output.append(i.getCasZaciatku().toString());
                        }else output.append("");
                    output.append("\"");

                output.append(",");

                    //KONIEC
                    output.append("\"");
                        output.append("cas_koniec");
                    output.append("\"");
                            output.append(":");                        
                    output.append("\"");
                        if(i.getCasKonca().toString()!= null){
                            output.append(i.getCasKonca().toString());
                        }else output.append("");
                    output.append("\"");

                output.append(",");

                    //POPIS
                    output.append("\"");
                        output.append("popis");
                    output.append("\"");
                            output.append(":");                        
                    output.append("\"");
                        if(i.getBlizsiPopis()!= null){
                            output.append(i.getBlizsiPopis());
                        }else output.append("");
                    output.append("\"");

                output.append(",");

                    //KRAJ
                    output.append("\"");
                        output.append("kraj");
                    output.append("\"");
                            output.append(":");                        
                    output.append("\"");
                        if(krajID.getKraj() != null){
                            output.append(krajID.getKraj());
                        }else output.append("");
                    output.append("\"");
               
                output.append("}");

                if(size-1 != times){
                    output.append(",");
                }
            times++;
                        
            }
            output.append("]");

        
            System.out.println("Size of buffer: " + output.length());
            StringBuilder res;
            
            long startTime = System.currentTimeMillis();
            System.out.println("Conversion using String time (msec): " + (System.currentTimeMillis() - startTime));
            if (!output.toString().equals(output.toString())) {
                System.err.println("Conversion error");
            }
        
            System.out.println("JSON KALENDAT MOJ :" + output.toString());
                return output.toString();
            }
        
        
                   
	
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
