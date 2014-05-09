package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sv_mat_construccion database table.
 * 
 */
@Entity
@Table(name="sv_mat_construccion")
@NamedQuery(name="SvMatConstruccion.findAll", query="SELECT s FROM SvMatConstruccion s")
public class SvMatConstruccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SV_MAT_CONSTRUCCION_ID_GENERATOR", sequenceName="SV_MAT_CONSTRUCCION_ID_MAT_CONSTRUCCION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SV_MAT_CONSTRUCCION_ID_GENERATOR")
	@Column(name="id_mat_construccion")
	private Long id;

	private String material;

	//bi-directional many-to-one association to TipoVivienda
	@OneToMany(mappedBy="svMatConstruccion")
	private Set<TipoVivienda> tipoViviendas;

	public SvMatConstruccion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Set<TipoVivienda> getTipoViviendas() {
		return this.tipoViviendas;
	}

	public void setTipoViviendas(Set<TipoVivienda> tipoViviendas) {
		this.tipoViviendas = tipoViviendas;
	}

	public TipoVivienda addTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().add(tipoVivienda);
		tipoVivienda.setSvMatConstruccion(this);

		return tipoVivienda;
	}

	public TipoVivienda removeTipoVivienda(TipoVivienda tipoVivienda) {
		getTipoViviendas().remove(tipoVivienda);
		tipoVivienda.setSvMatConstruccion(null);

		return tipoVivienda;
	}

}