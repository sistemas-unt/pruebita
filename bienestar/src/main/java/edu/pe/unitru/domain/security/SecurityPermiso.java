package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_permiso database table.
 * 
 */
@Entity
@Table(name="security_permiso")
@NamedQuery(name="SecurityPermiso.findAll", query="SELECT s FROM SecurityPermiso s")
public class SecurityPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_PERMISO_ID_GENERATOR", sequenceName="SECURITY_PERMISO_ID_PERMISO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_PERMISO_ID_GENERATOR")
	@Column(name="id_permiso", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(length=100)
	private String permiso;

	public SecurityPermiso() {
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

	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

}