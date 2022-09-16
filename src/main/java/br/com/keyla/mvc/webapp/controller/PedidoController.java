package br.com.keyla.mvc.webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.keyla.mvc.webapp.dto.RequisicaoNovoPedido;
import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
		
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) { //@Valid é necessario para solicitar a validacao ao Spring
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido();                                         // dos dados anotados como @NotBlando na classe Requisicao
		pedidoRepository.save(pedido);
		return "pedido/formulario";
	 }

}
