package edu.pe.unitru.domain.generic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ubigeo_reniec database table.
 * 
 */
@Entity
@Table(name="ubigeo_reniec")
@NamedQuery(name="UbigeoReniec.findAll", query="SELECT u FROM UbigeoReniec u")
public class UbigeoReniec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBIGEO_RENIEC_ID_GENERATOR", sequenceName="UBIGEO_RENIEC_ID_UBIGEO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBIGEO_RENIEC_ID_GENERATOR")
	@Column(name="id_ubigeo", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false)
	private Integer departamento;

	@Column(nullable=false)
	private Integer distrito;

	@Column(name="nombre_dep", length=100)
	private String nombreDepartamento;

	@Column(name="nombre_dist", length=100)
	private String nombreDistrito;

	@Column(name="nombre_prov", length=100)
	private String nombreProvincia;

	@Column(nullable=false)
	private Integer provincia;

	public UbigeoReniec() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public Integer getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}

	public String getNombreDepartamento() {
		return this.nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getNombreDistrito() {
		return this.nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public String getNombreProvincia() {
		return this.nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Integer getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Integer provincia) {
		this.provincia = provincia;
	}

}