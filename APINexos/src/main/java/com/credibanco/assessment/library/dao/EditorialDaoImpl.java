package com.credibanco.assessment.library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.*;

@Repository
@Transactional
public class EditorialDaoImpl extends AbstractSession implements EditorialDao {

	@Override
	public void saveEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		getSession().persist(editorial);
	}

	@Override
	public void deleteEditorialById(Long idEditorial) {
		// TODO Auto-generated method stub
		Editorial editorial = findById(idEditorial);
		if (editorial  != null) {
			getSession().delete(editorial );
		}
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		// TODO Auto-generated method stub
		getSession().update(editorial);
	}

	@Override
	public List<Editorial> findAllEditorials() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Editorial").list();
	}

	@Override
	public Editorial findById(Long idEditorial) {
		// TODO Auto-generated method stub
		return (Editorial) getSession().get(Editorial.class, idEditorial);
	}

	@Override
	public Editorial findByName(String nombre) {
		// TODO Auto-generated method stub
		return (Editorial) getSession().createQuery(
				"from Editorial where nombre = :nombre")
				.setParameter("nombre", nombre).uniqueResult();
	}
	

}
