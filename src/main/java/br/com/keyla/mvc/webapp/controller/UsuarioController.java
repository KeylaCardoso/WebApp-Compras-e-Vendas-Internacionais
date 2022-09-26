package br.com.keyla.mvc.webapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.model.StatusPedido;
import br.com.keyla.mvc.webapp.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired //serve para "solicitar" ao String uma instancia de PedidoRepository, no caso 
	private PedidoRepository pedidoRepository;
		
	@GetMapping("pedido")  //apenas/home
	public String home(Model model, Principal principal) { //Principal injeta os dados do usuario logado
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());		
		model.addAttribute("pedidos", pedidos);
		return "usuario/home";
		
	}
	
	@GetMapping("pedido/{status}")
	public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
		
		List<Pedido> pedidos = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());	//o valueOf transforma a String em umStatusPedido (que é um Enum)	
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "usuario/home";
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
	


}
