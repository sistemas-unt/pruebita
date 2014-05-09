package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the soc_aficiones database table.
 * 
 */
@Entity
@Table(name="soc_aficiones")
@NamedQuery(name="SocAficion.findAll", query="SELECT s FROM SocAficion s")
public class SocAficion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_AFICIONES_ID_GENERATOR", sequenceName="SOC_AFICIONES_ID_AFICION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_AFICIONES_ID_GENERATOR")
	@Column(name="id_aficion", unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String aficion;

	private Integer estado;

	//uni-directional many-to-one association to ServicioSocial
	@ManyToOne
	@JoinColumn(name="id_servicio_social")
	private ServicioSocial servicioSocial;

	public SocAficion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAficion() {
		return this.aficion;
	}

	public void setAficion(String aficion) {
		this.aficion = aficion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public ServicioSocial getServicioSocial() {
		return this.servicioSocial;
	}

	public void setServicioSocial(ServicioSocial servicioSocial) {
		this.servicioSocial = servicioSocial;
	}

}