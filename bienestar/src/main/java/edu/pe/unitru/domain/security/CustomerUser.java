package edu.pe.unitru.domain.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class CustomerUser extends User {

	private String nombre;
	private long perfil;
	private long persona;

	public CustomerUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean CredentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String nombre,
			long perfil, long persona) {
		super(username, password, enabled, accountNonExpired,
				CredentialsNonExpired, accountNonLocked, authorities);
		this.nombre = nombre;
		this.perfil = perfil;
		this.persona = persona;
	}

	public CustomerUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities, String nombre,long perfil, long persona) {
		this(username, password, true, true, true, true, authorities, nombre,perfil,persona);
	}

	public String getNombre() {
		return nombre;
	}
	
	public long getPerfil() {
		return perfil;
	}
	
	public long getPersona() {
		return persona;
	}


}
