package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the soc_diagrama_domicilio database table.
 * 
 */
@Entity
@Table(name="soc_diagrama_domicilio")
@NamedQuery(name="SocDiagramaDomicilio.findAll", query="SELECT s FROM SocDiagramaDomicilio s")
public class SocDiagramaDomicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_DIAGRAMA_DOMICILIO_ID_GENERATOR", sequenceName="SOC_DIAGRAMA_DOMICILIO_ID_DIAGRAMA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_DIAGRAMA_DOMICILIO_ID_GENERATOR")
	@Column(name="id_diagrama")
	private Long id;

	private String url;

	//bi-directional many-to-one association to ServicioSocial
	@OneToMany(mappedBy="socDiagramaDomicilio")
	private Set<ServicioSocial> servicioSocials;

	public SocDiagramaDomicilio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<ServicioSocial> getServicioSocials() {
		return this.servicioSocials;
	}

	public void setServicioSocials(Set<ServicioSocial> servicioSocials) {
		this.servicioSocials = servicioSocials;
	}

	public ServicioSocial addServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().add(servicioSocial);
		servicioSocial.setSocDiagramaDomicilio(this);

		return servicioSocial;
	}

	public ServicioSocial removeServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().remove(servicioSocial);
		servicioSocial.setSocDiagramaDomicilio(null);

		return servicioSocial;
	}

}