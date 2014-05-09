package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cli_hoja_consultorio database table.
 * 
 */
@Entity
@Table(name="cli_hoja_consultorio")
@NamedQuery(name="CliHojaConsultorio.findAll", query="SELECT c FROM CliHojaConsultorio c")
public class CliHojaConsultorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_HOJA_CONSULTORIO_ID_GENERATOR", sequenceName="CLI_HOJA_CONSULTORIO_ID_HOJA_CONSULTORIO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_HOJA_CONSULTORIO_ID_GENERATOR")
	@Column(name="id_hoja_consultorio", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=30)
	private String descripcion;

	@Column(nullable=false)
	private Timestamp fecha;

	//uni-directional many-to-one association to CliConsulta
	@ManyToOne
	@JoinColumn(name="id_consulta", nullable=false)
	private CliConsulta cliConsulta;

	public CliHojaConsultorio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public CliConsulta getCliConsulta() {
		return this.cliConsulta;
	}

	public void setCliConsulta(CliConsulta cliConsulta) {
		this.cliConsulta = cliConsulta;
	}

}