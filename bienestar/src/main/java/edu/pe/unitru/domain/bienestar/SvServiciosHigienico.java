package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_servicios_higienicos database table.
 * 
 */
@Entity
@Table(name="sv_servicios_higienicos")
@NamedQuery(name="SvServiciosHigienico.findAll", query="SELECT s FROM SvServiciosHigienico s")
public class SvServiciosHigienico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_SERVICIOS_HIGIENICOS_ID_GENERATOR", sequenceName="SV_SERVICIOS_HIGIENICOS_ID_SERV_HIGIENICOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_SERVICIOS_HIGIENICOS_ID_GENERATOR")
	@Column(name="id_serv_higienicos")
	private Long id;

	@Column(name="servicio_higienico")
	private String servicioHigienico;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svServiciosHigienico")
	private Set<TipoVivienda> tipoViviendas;

	public SvServiciosHigienico() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServicioHigienico() {
		return this.servicioHigienico;
	}

	public void setServicioHigienico(String servicioHigienico) {
		this.servicioHigienico = servicioHigienico;
	}

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvServiciosHigienico(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvServiciosHigienico(null);

		return tipoVivienda;
	}

}