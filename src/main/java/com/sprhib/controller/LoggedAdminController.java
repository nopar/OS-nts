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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/logged/admin")
public class LoggedAdminController {
 
    @Autowired
    private EntityService<Stat> statService;

    @Autowired
    private EntityService<Skupiny> skupinyService;

    //STATY    
    @RequestMapping(value = "/stat/add", method = RequestMethod.GET)
    public ModelAndView addStatPage() {
        ModelAndView modelAndView = new ModelAndView("staty/add-stat");
        modelAndView.addObject("stat", new Stat());
        return modelAndView;
    }

    @RequestMapping(value = "/stat/add", method = RequestMethod.POST)
    public ModelAndView addingStat(@ModelAttribute Stat stat) {

        ModelAndView modelAndView = new ModelAndView("staty/list-stat");
        statService.addEntity(stat);
        
        List<Stat> stats = statService.getEntites();
        modelAndView.addObject("stats", stats);

        String message = "Stat was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/stat/list")
    public ModelAndView listOfStats() {
        ModelAndView modelAndView = new ModelAndView("staty/list-stat");

        List<Stat> stats = statService.getEntites();
        modelAndView.addObject("stats", stats);

        return modelAndView;
    }

    @RequestMapping(value = "/stat/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editStatPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("staty/edit-stat");
        Stat stat = statService.getEntity(id);
        modelAndView.addObject("stat", stat);
        return modelAndView;
    }

    @RequestMapping(value = "/stat/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingStat(@ModelAttribute Stat stat, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("staty/list-stat");

        statService.updateEntity(stat);
        
        List<Stat> stats = statService.getEntites();
        modelAndView.addObject("stats", stats);

        String message = "Stat was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/stat/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteStat(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("staty/list-stat");
        statService.deleteEntity(id);
        
        List<Stat> stats = statService.getEntites();
        modelAndView.addObject("stats", stats);
        
        String message = "Stat was successfully deleted.";
        modelAndView.addObject("message", message);
        
        return modelAndView;
    }

    @RequestMapping(value = "/stat/getStaty", method = RequestMethod.GET)
    @ResponseBody
    public List<Stat> getEntites() {
        return statService.getEntites();
    }
    //END STATY
    
    
    
    
    //SKUPINY
    
    @RequestMapping(value="/skupiny/add", method=RequestMethod.GET)
	public ModelAndView addSKupinaPage() {
		ModelAndView modelAndView = new ModelAndView("skupiny/add-skupiny");
		modelAndView.addObject("skupiny", new Skupiny());
		return modelAndView;
	}
	
	@RequestMapping(value="/skupiny/add", method=RequestMethod.POST)
	public ModelAndView addingSkupina(
                @ModelAttribute Skupiny skupina) {
		
		ModelAndView modelAndView = new ModelAndView("skupiny/list-skupiny");
		skupinyService.addEntity(skupina);
                
                List<Skupiny> skupiny = skupinyService.getEntites();
		modelAndView.addObject("skupiny", skupiny);
		
		String message = "Stat was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/skupiny/list")
	public ModelAndView listOfSkupiny() {
		ModelAndView modelAndView = new ModelAndView("skupiny/list-skupiny");
		
		List<Skupiny> skupiny = skupinyService.getEntites();
		modelAndView.addObject("skupiny", skupiny);
		
		return modelAndView;
	}
	
        
	@RequestMapping(value="/skupiny/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editSkupinaPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("skupiny/edit-skupiny");
		Skupiny skupiny = skupinyService.getEntity(id);
		modelAndView.addObject("skupiny",skupiny);
		return modelAndView;
	}
	
	@RequestMapping(value="/skupiny/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingSkupina(
                @ModelAttribute Skupiny skupina,
                @PathVariable Integer id ) {
		
		ModelAndView modelAndView = new ModelAndView("skupiny/list-skupiny");
		
		skupinyService.updateEntity(skupina);
                
                List<Skupiny> skupiny = skupinyService.getEntites();
		modelAndView.addObject("skupiny", skupiny);
		
		String message = "Stat was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/skupiny/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSkupina(
                @PathVariable Integer id) {
            
		ModelAndView modelAndView = new ModelAndView("skupiny/list-skupiny");
		skupinyService.deleteEntity(id);
                
                List<Skupiny> skupiny = skupinyService.getEntites();
		modelAndView.addObject("skupiny", skupiny);
                
		String message = "Stat was successfully deleted.";
		modelAndView.addObject("message", message);
                
		return modelAndView;
	}
    
    //END SKUPINY

}
