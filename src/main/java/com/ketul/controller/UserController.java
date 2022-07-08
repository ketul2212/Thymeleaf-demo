package com.ketul.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ketul.module.User;

@Controller
public class UserController {

	@GetMapping("/form")
	public String getForm(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/saveUser")
	public String saveStudent(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "form";
		}
		
		model.addAttribute("user", user);
        return "user";
    }
}
