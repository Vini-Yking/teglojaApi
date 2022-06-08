package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tegloja.model.Foto;
import br.com.tegloja.model.Produto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

	Foto findByProduto(Produto produto);
}
