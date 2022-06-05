package br.com.tegloja.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.CategoriaResponseDTO;
import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.handler.NaoEncontradoException;
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
	public List<ProdutoResponseDTO> buscarTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		// @formatter:off
		return produtos.stream()
				.map(produto -> new ProdutoResponseDTO(produto))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<ProdutoResponseDTO> buscarPagina(Pageable page) {
		Page<Produto> produtos = produtoRepository.findAll(page);

		return produtos.map(produto -> new ProdutoResponseDTO(produto));
	}

	public Page<ProdutoResponseDTO> buscarPorNome(Pageable page, String nome) {
		Page<Produto> produtos = produtoRepository.findByNomeProdutoContainingIgnoreCase(page, nome);

		return produtos.map(produto -> new ProdutoResponseDTO(produto));
	}

	public List<ProdutoResponseDTO> buscarPorCategoria(Long idCategoria) {
		CategoriaResponseDTO categoriaResponse = categoriaService.buscarPorId(idCategoria);
		Categoria categoria = new Categoria(categoriaResponse);
		List<Produto> produtos = produtoRepository.findByCategoria(categoria);
		// @formatter:off
		return produtos.stream()
				.map(produto -> new ProdutoResponseDTO(produto))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<ProdutoResponseDTO> buscarPorCategoriaPaginado(Pageable pageable, Long idCategoria) {
		CategoriaResponseDTO categoriaResponse = categoriaService.buscarPorId(idCategoria);
		Categoria categoria = new Categoria(categoriaResponse);
		Page<Produto> produtos = produtoRepository.findByCategoria(pageable, categoria);

		return produtos.map(produto -> new ProdutoResponseDTO(produto));
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

//	public ProdutoResponseDTO adicionarComFoto(ProdutoRequestDTO produtoRequest, MultipartFile file)
//			throws IOException {
//		CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarPorId(produtoRequest.getCategoria().getId());
//		Categoria categoria = new Categoria(categoriaResponseDTO);
//		Produto produto = new Produto(produtoRequest);
//		produto.setCategoria(categoria);
//		if()
//		fotoService.inserir(produtoRepository.save(produto), file);
//		return new ProdutoResponseDTO(produto);
//	}

	public ProdutoResponseDTO buscarPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isEmpty()) {
			throw new NaoEncontradoException("Não existe um produto com esse id.");
		}
		return new ProdutoResponseDTO(produto.get());
	}

	public ProdutoResponseDTO atualizar(ProdutoRequestDTO produtoRequest, Long id) {
		buscarPorId(id);
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.buscarPorId(produtoRequest.getCategoria().getId());

		Categoria categoria = new Categoria(categoriaResponseDTO);
		Produto produto = new Produto(produtoRequest);
		produto.setDataAlteracao(LocalDate.now());
		produto.setCategoria(categoria);
		produto.setId(id);
		produtoRepository.save(produto);

		return new ProdutoResponseDTO(produto);
	}

	public ProdutoResponseDTO subtrairEstoque(Long idProduto, Integer quantidade) {
		ProdutoResponseDTO produtoResponse = buscarPorId(idProduto);

		Produto produto = new Produto(produtoResponse);
		produto.setQuantidadeEstoq(produto.getQuantidadeEstoque() - quantidade);
		produtoRepository.save(produto);

		return new ProdutoResponseDTO(produto);
	}

	public void deletar(Long id) {
		buscarPorId(id);
		produtoRepository.deleteById(id);
	}

}
