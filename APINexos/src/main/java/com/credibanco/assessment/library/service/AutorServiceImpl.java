package com.credibanco.assessment.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dao.*;
import com.credibanco.assessment.library.model.*;

@Service("autorService")
@Transactional
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorDao _autorDao;

	@Override
	public void saveAutor(Autor autor) {
		// TODO Auto-generated method stub
		_autorDao.saveAutor(autor);
	}

	@Override
	public void deleteAutorById(Long idAutor) {
		// TODO Auto-generated method stub
		_autorDao.deleteAutorById(idAutor);
	}

	@Override
	public void updateAutor(Autor autor) {
		// TODO Auto-generated method stub
		_autorDao.updateAutor(autor);
	}

	@Override
	public List<Autor> findAllAutors() {
		// TODO Auto-generated method stub
		return _autorDao.findAllAutores();
	}

	@Override
	public Autor findById(Long idAutor) {
		// TODO Auto-generated method stub
		return _autorDao.findById(idAutor);
	}

	@Override
	public Autor findByName(String name) {
		// TODO Auto-generated method stub
		return _autorDao.findByName(name);
	}

	
}
