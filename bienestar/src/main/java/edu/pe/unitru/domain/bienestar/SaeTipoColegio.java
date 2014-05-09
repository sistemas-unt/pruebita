package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sae_tipo_colegio database table.
 * 
 */
@Entity
@Table(name="sae_tipo_colegio")
@NamedQuery(name="SaeTipoColegio.findAll", query="SELECT s FROM SaeTipoColegio s")
public class SaeTipoColegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SAE_TIPO_COLEGIO_ID_GENERATOR", sequenceName="SAE_TIPO_COLEGIO_ID_TIPO_COLEGIO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAE_TIPO_COLEGIO_ID_GENERATOR")
	@Column(name="id_tipo_colegio")
	private Long id;

	private String tipo;

	//bi-directional many-to-one association to SocAntEscolar
	@OneToMany(mappedBy="saeTipoColegio")
	private Set<SocAntEscolar> socAntEscolares;

	public SaeTipoColegio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<SocAntEscolar> getSocAntEscolares() {
		return this.socAntEscolares;
	}

	public void setSocAntEscolares(Set<SocAntEscolar> socAntEscolares) {
		this.socAntEscolares = socAntEscolares;
	}

	public SocAntEscolar addSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().add(socAntEscolare);
		socAntEscolare.setSaeTipoColegio(this);

		return socAntEscolare;
	}

	public SocAntEscolar removeSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().remove(socAntEscolare);
		socAntEscolare.setSaeTipoColegio(null);

		return socAntEscolare;
	}

}