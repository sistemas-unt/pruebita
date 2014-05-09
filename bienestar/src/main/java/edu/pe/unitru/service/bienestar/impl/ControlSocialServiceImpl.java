package edu.pe.unitru.service.bienestar.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import edu.pe.unitru.service.bienestar.ControlSocialService;

@Service
public class ControlSocialServiceImpl implements ControlSocialService {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ControlSocialDAO  controlSocialDao;
	
//	@Transactional(readOnly = false)
//	public void addComedorAsistenta(ComRangoAsistenta asistenta) {
//		// TODO Auto-generated method stub
//		controlSocialDao.addComedorAsistenta(asistenta);
//	}
	@Transactional(readOnly = false)
	public void addPermiso(ComPermiso permiso)
	{
		controlSocialDao.addPermiso(permiso);
	}
	@Transactional(readOnly = false)
	public void agregarSobratickets(ComTicketsDependencia comTicketsDependencia)
	{
		controlSocialDao.agregarSobratickets(comTicketsDependencia);
	}
	public List<Dependencia> getListEscuela(long codigo)
	{
		return controlSocialDao.getListEscuela(codigo);
	}
	public List<Dependencia> getListEscuelaDisponibles(long codigo) {
		// TODO Auto-generated method stub
		return controlSocialDao.getListEscuelaDisponibles(codigo);
	}
	public List<ComTicketsDependencia> codigossobrantes(){
		// TODO Auto-generated method stub
		return controlSocialDao.codigossobrantes();
	}
	
	
	public List<ComTicket> getListTickets() {
		// TODO Auto-generated method stub
		return controlSocialDao.getListTickets();
	}
	
	public List<Dependencia> getListEscuelasTotales() {
		// TODO Auto-generated method stub
		return controlSocialDao.getListEscuelasTotales();
	}
	public Perfil findAsistentaByDni(String dni)
	{
		return controlSocialDao.findAsistentaByDni(dni);
	}

	public Persona findAsistentainComedor(String dni)
	{
		return controlSocialDao.findAsistentainComedor(dni);
	}
	public List<Persona> getListAsistentas() 
	{
		return controlSocialDao.getListAsistentas();
	}
	
	public List<Persona> findbyHistoria (String dni, String codigoAlumno) 
	{
		return controlSocialDao.getListAsistentas();
	}
	
	public Object[] getDataAsistenta(long codigo)
	{
		return controlSocialDao.getDataAsistenta(codigo);
	}
	public ComTicket buscarcodigo(Long id) {
		// TODO Auto-generated method stub
		return controlSocialDao.buscarcodigo(id);
	}
	public ComTicketsDependencia getComTickestDependencia(Long id){
		// TODO Auto-generated method stub
		return controlSocialDao.getComTickestDependencia(id);
	}
	public Dependencia getescuelas(Long id){
		// TODO Auto-generated method stub
		return controlSocialDao.getescuelas(id);
	}
	public void editartickets(ComTicketsDependencia comTicketsDependencia) {
		// TODO Auto-generated method stub 
		controlSocialDao.editartickets(comTicketsDependencia);

	}
	public ComPermiso buscaridpermiso(Long id){
		// TODO Auto-generated method stub 
		return controlSocialDao.buscaridpermiso(id);
	}
	public void eliminarescuela(Long idf){
		controlSocialDao.eliminarescuela(idf);
	}
	public List<ComTicketsDependencia> buscarcodigos(Long idf){
		return controlSocialDao.buscarcodigos(idf);
	}
	public void eliminarcodigo(Long idf){
		controlSocialDao.eliminarcodigo(idf);
	}
	public Dependencia buscarescuela(Long id){
		return controlSocialDao.buscarescuela(id);
	}
	public void agregarescuela(ComPermiso comPermiso)
	{
		controlSocialDao.agregarescuela(comPermiso);
	}
	public ComPeriodo buscarperiodo(Long id)
	{
		return controlSocialDao.buscarperiodo(id);
	}

}
