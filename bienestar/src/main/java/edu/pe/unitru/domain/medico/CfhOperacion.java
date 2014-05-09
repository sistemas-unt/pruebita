package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cfh_operaciones database table.
 * 
 */
@Entity
@Table(name="cfh_operaciones")
@NamedQuery(name="CfhOperacion.findAll", query="SELECT c FROM CfhOperacion c")
public class CfhOperacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CFH_OPERACIONES_ID_GENERATOR", sequenceName="CFH_OPERACIONES_ID_OPERACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFH_OPERACIONES_ID_GENERATOR")
	@Column(name="id_operacion")
	private Long id;

	private String nombre;

	private Integer sano;

	//bi-directional many-to-one association to CliFichaHistorial
	@ManyToOne
	@JoinColumn(name="id_ficha_historial")
	private CliFichaHistorial cliFichaHistorial;

	public CfhOperacion() {
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