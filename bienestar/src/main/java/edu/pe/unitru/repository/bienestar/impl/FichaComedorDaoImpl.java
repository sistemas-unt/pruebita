package edu.pe.unitru.repository.bienestar.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.domain.bienestar.ComDataRequisito;
import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRegTicket;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;
import edu.pe.unitru.domain.bienestar.GrupoFamiliar;
import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.repository.bienestar.FichaComedorDao;

@Repository(value = "fichaComedorDao")
public class FichaComedorDaoImpl implements FichaComedorDao {
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
	public List<Persona> buscarDniList(Persona persona) {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select p.nombre,q.apellidoPaterno,q.apellidoMaterno,q.nombres,q.id from Dependencia p inner join "
								+ "p.perfils d inner join d.persona q where q.docIdentidad='"
								+ persona.getDocIdentidad() + "'")
				.getResultList();
	}

	@Transactional(readOnly = false)
	public void addFichacomedor(ComFichaComedor fichacomedor) {
		// TODO Auto-generated method stub
		em.persist(fichacomedor);
	}

	@Transactional(readOnly = false)
	public void editFichacomedor(ComFichaComedor fichacomedor) {
		// TODO Auto-generated method stub
		em.merge(fichacomedor);
	}



	@Transactional(readOnly = false)
	public void eliminarFichacomedor(ComFichaComedor fichacomedor) {
		// TODO Auto-generated method stub
		em.merge(fichacomedor);
	}
	
	@Transactional(readOnly = false)
	public void addDataRequisitos(ComDataRequisito datarequisito) {
		// TODO Auto-generated method stub
		em.persist(datarequisito);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComCategoria> getListaCategoria() {
		// TODO Auto-generated method stub
		return em.createQuery("select cc from ComCategoria cc").getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComFichaComedor> getListaComedor(Long ida) {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select c.perfilAlumno.persona.nombres,p.dependencia.nombre,c.comTicketsDependencia.id,c.categoria.tipo,c.id,c.perfilAlumno.persona.apellidoPaterno,c.perfilAlumno.persona.apellidoMaterno,c.perfilAlumno.persona.docIdentidad from ComFichaComedor c inner join c.perfilAlumno p where c.perfilAsistenta="
								+ ida + " and c.estado=1").getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComFichaComedor> getListaVerificarPadron() {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select c.id as idFicha, c.comTicketsDependencia.id as codComedor, p.docIdentidad as dni, pfl.codigoPerfil as codigo, p.apellidoPaterno || ' ' || p.apellidoMaterno || ' ' || p.nombres as nombres from ComFichaComedor c inner join c.perfilAlumno pfl inner join pfl.persona p order by dni")
				.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComFichaComedor> getDataTicket(int codigo) {
		// TODO Auto-generated method stub
		System.out.println(codigo);
		return em
				.createQuery(
						"select c.id as idFicha, c.comTicketsDependencia.id as codComedor, p.docIdentidad as dni, pfl.codigoPerfil as codigo, p.apellidoPaterno || ' ' || p.apellidoMaterno || ' ' || p.nombres as nombres, d.nombre as idDependencia from ComFichaComedor c inner join c.perfilAlumno pfl inner join pfl.persona p inner join pfl.dependencia d where c.id = "
								+ codigo).getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComFichaComedor> getRowTicket(int codigo) {
		// TODO Auto-generated method stub
		// System.out.println(codigo);

		String sql = "select t.boucher as boucher, t.fechaReg as fecha, t.cantidad as cantidad, t.monto as monto from ComRegTicket t inner join t.comFichaComedor c where c.id = "
				+ codigo;
		// sql =
		// "select c.id as idFicha, c.codigoAlumno as codComedor, p.docIdentidad as dni, pfl.codigoPerfil as codigo, p.apellidoPaterno || ' ' || p.apellidoMaterno || ' ' || p.nombres as nombres, d.nombre as idDependencia from ComFichaComedor c inner join c.perfilAlumno pfl inner join pfl.persona p inner join pfl.dependencia d where c.id = 5";
		// System.out.println(sql);
		return em.createQuery(sql).getResultList();
	}

	@Transactional(readOnly = false)
	public void addTicketComedor(ComRegTicket comregticket) {
		// TODO Auto-generated method stub

		em.persist(comregticket);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComFichaComedor> findbyHistoria(String dni, String codigoAlumno) {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select c.codigoAlumno, c.categoria.tipo,pfl.dependencia.nombre, c.observacion, p.nombres, p.apellidoPaterno, p.apellidoMaterno, p.docIdentidad"
								+ " from ComFichaComedor c inner join c.perfilAlumno pfl inner join pfl.persona p  where p.docIdentidad = '"
								+ dni
								+ "' or c.codigoAlumno = '"
								+ codigoAlumno + "'").getResultList();
	}

	public ComFichaComedor existeregistro(String dni) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select c from ComFichaComedor c inner join c.perfilAlumno p inner join p.persona pp where pp.docIdentidad = ?1";

			TypedQuery<ComFichaComedor> query = em.createQuery(queryStr,
					ComFichaComedor.class);
			query.setParameter(1, dni);
			ComFichaComedor resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}

	}
	
	public ComPermiso perteneceescuela(Long idasis,String dni) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select c from ComPermiso c,Perfil p inner join p.persona per where c.perfil.id=?1 and per.docIdentidad=?2 and p.dependencia=c.dependencia";

			TypedQuery<ComPermiso> query = em.createQuery(queryStr,
					ComPermiso.class);
			query.setParameter(1, idasis);
			query.setParameter(2, dni);
			ComPermiso resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}

	}

	public ComFichaComedor getFichaComedor(Integer id) {
		// TODO Auto-generated method stub

		String sql = "select c from ComFichaComedor c where c.id = " + id;

		return (ComFichaComedor) em.createQuery(sql).getSingleResult();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ComRequisito> getListaRequisitos() {

		return em.createQuery("select c from ComRequisito c order by c.id").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ComDataRequisito> requisitoporalumno(Long idf) {

		return em
				.createQuery(
						"select c from ComDataRequisito c  where c.comFichaComedor="
								+ idf + "").getResultList();
	}


	@Transactional(readOnly = true)
	public ComRequisito buscarRequisito(Long id) {
		// TODO Auto-generated method stub
		return (ComRequisito) em.createQuery(
				"select c from ComRequisito c where c.id='" + id + "'")
				.getSingleResult();
	}
	@Transactional
	public void eliminarrequisitos(Long idf) {
		 ComDataRequisito comDataRequisito = em.find(ComDataRequisito.class,idf );
		  em.remove(comDataRequisito);
	}

	public Object[] editarFichacomedor(Long ve) {
		// TODO Auto-generated method stub

		String queryStr = "select p.nombres,p.apellidoPaterno,p.apellidoMaterno,"
				+ "per.dependencia.nombre,per.dependencia.id,c.comTicketsDependencia.id,c.id,c.categoria.id,c.categoria.tipo,c.nota from ComFichaComedor c inner join c.perfilAlumno per inner join per.persona p where c.id= ?1";

		TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
		query.setParameter(1, ve);

		Object[] resultado = query.getSingleResult();
		return resultado;

	}

	@Transactional(readOnly = true)
	public ComFichaComedor getFichaComedor(Long id) {
		try {
			ComFichaComedor comFichaComedor = em
					.find(ComFichaComedor.class, id);
			return comFichaComedor;
		} catch (NoResultException e) {
			return null;
		}
	}


}