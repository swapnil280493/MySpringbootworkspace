package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.AlienRepo;

@RestController
public class HomeController {
	
    @Autowired
	AlienRepo ar1;
    
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien a1)
	{
		ar1.save(a1);
		return a1;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid)
	{
		ar1.deleteById(aid);
		return "deleted";
	}
	
	@PutMapping("/alien")
	public Alien addorUpdateAlien(@RequestBody Alien a1)
	{
		ar1.save(a1);
		return a1;
	}
	
	@GetMapping("/getAlien")
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
	
	@RequestMapping(path="/aliens",produces="application/xml")
	public List<Alien> getAliens()
	{
		return ar1.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	public  Optional<Alien> getAliens(@PathVariable("aid")int aid)
	{
		return ar1.findById(aid);
	}
	
	
}
