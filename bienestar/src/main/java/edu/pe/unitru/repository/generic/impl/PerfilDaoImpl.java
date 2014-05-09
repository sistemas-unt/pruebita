package edu.pe.unitru.repository.generic.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.repository.generic.PerfilDao;

@Repository(value = "perfilDao")
public class PerfilDaoImpl implements PerfilDao{
	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	public Perfil findByPerfil(Long idp2) {
		// TODO Auto-generated method stub
		
		return (Perfil)em.createQuery("Select p from Perfil p where p.persona="+idp2+"").getSingleResult();
	}
	public Perfil findByPerfil2(Long idp2) {
		// TODO Auto-generated method stub
		
		return (Perfil)em.createQuery("Select p from Perfil p where p.id="+idp2+"").getSingleResult();
	}
	public Perfil getDatosAlumno(String dni) {
		// TODO Auto-generated method stub
		try{
			return (Perfil)em.createQuery("select p from Perfil p inner join p.persona per where per.docIdentidad='"+dni+"'").getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	
	}
	
	public Perfil findById(long id) {
		try {
			Perfil perfil = em.find(Perfil.class, id);
			return perfil;
		} catch (NoResultException e) {
			return null;
		}
	}

}
