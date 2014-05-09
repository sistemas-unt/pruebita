package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cli_consulta database table.
 * 
 */
@Entity
@Table(name="cli_consulta")
@NamedQuery(name="CliConsulta.findAll", query="SELECT c FROM CliConsulta c")
public class CliConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_CONSULTA_ID_GENERATOR", sequenceName="CLI_CONSULTA_ID_CONSULTA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_CONSULTA_ID_GENERATOR")
	@Column(name="id_consulta", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false)
	private Boolean diagnostico;

	@Column(name="enfermedad_actual", nullable=false)
	private Boolean enfermedadActual;

	@Column(nullable=false)
	private Boolean evolucion;

	@Column(name="exa_clinico", nullable=false)
	private Boolean exaClinico;

	@Column(nullable=false)
	private Boolean interconsultas;

	@Column(nullable=false)
	private Boolean sintomas;

	@Column(nullable=false)
	private Boolean tratamiento;

	public CliConsulta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(Boolean diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Boolean getEnfermedadActual() {
		return this.enfermedadActual;
	}

	public void setEnfermedadActual(Boolean enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}

	public Boolean getEvolucion() {
		return this.evolucion;
	}

	public void setEvolucion(Boolean evolucion) {
		this.evolucion = evolucion;
	}

	public Boolean getExaClinico() {
		return this.exaClinico;
	}

	public void setExaClinico(Boolean exaClinico) {
		this.exaClinico = exaClinico;
	}

	public Boolean getInterconsultas() {
		return this.interconsultas;
	}

	public void setInterconsultas(Boolean interconsultas) {
		this.interconsultas = interconsultas;
	}

	public Boolean getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(Boolean sintomas) {
		this.sintomas = sintomas;
	}

	public Boolean getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(Boolean tratamiento) {
		this.tratamiento = tratamiento;
	}

}