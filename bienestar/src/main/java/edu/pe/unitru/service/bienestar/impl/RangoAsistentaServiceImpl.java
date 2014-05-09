package edu.pe.unitru.service.bienestar.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;
import edu.pe.unitru.repository.bienestar.RangoAsistentaDao;
import edu.pe.unitru.service.bienestar.RangoAsistentaService;

@Service
public class RangoAsistentaServiceImpl implements RangoAsistentaService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private RangoAsistentaDao rangoAsistentaDao;
	
	public List<ComTicketsDependencia> getRango(Long ide) {
		// TODO Auto-generated method stub
		return rangoAsistentaDao.getRango(ide);
	}
	public List<ComTicketsDependencia> codigosdisponibles(Long ide) {
		// TODO Auto-generated method stub
		return rangoAsistentaDao.codigosdisponibles(ide);
	}
	public List<ComPermiso> escuelas() {
		// TODO Auto-generated method stub
		return rangoAsistentaDao.escuelas();
	}
	public ComTicketsDependencia findByCodigo(Long idp2) {
		// TODO Auto-generated method stub
		return rangoAsistentaDao.findByCodigo(idp2);
	}
	public ComTicket findById(Long idp2) {
		// TODO Auto-generated method stub
		return rangoAsistentaDao.findById(idp2);
	}
	public void editarticket(ComTicket comticket) {
		// TODO Auto-generated method stub 
		rangoAsistentaDao.editarticket(comticket);

	}
	
}
