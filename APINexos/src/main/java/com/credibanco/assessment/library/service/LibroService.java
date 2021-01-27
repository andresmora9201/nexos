package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.model.*;

public interface LibroService {
	
	void saveLibro(Libro libro);
	
	void deleteLibroById(Long idLibro);
	
	void updateLibro(Libro libro);
	
	List<Libro> findAllLibros();
	
	Libro findById(Long idLibro);
	
	Libro findByName(String name);
	
	List<Libro> findByIdAutor(Long idAutor);
	
	List<Libro> findByIdEditorial(Long idEditorial);	
	
}
