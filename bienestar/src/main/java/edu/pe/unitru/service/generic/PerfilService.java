package edu.pe.unitru.service.generic;

import java.io.Serializable;

import edu.pe.unitru.domain.generic.Perfil;

public interface PerfilService extends Serializable {
	public Perfil findByPerfil(Long idp2);
	public Perfil findByPerfil2(Long idp2);
	public Perfil getDatosAlumno(String dni);
	public Perfil findById(long id);
}
