package edu.pe.unitru.domain.gerencia;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ucontrol_tipo_ficha database table.
 * 
 */
@Entity
@Table(name="ucontrol_tipo_ficha")
@NamedQuery(name="TipoFicha.findAll", query="SELECT t FROM TipoFicha t")
public class TipoFicha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UCONTROL_TIPO_FICHA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UCONTROL_TIPO_FICHA_ID_GENERATOR")
	@Column(name="id_tipo_ficha", unique=true, nullable=false, length=100)
	private String id;

	@Column(nullable=false, length=100)
	private String descripcion;

	public TipoFicha() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}