package edu.pe.unitru.service.bienestar;

import java.util.List;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.bienestar.SocAficion;
import edu.pe.unitru.domain.bienestar.SocDeporte;
import edu.pe.unitru.domain.bienestar.SocObservacion;
import edu.pe.unitru.domain.bienestar.SocPrestacionAsistencial;
import edu.pe.unitru.domain.bienestar.SocProblematica;
import edu.pe.unitru.domain.security.CustomerUser;

public interface HistorialSocialService {

	public Object[] getFichaHistorial(String dni);
	public List<Object[]> getGrupoFamiliar(String dni);
	public List<Object[]> getSocialVivienda(String dni);
	public Object[] getSocialSituacionEconomica(String dni);
	public Object[] getSocialAntecdentesEscolares(String dni);	
	public Object[] getSocialRecreacion(String dni);
	public List<SocDeporte> getSocialDeportes(String dni);
	public List<SocAficion> getSocialAficiones(String dni);
	public List<Object[]> getSocialObservaciones(String dni);
	public List<Object[]> getSocialProblematica(String dni); 
	public List<Object[]> getSocialPrestaciones(String dni); 
	public ServicioSocial getFichaSocial(long id);
	public void addObservacion(SocObservacion observacion);
	public void addProblematica(SocProblematica problematica);
	public void addPrestacion(SocPrestacionAsistencial prestacion);
	public Long countPrestacion(long id);
	public String findFichaByDni(String dni);
	public void addCategoria(long idSocial, Integer categoria, String motivo,CustomerUser user);
}
