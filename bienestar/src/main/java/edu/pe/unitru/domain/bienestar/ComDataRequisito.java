package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_data_requisitos database table.
 * 
 */
@Entity
@Table(name="com_data_requisitos")
@NamedQuery(name="ComDataRequisito.findAll", query="SELECT c FROM ComDataRequisito c")
public class ComDataRequisito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_DATA_REQUISITOS_ID_GENERATOR", sequenceName="COM_DATA_REQUISITOS_ID_DATA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_DATA_REQUISITOS_ID_GENERATOR")
	@Column(name="id_data")
	private Long id;

	private Integer estado;

	//uni-directional many-to-one association to ComFichaComedor
	@ManyToOne
	@JoinColumn(name="id_ficha")
	private ComFichaComedor comFichaComedor;

	//uni-directional many-to-one association to ComRequisito
	@ManyToOne
	@JoinColumn(name="id_requisitos")
	private ComRequisito comRequisito;

	public ComDataRequisito() {
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

	public ComFichaComedor getComFichaComedor() {
		return this.comFichaComedor;
	}

	public void setComFichaComedor(ComFichaComedor comFichaComedor) {
		this.comFichaComedor = comFichaComedor;
	}

	public ComRequisito getComRequisito() {
		return this.comRequisito;
	}

	public void setComRequisito(ComRequisito comRequisito) {
		this.comRequisito = comRequisito;
	}

}