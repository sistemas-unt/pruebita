package edu.pe.unitru.service.gerencia.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.gerencia.PersonalAdminCas;
import edu.pe.unitru.repository.gerencia.UCADao;
import edu.pe.unitru.service.gerencia.UCAService;



@Service
public class UCAServiceImpl implements UCAService  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UCADao fichacontrolrepositorio;
	public List<PersonalAdminCas> seleccionarPersonalAdmin()
	{
		return fichacontrolrepositorio.seleccionarPersonalAdmin();
	}
	

}
