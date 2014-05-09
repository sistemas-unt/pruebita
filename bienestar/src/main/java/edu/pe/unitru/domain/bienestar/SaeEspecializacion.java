package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sae_especializacion database table.
 * 
 */
@Entity
@Table(name="sae_especializacion")
@NamedQuery(name="SaeEspecializacion.findAll", query="SELECT s FROM SaeEspecializacion s")
public class SaeEspecializacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SAE_ESPECIALIZACION_ID_GENERATOR", sequenceName="SAE_ESPECIALIZACION_ID_ESPECIALIDAD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAE_ESPECIALIZACION_ID_GENERATOR")
	@Column(name="id_especialidad")
	private Long id;

	private String especialidad;

	//bi-directional many-to-one association to SocAntEscolar
	@OneToMany(mappedBy="saeEspecializacion")
	private Set<SocAntEscolar> socAntEscolares;

	public SaeEspecializacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Set<SocAntEscolar> getSocAntEscolares() {
		return this.socAntEscolares;
	}

	public void setSocAntEscolares(Set<SocAntEscolar> socAntEscolares) {
		this.socAntEscolares = socAntEscolares;
	}

	public SocAntEscolar addSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().add(socAntEscolare);
		socAntEscolare.setSaeEspecializacion(this);

		return socAntEscolare;
	}

	public SocAntEscolar removeSocAntEscolare(SocAntEscolar socAntEscolare) {
		getSocAntEscolares().remove(socAntEscolare);
		socAntEscolare.setSaeEspecializacion(null);

		return socAntEscolare;
	}

}