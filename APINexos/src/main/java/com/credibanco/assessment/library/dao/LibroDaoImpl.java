package com.credibanco.assessment.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.*;

@Repository
@Transactional
public class LibroDaoImpl extends AbstractSession implements LibroDao {

	@Override
	public void saveLibro(Libro libro) {
		// TODO Auto-generated method stub
		getSession().persist(libro);
	}

	@Override
	public void deleteLibroById(Long idLibro) {
		// TODO Auto-generated method stub
		Libro libro = findById(idLibro);
		if (libro  != null) {
			getSession().delete(libro );
		}
	}

	@Override
	public void updateLibro(Libro libro) {
		// TODO Auto-generated method stub
		getSession().update(libro);
	}

	@Override
	public List<Libro> findAllLibros() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Libro").list();
	}

	@Override
	public Libro findById(Long idLibro) {
		// TODO Auto-generated method stub
		return (Libro) getSession().get(Libro.class, idLibro);
	}

	@Override
	public Libro findByName(String titulo) {
		// TODO Auto-generated method stub
		return (Libro) getSession().createQuery(
				"from Libro where titulo = :titulo")
				.setParameter("titulo", titulo).uniqueResult();
	}

	@Override
	public List<Libro> findByIdEditorial(Long idEditorial) {
		// TODO Auto-generated method stub
		return (List<Libro>) getSession().createQuery(
				"from Libro c join c.editorial t where t.idEditorial = :idEditorial")
				.setParameter("idEditorial", idEditorial).list();
	}	
	
	@Override
	public List<Libro> findByIdAutor(Long idAutor) {
		// TODO Auto-generated method stub
		return (List<Libro>) getSession().createQuery(
				"from Libro c join c.autor t where t.idAutor = :idAutor")
				.setParameter("idAutor", idAutor).list();
	}
	


}
