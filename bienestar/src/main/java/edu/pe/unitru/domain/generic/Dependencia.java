package edu.pe.unitru.domain.generic;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the dependencia database table.
 * 
 */
@Entity
@NamedQuery(name="Dependencia.findAll", query="SELECT d FROM Dependencia d")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPENDENCIA_ID_GENERATOR", sequenceName="DEPENDENCIA_DEP_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPENDENCIA_ID_GENERATOR")
	@Column(name="dep_id")
	private Long id;

	@Column(name="dep_abrev")
	private String abreviatura;

	@Column(name="dep_cargo")
	private String cargo;

	@Column(name="dep_estado")
	private Integer estado;

	@Column(name="dep_fcreacion")
	private Timestamp fechaCreacion;

	@Column(name="dep_nombre")
	private String nombre;

	@Column(name="dep_recibe_tramite")
	private Integer recibeTramite;

	@Column(name="dep_representante")
	private String representante;

	@Column(name="dep_siglas")
	private String siglas;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="dep_depende")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="dependencia")
	private Set<Dependencia> dependencias;

	//bi-directional many-to-one association to TipoDependencia
	@ManyToOne
	@JoinColumn(name="tde_id")
	private TipoDependencia tipoDependencia;

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="dependencia")
	private Set<Perfil> perfils;

	public Dependencia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getRecibeTramite() {
		return this.recibeTramite;
	}

	public void setRecibeTramite(Integer recibeTramite) {
		this.recibeTramite = recibeTramite;
	}

	public String getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getSiglas() {
		return this.siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Set<Dependencia> getDependencias() {
		return this.dependencias;
	}

	public void setDependencias(Set<Dependencia> dependencias) {
		this.dependencias = dependencias;
	}

	public Dependencia addDependencia(Dependencia dependencia) {
		getDependencias().add(dependencia);
		dependencia.setDependencia(this);

		return dependencia;
	}

	public Dependencia removeDependencia(Dependencia dependencia) {
		getDependencias().remove(dependencia);
		dependencia.setDependencia(null);

		return dependencia;
	}

	public TipoDependencia getTipoDependencia() {
		return this.tipoDependencia;
	}

	public void setTipoDependencia(TipoDependencia tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
	}

	public Set<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(Set<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setDependencia(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setDependencia(null);

		return perfil;
	}

}