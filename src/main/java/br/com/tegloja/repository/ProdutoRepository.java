package br.com.tegloja.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tegloja.model.Categoria;
import br.com.tegloja.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoria(Categoria categoria);

	Page<Produto> findByCategoria(Pageable pageable, Categoria categoria);

	Page<Produto> findByNomeProdutoContainingIgnoreCase(Pageable pageable, String nomeProduto);
}
