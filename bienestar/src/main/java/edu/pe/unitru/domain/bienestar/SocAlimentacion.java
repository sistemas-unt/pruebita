package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the soc_alimentacion database table.
 * 
 */
@Entity
@Table(name="soc_alimentacion")
@NamedQuery(name="SocAlimentacion.findAll", query="SELECT s FROM SocAlimentacion s")
public class SocAlimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_ALIMENTACION_ID_GENERATOR", sequenceName="SOC_ALIMENTACION_ID_ALIMENTACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_ALIMENTACION_ID_GENERATOR")
	@Column(name="id_alimentacion")
	private Long id;

	private String alimentacion;

	//bi-directional many-to-one association to ServicioSocial
	@OneToMany(mappedBy="socAlimentacion")
	private Set<ServicioSocial> servicioSocials;

	public SocAlimentacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlimentacion() {
		return this.alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public Set<ServicioSocial> getServicioSocials() {
		return this.servicioSocials;
	}

	public void setServicioSocials(Set<ServicioSocial> servicioSocials) {
		this.servicioSocials = servicioSocials;
	}

	public ServicioSocial addServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().add(servicioSocial);
		servicioSocial.setSocAlimentacion(this);

		return servicioSocial;
	}

	public ServicioSocial removeServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().remove(servicioSocial);
		servicioSocial.setSocAlimentacion(null);

		return servicioSocial;
	}

}