package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;

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
 * The persistent class for the servicio_social database table.
 * 
 */
@Entity
@Table(name="servicio_social")
@NamedQuery(name="ServicioSocial.findAll", query="SELECT s FROM ServicioSocial s")
public class ServicioSocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SERVICIO_SOCIAL_ID_GENERATOR", sequenceName="SERVICIO_SOCIAL_ID_SERVICIO_SOCIAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICIO_SOCIAL_ID_GENERATOR")
	@Column(name="id_servicio_social", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	//uni-directional many-to-one association to SocAlimentacion
	@ManyToOne
	@JoinColumn(name="id_alimentacion")
	private SocAlimentacion socAlimentacion;

	//uni-directional many-to-one association to SocAntEscolar
	@ManyToOne
	@JoinColumn(name="id_antecente_escolar")
	private SocAntEscolar socAntEscolare;

	//uni-directional many-to-one association to SocDiagramaDomicilio
	@ManyToOne
	@JoinColumn(name="id_diagrama")
	private SocDiagramaDomicilio socDiagramaDomicilio;

	
	//uni-directional many-to-one association to SocSalud
	@ManyToOne
	@JoinColumn(name="id_salud")
	private SocSalud socSalud;

	//uni-directional many-to-one association to SocSituacionEconomica
	@ManyToOne
	@JoinColumn(name="id_situacion_economica")
	private SocSituacionEconomica socSituacionEconomica;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil", nullable=false)
	private Perfil perfil;
	
	private Integer categoria;

	public ServicioSocial() {
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

	public SocAlimentacion getSocAlimentacion() {
		return this.socAlimentacion;
	}

	public void setSocAlimentacion(SocAlimentacion socAlimentacion) {
		this.socAlimentacion = socAlimentacion;
	}

	public SocAntEscolar getSocAntEscolare() {
		return this.socAntEscolare;
	}

	public void setSocAntEscolare(SocAntEscolar socAntEscolare) {
		this.socAntEscolare = socAntEscolare;
	}

	public SocDiagramaDomicilio getSocDiagramaDomicilio() {
		return this.socDiagramaDomicilio;
	}

	public void setSocDiagramaDomicilio(SocDiagramaDomicilio socDiagramaDomicilio) {
		this.socDiagramaDomicilio = socDiagramaDomicilio;
	}



	public SocSalud getSocSalud() {
		return this.socSalud;
	}

	public void setSocSalud(SocSalud socSalud) {
		this.socSalud = socSalud;
	}

	public SocSituacionEconomica getSocSituacionEconomica() {
		return this.socSituacionEconomica;
	}

	public void setSocSituacionEconomica(SocSituacionEconomica socSituacionEconomica) {
		this.socSituacionEconomica = socSituacionEconomica;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Integer getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

}