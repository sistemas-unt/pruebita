package edu.pe.unitru.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.security.SecurityUser;
import edu.pe.unitru.repository.security.UsuarioDao;
import edu.pe.unitru.service.security.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	 public SecurityUser getUser(String login) {
		         return usuarioDao.getUser(login);
		     }

	

	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		
	}


	public Boolean validarPassword(String password, String username) {
		// TODO Auto-generated method stub
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String passwordEncoder = encoder.encodePassword(password, null);
		String passwordUser = this.usuarioDao.getPassword(username);
		if (passwordEncoder.equals(passwordUser)) {
			return true;
		} else {
			return false;
		}

	}



	public void cambiarPassword(String password, String username) {
		// TODO Auto-generated method stub
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String passwordEncoder = encoder.encodePassword(password, null);
		
		SecurityUser user = this.usuarioDao.getUser(username);
		user.setPassword(passwordEncoder);
		this.usuarioDao.cambiarPassword(user);
		
	}



//	public void increasePrice(int percentage) {
//		// TODO Auto-generated method stub
//		List<Usuario> usuarios = usuarioDao.getUsuarioList();
//		if (usuarios != null) {
//            for (Usuario usuario : usuarios) {
//            	if(usuario.getUsuarioApellmater() == "MONZON") {
//            		usuario.setUsuarioApellmater("MONZONTROXY");
//            		usuarioDao.updateUsuario(usuario);            		
//            	}
//            }
//        } 
//	}
//
//	public List<Usuario> getUsuarios() {
//		// TODO Auto-generated method stub
//		return usuarioDao.getUsuarioList();
//	}
//
//	public void setUsuarioDao(UsuarioDao usuarioDao) {
//		this.usuarioDao = usuarioDao;
//	}
//
//	public void addUsuario(Usuario usuario) {
//		// TODO Auto-generated method stub
//		usuarioDao.addUsuario(usuario);
//	}
//
//	public void deleteUsuario(long id) {
//		// TODO Auto-generated method stub
//		
//		usuarioDao.deleteUsuario(id);
//	}
//
//	public void updateUsuario(Usuario usuario) {
//		// TODO Auto-generated method stub
//		usuarioDao.updateUsuario(usuario);
//	}
//
//	public Usuario findById(long id) {
//		// TODO Auto-generated method stub
//		Usuario usuario =  usuarioDao.findById(id);
//		return usuario;
//	}
	
	//public List<Persona> verificaLogin(Cuenta cuenta) {
		// TODO Auto-generated method stub
		//return usuarioDao.verificaLoginList(cuenta);
	//}
	
	
	
	
}
