package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sae_turno database table.
 * 
 */
@Entity
@Table(name="sae_turno")
@NamedQuery(name="SaeTurno.findAll", query="SELECT s FROM SaeTurno s")
public class SaeTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SAE_TURNO_ID_GENERATOR", sequenceName="SAE_TURNO_ID_TURNO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAE_TURNO_ID_GENERATOR")
	@Column(name="id_turno")
	private Long id;

	private String turno;

	//bi-directional many-to-one association to SocAntEscolar
	@OneToMany(mappedBy="saeTurno")
	private Set<SocAntEscolar> socAntEscolares;

	public SaeTurno() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Set<SocAntEscolar> getSocAntEscolares() {
		return this.socAntEscolares;
	}

	public void setSocAntEscolares(Set<SocAntEscolar> socAntEscolares) {
		this.socAntEscolares = socAntEscolares;
	}

	public SocAntEscolar addSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().add(socAntEscolare);
		socAntEscolare.setSaeTurno(this);

		return socAntEscolare;
	}

	public SocAntEscolar removeSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().remove(socAntEscolare);
		socAntEscolare.setSaeTurno(null);

		return socAntEscolare;
	}

}