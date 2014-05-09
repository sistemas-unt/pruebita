package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cfh_inmunizaciones database table.
 * 
 */
@Entity
@Table(name="cfh_inmunizaciones")
@NamedQuery(name="CfhInmunizacion.findAll", query="SELECT c FROM CfhInmunizacion c")
public class CfhInmunizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CFH_INMUNIZACIONES_IDINMUNIZACION_GENERATOR", sequenceName="CFH_INMUNIZACIONES_ID_INMUNIZACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFH_INMUNIZACIONES_IDINMUNIZACION_GENERATOR")
	@Column(name="id_inmunizacion")
	private Long idInmunizacion;

	private String nombre;

	private Integer sano;

	//bi-directional many-to-one association to CliFichaHistorial
	@ManyToOne
	@JoinColumn(name="id_ficha_historial")
	private CliFichaHistorial cliFichaHistorial;

	public CfhInmunizacion() {
	}

	public Long getIdInmunizacion() {
		return this.idInmunizacion;
	}

	public void setIdInmunizacion(Long idInmunizacion) {
		this.idInmunizacion = idInmunizacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSano() {
		return this.sano;
	}

	public void setSano(Integer sano) {
		this.sano = sano;
	}

	public CliFichaHistorial getCliFichaHistorial() {
		return this.cliFichaHistorial;
	}

	public void setCliFichaHistorial(CliFichaHistorial cliFichaHistorial) {
		this.cliFichaHistorial = cliFichaHistorial;
	}

}