package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sse_ocupacion_laboral database table.
 * 
 */
@Entity
@Table(name="sse_ocupacion_laboral")
@NamedQuery(name="SseOcupacionLaboral.findAll", query="SELECT s FROM SseOcupacionLaboral s")
public class SseOcupacionLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SSE_OCUPACION_LABORAL_ID_GENERATOR", sequenceName="SSE_OCUPACION_LABORAL_ID_SE_OCUPACION_LABORAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSE_OCUPACION_LABORAL_ID_GENERATOR")
	@Column(name="id_se_ocupacion_laboral")
	private Long id;

	private String ocupacion;

	//bi-directional many-to-one association to SocSituacionEconomica
	@OneToMany(mappedBy="sseOcupacionLaboral")
	private Set<SocSituacionEconomica> socSituacionEconomicas;

	public SseOcupacionLaboral() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Set<SocSituacionEconomica> getSocSituacionEconomicas() {
		return this.socSituacionEconomicas;
	}

	public void setSocSituacionEconomicas(Set<SocSituacionEconomica> socSituacionEconomicas) {
		this.socSituacionEconomicas = socSituacionEconomicas;
	}

	public SocSituacionEconomica addSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().add(socSituacionEconomica);
		socSituacionEconomica.setSseOcupacionLaboral(this);

		return socSituacionEconomica;
	}

	public SocSituacionEconomica removeSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().remove(socSituacionEconomica);
		socSituacionEconomica.setSseOcupacionLaboral(null);

		return socSituacionEconomica;
	}

}