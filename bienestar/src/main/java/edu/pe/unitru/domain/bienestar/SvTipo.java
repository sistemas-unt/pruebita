package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_tipo database table.
 * 
 */
@Entity
@Table(name="sv_tipo")
@NamedQuery(name="SvTipo.findAll", query="SELECT s FROM SvTipo s")
public class SvTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_TIPO_ID_GENERATOR", sequenceName="SV_TIPO_ID_TIPO_VIVIENDA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_TIPO_ID_GENERATOR")
	@Column(name="id_tipo_vivienda")
	private Long id;

	private String tipo;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svTipo")
	private Set<TipoVivienda> tipoViviendas;

	public SvTipo() {
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

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvTipo(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvTipo(null);

		return tipoVivienda;
	}

}