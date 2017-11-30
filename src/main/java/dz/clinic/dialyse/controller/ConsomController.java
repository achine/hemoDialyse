package dz.clinic.dialyse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dz.clinic.dialyse.model.Consomable;
import dz.clinic.dialyse.services.ConsomableService;

@Controller
public class ConsomController {

	@Autowired ConsomableService consomableService;
	
	@RequestMapping(value = "/consoms", method = RequestMethod.GET)
	public ModelAndView consoms() {
		
		List<Consomable> liste = consomableService.chercherConsomablesEtCaracts(0L);
		
		ModelAndView model = new ModelAndView("consomable");
		model.addObject("consoms", liste);
		
		return model;
	}
	
//	
//	@RequestMapping(value = "/consoms", method = RequestMethod.GET)
//	public String consom(Model model) {
//		
//		List<Consomable> liste = consomableService.chercherConsomablesEtCaracts(0L);
//		
//		model.addAttribute("liste", liste);
//		
//		return  "redirect:/consomable" ;
//	}
}
