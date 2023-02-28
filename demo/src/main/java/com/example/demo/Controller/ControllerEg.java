package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.TestEntity;
import com.example.demo.repo.TestRepo;

import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEg 
{
	@Autowired
	private TestRepo repo;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("User Connected");
		model.addAttribute("index", new TestEntity());
		return "index";
	}
	//@ResponseBody
	@PostMapping("/register")
	public String register(@ModelAttribute TestEntity t)
	{
		TestEntity newte=repo.save(t);
		System.out.println("post...");
		System.out.println(newte);
		return "welcome";
	}
	
	@PostMapping("/delete")
	public String deleteuser()
	{
		repo.deleteById(123);
		return "index";
	}

}