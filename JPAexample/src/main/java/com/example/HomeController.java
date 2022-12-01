package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.AlienRepo;

@Controller
public class HomeController {
	
    @Autowired
	AlienRepo ar1;
    
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien a1)
	{
		ar1.save(a1);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		Alien a1= ar1.findById(aid).orElse(new Alien());
		ModelAndView mv = new ModelAndView();
		mv.addObject(a1);
		System.out.println(ar1.findByTech("java"));
		System.out.println(ar1.findByAidGreaterThan(1));
		System.out.println(ar1.findByTechSorted("java"));
		mv.setViewName("showAlien.jsp");
		return mv;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		return ar1.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public  Optional<Alien> getAliens(@PathVariable("aid")int aid)
	{
		return ar1.findById(aid);
	}
	
	
}
