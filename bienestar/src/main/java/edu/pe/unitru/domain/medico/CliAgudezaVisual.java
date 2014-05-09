package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cli_agudeza_visual database table.
 * 
 */
@Entity
@Table(name="cli_agudeza_visual")
@NamedQuery(name="CliAgudezaVisual.findAll", query="SELECT c FROM CliAgudezaVisual c")
public class CliAgudezaVisual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_AGUDEZA_VISUAL_ID_GENERATOR", sequenceName="CLI_AGUDEZA_VISUAL_ID_AGUDEZA_VISUAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_AGUDEZA_VISUAL_ID_GENERATOR")
	@Column(name="id_agudeza_visual", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=50)
	private String descripcion;

	@Column(name="ojo_derecho", nullable=false, precision=4, scale=2)
	private BigDecimal ojoDerecho;

	@Column(name="ojo_izquierdo", nullable=false, precision=4, scale=2)
	private BigDecimal ojoIzquierdo;

	public CliAgudezaVisual() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getOjoDerecho() {
		return this.ojoDerecho;
	}

	public void setOjoDerecho(BigDecimal ojoDerecho) {
		this.ojoDerecho = ojoDerecho;
	}

	public BigDecimal getOjoIzquierdo() {
		return this.ojoIzquierdo;
	}

	public void setOjoIzquierdo(BigDecimal ojoIzquierdo) {
		this.ojoIzquierdo = ojoIzquierdo;
	}

}