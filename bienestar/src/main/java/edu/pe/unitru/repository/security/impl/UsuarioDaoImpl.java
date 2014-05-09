package edu.pe.unitru.repository.security.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.unitru.domain.security.SecurityRolUser;
import edu.pe.unitru.domain.security.SecurityUser;
import edu.pe.unitru.repository.security.UsuarioDao;

@Repository(value = "usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

//	@Transactional(readOnly = true)
//	@SuppressWarnings("unchecked")
//	public List<Usuario> getUsuarioList() {
//		// TODO Auto-generated method stub
//		return em.createQuery("select p from Usuario p").getResultList();
//	}
//
//	@Transactional(readOnly = false)
//	public void addUsuario(Usuario usuario) {
//		// TODO Auto-generated method stub
//		em.persist(usuario);
//	}
//
//	@Transactional(readOnly = false)
//	public void deleteUsuario(long id) {
//		// TODO Auto-generated method stub
//		Usuario usuario = em.find(Usuario.class, id);
//		em.remove(usuario);
//	}
//
//	@Transactional(readOnly = true)
//	public Usuario findById(long id) {
//		// TODO Auto-generated method stub
//		Usuario usuario = em.find(Usuario.class, id);
//		return usuario;
//	}
//
//	@Transactional(readOnly = false)
//	public void updateUsuario(Usuario usuario) {
//		// TODO Auto-generated method stub
//		em.merge(usuario);
//	}
	
	
	
	//@Transactional(readOnly = true)
	//@SuppressWarnings("unchecked")
	//public List<Persona> verificaLoginList(Cuenta cuenta) {
		// TODO Auto-generated method stub
		//return em.createQuery("select p from Cuenta as c inner join c.persona as p where c.username= '"+cuenta.getUsername() +"' and c.password='"+cuenta.getPassword()+"'").getResultList();
	//}
	
     
    @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
    public SecurityUser getUser(String login) {
        List userList = new ArrayList();
        userList=em.createQuery("from SecurityUser  as u where u.username='"+login+"'").getResultList();
        if (userList.size() > 0)
            return (SecurityUser) userList.get(0);
        else
            return null;   
    }

    @Transactional(readOnly = true)
	public SecurityRolUser getPerfil(long id) {
		// TODO Auto-generated method stub
//		return null;
		return (SecurityRolUser) em.createQuery("select p from SecurityRolUser p where  p.securityUser="+id).getSingleResult();
	}

	public String getPassword(String username) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select u.password from SecurityUser u where u.username = ?1";

			TypedQuery<String> query = em.createQuery(queryStr, String.class);
			query.setParameter(1, username);
			String resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void cambiarPassword(SecurityUser user) {
		// TODO Auto-generated method stub
		em.merge(user);
	}
	

}
