package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.produto.ProdutoRequestDTO;
import br.com.tegloja.dto.produto.ProdutoResponseDTO;
import br.com.tegloja.model.Categoria;
import br.com.tegloja.model.Produto;
import br.com.tegloja.repository.CategoriaRepository;
import br.com.tegloja.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository _produtoRepository;
	@Autowired
	private CategoriaRepository _categoriaRepository;

	// Ao listar os produtos, deverá exibir a categoria referente a esse produto
	public List<ProdutoResponseDTO> listar() {
		List<Produto> produtos = _produtoRepository.findAll();
		// @formatter:off
		return produtos.stream()
				.map(p -> new ProdutoResponseDTO(p))
				.collect(Collectors.toList());
		// @formatter:on
	}

	// Ao inserir um novo produto, obrigatoriamente deverá estar atrelado a uma
	// categoria
	public ProdutoResponseDTO adicionar(ProdutoRequestDTO produtoRequest) {
		Optional<Categoria> categoria = _categoriaRepository
				.findByCategoria(produtoRequest.getCategoria().getCategoria());
		if (categoria.isEmpty()) {
			// throw new BAD REQUEST categoria inválida
		}
		Produto produto = new Produto(produtoRequest);
		produto = _produtoRepository.save(produto);

		return new ProdutoResponseDTO(produto);
	}

	public ProdutoResponseDTO buscar(Long id) {
		Optional<Produto> produto = _produtoRepository.findById(id);
		if (produto.isEmpty()) {
			// throw new NOT FOUND produto não encontrado
		}
		return new ProdutoResponseDTO(produto.get());
	}

	public ProdutoResponseDTO atualizar(ProdutoRequestDTO produtoRequest, Long id) {
		if (_produtoRepository.findById(id).isEmpty()) {
			// throw new NOT FOUND
		}
		Produto produto = new Produto(produtoRequest);
		produto.setId(id);
		_produtoRepository.save(produto);
		return new ProdutoResponseDTO(produto);
	}

	public void deletar(Long id) {
		if (_produtoRepository.findById(id).isEmpty()) {
			// throw new NOT FOUND
		}
		_produtoRepository.deleteById(id);
	}

}
