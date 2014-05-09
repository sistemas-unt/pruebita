package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_grupo database table.
 * 
 */
@Entity
@Table(name="security_grupo")
@NamedQuery(name="SecurityGrupo.findAll", query="SELECT s FROM SecurityGrupo s")
public class SecurityGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_GRUPO_ID_GENERATOR", sequenceName="SECURITY_GRUPO_ID_GRUPO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_GRUPO_ID_GENERATOR")
	@Column(name="id_grupo", unique=true, nullable=false)
	private Long id;

	private Long depende;

	private Integer estado;

	@Column(length=100)
	private String nombre;

	public SecurityGrupo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepende() {
		return this.depende;
	}

	public void setDepende(Long depende) {
		this.depende = depende;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}