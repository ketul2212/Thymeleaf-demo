package com.ketul.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ketul.module.User;

@Controller
public class MyController {
	
	//section print Strings
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "Ketul Patel");
		model.addAttribute("day", LocalDateTime.now());
		return "about";
	}
	
	// section for-each loop
	@GetMapping("/for-each")
	public String iterator(Model model) {
		List<String> names = List.of("Ketul", "Jal", "Sunny", "Bunny", "Chinny", "Pinny");
		model.addAttribute("names", names);
		return "iterator";
	}
	
	// section conditional statements
	@GetMapping("/conditions")
	public String conditional(Model model) {
		model.addAttribute("isActive", true);
		model.addAttribute("num1", 6);
		model.addAttribute("gender", "Female");
		model.addAttribute("list", List.of(10, 20, 30, 40));
		return "conditions";
	}
	
	// section fragment with 3 types
	/*
	 * In this, use fragment with static content and 3 types of fragments:
	 * 1.) th:include
	 * 2.) th:replace
	 * 3.) th:insert
	*/
	@GetMapping("/fragment")
	public String fragment() {
		return "fragment";
	}
	
	// section this use fragment with dynamic content
	@GetMapping("/fragment-dynamic")
	public String fragmentDynamic(Model model) {
		model.addAttribute("name", "Ketul Patel");
		model.addAttribute("today", LocalDateTime.now());
		return "fragment-dynamic";
	}
	
	// section print custom dynamic user
	@GetMapping("/user")
	public String dynamicUser(Model model) {
		model.addAttribute("user", new User("Ketul Patel", "ketul.patel@drcsystems.com"));
		return "user";
	}
	
	// section inherit
	/*
	 * In this, we have a two HTML files:
	 * 1.) base.html 2.) contact.html
	 * 
	 * and also one CSS file inside static directory:
	 * 1.) base.css
	 * 
	 * In this, we just replace base.html contain with contact.html contain
	 * 
	 *  Some Syntaxes:-
	 *  1.) In base.html,
	 *  	+> syntax:- th:fragment="[fragment name]([variable Name <- if it present])
	 *  	I.) <html xmlns:th="http://www.thymeleaf.org" th:fragment="baseLayout(content)">
	 * -> We create 1 fragment with 1 argument [it's just like a function] named with 
	 * 	  baseLayout(content)
	 * 		II.) <div th:replace="${content}"></div>
	 * -> Now, we replace div tag content with dynamically provided page content. 
	 * 	  For Ex:- If we provide contect.html content then replace this div tag of base.html
	 * 		III.) <link rel="stylesheet" th:href="@{/base.css}"/>
	 * -> use this syntax to use static/base.css file in htmls.
	 * 
	 * 2.) In contact.html,
	 * 		+> th:replace="[file name]::[fragment name](~{::[any tag]})"
	 * 		I.) <html xmlns:th="http://www.thymeleaf.org" th:replace="base::baseLayout(~{::section})">
	 * -> this is use to give particular teg content.
	 * 
	 * 
	*/
	@GetMapping("/contact")
	public String inherit() {
		return "contact";
	}
}
