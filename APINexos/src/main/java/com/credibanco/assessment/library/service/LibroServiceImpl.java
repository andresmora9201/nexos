package com.credibanco.assessment.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dao.*;
import com.credibanco.assessment.library.model.*;

@Service("libroService")
@Transactional
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	private LibroDao _libroDao;

	@Override
	public void saveLibro(Libro libro) {
		// TODO Auto-generated method stub
		_libroDao.saveLibro(libro);
	}

	@Override
	public void deleteLibroById(Long idLibro) {
		// TODO Auto-generated method stub
		_libroDao.deleteLibroById(idLibro);
	}

	@Override
	public void updateLibro(Libro libro) {
		// TODO Auto-generated method stub
		_libroDao.updateLibro(libro);
	}

	@Override
	public List<Libro> findAllLibros() {
		// TODO Auto-generated method stub
		return _libroDao.findAllLibros();
	}

	@Override
	public Libro findById(Long idLibro) {
		// TODO Auto-generated method stub
		return _libroDao.findById(idLibro);
	}

	@Override
	public Libro findByName(String name) {
		// TODO Auto-generated method stub
		return _libroDao.findByName(name);
	}

	@Override
	public List<Libro> findByIdAutor(Long idAutor) {
		// TODO Auto-generated method stub
		return _libroDao.findByIdAutor(idAutor);
	}
	
	@Override
	public List<Libro> findByIdEditorial(Long idEditorial) {
		// TODO Auto-generated method stub
		return _libroDao.findByIdEditorial(idEditorial);
	}
	
	

}
