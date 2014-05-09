package edu.pe.unitru.service.bienestar;

import java.io.Serializable;
import java.util.List;



import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;


public interface RangoAsistentaService extends Serializable {
	public List<ComTicketsDependencia> getRango(Long ide);
	public List<ComTicketsDependencia> codigosdisponibles(Long ide);
	public ComTicketsDependencia findByCodigo(Long idp2);
	public List<ComPermiso> escuelas();
	public ComTicket findById(Long idp2);
	public void editarticket(ComTicket comTicket);
}
