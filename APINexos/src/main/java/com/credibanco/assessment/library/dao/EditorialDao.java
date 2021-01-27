package com.credibanco.assessment.library.dao;

import java.util.List;

import com.credibanco.assessment.library.model.*;

public interface EditorialDao {
	void saveEditorial(Editorial Editorial);
	
	void deleteEditorialById(Long idEditorial);
	
	void updateEditorial(Editorial editorial);
	
	List<Editorial> findAllEditorials();
	
	Editorial findById(Long idEditorial);
	
	Editorial findByName(String name);	
	
}
