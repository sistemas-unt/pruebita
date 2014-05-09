package edu.pe.unitru.service.bienestar.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.repository.bienestar.ServicioClinicoDao;
import edu.pe.unitru.service.bienestar.ServicioClinicoService;

@Service
public class ServicioClinicoServiceImpl implements ServicioClinicoService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ServicioClinicoDao servicioClinicoDao;
	
	public List<ServicioSocial> getListaSocial() {
		// TODO Auto-generated method stub
		return servicioClinicoDao.getListaSocial();
	}
	
}
