package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the cli_examen_fisico database table.
 * 
 */
@Entity
@Table(name="cli_examen_fisico")
@NamedQuery(name="CliExamenFisico.findAll", query="SELECT c FROM CliExamenFisico c")
public class CliExamenFisico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_EXAMEN_FISICO_ID_GENERATOR", sequenceName="CLI_EXAMEN_FISICO_ID_EXAMEN_FISICO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_EXAMEN_FISICO_ID_GENERATOR")
	@Column(name="id_examen_fisico", unique=true, nullable=false)
	private Long id;

	@Column(name="abdome_higado", nullable=false, length=50)
	private String abdomeHigado;

	@Column(name="abdomen_anormalidad", nullable=false, length=50)
	private String abdomenAnormalidad;

	@Column(name="abdomen_bazo", nullable=false, length=50)
	private String abdomenBazo;

	@Column(name="abdomen_forma", nullable=false, length=50)
	private String abdomenForma;

	@Column(length=50)
	private String amigdala;

	@Column(name="aparato_circulatorio", nullable=false, length=250)
	private String aparatoCirculatorio;

	@Column(name="aparato_respiratorio", nullable=false, length=250)
	private String aparatoRespiratorio;

	@Column(length=50)
	private String boca;

	@Column(length=50)
	private String contestura;

	@Column(nullable=false)
	private Boolean dolor;

	@Column(name="est_nutricional", length=50)
	private String estNutricional;

	@Column(name="examen_mental", nullable=false, length=250)
	private String examenMental;

	@Column(nullable=false, length=50)
	private String extremidades;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(length=50)
	private String nariz;

	@Column(length=50)
	private String oidos;

	@Column(length=20)
	private String ojos;

	@Column(name="pa_esfuerzo_diastolica", nullable=false)
	private Integer paEsfuerzoDiastolica;

	@Column(name="pa_esfuerzo_diferencial", nullable=false)
	private Integer paEsfuerzoDiferencial;

	@Column(name="pa_esfuerzo_media", nullable=false)
	private Integer paEsfuerzoMedia;

	@Column(name="pa_esfuerzo_sistolica", nullable=false)
	private Integer paEsfuerzoSistolica;

	@Column(name="pa_reposo_diastolica", nullable=false)
	private Integer paReposoDiastolica;

	@Column(name="pa_reposo_diferencial", nullable=false)
	private Integer paReposoDiferencial;

	@Column(name="pa_reposo_media", nullable=false)
	private Integer paReposoMedia;

	@Column(name="pa_reposo_sistolica", nullable=false)
	private Integer paReposoSistolica;

	@Column(precision=10, scale=3)
	private BigDecimal peso;

	@Column(name="piel_mucosas", length=50)
	private String pielMucosas;

	@Column(name="pulsaciones_esfuerzo", nullable=false)
	private Integer pulsacionesEsfuerzo;

	@Column(name="pulsaciones_reposo", nullable=false)
	private Integer pulsacionesReposo;

	@Column(name="resp_esfuerzo", nullable=false)
	private Integer respEsfuerzo;

	@Column(name="resp_reposo", nullable=false)
	private Integer respReposo;

	@Column(name="sis_linfatico", nullable=false, length=50)
	private String sisLinfatico;

	@Column(precision=10, scale=3)
	private BigDecimal talla;

	@Column(length=50)
	private String tiroides;

	@Column(name="torax_auscultacion", nullable=false, length=50)
	private String toraxAuscultacion;

	@Column(name="torax_conform", nullable=false, length=50)
	private String toraxConform;

	@Column(name="torax_percusion", nullable=false, length=50)
	private String toraxPercusion;

	@Column(nullable=false, length=50)
	private String tumoracion;

	//uni-directional many-to-one association to CliAgudezaVisual
	@ManyToOne
	@JoinColumn(name="id_agudeza_visual", nullable=false)
	private CliAgudezaVisual cliAgudezaVisual;

	public CliExamenFisico() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbdomeHigado() {
		return this.abdomeHigado;
	}

	public void setAbdomeHigado(String abdomeHigado) {
		this.abdomeHigado = abdomeHigado;
	}

	public String getAbdomenAnormalidad() {
		return this.abdomenAnormalidad;
	}

	public void setAbdomenAnormalidad(String abdomenAnormalidad) {
		this.abdomenAnormalidad = abdomenAnormalidad;
	}

	public String getAbdomenBazo() {
		return this.abdomenBazo;
	}

	public void setAbdomenBazo(String abdomenBazo) {
		this.abdomenBazo = abdomenBazo;
	}

	public String getAbdomenForma() {
		return this.abdomenForma;
	}

	public void setAbdomenForma(String abdomenForma) {
		this.abdomenForma = abdomenForma;
	}

	public String getAmigdala() {
		return this.amigdala;
	}

	public void setAmigdala(String amigdala) {
		this.amigdala = amigdala;
	}

	public String getAparatoCirculatorio() {
		return this.aparatoCirculatorio;
	}

	public void setAparatoCirculatorio(String aparatoCirculatorio) {
		this.aparatoCirculatorio = aparatoCirculatorio;
	}

	public String getAparatoRespiratorio() {
		return this.aparatoRespiratorio;
	}

	public void setAparatoRespiratorio(String aparatoRespiratorio) {
		this.aparatoRespiratorio = aparatoRespiratorio;
	}

	public String getBoca() {
		return this.boca;
	}

	public void setBoca(String boca) {
		this.boca = boca;
	}

	public String getContestura() {
		return this.contestura;
	}

	public void setContestura(String contestura) {
		this.contestura = contestura;
	}

	public Boolean getDolor() {
		return this.dolor;
	}

	public void setDolor(Boolean dolor) {
		this.dolor = dolor;
	}

	public String getEstNutricional() {
		return this.estNutricional;
	}

	public void setEstNutricional(String estNutricional) {
		this.estNutricional = estNutricional;
	}

	public String getExamenMental() {
		return this.examenMental;
	}

	public void setExamenMental(String examenMental) {
		this.examenMental = examenMental;
	}

	public String getExtremidades() {
		return this.extremidades;
	}

	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getNariz() {
		return this.nariz;
	}

	public void setNariz(String nariz) {
		this.nariz = nariz;
	}

	public String getOidos() {
		return this.oidos;
	}

	public void setOidos(String oidos) {
		this.oidos = oidos;
	}

	public String getOjos() {
		return this.ojos;
	}

	public void setOjos(String ojos) {
		this.ojos = ojos;
	}

	public Integer getPaEsfuerzoDiastolica() {
		return this.paEsfuerzoDiastolica;
	}

	public void setPaEsfuerzoDiastolica(Integer paEsfuerzoDiastolica) {
		this.paEsfuerzoDiastolica = paEsfuerzoDiastolica;
	}

	public Integer getPaEsfuerzoDiferencial() {
		return this.paEsfuerzoDiferencial;
	}

	public void setPaEsfuerzoDiferencial(Integer paEsfuerzoDiferencial) {
		this.paEsfuerzoDiferencial = paEsfuerzoDiferencial;
	}

	public Integer getPaEsfuerzoMedia() {
		return this.paEsfuerzoMedia;
	}

	public void setPaEsfuerzoMedia(Integer paEsfuerzoMedia) {
		this.paEsfuerzoMedia = paEsfuerzoMedia;
	}

	public Integer getPaEsfuerzoSistolica() {
		return this.paEsfuerzoSistolica;
	}

	public void setPaEsfuerzoSistolica(Integer paEsfuerzoSistolica) {
		this.paEsfuerzoSistolica = paEsfuerzoSistolica;
	}

	public Integer getPaReposoDiastolica() {
		return this.paReposoDiastolica;
	}

	public void setPaReposoDiastolica(Integer paReposoDiastolica) {
		this.paReposoDiastolica = paReposoDiastolica;
	}

	public Integer getPaReposoDiferencial() {
		return this.paReposoDiferencial;
	}

	public void setPaReposoDiferencial(Integer paReposoDiferencial) {
		this.paReposoDiferencial = paReposoDiferencial;
	}

	public Integer getPaReposoMedia() {
		return this.paReposoMedia;
	}

	public void setPaReposoMedia(Integer paReposoMedia) {
		this.paReposoMedia = paReposoMedia;
	}

	public Integer getPaReposoSistolica() {
		return this.paReposoSistolica;
	}

	public void setPaReposoSistolica(Integer paReposoSistolica) {
		this.paReposoSistolica = paReposoSistolica;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getPielMucosas() {
		return this.pielMucosas;
	}

	public void setPielMucosas(String pielMucosas) {
		this.pielMucosas = pielMucosas;
	}

	public Integer getPulsacionesEsfuerzo() {
		return this.pulsacionesEsfuerzo;
	}

	public void setPulsacionesEsfuerzo(Integer pulsacionesEsfuerzo) {
		this.pulsacionesEsfuerzo = pulsacionesEsfuerzo;
	}

	public Integer getPulsacionesReposo() {
		return this.pulsacionesReposo;
	}

	public void setPulsacionesReposo(Integer pulsacionesReposo) {
		this.pulsacionesReposo = pulsacionesReposo;
	}

	public Integer getRespEsfuerzo() {
		return this.respEsfuerzo;
	}

	public void setRespEsfuerzo(Integer respEsfuerzo) {
		this.respEsfuerzo = respEsfuerzo;
	}

	public Integer getRespReposo() {
		return this.respReposo;
	}

	public void setRespReposo(Integer respReposo) {
		this.respReposo = respReposo;
	}

	public String getSisLinfatico() {
		return this.sisLinfatico;
	}

	public void setSisLinfatico(String sisLinfatico) {
		this.sisLinfatico = sisLinfatico;
	}

	public BigDecimal getTalla() {
		return this.talla;
	}

	public void setTalla(BigDecimal talla) {
		this.talla = talla;
	}

	public String getTiroides() {
		return this.tiroides;
	}

	public void setTiroides(String tiroides) {
		this.tiroides = tiroides;
	}

	public String getToraxAuscultacion() {
		return this.toraxAuscultacion;
	}

	public void setToraxAuscultacion(String toraxAuscultacion) {
		this.toraxAuscultacion = toraxAuscultacion;
	}

	public String getToraxConform() {
		return this.toraxConform;
	}

	public void setToraxConform(String toraxConform) {
		this.toraxConform = toraxConform;
	}

	public String getToraxPercusion() {
		return this.toraxPercusion;
	}

	public void setToraxPercusion(String toraxPercusion) {
		this.toraxPercusion = toraxPercusion;
	}

	public String getTumoracion() {
		return this.tumoracion;
	}

	public void setTumoracion(String tumoracion) {
		this.tumoracion = tumoracion;
	}

	public CliAgudezaVisual getCliAgudezaVisual() {
		return this.cliAgudezaVisual;
	}

	public void setCliAgudezaVisual(CliAgudezaVisual cliAgudezaVisual) {
		this.cliAgudezaVisual = cliAgudezaVisual;
	}

}