package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_tenencia database table.
 * 
 */
@Entity
@Table(name="sv_tenencia")
@NamedQuery(name="SvTenencia.findAll", query="SELECT s FROM SvTenencia s")
public class SvTenencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_TENENCIA_ID_GENERATOR", sequenceName="SV_TENENCIA_ID_TENENCIA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_TENENCIA_ID_GENERATOR")
	@Column(name="id_tenencia")
	private Long id;

	private String tenencia;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svTenencia")
	private Set<TipoVivienda> tipoViviendas;

	public SvTenencia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenencia() {
		return this.tenencia;
	}

	public void setTenencia(String tenencia) {
		this.tenencia = tenencia;
	}

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvTenencia(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvTenencia(null);

		return tipoVivienda;
	}

}