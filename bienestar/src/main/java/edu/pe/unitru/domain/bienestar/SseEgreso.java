package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the sse_egresos database table.
 * 
 */
@Entity
@Table(name="sse_egresos")
@NamedQuery(name="SseEgreso.findAll", query="SELECT s FROM SseEgreso s")
public class SseEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SSE_EGRESOS_ID_GENERATOR", sequenceName="SSE_EGRESOS_ID_SE_EGRESOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSE_EGRESOS_ID_GENERATOR")
	@Column(name="id_se_egresos")
	private Long id;

	private BigDecimal alimentacion;

	private BigDecimal habitacion;

	private BigDecimal movilidad;

	@Column(name="pension_universitaria")
	private BigDecimal pensionUniversitaria;

	private BigDecimal utiles;

	private BigDecimal vestimenta;

	//bi-directional many-to-one association to SocSituacionEconomica
	@OneToMany(mappedBy="sseEgreso")
	private Set<SocSituacionEconomica> socSituacionEconomicas;

	public SseEgreso() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAlimentacion() {
		return this.alimentacion;
	}

	public void setAlimentacion(BigDecimal alimentacion) {
		this.alimentacion = alimentacion;
	}

	public BigDecimal getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(BigDecimal habitacion) {
		this.habitacion = habitacion;
	}

	public BigDecimal getMovilidad() {
		return this.movilidad;
	}

	public void setMovilidad(BigDecimal movilidad) {
		this.movilidad = movilidad;
	}

	public BigDecimal getPensionUniversitaria() {
		return this.pensionUniversitaria;
	}

	public void setPensionUniversitaria(BigDecimal pensionUniversitaria) {
		this.pensionUniversitaria = pensionUniversitaria;
	}

	public BigDecimal getUtiles() {
		return this.utiles;
	}

	public void setUtiles(BigDecimal utiles) {
		this.utiles = utiles;
	}

	public BigDecimal getVestimenta() {
		return this.vestimenta;
	}

	public void setVestimenta(BigDecimal vestimenta) {
		this.vestimenta = vestimenta;
	}

	public Set<SocSituacionEconomica> getSocSituacionEconomicas() {
		return this.socSituacionEconomicas;
	}

	public void setSocSituacionEconomicas(Set<SocSituacionEconomica> socSituacionEconomicas) {
		this.socSituacionEconomicas = socSituacionEconomicas;
	}

	public SocSituacionEconomica addSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().add(socSituacionEconomica);
		socSituacionEconomica.setSseEgreso(this);

		return socSituacionEconomica;
	}

	public SocSituacionEconomica removeSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		getSocSituacionEconomicas().remove(socSituacionEconomica);
		socSituacionEconomica.setSseEgreso(null);

		return socSituacionEconomica;
	}

}