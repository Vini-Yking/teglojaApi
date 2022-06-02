package br.com.tegloja.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.tegloja.model.Foto;
import br.com.tegloja.model.Produto;
import br.com.tegloja.repository.FotoRepository;

@Service

public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;

	public Foto inserir(Produto produto, MultipartFile file) throws IOException {
		Foto foto = new Foto(file.getBytes(), file.getContentType(), file.getName(), produto);
		return fotoRepository.save(foto);
	}

	public Foto buscar(Long id) {
		Optional<Foto> foto = fotoRepository.findById(id);
		return foto.isPresent() ? foto.get() : null;
	}
}
