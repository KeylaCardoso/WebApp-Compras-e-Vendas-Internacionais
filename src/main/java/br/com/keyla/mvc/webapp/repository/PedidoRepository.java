package br.com.keyla.mvc.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.keyla.mvc.webapp.model.Pedido;

@Repository // fala para o spring gerenciar a classe e criar instancias toda vez que alguem solicitar
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
		
		
	}
