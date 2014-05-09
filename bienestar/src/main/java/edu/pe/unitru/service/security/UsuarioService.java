package edu.pe.unitru.service.security;

import java.io.Serializable;

import javax.swing.text.StyledEditorKit.BoldAction;

import edu.pe.unitru.domain.security.SecurityUser;

public interface UsuarioService extends Serializable {

	public void increasePrice(int percentage);

//	public List<Usuario> getUsuarios();
//
//	public void addUsuario(Usuario usuario);
//
//	public void deleteUsuario(long id);
//
//	public void updateUsuario(Usuario usuario);
//
//	public Usuario findById(long id);
	
	//public List<Persona> verificaLogin(Cuenta cuenta);
	
	public SecurityUser getUser(String login);
	public Boolean validarPassword(String password,String username);
	
	public void cambiarPassword(String password,String username);
	
}
