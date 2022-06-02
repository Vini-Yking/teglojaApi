package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tegloja.model.PedidoItem;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
