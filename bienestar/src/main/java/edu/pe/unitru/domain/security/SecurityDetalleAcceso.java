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


/**
 * The persistent class for the security_detalle_acceso database table.
 * 
 */
@Entity
@Table(name="security_detalle_acceso")
@NamedQuery(name="SecurityDetalleAcceso.findAll", query="SELECT s FROM SecurityDetalleAcceso s")
public class SecurityDetalleAcceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_DETALLE_ACCESO_ID_GENERATOR", sequenceName="SECURITY_DETALLE_ACCESO_ID_DETALLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_DETALLE_ACCESO_ID_GENERATOR")
	@Column(name="id_detalle", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	//uni-directional many-to-one association to SecurityPermiso
	@ManyToOne
	@JoinColumn(name="id_permiso")
	private SecurityPermiso securityPermiso;

	//uni-directional many-to-one association to SecurityRol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private SecurityRol securityRol;

	//uni-directional many-to-one association to SecurityTarea
	@ManyToOne
	@JoinColumn(name="id_tarea")
	private SecurityTarea securityTarea;

	public SecurityDetalleAcceso() {
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

	public SecurityPermiso getSecurityPermiso() {
		return this.securityPermiso;
	}

	public void setSecurityPermiso(SecurityPermiso securityPermiso) {
		this.securityPermiso = securityPermiso;
	}

	public SecurityRol getSecurityRol() {
		return this.securityRol;
	}

	public void setSecurityRol(SecurityRol securityRol) {
		this.securityRol = securityRol;
	}

	public SecurityTarea getSecurityTarea() {
		return this.securityTarea;
	}

	public void setSecurityTarea(SecurityTarea securityTarea) {
		this.securityTarea = securityTarea;
	}

}