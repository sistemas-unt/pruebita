package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the sse_ingresos database table.
 * 
 */
@Entity
@Table(name="sse_ingresos")
@NamedQuery(name="SseIngreso.findAll", query="SELECT s FROM SseIngreso s")
public class SseIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SSE_INGRESOS_ID_GENERATOR", sequenceName="SSE_INGRESOS_ID_SE_INGRESOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSE_INGRESOS_ID_GENERATOR")
	@Column(name="id_se_ingresos")
	private Long id;

	private BigDecimal abuelos;

	@Column(name="otros_parientes")
	private BigDecimal otrosParientes;

	private BigDecimal padres;

	private BigDecimal pension;

	private BigDecimal trabajo;

	//bi-directional many-to-one association to SocSituacionEconomica
	@OneToMany(mappedBy="sseIngreso")
	private Set<SocSituacionEconomica> socSituacionEconomicas;

	public SseIngreso() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAbuelos() {
		return this.abuelos;
	}

	public void setAbuelos(BigDecimal abuelos) {
		this.abuelos = abuelos;
	}

	public BigDecimal getOtrosParientes() {
		return this.otrosParientes;
	}

	public void setOtrosParientes(BigDecimal otrosParientes) {
		this.otrosParientes = otrosParientes;
	}

	public BigDecimal getPadres() {
		return this.padres;
	}

	public void setPadres(BigDecimal padres) {
		this.padres = padres;
	}

	public BigDecimal getPension() {
		return this.pension;
	}

	public void setPension(BigDecimal pension) {
		this.pension = pension;
	}

	public BigDecimal getTrabajo() {
		return this.trabajo;
	}

	public void setTrabajo(BigDecimal trabajo) {
		this.trabajo = trabajo;
	}

	public Set<SocSituacionEconomica> getSocSituacionEconomicas() {
		return this.socSituacionEconomicas;
	}

	public void setSocSituacionEconomicas(Set<SocSituacionEconomica> socSituacionEconomicas) {
		this.socSituacionEconomicas = socSituacionEconomicas;
	}

	public SocSituacionEconomica addSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().add(socSituacionEconomica);
		socSituacionEconomica.setSseIngreso(this);

		return socSituacionEconomica;
	}

	public SocSituacionEconomica removeSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().remove(socSituacionEconomica);
		socSituacionEconomica.setSseIngreso(null);

		return socSituacionEconomica;
	}

}