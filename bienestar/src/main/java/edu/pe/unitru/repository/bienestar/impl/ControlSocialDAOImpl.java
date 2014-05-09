package edu.pe.unitru.repository.bienestar.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.bienestar.ComDataRequisito;
import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPeriodo;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;
import edu.pe.unitru.domain.generic.Dependencia;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.repository.bienestar.ControlSocialDAO;

@Repository(value = "ControlSocialDao")
public class ControlSocialDAOImpl implements ControlSocialDAO  {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
//	@Transactional(readOnly = false)
//	public void addComedorAsistenta(ComRangoAsistenta asistenta) {
//		// TODO Auto-generated method stub
//		em.persist(asistenta);
//	}
	
	@Transactional(readOnly = false)
	public void addPermiso(ComPermiso permiso) {
		// TODO Auto-generated method stub
		em.persist(permiso);
	}
	@Transactional(readOnly = false)
	public void agregarSobratickets(ComTicketsDependencia comTicketsDependencia) {
		// TODO Auto-generated method stub
		em.persist(comTicketsDependencia);
	}
	@Transactional(readOnly = false)
	public void agregarescuela(ComPermiso comPermiso) {
		// TODO Auto-generated method stub
		em.persist(comPermiso);
	}
	

	@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public List<Dependencia> getListEscuela(long codigo) {
		// TODO Auto-generated method stub

		return em.createQuery("select distinct d.id, d.nombre,(select count(c.comTicket.id) from ComTicketsDependencia c where c.dependencia.id=d.id),(select count(c.comTicket.id) from ComTicketsDependencia c where c.comTicket.estado=1 and c.dependencia.id=d.id),(select count(c.comTicket.id) from ComTicketsDependencia c where c.comTicket.estado=0 and c.dependencia.id=d.id) from ComTicketsDependencia ct,ComPermiso x right outer join ct.dependencia d join d.tipoDependencia t join x.perfil per where t.id = 3 and d.id=x.dependencia and d.id not in(28,217,218,219,220,221,222) and per.id="+codigo+" order by d.nombre").getResultList();

	}
	
   @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Dependencia> getListEscuelaDisponibles2(long codigo) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT d.id, d.nombre from Dependencia d where d.tipoDependencia= 3 and d.id != 28 and d.id not in  (SELECT d.id from ComPermiso p join p.dependencia d where d.tipoDependencia=3 and d.id != 28 and p.perfil.id='"+codigo+"')").getResultList();
	}
   @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Dependencia> getListEscuelaDisponibles(long codigo) {
		// TODO Auto-generated method stub
		return em.createQuery("select c.id, d.id, d.nombre from ComPermiso c right outer join c.dependencia d where d.tipoDependencia=3 and d.id!=28 and c.id=null and d.id!=217 and d.id!=218 and d.id!=219 and d.id!=220 and d.id!=221 and d.id!=222").getResultList();
	}
   @Transactional(readOnly = true)
 	@SuppressWarnings("unchecked")
 	public List<ComTicket> getListTickets() {
 		// TODO Auto-generated method stub
 		return em.createQuery("SELECT d.id, d.nombre from Dependencia d where d.tipoDependencia= 3 and d.id != 28 and d.id not in  (SELECT d.id from ComPermiso p join p.dependencia d where d.tipoDependencia=3 and d.id != 28 )").getResultList();
 	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Dependencia> getListEscuelasTotales() {
		// TODO Auto-generated method stub
		return em.createQuery("select distinct d.id, d.nombre,(select count(c.comTicket.id) from ComTicketsDependencia c where c.dependencia.id=d.id and c.comPeriodo.estado='1'),(select count(c.comTicket.id) from ComTicketsDependencia c where c.comTicket.estado=1 and c.dependencia.id=d.id and c.comPeriodo.estado='1'),(select count(c.comTicket.id) from ComTicketsDependencia c where c.comTicket.estado=0 and c.dependencia.id=d.id and c.comPeriodo.estado='1'),per.persona.nombres,per.persona.apellidoPaterno from ComTicketsDependencia ct,ComPermiso x right outer join ct.dependencia d join d.tipoDependencia t join x.perfil per where t.id = 3 and d.id=x.dependencia and d.id not in(28,217,218,219,220,221,222) order by d.nombre").getResultList();
	}
	
	@Transactional(readOnly = true)
	public Perfil findAsistentaByDni(String dni)
	{
		// TODO Auto-generated method stub
		try{
	    
		return (Perfil) em.createQuery("Select q from Perfil q inner join q.persona p  where q.persona.docIdentidad='"+dni+"' and q.rol=4 ").getSingleResult();
	
		 } 
		catch(NoResultException e) {
		        return null;
		    }
		
		}

	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Persona findAsistentainComedor(String dni)
	{
		// TODO Auto-generated method stub
		try{
		return (Persona)em.createQuery("select q from ComRangoAsistenta a inner join a.comPermiso p inner join p.perfil.persona q where q.docIdentidad='"+dni+"' ").getSingleResult();
		 } 
		catch(NoResultException e) {
		        return null;
		    }
		}
		
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Persona> getListAsistentas() {
		// TODO Auto-generated method stub
		return em.createQuery("select  per.id,p.nombres,p.apellidoPaterno,p.apellidoMaterno,count(c.dependencia),p.docIdentidad from ComPermiso c inner join c.perfil per inner join per.persona p  group BY per.id,p.nombres,p.apellidoPaterno,p.apellidoMaterno,p.docIdentidad").getResultList();
	}
	
	@Transactional(readOnly = true)
	
	public Object[] getDataAsistenta(long  codigo) {
		// TODO Auto-generated method stub
		String queryStr =" select  per.nombres, per.apellidoPaterno ,per.apellidoMaterno,p.id from Perfil p inner join p.persona per where p.id=?1";
		TypedQuery<Object[]> query = em.createQuery(queryStr , Object[].class);
		query.setParameter(1,codigo);
//		query.setParameter(2, dni);
		Object[] resultado = query.getSingleResult();				
		return resultado;		
		
		
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public ComTicket buscarcodigo(Long id) {
		// TODO Auto-generated method stub
		return (ComTicket) em.createQuery(
				"select c from ComTicket c where c.id="+id+" "  )
				.getSingleResult();
	}
	
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public ComPeriodo buscarperiodo(Long id) {
		// TODO Auto-generated method stub
		return (ComPeriodo) em.createQuery(
				"select c from ComPeriodo c where c.id="+id+" "  )
				.getSingleResult();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public ComTicketsDependencia getComTickestDependencia(Long id) {
		// TODO Auto-generated method stub
		return (ComTicketsDependencia) em.createQuery(
				"select c from ComTicketsDependencia c where c.comTicket="+id+" "  )
				.getSingleResult();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Dependencia getescuelas(Long id) {
		try {
			Dependencia dependencia = em
					.find(Dependencia.class, id);
			return dependencia;
		} catch (NoResultException e) {
			return null;
		}
	}
	@Transactional(readOnly = false)
	public void editartickets(ComTicketsDependencia comTicketsDependencia) {
		// TODO Auto-generated method stub
		em.merge(comTicketsDependencia);
	}
	@SuppressWarnings("unchecked")
	public List<ComTicketsDependencia> codigossobrantes() {
		// TODO Auto-generated method stub
		
		return em.createQuery("select ct.id,ct.ticket from ComTicketsDependencia c right outer join c.comTicket ct where c.id=null order by ct.id").getResultList();
	}
	@Transactional
	public void eliminarescuela(Long idf) {
		 ComPermiso comPermiso = em.find(ComPermiso.class,idf );
		  em.remove(comPermiso);
	}
	@Transactional
	public void eliminarcodigo(Long idf) {
		 ComTicketsDependencia comTicketsDependencia = em.find(ComTicketsDependencia.class,idf );
		  em.remove(comTicketsDependencia);
	}
	@SuppressWarnings("unchecked")
	public ComPermiso buscaridpermiso(Long id) {
		// TODO Auto-generated method stub
		return (ComPermiso) em.createQuery(
				"select c from ComPermiso c where c.dependencia.id="+id+"")
				.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<ComTicketsDependencia> buscarcodigos(Long idf) {

		return em
				.createQuery(
						"select ctd from ComTicketsDependencia ctd where ctd.dependencia="+idf+"").getResultList();
	}
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Dependencia buscarescuela(Long id) {
		// TODO Auto-generated method stub
		return (Dependencia) em.createQuery(
				"select d from Dependencia d where d.id='" + id + "'")
				.getSingleResult();
	}

}
	