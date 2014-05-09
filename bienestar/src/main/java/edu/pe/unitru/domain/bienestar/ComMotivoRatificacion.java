package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the com_motivo_ratificacion database table.
 * 
 */
@Entity
@Table(name="com_motivo_ratificacion")
@NamedQuery(name="ComMotivoRatificacion.findAll", query="SELECT c FROM ComMotivoRatificacion c")
public class ComMotivoRatificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_MOTIVO_RATIFICACION_ID_GENERATOR", sequenceName="COM_MOTIVO_RATIFICACION_ID_MOTIVO_RAT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_MOTIVO_RATIFICACION_ID_GENERATOR")
	@Column(name="id_motivo_rat")
	private Long id;

	private Integer estado;

	private Timestamp fecha;

	private String motivo;

	//uni-directional many-to-one association to ComFichaComedor
	@ManyToOne
	@JoinColumn(name="id_ficha")
	private ComFichaComedor comFichaComedor;

	public ComMotivoRatificacion() {
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

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public ComFichaComedor getComFichaComedor() {
		return this.comFichaComedor;
	}

	public void setComFichaComedor(ComFichaComedor comFichaComedor) {
		this.comFichaComedor = comFichaComedor;
	}

}