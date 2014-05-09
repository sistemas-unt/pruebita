package edu.pe.unitru.service.bienestar;

import java.io.Serializable;

import edu.pe.unitru.domain.bienestar.ComCategoria;

public interface CategoriaService extends Serializable {
	public ComCategoria findByCategoria(Long idcat);
}
