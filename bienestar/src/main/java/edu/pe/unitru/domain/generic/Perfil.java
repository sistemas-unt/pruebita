package edu.pe.unitru.domain.generic;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERFIL_ID_GENERATOR", sequenceName="PERFIL_ID_PERFIL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERFIL_ID_GENERATOR")
	@Column(name="id_perfil")
	private Long id;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="dep_id")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="sede_id")
	private Sede sede;
	
	@Column(name="cod_usuario", length=15)
	private String codigoPerfil;
	
	private Integer estado;

	public Perfil() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	public String getCodigoPerfil() {
		return this.codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}