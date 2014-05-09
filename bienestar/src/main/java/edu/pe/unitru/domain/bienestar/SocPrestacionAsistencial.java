package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import java.sql.Timestamp;

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

import edu.pe.unitru.domain.generic.Perfil;


/**
 * The persistent class for the soc_prestaciones_asistenciales database table.
 * 
 */
@Entity
@Table(name="soc_prestaciones_asistenciales")
@NamedQuery(name="SocPrestacionAsistencial.findAll", query="SELECT s FROM SocPrestacionAsistencial s")
public class SocPrestacionAsistencial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_PRESTACIONES_ASISTENCIALES_ID_GENERATOR", sequenceName="SOC_PRESTACIONES_ASISTENCIALE_ID_PRESTACIONES_ASISTENCIALES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_PRESTACIONES_ASISTENCIALES_ID_GENERATOR")
	@Column(name="id_prestaciones_asistenciales", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(name="problematica_social", nullable=false, length=250)
	private String problematicaSocial;

	@Column(nullable=false, length=250)
	private String resultado;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//uni-directional many-to-one association to ServicioSocial
	@ManyToOne
	@JoinColumn(name="id_servicio_social")
	private ServicioSocial servicioSocial;

	public SocPrestacionAsistencial() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getProblematicaSocial() {
		return this.problematicaSocial;
	}

	public void setProblematicaSocial(String problematicaSocial) {
		this.problematicaSocial = problematicaSocial;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public ServicioSocial getServicioSocial() {
		return this.servicioSocial;
	}

	public void setServicioSocial(ServicioSocial servicioSocial) {
		this.servicioSocial = servicioSocial;
	}

}