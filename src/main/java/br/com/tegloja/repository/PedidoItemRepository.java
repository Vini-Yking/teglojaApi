package br.com.tegloja.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tegloja.model.Pedido;
import br.com.tegloja.model.PedidoItem;
import br.com.tegloja.model.Produto;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

	List<PedidoItem> findByPedido(Pedido pedido);

	Page<PedidoItem> findByProduto(Pageable pageable, Produto produto);

	// @Query("SELECT item FROM PedidoItem WHERE item.pedido.id = ?1")
	// List<PedidoItem> findByIdPedido(Long idPedido);

}
