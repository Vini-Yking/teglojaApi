package br.com.tegloja.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.CategoriaRequestDTO;
import br.com.tegloja.dto.CategoriaResponseDTO;
import br.com.tegloja.services.CategoriaService;

@RestController
@RequestMapping("/tegloja/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaResponseDTO>> listar() {
		return ResponseEntity.ok(categoriaService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaResponseDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(categoriaService.buscarId(id));
	}

	@PostMapping
	public ResponseEntity<CategoriaResponseDTO> adicionar(@Valid @RequestBody CategoriaRequestDTO request) {
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.adicionar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriaResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaResponseDTO> atualizar(@Valid @RequestBody CategoriaRequestDTO request,
			@PathVariable Long id) {
		CategoriaResponseDTO responseBody = categoriaService.atualizar(request, id);

		return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		categoriaService.deletar(id);
		return ResponseEntity.ok().build();
	}

}
