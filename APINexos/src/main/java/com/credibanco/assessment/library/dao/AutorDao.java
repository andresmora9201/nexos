package com.credibanco.assessment.library.dao;

import java.util.List;

import com.credibanco.assessment.library.model.Autor;

public interface AutorDao {
	void saveAutor(Autor course);
	
	void deleteAutorById(Long idCourse);
	
	void updateAutor(Autor course);
	
	List<Autor> findAllAutores();
	
	Autor findById(Long idCourse);
	
	Autor findByName(String name);	
	
}
