package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the soc_deportes database table.
 * 
 */
@Entity
@Table(name="soc_deportes")
@NamedQuery(name="SocDeporte.findAll", query="SELECT s FROM SocDeporte s")
public class SocDeporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_DEPORTES_ID_GENERATOR", sequenceName="SOC_DEPORTES_ID_DEPORTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_DEPORTES_ID_GENERATOR")
	@Column(name="id_deporte", unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String deporte;

	private Integer estado;

	//uni-directional many-to-one association to ServicioSocial
	@ManyToOne
	@JoinColumn(name="id_servicio_social")
	private ServicioSocial servicioSocial;

	public SocDeporte() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeporte() {
		return this.deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
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