package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_roles_grupo database table.
 * 
 */
@Entity
@Table(name="security_roles_grupo")
@NamedQuery(name="SecurityRolesGrupo.findAll", query="SELECT s FROM SecurityRolesGrupo s")
public class SecurityRolesGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_ROLES_GRUPO_ID_GENERATOR", sequenceName="SECURITY_ROLES_GRUPO_ID_DETALLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_ROLES_GRUPO_ID_GENERATOR")
	@Column(name="id_detalle", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	//uni-directional many-to-one association to SecurityGrupo
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private SecurityGrupo securityGrupo;

	//uni-directional many-to-one association to SecurityRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private SecurityRol securityRol;

	public SecurityRolesGrupo() {
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

	public SecurityGrupo getSecurityGrupo() {
		return this.securityGrupo;
	}

	public void setSecurityGrupo(SecurityGrupo securityGrupo) {
		this.securityGrupo = securityGrupo;
	}

	public SecurityRol getSecurityRol() {
		return this.securityRol;
	}

	public void setSecurityRol(SecurityRol securityRol) {
		this.securityRol = securityRol;
	}

}