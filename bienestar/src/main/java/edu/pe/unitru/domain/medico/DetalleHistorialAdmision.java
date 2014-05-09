package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detalle_historial_admision database table.
 * 
 */
@Entity
@Table(name="detalle_historial_admision")
@NamedQuery(name="DetalleHistorialAdmision.findAll", query="SELECT d FROM DetalleHistorialAdmision d")
public class DetalleHistorialAdmision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_HISTORIAL_ADMISION_ID_GENERATOR", sequenceName="DETALLE_HISTORIAL_ADMISION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_HISTORIAL_ADMISION_ID_GENERATOR")
	@Column(name="detalle_admision_id", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(name="fecha_historial_admision")
	private Timestamp fechaHistorialAdmision;

	//uni-directional many-to-one association to Clinico
	@ManyToOne
	@JoinColumn(name="id_clinico", nullable=false)
	private Clinico clinico;

	public DetalleHistorialAdmision() {
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

	public Timestamp getFechaHistorialAdmision() {
		return this.fechaHistorialAdmision;
	}

	public void setFechaHistorialAdmision(Timestamp fechaHistorialAdmision) {
		this.fechaHistorialAdmision = fechaHistorialAdmision;
	}

	public Clinico getClinico() {
		return this.clinico;
	}

	public void setClinico(Clinico clinico) {
		this.clinico = clinico;
	}

}