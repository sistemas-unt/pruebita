package edu.pe.unitru.repository.generic;

import edu.pe.unitru.domain.generic.Perfil;

public interface PerfilDao {
	public Perfil findByPerfil(Long idp2);
	public Perfil findByPerfil2(Long idp2);
	public Perfil getDatosAlumno(String dni);
	public Perfil findById(long id);
}
