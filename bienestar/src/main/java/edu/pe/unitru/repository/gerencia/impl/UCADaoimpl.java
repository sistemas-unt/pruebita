package edu.pe.unitru.repository.gerencia.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




import edu.pe.unitru.domain.gerencia.PersonalAdminCas;
import edu.pe.unitru.repository.gerencia.UCADao;


@Repository(value = "fichacontrolrepositorio")
public class UCADaoimpl implements  UCADao{

	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<PersonalAdminCas> seleccionarPersonalAdmin(){
		// TODO Auto-generated method stub
		return  em.createQuery("select cas.numeroResolucion,cas.TipoFicha.id from PersonalAdminCas cas where cas.id='1'").getResultList();
	}
	
}
