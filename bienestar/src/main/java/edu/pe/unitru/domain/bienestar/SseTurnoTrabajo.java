package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sse_turno_trabajo database table.
 * 
 */
@Entity
@Table(name="sse_turno_trabajo")
@NamedQuery(name="SseTurnoTrabajo.findAll", query="SELECT s FROM SseTurnoTrabajo s")
public class SseTurnoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SSE_TURNO_TRABAJO_ID_GENERATOR", sequenceName="SSE_TURNO_TRABAJO_ID_SE_TURNO_TRABAJO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSE_TURNO_TRABAJO_ID_GENERATOR")
	@Column(name="id_se_turno_trabajo")
	private Long id;

	private String turno;

	//bi-directional many-to-one association to SocSituacionEconomica
	@OneToMany(mappedBy="sseTurnoTrabajo")
	private Set<SocSituacionEconomica> socSituacionEconomicas;

	public SseTurnoTrabajo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Set<SocSituacionEconomica> getSocSituacionEconomicas() {
		return this.socSituacionEconomicas;
	}

	public void setSocSituacionEconomicas(Set<SocSituacionEconomica> socSituacionEconomicas) {
		this.socSituacionEconomicas = socSituacionEconomicas;
	}

	public SocSituacionEconomica addSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().add(socSituacionEconomica);
		socSituacionEconomica.setSseTurnoTrabajo(this);

		return socSituacionEconomica;
	}

	public SocSituacionEconomica removeSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().remove(socSituacionEconomica);
		socSituacionEconomica.setSseTurnoTrabajo(null);

		return socSituacionEconomica;
	}

}