package edu.pe.unitru.repository.generic;

import java.util.List;

import edu.pe.unitru.domain.generic.UbigeoReniec;

public interface UbigeoDao {
	public List<UbigeoReniec> getDepartamentos();
	public UbigeoReniec getUbigeo(Integer depa,Integer prov, Integer dist);
}
