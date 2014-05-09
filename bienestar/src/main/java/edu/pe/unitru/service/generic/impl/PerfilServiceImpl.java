package edu.pe.unitru.service.generic.impl;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.repository.generic.PerfilDao;
import edu.pe.unitru.service.generic.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private PerfilDao perfilDao;
	
	public Perfil findByPerfil(Long idp2) {
		// TODO Auto-generated method stub
		return perfilDao.findByPerfil(idp2);
	}
	public Perfil findByPerfil2(Long idp2) {
		// TODO Auto-generated method stub
		return perfilDao.findByPerfil2(idp2);
	}
	public Perfil getDatosAlumno(String dni){
		// TODO Auto-generated method stub
		return perfilDao.getDatosAlumno(dni);
	}
	public Perfil findById(long id) {
		// TODO Auto-generated method stub
		return perfilDao.findById(id);
	}
}
