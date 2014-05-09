package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cli_ficha_dental database table.
 * 
 */
@Entity
@Table(name="cli_ficha_dental")
@NamedQuery(name="CliFichaDental.findAll", query="SELECT c FROM CliFichaDental c")
public class CliFichaDental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_FICHA_DENTAL_ID_GENERATOR", sequenceName="CLI_FICHA_DENTAL_ID_DENTAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_FICHA_DENTAL_ID_GENERATOR")
	@Column(name="id_dental", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(name="med_responsable", nullable=false, length=25)
	private String medResponsable;

	@Column(nullable=false, length=35)
	private String tratamiento;

	public CliFichaDental() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getMedResponsable() {
		return this.medResponsable;
	}

	public void setMedResponsable(String medResponsable) {
		this.medResponsable = medResponsable;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

}