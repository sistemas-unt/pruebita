package edu.pe.unitru.service.generic;

import java.io.Serializable;
import java.util.List;

import edu.pe.unitru.domain.generic.Persona;

public interface PersonaService extends Serializable {

	public List<Persona> getPersonas();
	public List<Persona> getPersonaByDni(String dni);

	public void addUsuario(Persona usuario);

	public void deleteUsuario(long id);

	public void updateUsuario(Persona usuario);

	public Persona findById(long id);
	public void updateEmail(Persona p);
	public Persona findByDni(String dni);
	
	public Object[] findPersonaByDni(String dni);
	public Object[] findDatosPersonalesByDni(String dni);
	public String findEmailByDni(String dni);
	
}
