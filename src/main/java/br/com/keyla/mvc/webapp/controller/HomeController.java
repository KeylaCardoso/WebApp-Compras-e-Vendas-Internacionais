package br.com.keyla.mvc.webapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.keyla.mvc.webapp.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 8");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51RIqTiRc8L._AC_SL1000_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-Camera/dp/B07Z5BBG56");
		pedido.setDescricao("Descrição para este pedido.");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		return "home";
		
	}

}
