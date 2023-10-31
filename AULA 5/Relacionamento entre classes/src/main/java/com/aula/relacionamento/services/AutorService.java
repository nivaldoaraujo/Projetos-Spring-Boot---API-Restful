package com.aula.relacionamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.relacionamento.entities.Autor;
import com.aula.relacionamento.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	public List<Autor> getAll() {
		return repository.findAll();
	}
	
	public void saveAutor(Autor autor) {
		repository.save(autor);
	}
}
