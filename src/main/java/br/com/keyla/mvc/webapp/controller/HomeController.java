package br.com.keyla.mvc.webapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.model.StatusPedido;
import br.com.keyla.mvc.webapp.repository.PedidoRepository;

@Controller
@RequestMapping("/home") //todas as requisicoes /home chegarao aqui
public class HomeController {
	
	@Autowired //serve para "solicitar" ao String uma instancia de PedidoRepository, no caso 
	private PedidoRepository pedidoRepository;
		
	@GetMapping  //apenas/home
	public String home(Model model, Principal principal) { //Principal injeta os dados do usuario logado
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);		
		model.addAttribute("pedidos", pedidos);
		return "home";
		
	}
	
	

}
