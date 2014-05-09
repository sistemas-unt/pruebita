package edu.pe.unitru.repository.generic.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.repository.generic.PersonaDao;

@Repository(value = "personaDao")
public class PersonaDaoImpl implements PersonaDao {

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
	public List<Persona> getPersonaList() {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"SELECT c.id,c.domicilioActual,c.email,c.docIdentidad,c.apellidoPaterno,c.apellidoMaterno,c.nombres FROM Persona c")
				.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Persona> getPersonaByDni(String dni) {
		
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select  p.id, p.apellidoPaterno,p.apellidoMaterno,p.nombres,p.docIdentidad,p.sexo,p.estadoCivil,p.fechaNacimiento,p.telefono,p.celular,p.email"
								+ ",q.nombre,p.idLugarNacimiento.nombre as distritoN"
								+ ",(select distinct (u.nombre) from Ubigeo u where (p.idLugarNacimiento.departamento= u.departamento) and u.provincia=0 and u.distrito=0) as departamentoN"
								+ ",(select distinct (u.nombre ) from Ubigeo u where (p.idLugarNacimiento.departamento= u.departamento) and(p.idLugarNacimiento.provincia= u.provincia) and u.distrito=0 ) as provinciaN"
								+ ",p.lugarProcedencia.nombre as distritoP"
								+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarProcedencia.departamento= u.departamento) and u.provincia=0 and u.distrito=0) as departamentoP"
								+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarProcedencia.departamento= u.departamento) and(p.lugarProcedencia.provincia= u.provincia) and u.distrito=0 ) as provinciaP"
								+ ",p.lugarActual.nombre as distritoA "
								+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarActual.departamento= u.departamento) and u.provincia=0 and u.distrito=0) as departamentoA"
								+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarActual.departamento= u.departamento) and(p.lugarActual.provincia= u.provincia) and u.distrito=0 ) as provinciaA"
								+ ",p.domicilioActual as domicilio from Dependencia q inner join q.perfils d inner join d.persona p where p.docIdentidad='"+dni+"'")
				.getResultList();
	}

	@Transactional(readOnly = false)
	public void addUsuario(Persona usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);
	}

	public void deleteUsuario(long id) {
		// TODO Auto-generated method stub

	}

	public Persona findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = false)
	public void updateUsuario(Persona usuario) {
		// TODO Auto-generated method stub

		em.merge(usuario);
	}
	
	@Transactional(readOnly = false)
	public void updateEmail(Persona p) {
		// TODO Auto-generated method stub
		
		em.merge(p);
	}

	public Persona findByDni(String dni) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "Select p from Persona p where p.docIdentidad = ?1";

			TypedQuery<Persona> query = em.createQuery(queryStr,
					Persona.class);
			query.setParameter(1, dni);
			Persona resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	
	}


	public Object[] findPersonaByDni(String dni) {
		// TODO Auto-generated method stub
		try {
		String queryStr = "select  p.id, p.apellidoPaterno,p.apellidoMaterno,p.nombres,p.docIdentidad,p.sexo,p.estadoCivil,p.fechaNacimiento,p.telefono,p.celular,p.email"
					+ ",q.nombre,p.idLugarNacimiento.nombre as distritoN" 
				+ ",(select distinct (u.nombre) from Ubigeo u where (p.idLugarNacimiento.departamento= u.departamento) and u.provincia=0 and u.distrito=0) as departamentoN" 
				+ ",(select distinct (u.nombre ) from Ubigeo u where (p.idLugarNacimiento.departamento= u.departamento) and(p.idLugarNacimiento.provincia= u.provincia) and u.distrito=0 ) as provinciaN" 
				+ ",p.lugarProcedencia.nombre as distritoP" 
				+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarProcedencia.departamento= u.departamento) and u.provincia=0 and u.distrito=0) as departamentoP" 
				+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarProcedencia.departamento= u.departamento) and(p.lugarProcedencia.provincia= u.provincia) and u.distrito=0 ) as provinciaP"  
				+ ",p.lugarActual.nombre as distritoA "
				+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarActual.departamento= u.departamento) and u.provincia=0 and u.distrito=0) as departamentoA" 
				+ ",(select distinct (u.nombre ) from Ubigeo u where (p.lugarActual.departamento= u.departamento) and(p.lugarActual.provincia= u.provincia) and u.distrito=0 ) as provinciaA" 
				+ ",p.domicilioActual as domicilio,d.id from Dependencia q inner join q.perfils d inner join d.persona p where p.docIdentidad= ?1";
		
		TypedQuery<Object[]> query = em.createQuery(queryStr , Object[].class);
		query.setParameter(1,dni);
//		query.setParameter(2, dni);
		Object[] resultado = query.getSingleResult();				
		return resultado;	
		}catch(NoResultException e) {
			return null;
		}
		
	}
	
	public Object[] findDatosPersonalesByDni(String dni) {
		// TODO Auto-generated method stub
		try {
		String queryStr = "select p.id as perfil,per.id as persona,d.id as dep,dep.id as dep_pertenece,s.id as sede,r.id as ocupacion,per.docIdentidad as dni,p.codigoPerfil as codigo,per.nombres as nombres,per.apellidoPaterno as paterno,per.apellidoMaterno as materno,per.sexo as sexo,per.estadoCivil as estado_civil,per.fechaNacimiento as fecha_nac,r.nombre as ocupacion,d.nombre as depe,dep.nombre as pertenece,s.nombre as sede,t.nombre as tipo_dep,per.domicilioActual as dom_actual,per.domicilioFamiliar as dom_familiar,per.telefono as telefono,per.celular as celular,per.email as email,per.lugarNacimiento as lugar_nac,nac.id as nacimiento_id,nac.departamento,nac.provincia,nac.distrito,nac.nombreDepartamento,nac.nombreProvincia,nac.nombreDistrito,proc.id as procedencia_id,proc.departamento,proc.provincia,proc.distrito,proc.nombreDepartamento,proc.nombreProvincia,proc.nombreDistrito,act.id as actual_id,act.departamento,act.provincia,act.distrito,act.nombreDepartamento,act.nombreProvincia,act.nombreDistrito  from Perfil p join p.persona per join p.dependencia d join p.sede s join p.rol r join d.dependencia dep join d.tipoDependencia t join per.idLugarNacimiento nac join per.lugarProcedencia proc join per.lugarActual act where per.docIdentidad = ?1";
		
		TypedQuery<Object[]> query = em.createQuery(queryStr , Object[].class);
		query.setParameter(1,dni);
		Object[] resultado = query.getSingleResult();				
		return resultado;	
		}catch(NoResultException e) {
			return null;
		}
		
	}

	public String findEmailByDni(String dni) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select p.email from Persona p where p.docIdentidad = ?1";

			TypedQuery<String> query = em.createQuery(queryStr, String.class);
			query.setParameter(1, dni);
			String resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	
}
	

