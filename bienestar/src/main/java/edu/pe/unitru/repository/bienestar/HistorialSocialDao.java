package edu.pe.unitru.repository.bienestar;

import java.util.List;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.bienestar.SocAficion;
import edu.pe.unitru.domain.bienestar.SocCategoriaHistorial;
import edu.pe.unitru.domain.bienestar.SocDeporte;
import edu.pe.unitru.domain.bienestar.SocObservacion;
import edu.pe.unitru.domain.bienestar.SocPrestacionAsistencial;
import edu.pe.unitru.domain.bienestar.SocProblematica;

public interface HistorialSocialDao {

	public Object[] getFichaHistorial(String dni);
	public List<Object[]> getGrupoFamiliar(String dni);
	public List<Object[]> getSocialVivienda(String dni);
	public Object[] getSocialEconomica(String dni);
	public Object[] getSocialAntEscolares(String dni);
	public Object[] getSocialRecreacion(String dni);
	public List<SocDeporte> getSocialDeportes(String dni);
	public List<SocAficion> getSocialAficiones(String dni);
	public List<Object[]> getSocialObservaciones(String dni);
	public List<Object[]> getSocialProblematica(String  dni);
	public List<Object[]> getSocialPrestaciones(String  dni);
	public ServicioSocial getFichaSocial(long id);
	public void addObservacion(SocObservacion observacion);
	public void addProblematica(SocProblematica problematica);
	public void addPrestacion(SocPrestacionAsistencial prestacion);
	public Long countPrestacion(long id);
	public String findFichaByDni(String dni);
	public void addCategoriaHistorial(SocCategoriaHistorial categoria);
}
