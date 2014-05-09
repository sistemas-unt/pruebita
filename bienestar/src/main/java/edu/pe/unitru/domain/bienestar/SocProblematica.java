package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import java.sql.Timestamp;

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

import edu.pe.unitru.domain.generic.Perfil;


/**
 * The persistent class for the soc_problematica database table.
 * 
 */
@Entity
@Table(name="soc_problematica")
@NamedQuery(name="SocProblematica.findAll", query="SELECT s FROM SocProblematica s")
public class SocProblematica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_PROBLEMATICA_ID_GENERATOR", sequenceName="SOC_PROBLEMATICA_ID_PROBLEMATICA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_PROBLEMATICA_ID_GENERATOR")
	@Column(name="id_problematica", unique=true, nullable=false)
	private long id;

	private Integer estado;

	@Column(nullable=false)
	private Timestamp fecha;
	
	@Column(length=600)
	private String problematica;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//uni-directional many-to-one association to ServicioSocial
	@ManyToOne
	@JoinColumn(name="id_servicio_social")
	private ServicioSocial servicioSocial;

	public SocProblematica() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getProblematica() {
		return this.problematica;
	}

	public void setProblematica(String problematica) {
		this.problematica = problematica;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public ServicioSocial getServicioSocial() {
		return this.servicioSocial;
	}

	public void setServicioSocial(ServicioSocial servicioSocial) {
		this.servicioSocial = servicioSocial;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}