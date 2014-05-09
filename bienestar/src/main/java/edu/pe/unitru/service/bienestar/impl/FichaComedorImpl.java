package edu.pe.unitru.service.bienestar.impl;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.domain.bienestar.ComDataRequisito;
import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRegTicket;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.repository.bienestar.FichaComedorDao;
import edu.pe.unitru.service.bienestar.FichaComedorService;

@Service
public class FichaComedorImpl implements FichaComedorService 
{
	private static final long serialVersionUID = 1L;

	@Autowired
	private FichaComedorDao fichaComedorDao;

	public List<Persona> buscarDni(Persona persona)
	{
		// TODO Auto-generated method stub
		return fichaComedorDao.buscarDniList(persona);
	}
	public void addFichacomedor(ComFichaComedor fichacomedor) {
		// TODO Auto-generated method stub 
		fichaComedorDao.addFichacomedor(fichacomedor);

	}
	public void editFichacomedor(ComFichaComedor fichacomedor) {
		// TODO Auto-generated method stub 
		fichaComedorDao.editFichacomedor(fichacomedor);

	}
	public void eliminarFichacomedor(ComFichaComedor fichacomedor) {
		// TODO Auto-generated method stub 
		fichaComedorDao.eliminarFichacomedor(fichacomedor);

	}
	public void eliminarrequisitos(Long idf) {
		// TODO Auto-generated method stub 
		fichaComedorDao.eliminarrequisitos(idf);

	}
	public void addDataRequisito(ComDataRequisito dataRequisito) {
		// TODO Auto-generated method stub 
		fichaComedorDao.addDataRequisitos(dataRequisito);

	}
	public List<ComCategoria> getListaCategoria() {
		// TODO Auto-generated method stub
		return fichaComedorDao.getListaCategoria();
	}
	public List<ComFichaComedor> getListaComedor(Long ida) {
		// TODO Auto-generated method stub
		return fichaComedorDao.getListaComedor(ida);
	}
	
	public List<ComFichaComedor> getDataTicket(int codigo) {
		// TODO Auto-generated method stub
		return fichaComedorDao.getDataTicket(codigo);
	}
	
	public List<ComFichaComedor> getRowTicket(int codigo) {
		// TODO Auto-generated method stub
		return fichaComedorDao.getRowTicket(codigo);
	}
	
	public void addTicketComedor(String voucher, Integer cantidad, BigDecimal monto, Integer idFicha) {
		
		ComRegTicket comRegTicket = new ComRegTicket();
		
		ComFichaComedor comFichaComedor = fichaComedorDao.getFichaComedor(idFicha);

		//Carga del Objeto
		comRegTicket.setBoucher(voucher);
		comRegTicket.setCantidad(cantidad);
		comRegTicket.setMonto(monto);
		comRegTicket.setComFichaComedor(comFichaComedor);
		//comregticket.set
		
		java.util.Date date= new java.util.Date();
		//System.out.println(new Timestamp(date.getTime()));
		
		comRegTicket.setFechaReg(new Timestamp(date.getTime()));
		comRegTicket.setEstado(1);
		
		//PRUEBA
		
		System.out.println(comRegTicket.getBoucher());
		System.out.println(comRegTicket.getCantidad());
		System.out.println(comRegTicket.getComFichaComedor());
		System.out.println(comRegTicket.getFechaReg());
		System.out.println(comRegTicket.getEstado());
		System.out.println(comRegTicket.getMonto());
				
		fichaComedorDao.addTicketComedor(comRegTicket);
	}
	
	public List<ComFichaComedor> getListaVerificarPadron() {
		// TODO Auto-generated method stub
		return fichaComedorDao.getListaVerificarPadron();
	}
	
	public List<ComFichaComedor> findbyHistoria(String dni, String codigoAlumno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ComFichaComedor existeregistro(String dni) {
		// TODO Auto-generated method stub
		return fichaComedorDao.existeregistro(dni);
	}
	public ComPermiso perteneceescuela(Long idasis,String dni){
		// TODO Auto-generated method stub
				return fichaComedorDao.perteneceescuela(idasis,dni);
	}
	public List<ComRequisito> getListaRequisitos() {
		// TODO Auto-generated method stub
		return fichaComedorDao.getListaRequisitos();
	}
	public List<ComDataRequisito> requisitoporalumno(Long idf) {
		// TODO Auto-generated method stub
		return fichaComedorDao.requisitoporalumno(idf);
	}
	public ComRequisito buscarRequisito(Long id) {
		// TODO Auto-generated method stub
		return fichaComedorDao.buscarRequisito(id);
	}
	public Object[] editarFichacomedor(Long ve) {
		
		return fichaComedorDao.editarFichacomedor(ve);
	}
	public ComFichaComedor getFichaComedor(Long id) {
		// TODO Auto-generated method stub
		return fichaComedorDao.getFichaComedor(id);
	}

}
