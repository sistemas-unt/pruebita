package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.pe.unitru.domain.generic.Persona;


/**
 * The persistent class for the grupo_familiar database table.
 * 
 */
@Entity
@Table(name="grupo_familiar")
@NamedQuery(name="GrupoFamiliar.findAll", query="SELECT g FROM GrupoFamiliar g")
public class GrupoFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRUPO_FAMILIAR_ID_GENERATOR", sequenceName="GRUPO_FAMILIAR_ID_GRUPOFAMILIAR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_FAMILIAR_ID_GENERATOR")
	@Column(name="id_grupofamiliar", unique=true, nullable=false)
	private Long id;

	@Column(name="apellido_materno", length=30)
	private String apellidoMaterno;

	@Column(name="apellido_paterno", length=30)
	private String apellidoPaterno;

	@Column(name="doc_identidad", nullable=false, length=15)
	private String docIdentidad;

	@Column(nullable=false, length=200)
	private String enfermo;

	@Column(name="estado_civil", nullable=false)
	private Integer estadoCivil;

	@Column(nullable=false, length=200)
	private String fallecido;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="grado_instruccion", length=20)
	private String gradoInstruccion;

	@Column(precision=10, scale=3)
	private BigDecimal ingresos;

	@Column(name="lugar_nacimiento", length=50)
	private String lugarNacimiento;

	@Column(length=50)
	private String nombres;

	@Column(length=500)
	private String observaciones;

	@Column(length=50)
	private String ocupacion;

	@Column(nullable=false)
	private Integer parentesco;

	@Column(nullable=false)
	private Integer sano;
	
	@Column(name="integra")
	private Integer integra;

	//uni-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false)
	private Persona persona;

	public GrupoFamiliar() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getDocIdentidad() {
		return this.docIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public String getEnfermo() {
		return this.enfermo;
	}

	public void setEnfermo(String enfermo) {
		this.enfermo = enfermo;
	}

	public Integer getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFallecido() {
		return this.fallecido;
	}

	public void setFallecido(String fallecido) {
		this.fallecido = fallecido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGradoInstruccion() {
		return this.gradoInstruccion;
	}

	public void setGradoInstruccion(String gradoInstruccion) {
		this.gradoInstruccion = gradoInstruccion;
	}

	public BigDecimal getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public String getLugarNacimiento() {
		return this.lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Integer getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(Integer parentesco) {
		this.parentesco = parentesco;
	}

	public Integer getSano() {
		return this.sano;
	}

	public void setSano(Integer sano) {
		this.sano = sano;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Integer getIntegra() {
		return this.integra;
	}

	public void setIntegra(Integer integra) {
		this.integra = integra;
	}

}