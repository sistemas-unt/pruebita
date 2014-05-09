package edu.pe.unitru.domain.gerencia;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ucontrol_tipo_resolucion database table.
 * 
 */
@Entity
@Table(name="ucontrol_tipo_resolucion")
@NamedQuery(name="TipoResolucion.findAll", query="SELECT t FROM TipoResolucion t")
public class TipoResolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UCONTROL_TIPO_RESOLUCION_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UCONTROL_TIPO_RESOLUCION_ID_GENERATOR")
	@Column(name="id_tipo_resolucion", unique=true, nullable=false, length=100)
	private String id;

	@Column(name="descripcion_tipo_resolucion", nullable=false, length=100)
	private String descripcion;

	public TipoResolucion() {
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