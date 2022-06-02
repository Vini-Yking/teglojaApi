package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.PedidoItem;

public interface PedidoItensRepository extends JpaRepository<PedidoItem, Long>{

}
