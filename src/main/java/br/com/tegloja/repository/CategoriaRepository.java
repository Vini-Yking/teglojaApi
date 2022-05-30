package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
