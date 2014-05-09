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
 * The persistent class for the soc_categoria_historial database table.
 * 
 */
@Entity
@Table(name="soc_categoria_historial")
@NamedQuery(name="SocCategoriaHistorial.findAll", query="SELECT s FROM SocCategoriaHistorial s")
public class SocCategoriaHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_CATEGORIA_HISTORIAL_ID_GENERATOR", sequenceName="SOC_CATEGORIA_HISTORIAL_ID_CATEGORIA_HISTORIAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_CATEGORIA_HISTORIAL_ID_GENERATOR")
	@Column(name="id_categoria_historial", unique=true, nullable=false)
	private Long id;

	@Column(name="categoria_actual")
	private Integer categoriaActual;

	@Column(name="categoria_anterior")
	private Integer categoriaAnterior;

	private Integer estado;

	private Timestamp fecha;

	@Column(name="motivo_cambio", length=600)
	private String motivoCambio;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//uni-directional many-to-one association to ServicioSocial
	@ManyToOne
	@JoinColumn(name="id_servicio_social")
	private ServicioSocial servicioSocial;

	public SocCategoriaHistorial() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCategoriaActual() {
		return this.categoriaActual;
	}

	public void setCategoriaActual(Integer categoriaActual) {
		this.categoriaActual = categoriaActual;
	}

	public Integer getCategoriaAnterior() {
		return this.categoriaAnterior;
	}

	public void setCategoriaAnterior(Integer categoriaAnterior) {
		this.categoriaAnterior = categoriaAnterior;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getMotivoCambio() {
		return this.motivoCambio;
	}

	public void setMotivoCambio(String motivoCambio) {
		this.motivoCambio = motivoCambio;
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

}