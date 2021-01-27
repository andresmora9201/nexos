package com.credibanco.assessment.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Autor;

@Repository
@Transactional
public class AutorDaoImpl extends AbstractSession implements AutorDao {

	@Override
	public void saveAutor(Autor autor) {
		// TODO Auto-generated method stub
		getSession().persist(autor);
	}

	@Override
	public void deleteAutorById(Long idAutor) {
		// TODO Auto-generated method stub
		Autor autor = findById(idAutor);
		if (autor  != null) {
			getSession().delete(autor);
		}
	}

	@Override
	public void updateAutor(Autor autor) {
		// TODO Auto-generated method stub
		getSession().update(autor);
	}

	@Override
	public List<Autor> findAllAutores() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Autor").list();
	}

	@Override
	public Autor findById(Long idAutor) {
		// TODO Auto-generated method stub
		return (Autor) getSession().get(Autor.class, idAutor);
	}

	@Override
	public Autor findByName(String nombre) {
		// TODO Auto-generated method stub
		return (Autor) getSession().createQuery(
				"from Autor where nombre = :nombre")
				.setParameter("nombre", nombre).uniqueResult();
	}	

}
