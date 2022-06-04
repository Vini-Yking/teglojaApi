package br.com.tegloja.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByCliente(Cliente cliente);

	Page<Pedido> findByCliente(Cliente cliente, Pageable pageable);

}
