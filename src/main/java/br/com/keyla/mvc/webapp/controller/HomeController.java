package br.com.keyla.mvc.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired //serve para "solicitar" ao String uma instancia de PedidoRepository, no caso 
	private PedidoRepository pedidoRepository;
		
	@GetMapping("/home")
	public String home(Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findAll();		
		model.addAttribute("pedidos", pedidos);
		return "home";
		
	}
	

}
