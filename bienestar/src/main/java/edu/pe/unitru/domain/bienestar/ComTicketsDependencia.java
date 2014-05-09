package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.pe.unitru.domain.generic.Dependencia;


/**
 * The persistent class for the com_rangtickets_dep database table.
 * 
 */
@Entity
@Table(name="com_rangtickets_dep")
@NamedQuery(name="ComTicketsDependencia.findAll", query="SELECT c FROM ComTicketsDependencia c")
public class ComTicketsDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_RANGTICKETS_DEP_ID_GENERATOR", sequenceName="COM_RANGTICKETS_DEP_ID_TICKETDEP_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_RANGTICKETS_DEP_ID_GENERATOR")
	@Column(name="id_ticketdep", unique=true, nullable=false)
	private Long id;

	//uni-directional many-to-one association to ComPeriodo
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private ComPeriodo comPeriodo;

	//uni-directional many-to-one association to ComTicket
	@ManyToOne
	@JoinColumn(name="id_tickets")
	private ComTicket comTicket;

	//uni-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="dep_id")
	private Dependencia dependencia;

	public ComTicketsDependencia() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ComPeriodo getComPeriodo() {
		return this.comPeriodo;
	}

	public void setComPeriodo(ComPeriodo comPeriodo) {
		this.comPeriodo = comPeriodo;
	}

	public ComTicket getComRangoTicket() {
		return this.comTicket;
	}

	public void setComRangoTicket(ComTicket comRangoTicket) {
		this.comTicket = comRangoTicket;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

}