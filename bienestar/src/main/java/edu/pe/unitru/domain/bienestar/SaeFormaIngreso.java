package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sae_forma_ingreso database table.
 * 
 */
@Entity
@Table(name="sae_forma_ingreso")
@NamedQuery(name="SaeFormaIngreso.findAll", query="SELECT s FROM SaeFormaIngreso s")
public class SaeFormaIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SAE_FORMA_INGRESO_ID_GENERATOR", sequenceName="SAE_FORMA_INGRESO_ID_FORMA_INGRESO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAE_FORMA_INGRESO_ID_GENERATOR")
	@Column(name="id_forma_ingreso")
	private Long id;

	private String forma;

	//bi-directional many-to-one association to SocAntEscolar
	@OneToMany(mappedBy="saeFormaIngreso")
	private Set<SocAntEscolar> socAntEscolares;

	public SaeFormaIngreso() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForma() {
		return this.forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public Set<SocAntEscolar> getSocAntEscolares() {
		return this.socAntEscolares;
	}

	public void setSocAntEscolares(Set<SocAntEscolar> socAntEscolares) {
		this.socAntEscolares = socAntEscolares;
	}

	public SocAntEscolar addSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().add(socAntEscolare);
		socAntEscolare.setSaeFormaIngreso(this);

		return socAntEscolare;
	}

	public SocAntEscolar removeSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().remove(socAntEscolare);
		socAntEscolare.setSaeFormaIngreso(null);

		return socAntEscolare;
	}

}