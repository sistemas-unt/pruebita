package edu.pe.unitru.domain.bienestar;

import java.io.Serializable;
import java.math.BigDecimal;

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

import edu.pe.unitru.domain.generic.Perfil;

/**
 * The persistent class for the com_ficha_comedor database table.
 * 
 */
@Entity
@Table(name = "com_ficha_comedor")
@NamedQuery(name = "ComFichaComedor.findAll", query = "SELECT c FROM ComFichaComedor c")
public class ComFichaComedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COM_FICHA_COMEDOR_ID_GENERATOR", sequenceName = "COM_FICHA_COMEDOR_ID_FICHA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COM_FICHA_COMEDOR_ID_GENERATOR")
	@Column(name = "id_ficha",unique=true, nullable=false)
	private Long id;

	@Column(name = "motivo_ratificar")
	private String motivoRatificar;

	private Integer estado;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private ComCategoria categoria;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "id_perfilalumno")
	private Perfil perfilAlumno;

	// @Column(name="id_perfilalumno")
	// private Long idPerfilalumno;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "id_perfilasistenta")
	private Perfil perfilAsistenta;

	// @Column(name = "\"id_perfilAsistenta\"")
	// private Long id_perfilAsistenta;

	private String observacion;
	
	// uni-directional many-to-one association to ComTicketsDependencia
	@ManyToOne
	@JoinColumn(name = "id_ticketdep")
	private ComTicketsDependencia	comTicketsDependencia;

	@Column(name = "nota_promedio")
	private BigDecimal nota;
	
	public ComFichaComedor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivoRatificar() {
		return this.motivoRatificar;
	}

	public void setMotivoRatificar(String motivoRatificar) {
		this.motivoRatificar = motivoRatificar;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public ComCategoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(ComCategoria categoria) {
		this.categoria = categoria;
	}

	public Perfil getPerfilAlumno() {
		return this.perfilAlumno;
	}

	public void setPerfilalumno(Perfil perfilAlumno) {
		this.perfilAlumno = perfilAlumno;
	}

	public Perfil getPerfilAsistenta() {
		return this.perfilAsistenta;
	}

	public void setPerfilAsistenta(Perfil perfilAsistenta) {
		this.perfilAsistenta = perfilAsistenta;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public ComTicketsDependencia getComTicketsDependencia() {
		return this.comTicketsDependencia;
	}

	public void setComTicketsDependencia(ComTicketsDependencia comTicketsDependencia) {
		this.comTicketsDependencia = comTicketsDependencia;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
}