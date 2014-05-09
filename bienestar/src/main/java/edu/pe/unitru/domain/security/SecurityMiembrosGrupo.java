package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_miembros_grupo database table.
 * 
 */
@Entity
@Table(name="security_miembros_grupo")
@NamedQuery(name="SecurityMiembrosGrupo.findAll", query="SELECT s FROM SecurityMiembrosGrupo s")
public class SecurityMiembrosGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_MIEMBROS_GRUPO_ID_GENERATOR", sequenceName="SECURITY_MIEMBROS_GRUPO_ID_MIEMBRO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_MIEMBROS_GRUPO_ID_GENERATOR")
	@Column(name="id_miembro", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	//uni-directional many-to-one association to SecurityGrupo
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private SecurityGrupo securityGrupo;

	//uni-directional many-to-one association to SecurityUser
	@ManyToOne
	@JoinColumn(name="id_user")
	private SecurityUser securityUser;

	public SecurityMiembrosGrupo() {
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

	public SecurityUser getSecurityUser() {
		return this.securityUser;
	}

	public void setSecurityUser(SecurityUser securityUser) {
		this.securityUser = securityUser;
	}

}