package br.com.tegloja.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.tegloja.handler.NaoEncontradoException;
import br.com.tegloja.model.Foto;
import br.com.tegloja.model.Produto;
import br.com.tegloja.repository.FotoRepository;

@Service

public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;

	public Foto inserir(Produto produto, MultipartFile file) throws IOException {
		Foto foto = new Foto(produto, file);

		return fotoRepository.save(foto);
	}

	public Foto buscarPorId(Long id) {
		Optional<Foto> foto = fotoRepository.findById(id);
		if (foto.isEmpty())
			throw new NaoEncontradoException("Imagem não encontrada.");
		return foto.get();
	}
}
