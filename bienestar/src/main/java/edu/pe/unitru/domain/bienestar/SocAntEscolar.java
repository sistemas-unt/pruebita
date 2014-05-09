package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the soc_ant_escolares database table.
 * 
 */
@Entity
@Table(name="soc_ant_escolares")
@NamedQuery(name="SocAntEscolar.findAll", query="SELECT s FROM SocAntEscolar s")
public class SocAntEscolar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOC_ANT_ESCOLARES_ID_GENERATOR", sequenceName="SOC_ANT_ESCOLARES_ID_ANT_ESCOLARES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOC_ANT_ESCOLARES_ID_GENERATOR")
	@Column(name="id_ant_escolares")
	private Long id;

	@Column(name="colegio_termino")
	private String colegioTermino;

	@Column(name="num_veces_postulo")
	private Integer numPostulaciones;

	//bi-directional many-to-one association to ServicioSocial
	@OneToMany(mappedBy="socAntEscolare")
	private Set<ServicioSocial> servicioSocials;

	//bi-directional many-to-one association to SaeEspecializacion
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private SaeEspecializacion saeEspecializacion;

	//bi-directional many-to-one association to SaeFormaIngreso
	@ManyToOne
	@JoinColumn(name="id_forma_ingreso")
	private SaeFormaIngreso saeFormaIngreso;

	//bi-directional many-to-one association to SaeTipoColegio
	@ManyToOne
	@JoinColumn(name="id_tipo_colegio")
	private SaeTipoColegio saeTipoColegio;

	//bi-directional many-to-one association to SaeTurno
	@ManyToOne
	@JoinColumn(name="id_turno")
	private SaeTurno saeTurno;

	public SocAntEscolar() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColegioTermino() {
		return this.colegioTermino;
	}

	public void setColegioTermino(String colegioTermino) {
		this.colegioTermino = colegioTermino;
	}

	public Integer getNumPostulaciones() {
		return this.numPostulaciones;
	}

	public void setNumPostulaciones(Integer numPostulaciones) {
		this.numPostulaciones = numPostulaciones;
	}

	public Set<ServicioSocial> getServicioSocials() {
		return this.servicioSocials;
	}

	public void setServicioSocials(Set<ServicioSocial> servicioSocials) {
		this.servicioSocials = servicioSocials;
	}

	public ServicioSocial addServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().add(servicioSocial);
		servicioSocial.setSocAntEscolare(this);

		return servicioSocial;
	}

	public ServicioSocial removeServicioSocial(ServicioSocial servicioSocial) {
		getServicioSocials().remove(servicioSocial);
		servicioSocial.setSocAntEscolare(null);

		return servicioSocial;
	}

	public SaeEspecializacion getSaeEspecializacion() {
		return this.saeEspecializacion;
	}

	public void setSaeEspecializacion(SaeEspecializacion saeEspecializacion) {
		this.saeEspecializacion = saeEspecializacion;
	}

	public SaeFormaIngreso getSaeFormaIngreso() {
		return this.saeFormaIngreso;
	}

	public void setSaeFormaIngreso(SaeFormaIngreso saeFormaIngreso) {
		this.saeFormaIngreso = saeFormaIngreso;
	}

	public SaeTipoColegio getSaeTipoColegio() {
		return this.saeTipoColegio;
	}

	public void setSaeTipoColegio(SaeTipoColegio saeTipoColegio) {
		this.saeTipoColegio = saeTipoColegio;
	}

	public SaeTurno getSaeTurno() {
		return this.saeTurno;
	}

	public void setSaeTurno(SaeTurno saeTurno) {
		this.saeTurno = saeTurno;
	}

}