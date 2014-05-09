package edu.pe.unitru.service.bienestar.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.bienestar.SocAficion;
import edu.pe.unitru.domain.bienestar.SocCategoriaHistorial;
import edu.pe.unitru.domain.bienestar.SocDeporte;
import edu.pe.unitru.domain.bienestar.SocObservacion;
import edu.pe.unitru.domain.bienestar.SocPrestacionAsistencial;
import edu.pe.unitru.domain.bienestar.SocProblematica;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.security.CustomerUser;
import edu.pe.unitru.repository.bienestar.HistorialSocialDao;
import edu.pe.unitru.service.bienestar.FichaSocialService;
import edu.pe.unitru.service.bienestar.HistorialSocialService;
import edu.pe.unitru.service.generic.PerfilService;

@Service
public class HistorialSocialServiceImpl implements HistorialSocialService {

	@Autowired
	private HistorialSocialDao historialSocialDao;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private FichaSocialService fichaSocialservice;
	
	public Object[] getFichaHistorial(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getFichaHistorial(dni);
	}

	public List<Object[]> getGrupoFamiliar(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getGrupoFamiliar(dni);
	}

	public List<Object[]> getSocialVivienda(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialVivienda(dni);
	}

	public Object[] getSocialSituacionEconomica(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialEconomica(dni);
	}

	public Object[] getSocialAntecdentesEscolares(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialAntEscolares(dni);
	}	

	public Object[] getSocialRecreacion(String dni) {
		// TODO Auto-generated method stub
		Object[] recreacion = this.historialSocialDao.getSocialRecreacion(dni);
		List<String> deportes = new ArrayList<String>();
		for(Integer i=1;i<=8;i++) {
			if((Integer)recreacion[i]==1) {
				switch (i) {
					case 1:deportes.add("FOOTBALL");						
					break;
					case 2:deportes.add("BASQUETBALL");						
					break;
					case 3:deportes.add("VOLLEYBALL");						
					break;
					case 4:deportes.add("NATACION");						
					break;
					case 5:deportes.add("TENIS");						
					break;
					case 6:deportes.add("PIN PONG");						
					break;
					case 7:deportes.add("EQUITACION");						
					break;
					case 8:deportes.add("OTROS");						
					break;
					default:
						break;
				}				
			}		
		}
		
		List<String> aficiones = new ArrayList<String>();
		for(Integer i=9;i<=22;i++) {
			if((Integer)recreacion[i]==1) {
				switch (i) {
					case 9:aficiones.add("DIBUJO O PINTURA");						
					break;
					case 10:aficiones.add("FOTOGRAFIA");						
					break;
					case 11:aficiones.add("MECANICA");						
					break;
					case 12:aficiones.add("CARPINTERIA");						
					break;
					case 13:aficiones.add("SASTERIA");						
					break;
					case 14:aficiones.add("DECORACION");						
					break;
					case 15:aficiones.add("LECTURA");						
					break;
					case 16:aficiones.add("POESIA");						
					break;
					case 17:aficiones.add("DANZA");						
					break;
					case 18:aficiones.add("BALLET");						
					break;
					case 19:aficiones.add("TEATRO");						
					break;
					case 20:aficiones.add("ESCRITOR");						
					break;
					case 21:aficiones.add("ARTESANIA");						
					break;
					case 22:aficiones.add("COSTURA");						
					break;
					default:
						break;
				}				
			}		
		}
		
		if((String)recreacion[23]=="") {
			
		}
		
		return null;
	}
	
	public List<SocDeporte> getSocialDeportes(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialDeportes(dni);
	}
	
	public List<SocAficion> getSocialAficiones(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialAficiones(dni);
	}

	public List<Object[]> getSocialObservaciones(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialObservaciones(dni);
	}
	
	public List<Object[]> getSocialProblematica(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialProblematica(dni);
	}
	
	public List<Object[]> getSocialPrestaciones(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.getSocialPrestaciones(dni);
	}

	public ServicioSocial getFichaSocial(long id) {
		// TODO Auto-generated method stub
		return historialSocialDao.getFichaSocial(id);
	}

	public void addObservacion(SocObservacion observacion) {
		// TODO Auto-generated method stub
		historialSocialDao.addObservacion(observacion);
	}

	public void addProblematica(SocProblematica problematica) {
		// TODO Auto-generated method stub
		historialSocialDao.addProblematica(problematica);
	}

	public void addPrestacion(SocPrestacionAsistencial prestacion) {
		// TODO Auto-generated method stub
		historialSocialDao.addPrestacion(prestacion);
	}

	public Long countPrestacion(long id) {
		// TODO Auto-generated method stub
		return historialSocialDao.countPrestacion(id);
	}

	public String findFichaByDni(String dni) {
		// TODO Auto-generated method stub
		return historialSocialDao.findFichaByDni(dni);
	}

	public void addCategoria(long idSocial, Integer categoria, String motivo, CustomerUser user) {
		// TODO Auto-generated method stub
		Perfil perfil = this.perfilService.findById(user.getPerfil());
		ServicioSocial fichaSocial = this.getFichaSocial(idSocial);
		Date date = new Date();
		
		SocCategoriaHistorial historial = new SocCategoriaHistorial();
		historial.setCategoriaActual(categoria);
		historial.setCategoriaAnterior(fichaSocial.getCategoria());
		historial.setMotivoCambio(motivo);
		historial.setFecha(new Timestamp(date.getTime()));
		historial.setServicioSocial(fichaSocial);
		historial.setPerfil(perfil);
		historial.setEstado(1);
		
		this.historialSocialDao.addCategoriaHistorial(historial);
		
		fichaSocial.setCategoria(categoria);
		this.fichaSocialservice.updateServicioSocial(fichaSocial);
		
	}

	

}
