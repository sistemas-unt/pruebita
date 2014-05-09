package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_user database table.
 * 
 */
@Entity
@Table(name="security_user")
@NamedQuery(name="SecurityUser.findAll", query="SELECT s FROM SecurityUser s")
public class SecurityUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_USER_ID_GENERATOR", sequenceName="SECURITY_USER_ID_USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_USER_ID_GENERATOR")
	@Column(name="id_user", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(nullable=false, length=100)
	private String password;

	@Column(nullable=false, length=100)
	private String username;

	public SecurityUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}