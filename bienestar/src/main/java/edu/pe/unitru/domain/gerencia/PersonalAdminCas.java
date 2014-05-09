package edu.pe.unitru.domain.gerencia;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ucontrol_personal_admin_cas database table.
 * 
 */
@Entity
@Table(name="ucontrol_personal_admin_cas")
@NamedQuery(name="PersonalAdminCas.findAll", query="SELECT p FROM PersonalAdminCas p")
public class PersonalAdminCas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UCONTROL_PERSONAL_ADMIN_CAS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UCONTROL_PERSONAL_ADMIN_CAS_ID_GENERATOR")
	@Column(name="id_personal_admin_cas", unique=true, nullable=false, length=100)
	private String id;

	@Column(name="anio_vacaciones")
	private Integer anioVacaciones;

	@Column(name="detalle_resolucion", length=150)
	private String detalleResolucion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_emision_resolucion", nullable=false)
	private Date fechaEmisionResolucion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_vacaciones", nullable=false)
	private Date fechaFinVacaciones;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_vacaciones", nullable=false)
	private Date fechaInicioVacaciones;

	@Column(name="numero_resolucion", nullable=false)
	private Integer numeroResolucion;

	@Column(name="periodo_vacaciones")
	private Integer periodoVacaciones;

	@Column(name="saldo_vacaciones")
	private Integer saldoVacaciones;

	@Column(name="total_dias_vacaciones", nullable=false)
	private Integer totalDiasVacaciones;

	//uni-directional many-to-one association to TipoFicha
	@ManyToOne
	@JoinColumn(name="id_tipo_ficha")
	private TipoFicha TipoFicha;

	//uni-directional many-to-one association to TipoResolucion
	@ManyToOne
	@JoinColumn(name="id_tipo_resolucion")
	private TipoResolucion TipoResolucion;

	public PersonalAdminCas() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAnioVacaciones() {
		return this.anioVacaciones;
	}

	public void setAnioVacaciones(Integer anioVacaciones) {
		this.anioVacaciones = anioVacaciones;
	}

	public String getDetalleResolucion() {
		return this.detalleResolucion;
	}

	public void setDetalleResolucion(String detalleResolucion) {
		this.detalleResolucion = detalleResolucion;
	}

	public Date getFechaEmisionResolucion() {
		return this.fechaEmisionResolucion;
	}

	public void setFechaEmisionResolucion(Date fechaEmisionResolucion) {
		this.fechaEmisionResolucion = fechaEmisionResolucion;
	}

	public Date getFechaFinVacaciones() {
		return this.fechaFinVacaciones;
	}

	public void setFechaFinVacaciones(Date fechaFinVacaciones) {
		this.fechaFinVacaciones = fechaFinVacaciones;
	}

	public Date getFechaInicioVacaciones() {
		return this.fechaInicioVacaciones;
	}

	public void setFechaInicioVacaciones(Date fechaInicioVacaciones) {
		this.fechaInicioVacaciones = fechaInicioVacaciones;
	}

	public Integer getNumeroResolucion() {
		return this.numeroResolucion;
	}

	public void setNumeroResolucion(Integer numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	public Integer getPeriodoVacaciones() {
		return this.periodoVacaciones;
	}

	public void setPeriodoVacaciones(Integer periodoVacaciones) {
		this.periodoVacaciones = periodoVacaciones;
	}

	public Integer getSaldoVacaciones() {
		return this.saldoVacaciones;
	}

	public void setSaldoVacaciones(Integer saldoVacaciones) {
		this.saldoVacaciones = saldoVacaciones;
	}

	public Integer getTotalDiasVacaciones() {
		return this.totalDiasVacaciones;
	}

	public void setTotalDiasVacaciones(Integer totalDiasVacaciones) {
		this.totalDiasVacaciones = totalDiasVacaciones;
	}

	public TipoFicha getTipoFicha() {
		return this.TipoFicha;
	}

	public void setTipoFicha(TipoFicha TipoFicha) {
		this.TipoFicha = TipoFicha;
	}

	public TipoResolucion getTipoResolucion() {
		return this.TipoResolucion;
	}

	public void setTipoResolucion(TipoResolucion TipoResolucion) {
		this.TipoResolucion = TipoResolucion;
	}

}