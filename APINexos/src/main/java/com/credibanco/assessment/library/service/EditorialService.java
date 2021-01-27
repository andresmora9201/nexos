package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.model.*;

public interface EditorialService {
	
	void saveEditorial(Editorial editorial);
	
	void deleteEditorialById(Long idEditorial);
	
	void updateEditorial(Editorial editorial);
	
	List<Editorial> findAllEditorials();
	
	Editorial findById(Long idEditorial);
	
	Editorial findByName(String name);
	
	
}
