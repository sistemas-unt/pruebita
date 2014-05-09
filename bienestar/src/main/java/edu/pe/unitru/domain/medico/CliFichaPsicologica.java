package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cli_ficha_psicologica database table.
 * 
 */
@Entity
@Table(name="cli_ficha_psicologica")
@NamedQuery(name="CliFichaPsicologica.findAll", query="SELECT c FROM CliFichaPsicologica c")
public class CliFichaPsicologica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_FICHA_PSICOLOGICA_ID_GENERATOR", sequenceName="CLI_FICHA_PSICOLOGICA_ID_FICHA_PSICOLOGICA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_FICHA_PSICOLOGICA_ID_GENERATOR")
	@Column(name="id_ficha_psicologica", unique=true, nullable=false)
	private Long id;

	@Column(name="psi_motivo_consulta", nullable=false, length=30)
	private String psiMotivoConsulta;

	@Column(name="psi_observaciones", nullable=false, length=30)
	private String psiObservaciones;

	@Column(name="psi_recomendacion", length=30)
	private String psiRecomendacion;

	@Column(name="psi_resultado", nullable=false, length=30)
	private String psiResultado;

	public CliFichaPsicologica() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPsiMotivoConsulta() {
		return this.psiMotivoConsulta;
	}

	public void setPsiMotivoConsulta(String psiMotivoConsulta) {
		this.psiMotivoConsulta = psiMotivoConsulta;
	}

	public String getPsiObservaciones() {
		return this.psiObservaciones;
	}

	public void setPsiObservaciones(String psiObservaciones) {
		this.psiObservaciones = psiObservaciones;
	}

	public String getPsiRecomendacion() {
		return this.psiRecomendacion;
	}

	public void setPsiRecomendacion(String psiRecomendacion) {
		this.psiRecomendacion = psiRecomendacion;
	}

	public String getPsiResultado() {
		return this.psiResultado;
	}

	public void setPsiResultado(String psiResultado) {
		this.psiResultado = psiResultado;
	}

}