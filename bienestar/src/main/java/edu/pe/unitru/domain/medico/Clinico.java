package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clinico database table.
 * 
 */
@Entity
@Table(name="clinico")
@NamedQuery(name="Clinico.findAll", query="SELECT c FROM Clinico c")
public class Clinico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLINICO_ID_GENERATOR", sequenceName="CLI_PACIENTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLINICO_ID_GENERATOR")
	@Column(name="id_clinico", unique=true, nullable=false)
	private Long id;

	//uni-directional many-to-one association to CliExamenFisico
	@ManyToOne
	@JoinColumn(name="id_examen_fisico")
	private CliExamenFisico cliExamenFisico;

	//uni-directional many-to-one association to CliFichaDental
	@ManyToOne
	@JoinColumn(name="id_dental")
	private CliFichaDental cliFichaDental;

	//uni-directional many-to-one association to CliFichaHistorial
	@ManyToOne
	@JoinColumn(name="id_ficha_historial")
	private CliFichaHistorial cliFichaHistorial;

	//uni-directional many-to-one association to CliFichaLaboratorio
	@ManyToOne
	@JoinColumn(name="id_ficha_laboratorio")
	private CliFichaLaboratorio cliFichaLaboratorio;

	//uni-directional many-to-one association to CliFichaPsicologica
	@ManyToOne
	@JoinColumn(name="id_ficha_psicologica")
	private CliFichaPsicologica cliFichaPsicologica;

	//uni-directional many-to-one association to CliFichaSaludpublica
	@ManyToOne
	@JoinColumn(name="id_salud_publica")
	private CliFichaSaludpublica cliFichaSaludpublica;

	//uni-directional many-to-one association to CliHojaConsultorio
	@ManyToOne
	@JoinColumn(name="id_hoja_consultorio")
	private CliHojaConsultorio cliHojaConsultorio;

	//uni-directional many-to-one association to CliPaciente
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false)
	private CliPaciente cliPaciente;

	public Clinico() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CliExamenFisico getCliExamenFisico() {
		return this.cliExamenFisico;
	}

	public void setCliExamenFisico(CliExamenFisico cliExamenFisico) {
		this.cliExamenFisico = cliExamenFisico;
	}

	public CliFichaDental getCliFichaDental() {
		return this.cliFichaDental;
	}

	public void setCliFichaDental(CliFichaDental cliFichaDental) {
		this.cliFichaDental = cliFichaDental;
	}

	public CliFichaHistorial getCliFichaHistorial() {
		return this.cliFichaHistorial;
	}

	public void setCliFichaHistorial(CliFichaHistorial cliFichaHistorial) {
		this.cliFichaHistorial = cliFichaHistorial;
	}

	public CliFichaLaboratorio getCliFichaLaboratorio() {
		return this.cliFichaLaboratorio;
	}

	public void setCliFichaLaboratorio(CliFichaLaboratorio cliFichaLaboratorio) {
		this.cliFichaLaboratorio = cliFichaLaboratorio;
	}

	public CliFichaPsicologica getCliFichaPsicologica() {
		return this.cliFichaPsicologica;
	}

	public void setCliFichaPsicologica(CliFichaPsicologica cliFichaPsicologica) {
		this.cliFichaPsicologica = cliFichaPsicologica;
	}

	public CliFichaSaludpublica getCliFichaSaludpublica() {
		return this.cliFichaSaludpublica;
	}

	public void setCliFichaSaludpublica(CliFichaSaludpublica cliFichaSaludpublica) {
		this.cliFichaSaludpublica = cliFichaSaludpublica;
	}

	public CliHojaConsultorio getCliHojaConsultorio() {
		return this.cliHojaConsultorio;
	}

	public void setCliHojaConsultorio(CliHojaConsultorio cliHojaConsultorio) {
		this.cliHojaConsultorio = cliHojaConsultorio;
	}

	public CliPaciente getCliPaciente() {
		return this.cliPaciente;
	}

	public void setCliPaciente(CliPaciente cliPaciente) {
		this.cliPaciente = cliPaciente;
	}

}