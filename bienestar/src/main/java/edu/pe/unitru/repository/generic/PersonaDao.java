package edu.pe.unitru.repository.generic;

import java.util.List;

import edu.pe.unitru.domain.generic.Persona;

public interface PersonaDao {
	public List<Persona> getPersonaList();

	public List<Persona> getPersonaByDni(String dni);

	public void addUsuario(Persona usuario);

	public void deleteUsuario(long id);

	public Persona findById(long id);

	public void updateUsuario(Persona usuario);

	public void updateEmail(Persona p);

	public Persona findByDni(String dni);

	public Object[] findPersonaByDni(String dni);

	public Object[] findDatosPersonalesByDni(String dni);
	
	public String findEmailByDni(String dni);

}
