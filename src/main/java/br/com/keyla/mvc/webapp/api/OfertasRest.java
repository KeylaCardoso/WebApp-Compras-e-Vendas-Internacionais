package br.com.keyla.mvc.webapp.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.keyla.mvc.webapp.dto.RequisicaoNovaOferta;
import br.com.keyla.mvc.webapp.model.Oferta;
import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {//@RequestBody pega os dados da requisicao e adiciona 
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) { //se o pedido nao for encontrado
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta nova = requisicao.toOferta(); //cria objeto do tipo Oferta
		
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova);
		pedidoRepository.save(pedido); 
		
		return nova;
		
	}

}
