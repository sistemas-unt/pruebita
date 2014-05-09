package edu.pe.unitru.domain.medico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.pe.unitru.domain.generic.Perfil;


/**
 * The persistent class for the cli_paciente database table.
 * 
 */
@Entity
@Table(name="cli_paciente")
@NamedQuery(name="CliPaciente.findAll", query="SELECT c FROM CliPaciente c")
public class CliPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_PACIENTE_ID_GENERATOR", sequenceName="CLI_PACIENTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_PACIENTE_ID_GENERATOR")
	@Column(name="id_paciente", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=15)
	private String nroClinico;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil", nullable=false)
	private Perfil perfil;

	public CliPaciente() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroClinico() {
		return this.nroClinico;
	}

	public void setNroClinico(String nroClinico) {
		this.nroClinico = nroClinico;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}