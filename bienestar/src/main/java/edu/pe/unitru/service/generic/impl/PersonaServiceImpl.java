package edu.pe.unitru.service.generic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.repository.generic.PersonaDao;
import edu.pe.unitru.service.generic.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaDao personaDao;
	
	public List<Persona> getPersonas() {
		// TODO Auto-generated method stub
		return personaDao.getPersonaList();
	}

	public void addUsuario(Persona usuario) {
		// TODO Auto-generated method stub 

	}

	public void deleteUsuario(long id) {
		// TODO Auto-generated method stub

	}

	public void updateUsuario(Persona usuario) {
		// TODO Auto-generated method stub
		personaDao.updateUsuario(usuario);
	}

	public Persona findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> getPersonaByDni(String dni) {
		// TODO Auto-generated method stub
		return personaDao.getPersonaByDni(dni);
	}

	public void updateEmail(Persona p) {
		// TODO Auto-generated method stub
		personaDao.updateEmail(p);
		
	}

	public Persona findByDni(String dni) {
		// TODO Auto-generated method stub
		return personaDao.findByDni(dni);
	}

	public Object[] findPersonaByDni(String dni) {
		// TODO Auto-generated method stub
		return personaDao.findPersonaByDni(dni);
	}

	public Object[] findDatosPersonalesByDni(String dni) {
		// TODO Auto-generated method stub
		return personaDao.findDatosPersonalesByDni(dni);
	}

	public String findEmailByDni(String dni) {
		// TODO Auto-generated method stub
		return personaDao.findEmailByDni(dni);
	}
	
	
}
