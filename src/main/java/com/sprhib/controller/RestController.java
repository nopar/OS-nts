package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Stat;
import com.sprhib.service.EntityService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/rest")
public class RestController {
	
	@Autowired
	private EntityService<Stat> statService;
	
	@RequestMapping(value = "/getStaty",method = RequestMethod.GET)
        @ResponseBody
        public List<Stat> getEntites(){
            return statService.getEntites();
        }	
	
	
//	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
//	public ModelAndView editStatPage(@PathVariable Integer id) {
//		ModelAndView modelAndView = new ModelAndView("edit-stat");
//		Stat stat = statService.getEntity(id);
//		modelAndView.addObject("stat",stat);
//		return modelAndView;
//	}
//	
//	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
//	public ModelAndView edditingStat(@ModelAttribute Stat stat, @PathVariable Integer id) {
//		
//		ModelAndView modelAndView = new ModelAndView("home");
//		
//		statService.updateEntity(stat);
//		
//		String message = "Stat was successfully edited.";
//		modelAndView.addObject("message", message);
//		
//		return modelAndView;
//	}
//	
	
        
       

}
