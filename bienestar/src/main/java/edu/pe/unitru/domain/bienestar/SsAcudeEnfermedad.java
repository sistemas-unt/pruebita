package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ss_acude_enfermedad database table.
 * 
 */
@Entity
@Table(name="ss_acude_enfermedad")
@NamedQuery(name="SsAcudeEnfermedad.findAll", query="SELECT s FROM SsAcudeEnfermedad s")
public class SsAcudeEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SS_ACUDE_ENFERMEDAD_ID_GENERATOR", sequenceName="SS_ACUDE_ENFERMEDAD_ID_ACUDE_ANTE_ENF_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SS_ACUDE_ENFERMEDAD_ID_GENERATOR")
	@Column(name="id_acude_ante_enf")
	private Long id;

	@Column(name="acude_enfermedad")
	private String acudeEnfermedad;

	//bi-directional many-to-one association to SocSalud
	@OneToMany(mappedBy="ssAcudeEnfermedad")
	private Set<SocSalud> socSaluds;

	public SsAcudeEnfermedad() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcudeEnfermedad() {
		return this.acudeEnfermedad;
	}

	public void setAcudeEnfermedad(String acudeEnfermedad) {
		this.acudeEnfermedad = acudeEnfermedad;
	}

	public Set<SocSalud> getSocSaluds() {
		return this.socSaluds;
	}

	public void setSocSaluds(Set<SocSalud> socSaluds) {
		this.socSaluds = socSaluds;
	}

	public SocSalud addSocSalud(SocSalud socSalud) {
		getSocSaluds().add(socSalud);
		socSalud.setSsAcudeEnfermedad(this);

		return socSalud;
	}

	public SocSalud removeSocSalud(SocSalud socSalud) {
		getSocSaluds().remove(socSalud);
		socSalud.setSsAcudeEnfermedad(null);

		return socSalud;
	}

}