package edu.pe.unitru.service.generic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.unitru.domain.generic.UbigeoReniec;
import edu.pe.unitru.repository.generic.UbigeoDao;
import edu.pe.unitru.service.generic.UbigeoService;

@Service
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	private UbigeoDao ubigeoDao;
	
	public List<UbigeoReniec> getDepartamentos() {
		// TODO Auto-generated method stub
		return this.ubigeoDao.getDepartamentos();
	}

	public UbigeoReniec getUbigeo(Integer depa, Integer prov, Integer dist) {
		// TODO Auto-generated method stub
		return this.ubigeoDao.getUbigeo(depa, prov, dist);
	}

}
