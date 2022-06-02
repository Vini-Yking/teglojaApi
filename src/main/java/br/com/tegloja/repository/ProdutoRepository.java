package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tegloja.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
