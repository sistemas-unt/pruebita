package edu.pe.unitru.domain.generic;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONA_ID_GENERATOR", sequenceName="PERSONA_ID_PERSONA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_ID_GENERATOR")
	@Column(name="id_persona")
	private Long id;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	private String celular;

	@Column(name="doc_identidad")
	private String docIdentidad;

	@Column(name="domicilio_actual")
	private String domicilioActual;

	@Column(name="domicilio_familiar")
	private String domicilioFamiliar;



	private String email;

	private Integer estado;

	@Column(name="estado_civil")
	private Integer estadoCivil;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="lugar_nacimiento")
	private String lugarNacimiento;

	private String nombres;

	private Integer sexo;

	private String telefono;

	//uni-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="lugar_actual")
	private UbigeoReniec lugarActual;

	//uni-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="lugar_procedencia")
	private UbigeoReniec lugarProcedencia;

	//uni-directional many-to-one association to Ubigeo
	@ManyToOne
	@JoinColumn(name="id_lugar_nacim")
	private UbigeoReniec idLugarNacimiento;

	public Persona() {
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

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDocIdentidad() {
		return this.docIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public String getDomicilioActual() {
		return this.domicilioActual;
	}

	public void setDomicilioActual(String domicilioActual) {
		this.domicilioActual = domicilioActual;
	}

	public String getDomicilioFamiliar() {
		return this.domicilioFamiliar;
	}

	public void setDomicilioFamiliar(String domicilioFamiliar) {
		this.domicilioFamiliar = domicilioFamiliar;
	}

	

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public Integer getSexo() {
		return this.sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public UbigeoReniec getLugarActual() {
		return this.lugarActual;
	}

	public void setLugarActual(UbigeoReniec lugarActual) {
		this.lugarActual = lugarActual;
	}

	public UbigeoReniec getLugarProcedencia() {
		return this.lugarProcedencia;
	}

	public void setLugarProcedencia(UbigeoReniec lugarProcedencia) {
		this.lugarProcedencia = lugarProcedencia;
	}

	public UbigeoReniec getIdLugarNacimiento() {
		return this.idLugarNacimiento;
	}

	public void setIdLugarNacimiento(UbigeoReniec idLugarNacimiento) {
		this.idLugarNacimiento = idLugarNacimiento;
	}

}