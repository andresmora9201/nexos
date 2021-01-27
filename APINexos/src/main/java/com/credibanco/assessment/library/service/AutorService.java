package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.model.*;

public interface AutorService {
	
	void saveAutor(Autor autor);
	
	void deleteAutorById(Long idAutor);
	
	void updateAutor(Autor autor);
	
	List<Autor> findAllAutors();
	
	Autor findById(Long idAutor);
	
	Autor findByName(String name);
	
	
}
