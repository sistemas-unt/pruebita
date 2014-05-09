package edu.pe.unitru.repository.security;

import edu.pe.unitru.domain.security.SecurityRolUser;
import edu.pe.unitru.domain.security.SecurityUser;


public interface UsuarioDao {

//	public List<Usuario> getUsuarioList();
//	public void addUsuario(Usuario usuario);
//	public void deleteUsuario(long id);
//	public Usuario findById(long id);
//	public void updateUsuario(Usuario usuario);
	
	//public List<Persona> verificaLoginList(Cuenta cuenta);
	public SecurityUser getUser(String login);
	public SecurityRolUser getPerfil(long id);
	public String getPassword(String username);
	public void cambiarPassword(SecurityUser user);
}
