package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the com_reg_ticket database table.
 * 
 */
@Entity
@Table(name="com_reg_ticket")
@NamedQuery(name="ComRegTicket.findAll", query="SELECT c FROM ComRegTicket c")
public class ComRegTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_REG_TICKET_ID_GENERATOR", sequenceName="COM_REG_TICKET_ID_REGTICKET_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_REG_TICKET_ID_GENERATOR")
	@Column(name="id_regticket")
	private Long id;

	private String boucher;

	private Integer cantidad;

	private Integer estado;

	@Column(name="fecha_reg")
	private Timestamp fechaReg;

	private BigDecimal monto;

	//uni-directional many-to-one association to ComFichaComedor
	@ManyToOne
	@JoinColumn(name="id_ficha_comedor")
	private ComFichaComedor comFichaComedor;

	public ComRegTicket() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoucher() {
		return this.boucher;
	}

	public void setBoucher(String boucher) {
		this.boucher = boucher;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Timestamp fechaReg) {
		this.fechaReg = fechaReg;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public ComFichaComedor getComFichaComedor() {
		return this.comFichaComedor;
	}

	public void setComFichaComedor(ComFichaComedor comFichaComedor) {
		this.comFichaComedor = comFichaComedor;
	}

}