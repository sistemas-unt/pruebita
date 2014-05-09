package edu.pe.unitru.repository.bienestar.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.bienestar.SocAficion;
import edu.pe.unitru.domain.bienestar.SocCategoriaHistorial;
import edu.pe.unitru.domain.bienestar.SocDeporte;
import edu.pe.unitru.domain.bienestar.SocObservacion;
import edu.pe.unitru.domain.bienestar.SocPrestacionAsistencial;
import edu.pe.unitru.domain.bienestar.SocProblematica;
import edu.pe.unitru.repository.bienestar.HistorialSocialDao;

@Repository(value = "historialServiceDao")
public class HistorialSocialDaoImpl implements HistorialSocialDao {
	
	private EntityManager	em	= null;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	public Object[] getFichaHistorial(String  dni) {
		try {
			String queryStr ="select c.id,ch.id,enf.nombre,ope.nombre,inm.nombre,acc.nombre,ale.nombre,ch.lentes "
				+ "from Clinico c "
				+ "join c.persona per "
				+ "join c.cliFichaHistorial ch "
				+ "join ch.cfhOperaciones ope "
				+ "join ch.cfhInmunizaciones inm "
				+ "join ch.cfhEnfermedades enf j"
				+ "oin ch.cfhAccidentes acc "
				+ "join ch.cfhAlergias ale "
				+ "where per.docIdentidad = ?1";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			Object[] resultado = query.getSingleResult();
			return resultado;
		}catch(NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getGrupoFamiliar(String  dni) {
		try {
			String queryStr = "select g.docIdentidad,g.apellidoMaterno ||' '|| g.apellidoMaterno||', '  || g.nombres,g.parentesco,g.lugarNacimiento,g.fechaNacimiento,g.estadoCivil,g.gradoInstruccion,g.ocupacion,g.ingresos from GrupoFamiliar g join g.persona per where per.docIdentidad = ?1";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			List<Object[]> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getSocialVivienda(String  dni) {
		try {
			String queryStr = "select ss.id,sv.id,t.tipo,ubi.ubicacion,mat.material,ten.tenencia,tip.tipo,agu.aguaPotable,sh.servicioHigienico,ilu.iluminacion from SocVivienda sv join sv.servicioSocial ss join sv.tipoVivienda t join t.svUbicacion ubi join t.svMatConstruccion mat join t.svTenencia ten join t.svTipo tip join t.svAguaPotable agu join t.svServiciosHigienico sh join t.svIluminacion ilu join ss.perfil p join p.persona per where per.docIdentidad = ?1 ";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			List<Object[]> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public Object[] getSocialEconomica(String  dni) {
		try {
			String queryStr = "select ss.id,se.id,ocu.ocupacion,con.condicion,ded.dedicacion,tur.turno,se.centroTrabajo,ing.padres,ing.abuelos,ing.trabajo,ing.otrosParientes,ing.pension,egr.pensionUniversitaria,egr.alimentacion,egr.habitacion,egr.vestimenta,egr.movilidad,egr.utiles,d.nombre,dep.nombre,ss.categoria from ServicioSocial ss join ss.socSituacionEconomica se join se.sseOcupacionLaboral ocu join se.sseCondicion con join se.sseDedicacion ded join se.sseTurnoTrabajo tur join se.sseIngreso ing join se.sseEgreso egr join ss.perfil p join p.dependencia d join d.dependencia dep join p.persona per where per.docIdentidad = ?1 ";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			Object[] resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public Object[] getSocialAntEscolares(String  dni) {
		try {
			String queryStr = "select ss.id, tip.tipo,tur.turno,esp.especialidad,ae.colegioTermino,ae.numPostulaciones,for.forma,senf.acudeEnfermedad,smot.motivo,ali.alimentacion from ServicioSocial ss join ss.socAlimentacion ali join ss.socSalud sal join sal.ssMotivo smot join sal.ssAcudeEnfermedad senf join ss.socAntEscolare ae join ae.saeTipoColegio tip join ae.saeTurno tur join ae.saeEspecializacion esp join ae.saeFormaIngreso for join ss.perfil p join p.persona per where per.docIdentidad = ?1 ";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			Object[] resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public Object[] getSocialRecreacion(String  dni) {
		try {
			String queryStr = "select ss.id,dep.football,dep.basquetball,dep.volleyball,dep.natacion,dep.tenis,dep.pinPong,dep.equitacion,dep.otros,afi.dibujoPintura,afi.fotografia,afi.mecanica,afi.carpinteria,afi.sastreria,afi.decoracion,afi.lectura,afi.poesia,afi.danza,afi.ballet,afi.teatro,afi.escritor,afi.artesania,afi.costura,afi.musica from ServicioSocial ss join ss.socRecreacion rec join rec.srDeporte dep join rec.srAficione afi join ss.perfil p join p.persona per where per.docIdentidad = ?1 ";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			Object[] resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<SocDeporte> getSocialDeportes(String  dni) {
		try {
			String queryStr = "select d from SocDeporte d join d.servicioSocial ss join ss.perfil p join p.persona per where per.docIdentidad = ?1";
			TypedQuery<SocDeporte> query = em.createQuery(queryStr, SocDeporte.class);
			query.setParameter(1, dni);
			List<SocDeporte> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<SocAficion> getSocialAficiones(String  dni) {
		try {
			String queryStr = "select a from SocAficion a join a.servicioSocial ss join ss.perfil p join p.persona per where per.docIdentidad = ?1";
			TypedQuery<SocAficion> query = em.createQuery(queryStr, SocAficion.class);
			query.setParameter(1, dni);
			List<SocAficion> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getSocialObservaciones(String  dni) {
		try {
			String queryStr = "select so.observaciones,asist.nombres ||' ' || asist.apellidoPaterno ||' '|| asist.apellidoMaterno,so.fecha from SocObservacion so join so.perfil pas join pas.persona asist join so.servicioSocial ss join ss.perfil p join p.persona per where per.docIdentidad = ?1";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			List<Object[]> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getSocialProblematica(String  dni) {
		try {
			String queryStr = "select sp.problematica,asist.nombres ||' ' || asist.apellidoPaterno ||' '|| asist.apellidoMaterno,sp.fecha from SocProblematica sp join sp.perfil pas join pas.persona asist join sp.servicioSocial ss join ss.perfil p join p.persona per where per.docIdentidad = ?1";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			List<Object[]> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getSocialPrestaciones(String  dni) {
		try {
			String queryStr = "select sp.fecha, sp.problematicaSocial,sp.resultado,asist.nombres ||' ' || asist.apellidoPaterno ||' '|| asist.apellidoMaterno from SocPrestacionAsistencial sp join sp.perfil pas join pas.persona asist join sp.servicioSocial ss join ss.perfil p join p.persona per where per.docIdentidad = ?1";
			TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
			query.setParameter(1, dni);
			List<Object[]> resultado = query.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public ServicioSocial getFichaSocial(long id) {
		try {
			ServicioSocial fichaSocial = em.find(ServicioSocial.class, id);
			return fichaSocial;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public void addObservacion(SocObservacion observacion) {
		em.persist(observacion);
	}
	
	@Transactional(readOnly = false)
	public void addProblematica(SocProblematica problematica) {
		// TODO Auto-generated method stub
		em.persist(problematica);
	}
	
	@Transactional(readOnly = false)
	public void addPrestacion(SocPrestacionAsistencial prestacion) {
		// TODO Auto-generated method stub
		em.persist(prestacion);
	}

	public Long countPrestacion(long id) {
		try {
			String queryStr = "select count(p.id) from SocPrestacionAsistencial p join p.servicioSocial ss where ss.id = ?1";
			TypedQuery<Long> query = em.createQuery(queryStr, Long.class);
			query.setParameter(1, id);
			Long resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
		// TODO Auto-generated method stub
		
	}

	public String findFichaByDni(String dni) {
		try {
			String queryStr = "select p.docIdentidad from ServicioSocial ss join ss.perfil pe join pe.persona p where p.docIdentidad = ?1";
			TypedQuery<String> query = em.createQuery(queryStr, String.class);
			query.setParameter(1, dni);
			String resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void addCategoriaHistorial(SocCategoriaHistorial categoria) {
		// TODO Auto-generated method stub
		em.persist(categoria);
	}
}
