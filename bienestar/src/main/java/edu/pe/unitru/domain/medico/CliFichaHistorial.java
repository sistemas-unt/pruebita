package edu.pe.unitru.domain.medico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cli_ficha_historial database table.
 * 
 */
@Entity
@Table(name="cli_ficha_historial")
@NamedQuery(name="CliFichaHistorial.findAll", query="SELECT c FROM CliFichaHistorial c")
public class CliFichaHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLI_FICHA_HISTORIAL_ID_GENERATOR", sequenceName="CLI_FICHA_HISTORIAL_ID_FICHA_HISTORIAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLI_FICHA_HISTORIAL_ID_GENERATOR")
	@Column(name="id_ficha_historial", unique=true, nullable=false)
	private Long id;

	private Integer lentes;

	public CliFichaHistorial() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLentes() {
		return this.lentes;
	}

	public void setLentes(Integer lentes) {
		this.lentes = lentes;
	}

}