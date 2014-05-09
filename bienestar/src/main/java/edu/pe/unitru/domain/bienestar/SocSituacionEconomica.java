package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the soc_situacion_economica database table.
 * 
 */
@Entity
@Table(name="soc_situacion_economica")
@NamedQuery(name="SocSituacionEconomica.findAll", query="SELECT s FROM SocSituacionEconomica s")
public class SocSituacionEconomica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_SITUACION_ECONOMICA_ID_GENERATOR", sequenceName="SOC_SITUACION_ECONOMICA_ID_SITUACION_ECONOMICA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_SITUACION_ECONOMICA_ID_GENERATOR")
	@Column(name="id_situacion_economica")
	private Long id;

	@Column(name="centro_trabajo")
	private String centroTrabajo;

	//bi-directional many-to-one association to ServicioSocial
	@OneToMany(mappedBy="socSituacionEconomica")
	private Set<ServicioSocial> servicioSocials;

	//bi-directional many-to-one association to SseCondicion
	@ManyToOne
	@JoinColumn(name="id_se_condicion")
	private SseCondicion sseCondicion;

	//bi-directional many-to-one association to SseDedicacion
	@ManyToOne
	@JoinColumn(name="id_se_dedidacion")
	private SseDedicacion sseDedicacion;

	//bi-directional many-to-one association to SseEgreso
	@ManyToOne
	@JoinColumn(name="id_se_egresos")
	private SseEgreso sseEgreso;

	//bi-directional many-to-one association to SseIngreso
	@ManyToOne
	@JoinColumn(name="id_se_ingresos")
	private SseIngreso sseIngreso;

	//bi-directional many-to-one association to SseOcupacionLaboral
	@ManyToOne
	@JoinColumn(name="id_se_ocupacion_laboral")
	private SseOcupacionLaboral sseOcupacionLaboral;

	//bi-directional many-to-one association to SseTurnoTrabajo
	@ManyToOne
	@JoinColumn(name="id_se_turno_trabajo")
	private SseTurnoTrabajo sseTurnoTrabajo;

	public SocSituacionEconomica() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCentroTrabajo() {
		return this.centroTrabajo;
	}

	public void setCentroTrabajo(String centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}

	public Set<ServicioSocial> getServicioSocials() {
		return this.servicioSocials;
	}

	public void setServicioSocials(Set<ServicioSocial> servicioSocials) {
		this.servicioSocials = servicioSocials;
	}

	public ServicioSocial addServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().add(servicioSocial);
		servicioSocial.setSocSituacionEconomica(this);

		return servicioSocial;
	}

	public ServicioSocial removeServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().remove(servicioSocial);
		servicioSocial.setSocSituacionEconomica(null);

		return servicioSocial;
	}

	public SseCondicion getSseCondicion() {
		return this.sseCondicion;
	}

	public void setSseCondicion(SseCondicion sseCondicion) {
		this.sseCondicion = sseCondicion;
	}

	public SseDedicacion getSseDedicacion() {
		return this.sseDedicacion;
	}

	public void setSseDedicacion(SseDedicacion sseDedicacion) {
		this.sseDedicacion = sseDedicacion;
	}

	public SseEgreso getSseEgreso() {
		return this.sseEgreso;
	}

	public void setSseEgreso(SseEgreso sseEgreso) {
		this.sseEgreso = sseEgreso;
	}

	public SseIngreso getSseIngreso() {
		return this.sseIngreso;
	}

	public void setSseIngreso(SseIngreso sseIngreso) {
		this.sseIngreso = sseIngreso;
	}

	public SseOcupacionLaboral getSseOcupacionLaboral() {
		return this.sseOcupacionLaboral;
	}

	public void setSseOcupacionLaboral(SseOcupacionLaboral sseOcupacionLaboral) {
		this.sseOcupacionLaboral = sseOcupacionLaboral;
	}

	public SseTurnoTrabajo getSseTurnoTrabajo() {
		return this.sseTurnoTrabajo;
	}

	public void setSseTurnoTrabajo(SseTurnoTrabajo sseTurnoTrabajo) {
		this.sseTurnoTrabajo = sseTurnoTrabajo;
	}

}