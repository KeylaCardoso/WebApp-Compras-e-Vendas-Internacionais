package br.com.keyla.mvc.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrimeiroController {

	@GetMapping("/hello")
	// public String hello(HttpServletRequest request) { //nao precisa usar o
	// HttpServletRequest (camada mais abaixo), pois o spring ja possui um recurso
	// para o request
	public String hello(Model model) {
		model.addAttribute("nome", "Mundo");
		return "hello";
	}

}
