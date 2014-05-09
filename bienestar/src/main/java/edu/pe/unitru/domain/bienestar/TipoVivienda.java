package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_vivienda database table.
 * 
 */
@Entity
@Table(name="tipo_vivienda")
@NamedQuery(name="TipoVivienda.findAll", query="SELECT t FROM TipoVivienda t")
public class TipoVivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_VIVIENDA_ID_GENERATOR", sequenceName="TIPO_VIVIENDA_ID_TIPO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_VIVIENDA_ID_GENERATOR")
	@Column(name="id_tipo")
	private Long id;

	private Integer tipo;

	//bi-directional many-to-one association to SocVivienda
	@OneToMany(mappedBy="tipoVivienda")
	private Set<SocVivienda> socViviendas;

	//bi-directional many-to-one association to SvAguaPotable
	@ManyToOne
	@JoinColumn(name="id_agua_potable")
	private SvAguaPotable svAguaPotable;

	//bi-directional many-to-one association to SvIluminacion
	@ManyToOne
	@JoinColumn(name="id_iluminacion")
	private SvIluminacion svIluminacion;

	//bi-directional many-to-one association to SvMatConstruccion
	@ManyToOne
	@JoinColumn(name="id_mat_construccion")
	private SvMatConstruccion svMatConstruccion;

	//bi-directional many-to-one association to SvServiciosHigienico
	@ManyToOne
	@JoinColumn(name="id_serv_higienicos")
	private SvServiciosHigienico svServiciosHigienico;

	//bi-directional many-to-one association to SvTenencia
	@ManyToOne
	@JoinColumn(name="id_tenencia")
	private SvTenencia svTenencia;

	//bi-directional many-to-one association to SvTipo
	@ManyToOne
	@JoinColumn(name="id_tipo_vivienda")
	private SvTipo svTipo;

	//bi-directional many-to-one association to SvUbicacion
	@ManyToOne
	@JoinColumn(name="id_ubicacion")
	private SvUbicacion svUbicacion;

	public TipoVivienda() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Set<SocVivienda> getSocViviendas() {
		return this.socViviendas;
	}

	public void setSocViviendas(Set<SocVivienda> socViviendas) {
		this.socViviendas = socViviendas;
	}

	public SocVivienda addSocVivienda(SocVivienda socVivienda) {
		getSocViviendas().add(socVivienda);
		socVivienda.setTipoVivienda(this);

		return socVivienda;
	}

	public SocVivienda removeSocVivienda(SocVivienda socVivienda) {
		getSocViviendas().remove(socVivienda);
		socVivienda.setTipoVivienda(null);

		return socVivienda;
	}

	public SvAguaPotable getSvAguaPotable() {
		return this.svAguaPotable;
	}

	public void setSvAguaPotable(SvAguaPotable svAguaPotable) {
		this.svAguaPotable = svAguaPotable;
	}

	public SvIluminacion getSvIluminacion() {
		return this.svIluminacion;
	}

	public void setSvIluminacion(SvIluminacion svIluminacion) {
		this.svIluminacion = svIluminacion;
	}

	public SvMatConstruccion getSvMatConstruccion() {
		return this.svMatConstruccion;
	}

	public void setSvMatConstruccion(SvMatConstruccion svMatConstruccion) {
		this.svMatConstruccion = svMatConstruccion;
	}

	public SvServiciosHigienico getSvServiciosHigienico() {
		return this.svServiciosHigienico;
	}

	public void setSvServiciosHigienico(SvServiciosHigienico svServiciosHigienico) {
		this.svServiciosHigienico = svServiciosHigienico;
	}

	public SvTenencia getSvTenencia() {
		return this.svTenencia;
	}

	public void setSvTenencia(SvTenencia svTenencia) {
		this.svTenencia = svTenencia;
	}

	public SvTipo getSvTipo() {
		return this.svTipo;
	}

	public void setSvTipo(SvTipo svTipo) {
		this.svTipo = svTipo;
	}

	public SvUbicacion getSvUbicacion() {
		return this.svUbicacion;
	}

	public void setSvUbicacion(SvUbicacion svUbicacion) {
		this.svUbicacion = svUbicacion;
	}

}