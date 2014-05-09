package edu.pe.unitru.domain.gerencia;

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
 * The persistent class for the ucontrol_ficha_personal database table.
 * 
 */
@Entity
@Table(name="ucontrol_ficha_personal")
@NamedQuery(name="FichaPersonal.findAll", query="SELECT f FROM FichaPersonal f")
public class FichaPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UCONTROL_FICHA_PERSONAL_ID_GENERATOR", sequenceName="UCONTROL_FICHA_PERSONAL_ID_FICHA_PERSONAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UCONTROL_FICHA_PERSONAL_ID_GENERATOR")
	@Column(name="id_ficha_personal", unique=true, nullable=false)
	private Long id;

	@Column(name="observacion_ficha_personal", length=250)
	private String observacion;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_personal")
	private Perfil perfil;

	//uni-directional many-to-one association to PersonalAdminCas
	@ManyToOne
	@JoinColumn(name="id_personal_admin_cas")
	private PersonalAdminCas PersonalAdminCas;

	public FichaPersonal() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public PersonalAdminCas getPersonalAdminCas() {
		return this.PersonalAdminCas;
	}

	public void setPersonalAdminCas(PersonalAdminCas PersonalAdminCas) {
		this.PersonalAdminCas = PersonalAdminCas;
	}

}