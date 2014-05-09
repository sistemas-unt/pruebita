package edu.pe.unitru.repository.bienestar;

import java.util.List;

import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPeriodo;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;
import edu.pe.unitru.domain.generic.Dependencia;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.generic.Persona;


public interface ControlSocialDAO 
{
	
	public List<Dependencia> getListEscuela(long codigo);
	public List<Dependencia> getListEscuelaDisponibles(long codigo);
	public List<Dependencia> getListEscuelasTotales();
	public List<ComTicket> getListTickets();
	public List<ComTicketsDependencia> codigossobrantes();
//	public void addComedorAsistenta(ComRangoAsistenta asistenta);
	public void addPermiso(ComPermiso permiso);
	public Perfil findAsistentaByDni(String dni);
	public Persona findAsistentainComedor(String dni);
	public List<Persona> getListAsistentas();
	public Object[] getDataAsistenta(long codigo);
	public ComTicket buscarcodigo(Long id);
	public ComTicketsDependencia getComTickestDependencia(Long id);
	public Dependencia getescuelas(Long id);
	public void editartickets(ComTicketsDependencia comTicketsDependencia);
	public void agregarSobratickets(ComTicketsDependencia comTicketsDependencia);
	public void agregarescuela(ComPermiso comPermiso);
	public ComPermiso buscaridpermiso(Long id);
	public void eliminarescuela(Long idf);
	public void eliminarcodigo(Long idf);
	public List<ComTicketsDependencia> buscarcodigos(Long idf);
	public Dependencia buscarescuela(Long id);
	public ComPeriodo buscarperiodo(Long id);
} 