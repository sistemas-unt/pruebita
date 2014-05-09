package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_rangotickets database table.
 * 
 */
@Entity
@Table(name="com_rangotickets")
@NamedQuery(name="ComTicket.findAll", query="SELECT c FROM ComTicket c")
public class ComTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_RANGOTICKETS_ID_GENERATOR", sequenceName="COM_RANGOTICKETS_ID_TICKETS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_RANGOTICKETS_ID_GENERATOR")
	@Column(name="id_tickets", unique=true, nullable=false)
	private Long id;

	private Integer estado;

	private Integer ticket;

	public ComTicket() {
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

	public Integer getTicket() {
		return this.ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}

}