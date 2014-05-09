package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_categoria database table.
 * 
 */
@Entity
@Table(name="com_categoria")
@NamedQuery(name="ComCategoria.findAll", query="SELECT c FROM ComCategoria c")
public class ComCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_CATEGORIA_ID_GENERATOR", sequenceName="COM_CATEGORIA_ID_CATEGORIA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_CATEGORIA_ID_GENERATOR")
	@Column(name="id_categoria")
	private Long id;

	private String tipo;

	public ComCategoria() {
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

}