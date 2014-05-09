package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_ubicacion database table.
 * 
 */
@Entity
@Table(name="sv_ubicacion")
@NamedQuery(name="SvUbicacion.findAll", query="SELECT s FROM SvUbicacion s")
public class SvUbicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_UBICACION_ID_GENERATOR", sequenceName="SV_UBICACION_ID_UBICACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_UBICACION_ID_GENERATOR")
	@Column(name="id_ubicacion")
	private Long id;

	private String ubicacion;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svUbicacion")
	private Set<TipoVivienda> tipoViviendas;

	public SvUbicacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvUbicacion(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvUbicacion(null);

		return tipoVivienda;
	}

}