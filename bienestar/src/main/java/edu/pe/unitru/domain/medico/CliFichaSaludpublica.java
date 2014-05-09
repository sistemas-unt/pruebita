package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cli_ficha_saludpublica database table.
 * 
 */
@Entity
@Table(name="cli_ficha_saludpublica")
@NamedQuery(name="CliFichaSaludpublica.findAll", query="SELECT c FROM CliFichaSaludpublica c")
public class CliFichaSaludpublica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_FICHA_SALUDPUBLICA_ID_GENERATOR", sequenceName="CLI_FICHA_SALUDPUBLICA_ID_SALUD_PUBLICA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_FICHA_SALUDPUBLICA_ID_GENERATOR")
	@Column(name="id_salud_publica", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false)
	private Boolean aborto;

	@Column(name="abuso_sexual", nullable=false)
	private Boolean abusoSexual;

	@Column(nullable=false)
	private Boolean alcohol;

	@Column(name="cantidad_hijos", nullable=false)
	private Integer cantidadHijos;

	@Column(nullable=false)
	private Boolean cohabitacion;

	@Column(nullable=false)
	private Boolean drogas;

	@Column(name="edad_rs", nullable=false)
	private Boolean edadRs;

	@Column(nullable=false)
	private Boolean elisa;

	@Column(nullable=false)
	private Boolean embarazo;

	@Column(nullable=false)
	private Boolean hijos;

	@Column(name="metodo_anticoncep", nullable=false, length=15)
	private String metodoAnticoncep;

	@Column(name="num_enamorados", nullable=false)
	private Boolean numEnamorados;

	@Column(name="num_parejasex", nullable=false)
	private Integer numParejasex;

	@Column(nullable=false, length=50)
	private String obsv;

	@Column(name="pareja_actual", nullable=false)
	private Boolean parejaActual;

	@Column(name="relacion_familiar", nullable=false, length=15)
	private String relacionFamiliar;

	@Column(nullable=false)
	private Boolean tabaco;

	@Column(nullable=false)
	private Boolean tatuajes;

	@Column(name="tbc_bk", nullable=false, length=20)
	private String tbcBk;

	@Column(name="tbc_familiar", nullable=false, length=5)
	private String tbcFamiliar;

	@Column(name="tbc_personal", nullable=false, length=5)
	private String tbcPersonal;

	@Column(name="tbc_sistresp", nullable=false, length=30)
	private String tbcSistresp;

	@Column(nullable=false)
	private Boolean transfusiones;

	@Column(nullable=false, length=20)
	private String vinculo;

	@Column(nullable=false)
	private Boolean violencia;

	public CliFichaSaludpublica() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAborto() {
		return this.aborto;
	}

	public void setAborto(Boolean aborto) {
		this.aborto = aborto;
	}

	public Boolean getAbusoSexual() {
		return this.abusoSexual;
	}

	public void setAbusoSexual(Boolean abusoSexual) {
		this.abusoSexual = abusoSexual;
	}

	public Boolean getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(Boolean alcohol) {
		this.alcohol = alcohol;
	}

	public Integer getCantidadHijos() {
		return this.cantidadHijos;
	}

	public void setCantidadHijos(Integer cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public Boolean getCohabitacion() {
		return this.cohabitacion;
	}

	public void setCohabitacion(Boolean cohabitacion) {
		this.cohabitacion = cohabitacion;
	}

	public Boolean getDrogas() {
		return this.drogas;
	}

	public void setDrogas(Boolean drogas) {
		this.drogas = drogas;
	}

	public Boolean getEdadRs() {
		return this.edadRs;
	}

	public void setEdadRs(Boolean edadRs) {
		this.edadRs = edadRs;
	}

	public Boolean getElisa() {
		return this.elisa;
	}

	public void setElisa(Boolean elisa) {
		this.elisa = elisa;
	}

	public Boolean getEmbarazo() {
		return this.embarazo;
	}

	public void setEmbarazo(Boolean embarazo) {
		this.embarazo = embarazo;
	}

	public Boolean getHijos() {
		return this.hijos;
	}

	public void setHijos(Boolean hijos) {
		this.hijos = hijos;
	}

	public String getMetodoAnticoncep() {
		return this.metodoAnticoncep;
	}

	public void setMetodoAnticoncep(String metodoAnticoncep) {
		this.metodoAnticoncep = metodoAnticoncep;
	}

	public Boolean getNumEnamorados() {
		return this.numEnamorados;
	}

	public void setNumEnamorados(Boolean numEnamorados) {
		this.numEnamorados = numEnamorados;
	}

	public Integer getNumParejasex() {
		return this.numParejasex;
	}

	public void setNumParejasex(Integer numParejasex) {
		this.numParejasex = numParejasex;
	}

	public String getObsv() {
		return this.obsv;
	}

	public void setObsv(String obsv) {
		this.obsv = obsv;
	}

	public Boolean getParejaActual() {
		return this.parejaActual;
	}

	public void setParejaActual(Boolean parejaActual) {
		this.parejaActual = parejaActual;
	}

	public String getRelacionFamiliar() {
		return this.relacionFamiliar;
	}

	public void setRelacionFamiliar(String relacionFamiliar) {
		this.relacionFamiliar = relacionFamiliar;
	}

	public Boolean getTabaco() {
		return this.tabaco;
	}

	public void setTabaco(Boolean tabaco) {
		this.tabaco = tabaco;
	}

	public Boolean getTatuajes() {
		return this.tatuajes;
	}

	public void setTatuajes(Boolean tatuajes) {
		this.tatuajes = tatuajes;
	}

	public String getTbcBk() {
		return this.tbcBk;
	}

	public void setTbcBk(String tbcBk) {
		this.tbcBk = tbcBk;
	}

	public String getTbcFamiliar() {
		return this.tbcFamiliar;
	}

	public void setTbcFamiliar(String tbcFamiliar) {
		this.tbcFamiliar = tbcFamiliar;
	}

	public String getTbcPersonal() {
		return this.tbcPersonal;
	}

	public void setTbcPersonal(String tbcPersonal) {
		this.tbcPersonal = tbcPersonal;
	}

	public String getTbcSistresp() {
		return this.tbcSistresp;
	}

	public void setTbcSistresp(String tbcSistresp) {
		this.tbcSistresp = tbcSistresp;
	}

	public Boolean getTransfusiones() {
		return this.transfusiones;
	}

	public void setTransfusiones(Boolean transfusiones) {
		this.transfusiones = transfusiones;
	}

	public String getVinculo() {
		return this.vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public Boolean getViolencia() {
		return this.violencia;
	}

	public void setViolencia(Boolean violencia) {
		this.violencia = violencia;
	}

}