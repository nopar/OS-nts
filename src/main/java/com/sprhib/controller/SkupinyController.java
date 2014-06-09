package com.sprhib.controller;

import com.sprhib.model.Skupiny;
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

@Controller
@RequestMapping(value="/admin/skupiny")
public class SkupinyController {
	
	@Autowired
	private EntityService<Skupiny> skupinyService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addSKupinaPage() {
		ModelAndView modelAndView = new ModelAndView("skupiny/add-skupiny");
		modelAndView.addObject("skupiny", new Skupiny());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingSkupina(
                @ModelAttribute Skupiny skupiny) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		skupinyService.addEntity(skupiny);
		
		String message = "Stat was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfSkupiny() {
		ModelAndView modelAndView = new ModelAndView("skupiny/list-skupiny");
		
		List<Skupiny> skupiny = skupinyService.getEntites();
		modelAndView.addObject("skupiny", skupiny);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editSkupinaPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("skupiny/edit-skupiny");
		Skupiny skupiny = skupinyService.getEntity(id);
		modelAndView.addObject("skupiny",skupiny);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingSkupina(
                @ModelAttribute Skupiny skupiny, 
                @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		skupinyService.updateEntity(skupiny);
		
		String message = "Stat was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteStat(
                @PathVariable Integer id) {
            
		ModelAndView modelAndView = new ModelAndView("home");
		skupinyService.deleteEntity(id);
		String message = "Stat was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
