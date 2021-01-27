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
public class EditorialController {

	@Autowired
	EditorialService _editorialService;

	// GET
	@RequestMapping(value = "/editoriales", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Editorial>> getEditorials() {

		List<Editorial> editorials = new ArrayList<>();
		editorials = _editorialService.findAllEditorials();
		if (editorials.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Editorial>>(editorials, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/editoriales", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createEditorial(@RequestBody Editorial editorial,
			UriComponentsBuilder uriComponentsBuilder) {
		if (editorial.getNombre().equals(null) || editorial.getNombre().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		if (_editorialService.findByName(editorial.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_editorialService.saveEditorial(editorial);
		Editorial editorial2 = _editorialService.findByName(editorial.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/editorials/{id}")
				.buildAndExpand(editorial2.getIdEditorial()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
