package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the com_periodo database table.
 * 
 */
@Entity
@Table(name="com_periodo")
@NamedQuery(name="ComPeriodo.findAll", query="SELECT c FROM ComPeriodo c")
public class ComPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_PERIODO_ID_GENERATOR", sequenceName="COM_PERIODO_ID_PERIODO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_PERIODO_ID_GENERATOR")
	@Column(name="id_periodo", unique=true, nullable=false)
	private Long id;

	@Column(length=15)
	private String semestre;
	
	private Integer estado;

	public ComPeriodo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}