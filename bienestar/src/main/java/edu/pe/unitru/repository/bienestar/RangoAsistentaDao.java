package edu.pe.unitru.repository.bienestar;
import java.util.List;

import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;


public interface RangoAsistentaDao {
	public List<ComTicketsDependencia> getRango(Long ide);
	public ComTicketsDependencia findByCodigo(Long idp2);
	public List<ComTicketsDependencia> codigosdisponibles(Long ide);
	public List<ComPermiso> escuelas();
	public ComTicket findById(Long idp2);
	public void editarticket(ComTicket comticket);
}
