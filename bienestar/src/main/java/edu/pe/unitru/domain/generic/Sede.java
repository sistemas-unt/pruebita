package edu.pe.unitru.domain.generic;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEDE_ID_GENERATOR", sequenceName="SEDE_SEDE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEDE_ID_GENERATOR")
	@Column(name="sede_id")
	private Long id;

	private String nombre;

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="sede")
	private Set<Perfil> perfils;

	public Sede() {
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
		perfil.setSede(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setSede(null);

		return perfil;
	}

}