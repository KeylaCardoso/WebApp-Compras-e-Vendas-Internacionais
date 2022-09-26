package br.com.keyla.mvc.webapp.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.keyla.mvc.webapp.model.Pedido;
import br.com.keyla.mvc.webapp.model.StatusPedido;

@Repository // fala para o spring gerenciar a classe e criar instancias toda vez que alguem solicitar
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	                    //o @Cacheable armazena dados em cache para que a aplicação nao precise acessar o banco de dados a cada 
	                    //atualização, para que, no caso de uma pagina com muitos usuários, se tenha um sistema
	@Cacheable("books") //com melhor performance
	List<Pedido> findByStatus(StatusPedido status, Pageable sort);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username")String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusEUsuario(@Param("status") StatusPedido status, @Param("username")String username);
		
		
	}
