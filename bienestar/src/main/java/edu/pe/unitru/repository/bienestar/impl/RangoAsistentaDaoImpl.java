package edu.pe.unitru.repository.bienestar.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;








import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.repository.bienestar.RangoAsistentaDao;

@Repository(value = "rangoAsistentaDao")
public class RangoAsistentaDaoImpl implements RangoAsistentaDao{

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComTicketsDependencia> getRango(Long ide) {
		// TODO Auto-generated method stub
		
		return em.createQuery("select ct.id,ct.ticket from ComTicketsDependencia c inner join c.comTicket ct where c.dependencia="+ide+" and c.comPeriodo.id=1 and ct.estado=1 order by ct.id").getResultList();
	}
	public ComTicketsDependencia findByCodigo(Long idp2) {
		// TODO Auto-generated method stub
		
		return (ComTicketsDependencia)em.createQuery("Select c from ComTicketsDependencia c where c.id="+idp2+"").getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<ComTicketsDependencia> codigosdisponibles(Long ide) {
		// TODO Auto-generated method stub
		
		return em.createQuery("select ct.id,ct.ticket from ComTicketsDependencia c inner join c.comTicket ct where c.dependencia.id="+ide+" and c.comTicket.estado=1 and c.comPeriodo.estado='1' order by ct.id ").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<ComPermiso> escuelas() {
		// TODO Auto-generated method stub
		
		return em.createQuery("select c.dependencia.id,c.dependencia.nombre from ComPermiso c ").getResultList();
	}
	public ComTicket findById(Long idp2) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "Select c from ComTicket c where c.id = ?1";

			TypedQuery<ComTicket> query = em.createQuery(queryStr,
					ComTicket.class);
			query.setParameter(1, idp2);
			ComTicket resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	@Transactional(readOnly = false)
	public void editarticket(ComTicket comticket) {
		// TODO Auto-generated method stub
		em.merge(comticket);
	}
	
	



}
