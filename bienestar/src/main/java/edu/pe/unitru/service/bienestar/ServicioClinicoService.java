package edu.pe.unitru.service.bienestar;
import java.io.Serializable;
import java.util.List;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
public interface ServicioClinicoService extends Serializable {
	public List<ServicioSocial> getListaSocial();
	
}




