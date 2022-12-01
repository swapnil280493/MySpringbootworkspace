package com.example;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("home")
	public ModelAndView home(Aliean a1) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", a1);
		mv.setViewName("home");
		
		return mv;
	}
}
