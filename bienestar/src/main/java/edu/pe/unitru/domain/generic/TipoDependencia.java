package edu.pe.unitru.domain.generic;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the tipo_dependencia database table.
 * 
 */
@Entity
@Table(name="tipo_dependencia")
@NamedQuery(name="TipoDependencia.findAll", query="SELECT t FROM TipoDependencia t")
public class TipoDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_DEPENDENCIA_ID_GENERATOR", sequenceName="TIPO_DEPENDENCIA_TDE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_DEPENDENCIA_ID_GENERATOR")
	@Column(name="tde_id")
	private Long id;

	@Column(name="rde_estado")
	private Integer estado;

	@Column(name="tde_grupo")
	private Integer grupo;

	@Column(name="tde_nombre")
	private String nombre;

	//bi-directional many-to-one association to Dependencia
	@OneToMany(mappedBy="tipoDependencia")
	private Set<Dependencia> dependencias;

	public TipoDependencia() {
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

	public Integer getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Dependencia> getDependencias() {
		return this.dependencias;
	}

	public void setDependencias(Set<Dependencia> dependencias) {
		this.dependencias = dependencias;
	}

	public Dependencia addDependencia(Dependencia dependencia) {
		getDependencias().add(dependencia);
		dependencia.setTipoDependencia(this);

		return dependencia;
	}

	public Dependencia removeDependencia(Dependencia dependencia) {
		getDependencias().remove(dependencia);
		dependencia.setTipoDependencia(null);

		return dependencia;
	}

}