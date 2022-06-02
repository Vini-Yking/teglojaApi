package br.com.tegloja.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.model.Foto;
import br.com.tegloja.services.FotoService;
import br.com.tegloja.services.ProdutoService;

@RestController
@RequestMapping("/tegloja/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FotoService fotoService;

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		return ResponseEntity.ok(produtoService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscar(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@RequestBody ProdutoRequestDTO produtoRequest, Long id) {
		return ResponseEntity.ok(produtoService.atualizar(produtoRequest, id));
	}
	
	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id){
		Foto foto = fotoService.buscar(id); // busco a foto no banco
		HttpHeaders headers = new HttpHeaders();//crio o cabeçalho
		headers.add("content-type", foto.getTipo());//tipo do arquivo png,jpge
		headers.add("content-length", String.valueOf(foto.getDados().length));//tamanho do arquivo 1kb 2mb
		return new ResponseEntity<>(foto.getDados(),headers,HttpStatus.OK);//retorno na resposta a foto, o cabeçalho e a resposta do servidor
		
	}

//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<ProdutoResponseDTO> adicionar(@Valid @RequestBody ProdutoRequestDTO produtoRequest){
//		ProdutoResponseDTO produtoResponseDTO = produtoService.adicionar(produtoRequest);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();
//		return ResponseEntity.created(uri).body(produtoResponseDTO);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutoResponseDTO> adicionarComFoto (@Valid @RequestParam MultipartFile file, @RequestPart ProdutoRequestDTO produtoRequest) throws IOException{
		ProdutoResponseDTO produtoResponseDTO = produtoService.adicionarComFoto(produtoRequest,file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();
		return ResponseEntity.created(uri).body(produtoResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
			produtoService.deletar(id);
			return ResponseEntity.noContent().build();
	}

}
