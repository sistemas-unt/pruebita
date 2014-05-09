package edu.pe.unitru.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.security.CustomerUser;
import edu.pe.unitru.domain.security.SecurityRolUser;
import edu.pe.unitru.domain.security.SecurityUser;
import edu.pe.unitru.repository.security.UsuarioDao;




@Service
@Transactional (readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UsuarioDao userDAO;
	
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String login)
	            throws UsernameNotFoundException {	 
	       SecurityUser domainUser = userDAO.getUser(login);
	       SecurityRolUser domainPerfil = userDAO.getPerfil(domainUser.getId());
	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
	        return new CustomerUser(
//	                domainUser.getPersona().getApellidoPaterno() +" "+ domainUser.getPersona().getApellidoMaterno()+" ,"+domainUser.getPersona().getNombres(),
	                domainUser.getUsername(),
	                domainUser.getPassword(),
	                enabled,
	                accountNonExpired,
	                credentialsNonExpired,
	                accountNonLocked,
	                getAuthorities(domainPerfil.getSecurityRol().getRol()),
	                domainPerfil.getPerfil().getPersona().getApellidoPaterno() +" "+
	                domainPerfil.getPerfil().getPersona().getApellidoMaterno() +" , "+
	                domainPerfil.getPerfil().getPersona().getNombres(),
	                domainPerfil.getPerfil().getId(),
	                domainPerfil.getPerfil().getPersona().getId()
//	                domainUser.getPersona().getApellidoPaterno() +" "+ domainUser.getPersona().getApellidoMaterno()+" , "+domainUser.getPersona().getNombres()
	        );
	    }
	
	
	@SuppressWarnings("rawtypes")
	public List getAuthorities(String role) {
		        List authList = getGrantedAuthorities(role);
		        return authList;
		    }
	
	
	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public String getRoles(long role) {
//		 String roles = "";
////	        List roles = new ArrayList();
//	        if (role == 1) {
////	            roles.add("ROLE_MODERATOR");
////	            roles.add("ROLE_ADMIN");
//	        	roles ="ROLE_ADMIN";
//	        } else if (role.intValue() == 2) {
////	            roles.add("ROLE_MODERATOR");
//	        	roles ="ROLE_ADMIN";
//	        }
//	        return roles;
//	    }
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getGrantedAuthorities(String roles) {
    List authorities = new ArrayList();
    
    
    	            authorities.add(new SimpleGrantedAuthority(roles));
    	        

   
    return authorities;
    }




	
	
	

}
