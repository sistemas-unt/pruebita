package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ss_motivos database table.
 * 
 */
@Entity
@Table(name="ss_motivos")
@NamedQuery(name="SsMotivo.findAll", query="SELECT s FROM SsMotivo s")
public class SsMotivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SS_MOTIVOS_ID_GENERATOR", sequenceName="SS_MOTIVOS_ID_MOTIVOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SS_MOTIVOS_ID_GENERATOR")
	@Column(name="id_motivos")
	private Long id;

	private String motivo;

	//bi-directional many-to-one association to SocSalud
	@OneToMany(mappedBy="ssMotivo")
	private Set<SocSalud> socSaluds;

	public SsMotivo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Set<SocSalud> getSocSaluds() {
		return this.socSaluds;
	}

	public void setSocSaluds(Set<SocSalud> socSaluds) {
		this.socSaluds = socSaluds;
	}

	public SocSalud addSocSalud(SocSalud socSalud) {
		getSocSaluds().add(socSalud);
		socSalud.setSsMotivo(this);

		return socSalud;
	}

	public SocSalud removeSocSalud(SocSalud socSalud) {
		getSocSaluds().remove(socSalud);
		socSalud.setSsMotivo(null);

		return socSalud;
	}

}