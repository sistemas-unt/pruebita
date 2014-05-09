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
import edu.pe.unitru.domain.generic.Perfil;


/**
 * The persistent class for the com_permisos database table.
 * 
 */
@Entity
@Table(name="com_permisos")
@NamedQuery(name="ComPermiso.findAll", query="SELECT c FROM ComPermiso c")
public class ComPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_PERMISOS_ID_GENERATOR", sequenceName="COM_PERMISOS_ID_PERMISOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_PERMISOS_ID_GENERATOR")
	@Column(name="id_permisos", unique=true, nullable=false)
	private Long id;

	//uni-directional many-to-one association to Dependencia
	@ManyToOne
	@JoinColumn(name="escuela")
	private Dependencia dependencia;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="asistente")
	private Perfil perfil;

	public ComPermiso() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}