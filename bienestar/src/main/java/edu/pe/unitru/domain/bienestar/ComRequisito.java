package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_requisitos database table.
 * 
 */
@Entity
@Table(name="com_requisitos")
@NamedQuery(name="ComRequisito.findAll", query="SELECT c FROM ComRequisito c")
public class ComRequisito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_REQUISITOS_ID_GENERATOR", sequenceName="COM_REQUISITOS_ID_REQUISITOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_REQUISITOS_ID_GENERATOR")
	@Column(name="id_requisitos")
	private Long id;

	private Integer estado;

	private String requisitos;

	public ComRequisito() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getRequisitos() {
		return this.requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

}