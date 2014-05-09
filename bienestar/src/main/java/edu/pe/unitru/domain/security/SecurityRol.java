package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_rol database table.
 * 
 */
@Entity
@Table(name="security_rol")
@NamedQuery(name="SecurityRol.findAll", query="SELECT s FROM SecurityRol s")
public class SecurityRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_ROL_ID_GENERATOR", sequenceName="SECURITY_ROL_ID_ROL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_ROL_ID_GENERATOR")
	@Column(name="id_rol", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(length=100)
	private String rol;

	public SecurityRol() {
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

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}