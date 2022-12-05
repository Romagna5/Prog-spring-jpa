package it.domenico.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.domenico.classi.User;

@Controller
public class MenuController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/chisono")
	public String chisono() {
		return "chisono";
	}
	@GetMapping("/servizi")
	public String servizi() {
		return "servizi";
	}
	@RequestMapping("/contatti")
	public String contatti() {
		return "contatti";
	}
	@RequestMapping(value="/contattato", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		user.create(user);
		System.out.print("User da form: "+user);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("info_inviate");
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	

}
