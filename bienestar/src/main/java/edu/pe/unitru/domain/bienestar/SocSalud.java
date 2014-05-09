package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the soc_salud database table.
 * 
 */
@Entity
@Table(name="soc_salud")
@NamedQuery(name="SocSalud.findAll", query="SELECT s FROM SocSalud s")
public class SocSalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_SALUD_ID_GENERATOR", sequenceName="SOC_SALUD_ID_SALUD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_SALUD_ID_GENERATOR")
	@Column(name="id_salud")
	private Long id;

	//bi-directional many-to-one association to ServicioSocial
	@OneToMany(mappedBy="socSalud")
	private Set<ServicioSocial> servicioSocials;

	//bi-directional many-to-one association to SsAcudeEnfermedad
	@ManyToOne
	@JoinColumn(name="id_acude_ante_enf")
	private SsAcudeEnfermedad ssAcudeEnfermedad;

	//bi-directional many-to-one association to SsMotivo
	@ManyToOne
	@JoinColumn(name="id_motivos")
	private SsMotivo ssMotivo;

	public SocSalud() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ServicioSocial> getServicioSocials() {
		return this.servicioSocials;
	}

	public void setServicioSocials(Set<ServicioSocial> servicioSocials) {
		this.servicioSocials = servicioSocials;
	}

	public ServicioSocial addServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().add(servicioSocial);
		servicioSocial.setSocSalud(this);

		return servicioSocial;
	}

	public ServicioSocial removeServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().remove(servicioSocial);
		servicioSocial.setSocSalud(null);

		return servicioSocial;
	}

	public SsAcudeEnfermedad getSsAcudeEnfermedad() {
		return this.ssAcudeEnfermedad;
	}

	public void setSsAcudeEnfermedad(SsAcudeEnfermedad ssAcudeEnfermedad) {
		this.ssAcudeEnfermedad = ssAcudeEnfermedad;
	}

	public SsMotivo getSsMotivo() {
		return this.ssMotivo;
	}

	public void setSsMotivo(SsMotivo ssMotivo) {
		this.ssMotivo = ssMotivo;
	}

}