package com.credibanco.assessment.library.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.credibanco.assessment.library.model.*;
import com.credibanco.assessment.library.service.*;
import com.credibanco.assessment.util.CustomErrorType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class LibroController {

	@Autowired
	LibroService _libroService;
	
	@Autowired
	EditorialService _editorialService;
	
	@Autowired
	AutorService _autorService;  

	// GET
	@RequestMapping(value = "/libros", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Libro>> getLibros() {

		List<Libro> libros = new ArrayList<>();
		libros = _libroService.findAllLibros();
		if (libros.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/libros", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createLibro(@RequestBody Libro libro,
			UriComponentsBuilder uriComponentsBuilder) {
		if (libro.getTitulo().equals(null) || libro.getTitulo().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		if (_libroService.findByName(libro.getTitulo()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}			
		
		if (libro.getEditorial() == null || _editorialService.findById(libro.getEditorial().getIdEditorial()) == null) {
			return new ResponseEntity(new CustomErrorType("La editorial no está registrada."), HttpStatus.CONFLICT);
		}
		
		if (libro.getAutor() == null || _autorService.findById(libro.getAutor().getIdAutor()) == null) {
			return new ResponseEntity(new CustomErrorType("El autor no está registrado."), HttpStatus.CONFLICT);
		}
		
		Editorial editorial = _editorialService.findById(libro.getEditorial().getIdEditorial());		
		if (editorial != null && _libroService.findAllLibros().size() >=  editorial.getMaximoLibros()) {
			return new ResponseEntity(new CustomErrorType("No es posible registrar el libro, se alcanzó el máximo permitido."), HttpStatus.CONFLICT);
		}	

		_libroService.saveLibro(libro);
		Libro libro2 = _libroService.findByName(libro.getTitulo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/libros/{id}")
				.buildAndExpand(libro2.getIdLibro()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
