package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_iluminacion database table.
 * 
 */
@Entity
@Table(name="sv_iluminacion")
@NamedQuery(name="SvIluminacion.findAll", query="SELECT s FROM SvIluminacion s")
public class SvIluminacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_ILUMINACION_ID_GENERATOR", sequenceName="SV_ILUMINACION_ID_VIV_ILUMINACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_ILUMINACION_ID_GENERATOR")
	@Column(name="id_viv_iluminacion")
	private Long id;

	private String iluminacion;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svIluminacion")
	private Set<TipoVivienda> tipoViviendas;

	public SvIluminacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIluminacion() {
		return this.iluminacion;
	}

	public void setIluminacion(String iluminacion) {
		this.iluminacion = iluminacion;
	}

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvIluminacion(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvIluminacion(null);

		return tipoVivienda;
	}

}