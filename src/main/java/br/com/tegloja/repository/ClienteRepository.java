package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
