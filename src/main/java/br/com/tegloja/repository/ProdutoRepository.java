package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
