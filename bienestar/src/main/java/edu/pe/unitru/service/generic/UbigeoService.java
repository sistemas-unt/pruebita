package edu.pe.unitru.service.generic;

import java.util.List;

import edu.pe.unitru.domain.generic.UbigeoReniec;

public interface UbigeoService {
	public List<UbigeoReniec> getDepartamentos();
	public UbigeoReniec getUbigeo(Integer depa, Integer prov,Integer dist);
}
