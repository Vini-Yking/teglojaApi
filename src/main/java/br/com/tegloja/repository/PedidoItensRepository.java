package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.PedidoItens;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long>{

}
