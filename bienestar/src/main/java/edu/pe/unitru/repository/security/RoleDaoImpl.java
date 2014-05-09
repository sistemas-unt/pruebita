package edu.pe.unitru.repository.security;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.generic.Rol;

@Repository(value = "roleDao")
public class RoleDaoImpl implements RoleDao {
	
	private EntityManager em = null;
    
//    private Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//        }
    
    
    @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
    public Rol getRole(int id) {
//        Rol role = (Rol) getCurrentSession().load(Rol.class, id);
//        return role;
    	return (Rol) em.createQuery("SELECT c FROM Rol c where c.id=1").getSingleResult();
    }
    

}