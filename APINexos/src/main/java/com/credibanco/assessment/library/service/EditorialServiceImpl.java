package com.credibanco.assessment.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dao.*;
import com.credibanco.assessment.library.model.*;

@Service("editorialService")
@Transactional
public class EditorialServiceImpl implements EditorialService {
	
	@Autowired
	private EditorialDao _editorialDao;

	@Override
	public void saveEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		_editorialDao.saveEditorial(editorial);
	}

	@Override
	public void deleteEditorialById(Long idEditorial) {
		// TODO Auto-generated method stub
		_editorialDao.deleteEditorialById(idEditorial);
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		_editorialDao.updateEditorial(editorial);
	}

	@Override
	public List<Editorial> findAllEditorials() {
		// TODO Auto-generated method stub
		return _editorialDao.findAllEditorials();
	}

	@Override
	public Editorial findById(Long idEditorial) {
		// TODO Auto-generated method stub
		return _editorialDao.findById(idEditorial);
	}

	@Override
	public Editorial findByName(String name) {
		// TODO Auto-generated method stub
		return _editorialDao.findByName(name);
	}

	
}
