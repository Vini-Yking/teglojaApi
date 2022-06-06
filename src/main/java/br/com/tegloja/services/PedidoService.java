package br.com.tegloja.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tegloja.backend.config.MailConfig;
import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.enums.FormaPagamento;
import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.handler.ArgumentoInvalidoException;
import br.com.tegloja.handler.NaoEncontradoException;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Pedido;
import br.com.tegloja.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository _pedidorepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PedidoItemService pedidoItemService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private MailConfig mailConfig;

	public List<PedidoResponseDTO> buscarTodos() {
		List<Pedido> pedidos = _pedidorepository.findAll();
		// @formatter:off
		return pedidos.stream()
				.map(pedido -> new PedidoResponseDTO(pedido))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<PedidoResponseDTO> buscarPagina(Pageable page) {
		Page<Pedido> pedidos = _pedidorepository.findAll(page);

		return pedidos.map(pedido -> new PedidoResponseDTO(pedido));
	}

	public PedidoResponseDTO buscarPorIdPedido(Long id) {
		Optional<Pedido> pedido = _pedidorepository.findById(id);
		if (pedido.isEmpty()) {
			throw new NaoEncontradoException("Não existe um pedido com esse id.");
		}
		return new PedidoResponseDTO(pedido.get());
	}

	public List<PedidoResponseDTO> buscarPorIdCliente(Long idCliente) {
		ClienteResponseDTO clienteResponse = clienteService.buscarPorId(idCliente);
		Cliente cliente = new Cliente(clienteResponse);

		List<Pedido> pedidos = _pedidorepository.findByCliente(cliente);
		// @formatter:off
		return pedidos.stream()
				.map(pedido -> new PedidoResponseDTO(pedido))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<PedidoResponseDTO> buscarPorIdClientePaginado(Long idCliente, Pageable pageable) {
		ClienteResponseDTO clienteResponse = clienteService.buscarPorId(idCliente);
		Cliente cliente = new Cliente(clienteResponse);

		Page<Pedido> pedidos = _pedidorepository.findByCliente(cliente, pageable);

		return pedidos.map(pedido -> new PedidoResponseDTO(pedido));
	}

	public PedidoResponseDTO adicionar(PedidoRequestDTO pedidoRequest) {
		ClienteResponseDTO clienteResponseDTO = clienteService.buscarPorId(pedidoRequest.getClienteId());

		Cliente cliente = new Cliente(clienteResponseDTO);
		Pedido pedido = new Pedido(pedidoRequest);

		pedido.setCliente(cliente);
		pedido = _pedidorepository.save(pedido);
		/**
		 * Não foi possivel enviar email por limitação do google
		 * mailConfig.enviarEmail(cliente.getEmail(), "Compra Concluida!",
		 * pedido.toString());
		 */

		return new PedidoResponseDTO(pedido);
	}

	public PedidoResponseDTO iniciarPedidoVazio(PedidoRequestDTO requestDTO) {
		ClienteResponseDTO clienteDTO = clienteService.buscarPorId(requestDTO.getClienteId());
		Pedido pedido = new Pedido();
		pedido.setCliente(new Cliente(clienteDTO));
		pedido.setStatus(StatusCompra.NAO_FINALIZADO);
		pedido.setValortotal(BigDecimal.ZERO);
		pedido = _pedidorepository.save(pedido);
		pedido.setFormaPagamento(FormaPagamento.ABERTO);
		return new PedidoResponseDTO(pedido);
	}

	public PedidoResponseDTO finalizarPedido(Long idPedido, PedidoRequestDTO requestDTO) {
		PedidoResponseDTO pedidoResponse = buscarPorIdPedido(idPedido);
		List<PedidoItemResponseDTO> itens = pedidoItemService.buscarPorIdPedido(idPedido);
		
		FormaPagamento pagamento = FormaPagamento.verificaPagamento(requestDTO.getFormaPagamento().intValue());
		
		
		// Verifica o estoque dos produtos
		for (PedidoItemResponseDTO pedidoItemResponseDTO : itens) {
			Long idProduto = pedidoItemResponseDTO.getProduto().getId();
			ProdutoResponseDTO produtoResponse = produtoService.buscarPorId(idProduto);
			Integer quantidadeProduto = pedidoItemResponseDTO.getQuantidadeProduto();

			if (quantidadeProduto > produtoResponse.getQuantidadeEstoque()) {
				throw new ArgumentoInvalidoException("Sem estoque para o produto: " + produtoResponse.getNomeProduto());
			}
		}

		// Subtrai do estoque
		for (PedidoItemResponseDTO pedidoItemResponseDTO : itens) {
			Long idProduto = pedidoItemResponseDTO.getProduto().getId();
			produtoService.subtrairEstoque(idProduto, pedidoItemResponseDTO.getQuantidadeProduto());
		}

		Pedido pedido = new Pedido(pedidoResponse);
		// @formatter:off
		BigDecimal total = itens.stream()
				.map(x -> x.getValorVenda())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		// @formatter:on
		pagamento.verificaPagamentoFinalizado(requestDTO.getFormaPagamento().intValue());
		total.setScale(2, RoundingMode.HALF_UP);
		pedido.setValortotal(total);
		pedido.setDataCompra(LocalDate.now());
		pedido.setDataEntrega(LocalDate.now().plusDays(7));
		pedido.setStatus(StatusCompra.FINALIZADO);
		pedido.setFormaPagamento(pagamento);
		pedido = _pedidorepository.save(pedido);

		return new PedidoResponseDTO(pedido);
	}

	public PedidoResponseDTO atualizar(PedidoRequestDTO pedidoRequest, Long id) {
		buscarPorIdPedido(id);
		ClienteResponseDTO clienteResponseDTO = clienteService.buscarPorId(pedidoRequest.getClienteId());

		Cliente cliente = new Cliente(clienteResponseDTO);
		Pedido pedido = new Pedido(pedidoRequest);

		pedido.setCliente(cliente);
		pedido.setId(id);
		pedido = _pedidorepository.save(pedido);

		return new PedidoResponseDTO(pedido);
	}

	public void deletar(Long id) {
		buscarPorIdPedido(id);
		_pedidorepository.deleteById(id);
	}

}
