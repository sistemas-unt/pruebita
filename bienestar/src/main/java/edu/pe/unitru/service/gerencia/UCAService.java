package edu.pe.unitru.service.gerencia;

import java.io.Serializable;
import java.util.List;

import edu.pe.unitru.domain.gerencia.PersonalAdminCas;

public interface UCAService extends	Serializable{
	
	public List<PersonalAdminCas> seleccionarPersonalAdmin(); 

}
