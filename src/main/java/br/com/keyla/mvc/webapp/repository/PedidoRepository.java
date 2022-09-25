package br.com.keyla.mvc.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.model.StatusPedido;

@Repository // fala para o spring gerenciar a classe e criar instancias toda vez que alguem solicitar
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido status);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username")String username);
		
		
	}
