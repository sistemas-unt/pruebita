package edu.pe.unitru.domain.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_tarea database table.
 * 
 */
@Entity
@Table(name="security_tarea")
@NamedQuery(name="SecurityTarea.findAll", query="SELECT s FROM SecurityTarea s")
public class SecurityTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECURITY_TAREA_ID_GENERATOR", sequenceName="SECURITY_TAREA_ID_TAREA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECURITY_TAREA_ID_GENERATOR")
	@Column(name="id_tarea", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	@Column(length=100)
	private String tarea;

	public SecurityTarea() {
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

	public String getTarea() {
		return this.tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

}