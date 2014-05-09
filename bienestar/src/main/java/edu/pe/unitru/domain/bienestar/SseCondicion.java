package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sse_condicion database table.
 * 
 */
@Entity
@Table(name="sse_condicion")
@NamedQuery(name="SseCondicion.findAll", query="SELECT s FROM SseCondicion s")
public class SseCondicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SSE_CONDICION_ID_GENERATOR", sequenceName="SSE_CONDICION_ID_SE_CONDICION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSE_CONDICION_ID_GENERATOR")
	@Column(name="id_se_condicion")
	private Long id;

	private String condicion;

	//bi-directional many-to-one association to SocSituacionEconomica
	@OneToMany(mappedBy="sseCondicion")
	private Set<SocSituacionEconomica> socSituacionEconomicas;

	public SseCondicion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCondicion() {
		return this.condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public Set<SocSituacionEconomica> getSocSituacionEconomicas() {
		return this.socSituacionEconomicas;
	}

	public void setSocSituacionEconomicas(Set<SocSituacionEconomica> socSituacionEconomicas) {
		this.socSituacionEconomicas = socSituacionEconomicas;
	}

	public SocSituacionEconomica addSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().add(socSituacionEconomica);
		socSituacionEconomica.setSseCondicion(this);

		return socSituacionEconomica;
	}

	public SocSituacionEconomica removeSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().remove(socSituacionEconomica);
		socSituacionEconomica.setSseCondicion(null);

		return socSituacionEconomica;
	}

}