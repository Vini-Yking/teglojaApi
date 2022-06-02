package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.CategoriaRequestDTO;
import br.com.tegloja.dto.CategoriaResponseDTO;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.Categoria;
import br.com.tegloja.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository _categoriarepository;

	public CategoriaResponseDTO adicionar(CategoriaRequestDTO categoriaRequest) {
		// Conversão de CategoriaRequestDTO para Categoria
		Categoria categoria = new Categoria(categoriaRequest);
		categoria = _categoriarepository.save(categoria);
		// Conversão de Categoria para CategoriaResponseDTO
		return new CategoriaResponseDTO(categoria);
	}

	public List<CategoriaResponseDTO> listar() {
		List<Categoria> categorias = _categoriarepository.findAll();
		// @formatter:off
		return categorias.stream()
				.map(c -> new CategoriaResponseDTO(c))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public CategoriaResponseDTO buscarId(Long id) {
		Optional<Categoria> categoria = _categoriarepository.findById(id);
		if (categoria.isEmpty()) {
			throw new IdNotFoundException("Não existe uma categoria com esse id.");
		}
		return new CategoriaResponseDTO(categoria.get());
	}

	public CategoriaResponseDTO buscarNome(String nome) {
		Optional<Categoria> categoria = _categoriarepository.findByCategoria(nome);
		if (categoria.isEmpty()) {
			throw new IdNotFoundException();
		}
		return new CategoriaResponseDTO(categoria.get());
	}

	public CategoriaResponseDTO atualizar(CategoriaRequestDTO categoriaRequest, Long id) {
		if (_categoriarepository.findById(id).isEmpty()) {
			throw new IdNotFoundException("Não existe uma categoria com esse id.");
		}
		Categoria categoria = new Categoria(categoriaRequest);
		categoria.setId(id);
		categoria = _categoriarepository.save(categoria);
		return new CategoriaResponseDTO(categoria);
	}

	public void deletar(Long id) {
		if (_categoriarepository.findById(id).isEmpty()) {
			throw new IdNotFoundException("Não existe uma categoria com esse id.");
		}
		_categoriarepository.deleteById(id);
	}

}
