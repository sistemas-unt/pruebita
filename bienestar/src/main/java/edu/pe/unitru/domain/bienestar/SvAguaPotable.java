package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_agua_potable database table.
 * 
 */
@Entity
@Table(name="sv_agua_potable")
@NamedQuery(name="SvAguaPotable.findAll", query="SELECT s FROM SvAguaPotable s")
public class SvAguaPotable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_AGUA_POTABLE_ID_GENERATOR", sequenceName="SV_AGUA_POTABLE_ID_AGUA_POTABLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_AGUA_POTABLE_ID_GENERATOR")
	@Column(name="id_agua_potable")
	private Long id;

	@Column(name="agua_potable")
	private String aguaPotable;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svAguaPotable")
	private Set<TipoVivienda> tipoViviendas;

	public SvAguaPotable() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAguaPotable() {
		return this.aguaPotable;
	}

	public void setAguaPotable(String aguaPotable) {
		this.aguaPotable = aguaPotable;
	}

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvAguaPotable(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvAguaPotable(null);

		return tipoVivienda;
	}

}