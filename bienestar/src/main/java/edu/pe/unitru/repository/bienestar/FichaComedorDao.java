package edu.pe.unitru.repository.bienestar;

import java.util.List;

import edu.pe.unitru.domain.bienestar.ComDataRequisito;
import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRegTicket;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.generic.Persona;

public interface FichaComedorDao 
{
	public List<Persona> buscarDniList(Persona persona);
	public List<ComCategoria> getListaCategoria();
	public void addFichacomedor(ComFichaComedor fichacomedor);
	public void editFichacomedor(ComFichaComedor fichacomedor);
	public void eliminarFichacomedor(ComFichaComedor fichacomedor);
	public void eliminarrequisitos(Long idf);
	public void addDataRequisitos(ComDataRequisito dataRequisito);
	public void addTicketComedor(ComRegTicket comregticket);
	public List<ComFichaComedor> getListaComedor(Long ida);
	public List<ComDataRequisito> requisitoporalumno(Long idf);
	public List<ComFichaComedor> getListaVerificarPadron();
	public List<ComFichaComedor> getDataTicket(int codigo);
	public List<ComFichaComedor> getRowTicket(int codigo);
	public List<ComFichaComedor> findbyHistoria (String dni, String codigoAlumno);
	public ComFichaComedor existeregistro(String dni);
	public ComPermiso perteneceescuela(Long idasis,String dni);
	public ComFichaComedor getFichaComedor(Integer id);
	public Object[]  editarFichacomedor(Long ve);
	public List<ComRequisito> getListaRequisitos();
	public ComRequisito buscarRequisito(Long id);
	public ComFichaComedor getFichaComedor(Long id);
	
	
}
