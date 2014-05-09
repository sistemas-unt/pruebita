package edu.pe.unitru.repository.bienestar.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;


import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.repository.bienestar.CategoriaDao;

@Repository(value = "categoriaDao")
public class CategoriaDaoImpl implements CategoriaDao{

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	public ComCategoria findByCategoria(Long idcat) {
		// TODO Auto-generated method stub
		
		return (ComCategoria)em.createQuery("Select c from ComCategoria c where c.id="+idcat+"").getSingleResult();
	}
}
