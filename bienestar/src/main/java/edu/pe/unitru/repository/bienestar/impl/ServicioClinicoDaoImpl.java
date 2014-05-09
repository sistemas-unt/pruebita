package edu.pe.unitru.repository.bienestar.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.repository.bienestar.ServicioClinicoDao;


@Repository(value = "servicioClinicoDao")
public class ServicioClinicoDaoImpl implements ServicioClinicoDao{

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<ServicioSocial> getListaSocial() {
		// TODO Auto-generated method stub
		return em.createQuery("select per.nombres,per.apellidoPaterno,per.apellidoMaterno,per.docIdentidad,"
				+ "p.dependencia.nombre,s.estado,p.codigoPerfil  from ServicioSocial s join s.perfil p join p.persona per").getResultList();
	}
	
}