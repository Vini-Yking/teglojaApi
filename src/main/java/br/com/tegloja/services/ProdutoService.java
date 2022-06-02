package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.CategoriaResponseDTO;
import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.model.Categoria;
import br.com.tegloja.model.Produto;
import br.com.tegloja.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository _produtoRepository;
	@Autowired
	private CategoriaService categoriaService;

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
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarId(produtoRequest.getCategoria().getId());
		Categoria categoria = new Categoria(categoriaResponseDTO.getId(), categoriaResponseDTO.getCategoria());
		Produto produto = new Produto(produtoRequest);
		produto.setCategoria(categoria);
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
		CategoriaResponseDTO categoriaResponseDTO = categoriaService
				.buscarNome(produtoRequest.getCategoria().getCategoria());
		Categoria categoria = new Categoria(categoriaResponseDTO.getId(), categoriaResponseDTO.getCategoria());
		Produto produto = new Produto(produtoRequest);
		produto.setId(id);
		produto.setCategoria(categoria);
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
