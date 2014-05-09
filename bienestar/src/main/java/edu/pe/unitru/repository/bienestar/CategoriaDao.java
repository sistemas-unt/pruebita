package edu.pe.unitru.repository.bienestar;

import edu.pe.unitru.domain.bienestar.ComCategoria;

public interface CategoriaDao {
	public ComCategoria findByCategoria(Long idcat);
}
