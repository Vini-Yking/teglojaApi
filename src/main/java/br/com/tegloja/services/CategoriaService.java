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
		Categoria categoria = new Categoria(categoriaRequest);
		categoria = _categoriarepository.save(categoria);

		return new CategoriaResponseDTO(categoria);
	}

	public List<CategoriaResponseDTO> buscarTodos() {
		List<Categoria> categorias = _categoriarepository.findAll();
		// @formatter:off
		return categorias.stream()
				.map(c -> new CategoriaResponseDTO(c))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public CategoriaResponseDTO buscarPorId(Long id) {
		Optional<Categoria> categoria = _categoriarepository.findById(id);
		if (categoria.isEmpty()) {
			throw new IdNotFoundException("Não existe uma categoria com esse id.");
		}
		return new CategoriaResponseDTO(categoria.get());
	}

	public CategoriaResponseDTO atualizar(CategoriaRequestDTO categoriaRequest, Long id) {
		CategoriaResponseDTO categoriaResponseDTO = buscarPorId(id);
		Categoria categoria = new Categoria(categoriaResponseDTO);
		categoria = _categoriarepository.save(categoria);
		return new CategoriaResponseDTO(categoria);
	}

	public void deletar(Long id) {
		buscarPorId(id);
		_categoriarepository.deleteById(id);
	}

}
