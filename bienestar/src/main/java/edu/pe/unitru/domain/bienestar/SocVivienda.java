package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the soc_vivienda database table.
 * 
 */
@Entity
@Table(name="soc_vivienda")
@NamedQuery(name="SocVivienda.findAll", query="SELECT s FROM SocVivienda s")
public class SocVivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_VIVIENDA_ID_GENERATOR", sequenceName="SOC_VIVIENDA_ID_VIVIENDA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_VIVIENDA_ID_GENERATOR")
	@Column(name="id_vivienda", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(length=500)
	private String observaciones;

	//uni-directional many-to-one association to ServicioSocial
	@ManyToOne
	@JoinColumn(name="id_servicio_social")
	private ServicioSocial servicioSocial;

	//uni-directional many-to-one association to TipoVivienda
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private TipoVivienda tipoVivienda;

	public SocVivienda() {
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ServicioSocial getServicioSocial() {
		return this.servicioSocial;
	}

	public void setServicioSocial(ServicioSocial servicioSocial) {
		this.servicioSocial = servicioSocial;
	}

	public TipoVivienda getTipoVivienda() {
		return this.tipoVivienda;
	}

	public void setTipoVivienda(TipoVivienda tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

}