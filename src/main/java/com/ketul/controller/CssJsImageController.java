package com.ketul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CssJsImageController {

	@GetMapping("/css-js-image")
	public String applyCssJsImageWithThymeleaf() {
		return "css-js-image";
	}
	
	@GetMapping("/bootstrap-css-js")
	public String applyBootstrapCssJs() {
		return "bootstrap-css-js";
	}
}
