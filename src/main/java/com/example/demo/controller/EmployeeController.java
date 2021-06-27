package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Todo;
import com.example.demo.service.EmployeeService;



@Controller

public class EmployeeController {
	 @Autowired
	 private EmployeeService service;
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        return "main";
	    }
	    
	   
	    @GetMapping("/sumb")
	    public String viewnextPage(Model model) {
	    	
	    	
	        List<Todo> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	        //System.out.print("Get / ");
	        return "login";
	    }
	    
	    @RequestMapping(path = "/sumb", method= RequestMethod.POST)
	    public String handlepage(@RequestParam("username") String userName,@RequestParam("password") String userpassword,RedirectAttributes redirAttrs)
	    {
	    	if(userName.equals("admin") && userpassword.equals("admin"))
	    		return "redirect:/sumb";
	    	else {
	    		
	    		redirAttrs.addFlashAttribute("error", "Incorrect username and password!!");
	    		return "redirect:/";
	    	}
	    }
	    
	    
	    

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("student", new Todo());
	        return "new";
	    }
	    
	    @GetMapping("/back")
	    public String backStudent(Model model) {
	        return "redirect:/sumb";
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("student") Todo std) {
	    	if(std.getTitle().isEmpty() || std.getTargetdate().isEmpty())
	    		return "redirect:/sumb";
	        service.save(std);
	        return "redirect:/sumb";
	    }

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Todo std = service.get(id);
	        mav.addObject("student", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/sumb";
	    }

}
