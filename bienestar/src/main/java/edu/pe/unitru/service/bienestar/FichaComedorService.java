package edu.pe.unitru.service.bienestar;

import java.io.Serializable;
import java.math.BigDecimal;

import edu.pe.unitru.domain.bienestar.ComDataRequisito;
import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.generic.Persona;

import java.util.List;

public interface FichaComedorService extends Serializable
{
	public List<Persona> buscarDni(Persona persona);
	
	public void addFichacomedor(ComFichaComedor fichacomedor);
	public void editFichacomedor(ComFichaComedor fichacomedor);
	public void eliminarFichacomedor(ComFichaComedor fichacomedor);
	public void eliminarrequisitos(Long idf);
	public void addDataRequisito(ComDataRequisito dataRequisito);
	
	public void addTicketComedor(String voucher, Integer cantidad, BigDecimal monto, Integer idFicha);
	
	public List<ComCategoria> getListaCategoria();
	public List<ComFichaComedor> getListaComedor(Long ida);
	public List<ComDataRequisito> requisitoporalumno(Long idf);
	public List<ComFichaComedor> getListaVerificarPadron();
	public List<ComFichaComedor> getDataTicket(int codigo);
	public List<ComFichaComedor> getRowTicket(int codigo);
	public List<ComFichaComedor> findbyHistoria(String dni, String codigoAlumno);
	
	public ComFichaComedor existeregistro(String dni);
	public ComPermiso perteneceescuela(Long idasis,String dni);
	public Object[]  editarFichacomedor(Long ve);
	public List<ComRequisito> getListaRequisitos();
	public ComRequisito buscarRequisito(Long id);
	public ComFichaComedor getFichaComedor(Long id);
	
}
