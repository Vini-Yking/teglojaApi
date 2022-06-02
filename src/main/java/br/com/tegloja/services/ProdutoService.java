package br.com.tegloja.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.tegloja.dto.CategoriaResponseDTO;
import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.Categoria;
import br.com.tegloja.model.Produto;
import br.com.tegloja.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private FotoService fotoService;
	
	// Ao listar os produtos, deverá exibir a categoria referente a esse produto
	public List<ProdutoResponseDTO> listar() {
		List<Produto> produtos = produtoRepository.findAll();
		// @formatter:off
		return produtos.stream()
				.map(p -> new ProdutoResponseDTO(p))
				.collect(Collectors.toList());
		// @formatter:on
	}

	/**
	 * Ao inserir um novo produto, obrigatoriamente deverá estar atrelado a uma
	 * categoria
	 * 
	 * @param produtoRequest
	 * @return
	 */
	public ProdutoResponseDTO adicionar(ProdutoRequestDTO produtoRequest) {
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarPorId(produtoRequest.getCategoria().getId());

		Categoria categoria = new Categoria(categoriaResponseDTO);
		Produto produto = new Produto(produtoRequest);

		produto.setCategoria(categoria);
		produto = produtoRepository.save(produto);

		return new ProdutoResponseDTO(produto);
	}

	public ProdutoResponseDTO adicionarComFoto(ProdutoRequestDTO produtoRequest,MultipartFile file)  throws IOException {
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarId(produtoRequest.getCategoria().getId());
		Categoria categoria = new Categoria(categoriaResponseDTO);
		Produto produto = new Produto(produtoRequest);
		produto.setCategoria(categoria);
		fotoService.inserir(produtoRepository.save(produto),file);
		return new ProdutoResponseDTO(produto);
	}
	
	public ProdutoResponseDTO buscar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isEmpty()) {
			throw new IdNotFoundException("Não existe um produto com esse id.");
		}
		return new ProdutoResponseDTO(produto.get());
	}

	public ProdutoResponseDTO atualizar(ProdutoRequestDTO produtoRequest, Long id) {
		ProdutoResponseDTO produtoDTO = buscar(id);
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarPorId(produtoRequest.getCategoria().getId());

		Categoria categoria = new Categoria(categoriaResponseDTO);
		Produto produto = new Produto(produtoDTO);
		produto.setCategoria(categoria);
		produtoRepository.save(produto);

		return new ProdutoResponseDTO(produto);
	}

	public void deletar(Long id) {
		buscar(id);
		produtoRepository.deleteById(id);
	}

}
