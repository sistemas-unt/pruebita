package edu.pe.unitru.repository.generic.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.generic.UbigeoReniec;
import edu.pe.unitru.repository.generic.UbigeoDao;

@Repository
public class UbigeoDaoImpl implements UbigeoDao {
	
	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	public List<UbigeoReniec> getDepartamentos() {		
		String query = "select distinct u.departamento,u.nombreDepartamento from UbigeoReniec u order by u.nombreDepartamento";
		return em.createQuery(query).getResultList();
	}
	
	@Transactional(readOnly = true)
	public UbigeoReniec getUbigeo(Integer depa, Integer prov, Integer dist) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select u from UbigeoReniec u where u.departamento = ?1 and u.provincia = ?2 and u.distrito = ?3";

			TypedQuery<UbigeoReniec> query = em.createQuery(queryStr,UbigeoReniec.class);
			query.setParameter(1, depa);
			query.setParameter(2, prov);
			query.setParameter(3, dist);
			UbigeoReniec resultado = query.getSingleResult();
			
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

}
