package edu.pe.unitru.service.security;
import java.io.Serializable;

import edu.pe.unitru.domain.generic.Rol;



public interface RoleService extends Serializable {
	
	public Rol getRole(int id);

}
	