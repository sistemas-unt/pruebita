package edu.pe.unitru.domain.generic;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_ID_GENERATOR", sequenceName="ROL_ROL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_ID_GENERATOR")
	@Column(name="rol_id")
	private Long id;

	@Column(name="rol_nombre")
	private String nombre;

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="rol")
	private Set<Perfil> perfils;

	public Rol() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(Set<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setRol(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setRol(null);

		return perfil;
	}

}