package br.com.tegloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tegloja.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long>{

}
