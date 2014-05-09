package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sse_dedicacion database table.
 * 
 */
@Entity
@Table(name="sse_dedicacion")
@NamedQuery(name="SseDedicacion.findAll", query="SELECT s FROM SseDedicacion s")
public class SseDedicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SSE_DEDICACION_ID_GENERATOR", sequenceName="SSE_DEDICACION_ID_SE_DEDICACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSE_DEDICACION_ID_GENERATOR")
	@Column(name="id_se_dedicacion")
	private Long id;

	private String dedicacion;

	//bi-directional many-to-one association to SocSituacionEconomica
	@OneToMany(mappedBy="sseDedicacion")
	private Set<SocSituacionEconomica> socSituacionEconomicas;

	public SseDedicacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public Set<SocSituacionEconomica> getSocSituacionEconomicas() {
		return this.socSituacionEconomicas;
	}

	public void setSocSituacionEconomicas(Set<SocSituacionEconomica> socSituacionEconomicas) {
		this.socSituacionEconomicas = socSituacionEconomicas;
	}

	public SocSituacionEconomica addSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().add(socSituacionEconomica);
		socSituacionEconomica.setSseDedicacion(this);

		return socSituacionEconomica;
	}

	public SocSituacionEconomica removeSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().remove(socSituacionEconomica);
		socSituacionEconomica.setSseDedicacion(null);

		return socSituacionEconomica;
	}

}