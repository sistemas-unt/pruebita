package edu.pe.unitru.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.generic.Rol;
import edu.pe.unitru.repository.security.RoleDao;
import edu.pe.unitru.service.security.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	 @Autowired
	 private RoleDao roleDAO;
	 
	     public Rol getRole(int id) {
	         return roleDAO.getRole(id);
	     }


}
