package com.credibanco.assessment.library.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.credibanco.assessment.library.model.*;
import com.credibanco.assessment.library.service.*;

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
public class AutorController {

	@Autowired
	AutorService _autorService;

	// GET
	@RequestMapping(value = "/autores", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Autor>> getAutors() {

		List<Autor> autors = new ArrayList<>();
		autors = _autorService.findAllAutors();
		if (autors.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Autor>>(autors, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/autores", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createAutor(@RequestBody Autor autor,
			UriComponentsBuilder uriComponentsBuilder) {
		if (autor.getNombre().equals(null) || autor.getNombre().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		if (_autorService.findByName(autor.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_autorService.saveAutor(autor);
		Autor autor2 = _autorService.findByName(autor.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/autors/{id}")
				.buildAndExpand(autor2.getIdAutor()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
