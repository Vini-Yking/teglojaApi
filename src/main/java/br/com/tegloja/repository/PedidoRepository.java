package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
