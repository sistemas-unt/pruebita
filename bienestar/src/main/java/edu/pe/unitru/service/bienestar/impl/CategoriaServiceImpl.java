package edu.pe.unitru.service.bienestar.impl;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.repository.bienestar.CategoriaDao;
import edu.pe.unitru.service.bienestar.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriaDao categoriaDao;
	
	public ComCategoria findByCategoria(Long idcat) {
		// TODO Auto-generated method stub
		return categoriaDao.findByCategoria(idcat);
	}
	
}
