package edu.pe.unitru.domain.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.pe.unitru.domain.generic.Perfil;


/**
 * The persistent class for the security_rol_user database table.
 * 
 */
@Entity
@Table(name="security_rol_user")
@NamedQuery(name="SecurityRolUser.findAll", query="SELECT s FROM SecurityRolUser s")
public class SecurityRolUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_ROL_USER_ID_GENERATOR", sequenceName="SECURITY_ROL_USER_ID_DETALLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_ROL_USER_ID_GENERATOR")
	@Column(name="id_detalle", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	//uni-directional many-to-one association to SecurityRol
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//uni-directional many-to-one association to SecurityRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private SecurityRol securityRol;

	//uni-directional many-to-one association to SecurityUser
	@ManyToOne
	@JoinColumn(name="id_user")
	private SecurityUser securityUser;

	public SecurityRolUser() {
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

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public SecurityRol getSecurityRol() {
		return this.securityRol;
	}

	public void setSecurityRol(SecurityRol securityRol) {
		this.securityRol = securityRol;
	}

	public SecurityUser getSecurityUser() {
		return this.securityUser;
	}

	public void setSecurityUser(SecurityUser securityUser) {
		this.securityUser = securityUser;
	}

}