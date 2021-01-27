package com.credibanco.assessment.library.dao;

import java.util.List;

import com.credibanco.assessment.library.model.*;

public interface LibroDao {
	void saveLibro(Libro libro);
	
	void deleteLibroById(Long idLibro);
	
	void updateLibro(Libro libro);
	
	List<Libro> findAllLibros();
	
	Libro findById(Long idLibro);
	
	Libro findByName(String name);
	
	List<Libro> findByIdEditorial(Long idEditorial);
	
	List<Libro> findByIdAutor(Long idAutor);
	
	
}
