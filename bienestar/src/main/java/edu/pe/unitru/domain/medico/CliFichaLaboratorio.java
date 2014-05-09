package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the cli_ficha_laboratorio database table.
 * 
 */
@Entity
@Table(name="cli_ficha_laboratorio")
@NamedQuery(name="CliFichaLaboratorio.findAll", query="SELECT c FROM CliFichaLaboratorio c")
public class CliFichaLaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_FICHA_LABORATORIO_ID_GENERATOR", sequenceName="CLI_FICHA_LABORATORIO_ID_FICHA_LABORATORIO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_FICHA_LABORATORIO_ID_GENERATOR")
	@Column(name="id_ficha_laboratorio", unique=true, nullable=false)
	private Long id;

	@Column(name="ac_urico", nullable=false, length=15)
	private String acUrico;

	@Column(nullable=false, length=15)
	private String col;

	@Column(nullable=false, length=15)
	private String crea;

	@Column(nullable=false, length=15)
	private String eco;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(nullable=false, precision=3, scale=2)
	private BigDecimal glucosa;

	@Column(nullable=false, length=15)
	private String gs;

	@Column(nullable=false, precision=2, scale=2)
	private BigDecimal hb;

	@Column(nullable=false)
	private Boolean hiv;

	@Column(nullable=false, precision=2, scale=2)
	private BigDecimal hm;

	@Column(nullable=false, length=15)
	private String hongos;

	@Column(nullable=false, precision=2, scale=2)
	private BigDecimal hto;

	@Column(nullable=false, length=15)
	private String perfil;

	@Column(nullable=false, length=25)
	private String pregnostico;

	@Column(nullable=false, length=15)
	private String rpr;

	@Column(nullable=false, length=15)
	private String secrecion;

	@Column(nullable=false, length=10)
	private String sexo;

	@Column(nullable=false, length=10)
	private String tcoag;

	@Column(nullable=false, length=15)
	private String tg;

	@Column(nullable=false, length=10)
	private String tsangre;

	@Column(nullable=false, length=20)
	private String urea;

	@Column(nullable=false, length=15)
	private String vs;

	public CliFichaLaboratorio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcUrico() {
		return this.acUrico;
	}

	public void setAcUrico(String acUrico) {
		this.acUrico = acUrico;
	}

	public String getCol() {
		return this.col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getCrea() {
		return this.crea;
	}

	public void setCrea(String crea) {
		this.crea = crea;
	}

	public String getEco() {
		return this.eco;
	}

	public void setEco(String eco) {
		this.eco = eco;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getGlucosa() {
		return this.glucosa;
	}

	public void setGlucosa(BigDecimal glucosa) {
		this.glucosa = glucosa;
	}

	public String getGs() {
		return this.gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public BigDecimal getHb() {
		return this.hb;
	}

	public void setHb(BigDecimal hb) {
		this.hb = hb;
	}

	public Boolean getHiv() {
		return this.hiv;
	}

	public void setHiv(Boolean hiv) {
		this.hiv = hiv;
	}

	public BigDecimal getHm() {
		return this.hm;
	}

	public void setHm(BigDecimal hm) {
		this.hm = hm;
	}

	public String getHongos() {
		return this.hongos;
	}

	public void setHongos(String hongos) {
		this.hongos = hongos;
	}

	public BigDecimal getHto() {
		return this.hto;
	}

	public void setHto(BigDecimal hto) {
		this.hto = hto;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPregnostico() {
		return this.pregnostico;
	}

	public void setPregnostico(String pregnostico) {
		this.pregnostico = pregnostico;
	}

	public String getRpr() {
		return this.rpr;
	}

	public void setRpr(String rpr) {
		this.rpr = rpr;
	}

	public String getSecrecion() {
		return this.secrecion;
	}

	public void setSecrecion(String secrecion) {
		this.secrecion = secrecion;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTcoag() {
		return this.tcoag;
	}

	public void setTcoag(String tcoag) {
		this.tcoag = tcoag;
	}

	public String getTg() {
		return this.tg;
	}

	public void setTg(String tg) {
		this.tg = tg;
	}

	public String getTsangre() {
		return this.tsangre;
	}

	public void setTsangre(String tsangre) {
		this.tsangre = tsangre;
	}

	public String getUrea() {
		return this.urea;
	}

	public void setUrea(String urea) {
		this.urea = urea;
	}

	public String getVs() {
		return this.vs;
	}

	public void setVs(String vs) {
		this.vs = vs;
	}

}