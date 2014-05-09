package edu.pe.unitru.controller.bienestar;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.unitru.domain.bienestar.ComCategoria;
import edu.pe.unitru.domain.bienestar.ComDataRequisito;
import edu.pe.unitru.domain.bienestar.ComFichaComedor;
import edu.pe.unitru.domain.bienestar.ComPeriodo;
import edu.pe.unitru.domain.bienestar.ComPermiso;
import edu.pe.unitru.domain.bienestar.ComRequisito;
import edu.pe.unitru.domain.bienestar.ComTicket;
import edu.pe.unitru.domain.bienestar.ComTicketsDependencia;
import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.generic.Dependencia;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.domain.security.CustomerUser;
import edu.pe.unitru.service.bienestar.CategoriaService;
import edu.pe.unitru.service.bienestar.ControlSocialService;
import edu.pe.unitru.service.bienestar.FichaComedorService;
import edu.pe.unitru.service.bienestar.FichaSocialService;
import edu.pe.unitru.service.bienestar.RangoAsistentaService;
import edu.pe.unitru.service.generic.PerfilService;
import edu.pe.unitru.service.generic.PersonaService;
import edu.pe.unitru.service.security.UsuarioService;

@Controller
@RequestMapping(value = "/bienestar")
public class BienestarController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private FichaSocialService fichasocialservice;

	@Autowired
	private PerfilService perfilService;
	@Autowired
	private ControlSocialService controlSocialService;
	@Autowired
	private ControlSocialService controlsocialService;
	@Autowired
	private FichaComedorService fichacomedorsevice;
	@Autowired
	private ControlSocialService controlsocialservice;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private RangoAsistentaService rangoAsistentaService;

	String dni;
	Perfil persona_asistenta;
	Persona asistenta_comedor;
	List<Dependencia> asistenta_escuela;
	List<Dependencia> asistenta_escuelaDisponible;

	ServicioSocial serviciosocial = new ServicioSocial();

	// SEGUNDO---------------------------------------------------------------

	public ModelAndView fichacomedor(String dni) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Perfil ide = perfilService.getDatosAlumno(dni);
		Long ide2 = ide.getDependencia().getId();
		List<ComTicketsDependencia> ca = rangoAsistentaService.getRango(ide2);
		myModel.put("listacategoria",
				this.fichacomedorsevice.getListaCategoria());
		myModel.put("datos", ide);
		myModel.put("codigo", ca);
		myModel.put("listaRequisitos",
				this.fichacomedorsevice.getListaRequisitos());
		return new ModelAndView("fichaComedor", "model", myModel);
	}

	@RequestMapping(value = "/ficha_comedor.htm", method = RequestMethod.POST)
	public ModelAndView formfichacomedor(
			@RequestParam("idalumno") Long idalumno,
			@RequestParam("codigo") Long codigo,
			@RequestParam("nota") BigDecimal nota,
			@RequestParam("categoria") Long idcat,
			@RequestParam("listaRequisitos") List<Long> listaRequisitos,
			Authentication auth) {

		ComFichaComedor fc = new ComFichaComedor();
		CustomerUser user2 = (CustomerUser) auth.getPrincipal();

		Long idp2 = user2.getPerfil();

		Perfil idalum = perfilService.findByPerfil(idalumno);
		ComTicketsDependencia codigo2 = rangoAsistentaService
				.findByCodigo(codigo);
		Perfil idper = perfilService.findByPerfil2(idp2);
		ComCategoria categoria = categoriaService.findByCategoria(idcat);

		fc.setPerfilalumno(idalum);
		fc.setComTicketsDependencia(codigo2);
		fc.setNota(nota);
		fc.setCategoria(categoria);
		fc.setEstado(1);
		fc.setPerfilAsistenta(idper);

		fichacomedorsevice.addFichacomedor(fc);

		for (int i = 0; i < listaRequisitos.size(); i++) {
			ComRequisito re = fichacomedorsevice
					.buscarRequisito(listaRequisitos.get(i));
			ComDataRequisito requisito = new ComDataRequisito();
			requisito.setComRequisito(re);
			requisito.setEstado(1);
			requisito.setComFichaComedor(fc);
			fichacomedorsevice.addDataRequisito(requisito);
		}

		ComTicket ct = rangoAsistentaService.findById(codigo);
		ct.setEstado(0);
		rangoAsistentaService.editarticket(ct);

		return new ModelAndView("redirect:/bienestar/lista_comedor.htm");
	}

	@RequestMapping(value = "/lista_comedor.htm")
	public ModelAndView listacomedor(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		CustomerUser user3 = (CustomerUser) auth.getPrincipal();
		Long ida = user3.getPerfil();
		myModel.put("listacomedor2",
				this.fichacomedorsevice.getListaComedor(ida));
		return new ModelAndView("listaComedor", "model", myModel);
	}

	@ModelAttribute("personas")
	public Persona getPersona() {
		return new Persona();
	}

	@RequestMapping(value = "/validardni.htm", method = RequestMethod.POST)
	public @ResponseBody
	String buscarDni(@RequestParam("dni") String dni, Authentication auth) {

		CustomerUser user2 = (CustomerUser) auth.getPrincipal();

		Long idasis = user2.getPerfil();

		Persona idp = personaService.findByDni(dni);

		ComPermiso existedni = fichacomedorsevice.perteneceescuela(idasis, dni);
		ComFichaComedor idp2 = fichacomedorsevice.existeregistro(dni);

		Perfil x = perfilService.getDatosAlumno(dni);

		// String ide2 = ide.getDependencia().getNombre();
		if (idp != null) {
			if (existedni != null) {
				if (idp2 == null) {
					return "0";
				} else
					return "2";

			} else if (x != null) {
				return "" + x.getDependencia().getNombre() + "";
			} else
				return dni;

		} else
			return "3";

	}

	@RequestMapping(value = "/fichaComedor.htm", method = RequestMethod.POST)
	public ModelAndView processSubmit(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "dni") String dni) {

		return this.fichacomedor(dni);

	}

	@RequestMapping(value = "/editarComedor.htm", method = RequestMethod.GET)
	public ModelAndView ticketComedor(HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "ve") Long ve) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		Object[] c = fichacomedorsevice.editarFichacomedor(ve);
		Object cod = c[4];
		Object codigoalumno = c[5];
		Object nota = c[9];
		Object idficha = c[6];
		Long on = (Long) cod;
		Long idficha2 = (Long) idficha;
		List<ComTicketsDependencia> ca = rangoAsistentaService.getRango(on);
		List<ComDataRequisito> cd = fichacomedorsevice
				.requisitoporalumno(idficha2);
		myModel.put("codigo", ca);
		myModel.put("codigoalumno", codigoalumno);
		myModel.put("nota", nota);
		myModel.put("datosalumno", c);
		myModel.put("listarequisitoporalumno", cd);
		myModel.put("listacategoria",
				this.fichacomedorsevice.getListaCategoria());
		myModel.put("listaRequisitos2",
				this.fichacomedorsevice.getListaRequisitos());

		return new ModelAndView("editarComedor", "model", myModel);
	}

	@RequestMapping(value = "/editarComedor.htm", method = RequestMethod.POST)
	public ModelAndView editarfichacomedor(
			@RequestParam("idfichacomedor") Long idfichacomedor,
			@RequestParam("codigo") Long codigo,
			@RequestParam("motivo") String motivo,
			@RequestParam("listaRequisitos2") List<Long> listaRequisitos2,
			@RequestParam("categoria") Long idcat) {
		Object[] c = fichacomedorsevice.editarFichacomedor(idfichacomedor);
		Object cod = c[5];
		Long on = (Long) cod;
		ComTicket ct2 = rangoAsistentaService.findById(on);
		if (ct2 != null) {
			ct2.setEstado(1);
			rangoAsistentaService.editarticket(ct2);
		}

		ComCategoria categoria = categoriaService.findByCategoria(idcat);
		ComFichaComedor fc = fichacomedorsevice.getFichaComedor(idfichacomedor);
		ComTicketsDependencia codigo2 = rangoAsistentaService
				.findByCodigo(codigo);
		fc.setCategoria(categoria);
		fc.setObservacion(motivo);
		fc.setComTicketsDependencia(codigo2);
		fichacomedorsevice.editFichacomedor(fc);

		List<ComDataRequisito> cdr = fichacomedorsevice
				.requisitoporalumno(idfichacomedor);
		for (int i = 0; i < cdr.size(); i++) {
			Long d = cdr.get(i).getId();
			fichacomedorsevice.eliminarrequisitos(d);
		}

		for (int i = 0; i < listaRequisitos2.size(); i++) {
			ComRequisito re = fichacomedorsevice
					.buscarRequisito(listaRequisitos2.get(i));
			ComDataRequisito requisito = new ComDataRequisito();
			requisito.setComRequisito(re);
			requisito.setEstado(1);
			requisito.setComFichaComedor(fc);
			fichacomedorsevice.addDataRequisito(requisito);
		}

		ComTicket ct = rangoAsistentaService.findById(codigo);
		ct.setEstado(0);
		rangoAsistentaService.editarticket(ct);
		return new ModelAndView("redirect:/bienestar/lista_comedor.htm");
	}

	@RequestMapping(value = "/lista_comedor2.htm", method = RequestMethod.POST)
	public ModelAndView eliminarFicha(@RequestParam("idfc") Long idfc,
			@RequestParam("motivo") String motivo) {

		ComFichaComedor fc2 = fichacomedorsevice.getFichaComedor(idfc);
		Long ticket = fc2.getComTicketsDependencia().getId();
		ComTicket ct = rangoAsistentaService.findById(ticket);

		ct.setEstado(1);
		rangoAsistentaService.editarticket(ct);

		ComFichaComedor fc = fichacomedorsevice.getFichaComedor(idfc);
		fc.setMotivoRatificar(motivo);
		fc.setComTicketsDependencia(null);
		fc.setEstado(0);
		fichacomedorsevice.eliminarFichacomedor(fc);

		return new ModelAndView("redirect:/bienestar/lista_comedor.htm");
	}

	// SAMUEL-----------------------------------------------------------------
	@RequestMapping(value = "/verificar_padron.htm")
	public ModelAndView verificarpadron(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("padron", this.fichacomedorsevice.getListaVerificarPadron());
		return new ModelAndView("verificarPadron", "model", myModel);
	}

	@RequestMapping(value = "/ticket_comedor.htm", method = RequestMethod.GET)
	public ModelAndView ticketComedor(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "cod") int codigo) throws ServletException,
			IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		myModel.put("ticket", this.fichacomedorsevice.getDataTicket(codigo));
		myModel.put("rowTicket", this.fichacomedorsevice.getRowTicket(codigo));

		return new ModelAndView("ticketComedor", "model", myModel);
	}

	@RequestMapping(value = "/ticket_comedor.htm", method = RequestMethod.POST)
	public ModelAndView formticketcomedor(
			@RequestParam("voucher") String voucher,
			@RequestParam("cantidad") Integer cantidad,
			@RequestParam("monto") BigDecimal monto,
			@RequestParam("idFicha") Integer idFicha) {

		fichacomedorsevice.addTicketComedor(voucher, cantidad, monto, idFicha);

		// System.out.println(voucher + "--- " + cantidad + "-----" + monto +
		// "----------" + idFicha);

		return new ModelAndView("redirect:/bienestar/ticket_comedor.htm?cod="
				+ idFicha);
	}

	// PILAR-----------------------------------------------
	@RequestMapping(value = "/editar_control.htm", method = RequestMethod.GET)
	public ModelAndView editarcontrol(HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "ida") long ida)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("control", this.controlsocialservice.getDataAsistenta(ida));
		myModel.put("escuela", this.controlsocialservice.getListEscuela(ida));
		myModel.put("escuela1",
				this.controlsocialservice.getListEscuelaDisponibles(ida));

		return new ModelAndView("editarControl", "model", myModel);
	}

	// SANDRA---------------------------------------------------------------------

	@RequestMapping(value = "/control_social.htm")
	public ModelAndView controlsocial(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("asistenta", this.controlsocialservice.getListAsistentas());
		myModel.put("escuela2",
				this.controlsocialservice.getListEscuelasTotales());
		return new ModelAndView("controlSocial", "model", myModel);
	}

	@RequestMapping(value = "/reasignarTickets.htm")
	public ModelAndView reasignarTickets(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "numero") Long numero)
			throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		Dependencia d=this.controlsocialservice.buscarescuela(numero);
		myModel.put("codigosdisponibles",
				this.rangoAsistentaService.codigosdisponibles(numero));
		myModel.put("escuelas", this.rangoAsistentaService.escuelas());
		myModel.put("nombreescuela", d.getNombre());

		return new ModelAndView("reasignarTickets", "model", myModel);
	}

	// --------> Eliminar una escuela que pertenece a una asistenta
	// <------------------------

	@RequestMapping(value = "/eliminarescuela.htm")
	public ModelAndView eliminarescuela(
			@RequestParam(value = "datoide") Long datoide) {
		ComPermiso cp = controlsocialservice.buscaridpermiso(datoide);
		Long a = cp.getId();
		controlsocialservice.eliminarescuela(a);

		List<ComTicketsDependencia> x = controlsocialservice
				.buscarcodigos(datoide);
		for (int i = 0; i < x.size(); i++) {

			controlsocialservice.eliminarcodigo(x.get(i).getId());
		}

		return new ModelAndView("redirect:/bienestar/editar_control.htm?ida="
				+ cp.getPerfil().getId() + "");
	}

	@RequestMapping(value = "/sobratickets.htm")
	public ModelAndView sobratickets(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("codigossobrantes",
				this.controlsocialservice.codigossobrantes());
		myModel.put("escuelas", this.rangoAsistentaService.escuelas());

		return new ModelAndView("sobratickets", "model", myModel);
	}

	@RequestMapping(value = "/editarTickets.htm", method = RequestMethod.POST)
	public ModelAndView editarTickets(
			@RequestParam("listaescuela") Long listaescuela,
			@RequestParam("codigosdisponibles") List<Long> codigosdisponibles) {

		for (int i = 0; i < codigosdisponibles.size(); i++) {
			ComTicket c = controlsocialservice.buscarcodigo(codigosdisponibles.get(i)); //encuentra los tickets
			ComTicketsDependencia ctd2 = controlsocialservice.getComTickestDependencia(c.getId());//obtiene el id del ComTicketsDependencia
		
			
			Dependencia x = controlsocialservice.getescuelas(listaescuela);//encuentra la escuela
			ctd2.setDependencia(x);
		

			controlsocialservice.editartickets(ctd2);
		}

		return new ModelAndView("redirect:/bienestar/control_social.htm");
	}

	@RequestMapping(value = "/editarSobraTickets.htm", method = RequestMethod.POST)
	public ModelAndView editarSobraTickets(
			@RequestParam("listaescuela") Long listaescuela,
			@RequestParam("codigossobrantes") List<Long> codigossobrantes) {

		for (int i = 0; i < codigossobrantes.size(); i++) {
			ComTicket c = controlsocialservice.buscarcodigo(codigossobrantes
					.get(i));
			ComTicketsDependencia ctd = new ComTicketsDependencia();
			Long e = Long.valueOf(1);
			ComPeriodo q = controlsocialservice.buscarperiodo(e);
			Dependencia x = controlsocialservice.getescuelas(listaescuela);
			ctd.setDependencia(x);
			ctd.setComRangoTicket(c);
			ctd.setComPeriodo(q);
			controlsocialservice.agregarSobratickets(ctd);
		}

		return new ModelAndView("redirect:/bienestar/control_social.htm");
	}

	
	
	// --------> AGREGAR UNA ESCUELA A UNA ASISTENTA <------------------------

	@RequestMapping(value = "/escuelasdisponibles.htm")
	public ModelAndView escuelasdisponibles(
			@RequestParam("idasistenta") Long idasistenta,
			@RequestParam("escuelasdisponibles") List<Long> escuelasdisponibles) {

		Perfil per = perfilService.findByPerfil2(idasistenta);
 	for (int i = 0; i < escuelasdisponibles.size(); i++) {
 		Perfil p = perfilService.findByPerfil2(idasistenta);
 		
 		Dependencia d = controlsocialservice.buscarescuela(escuelasdisponibles.get(i));
 		ComPermiso comPermiso = new ComPermiso();
 	    comPermiso.setPerfil(p);
 		comPermiso.setDependencia(d);
 		
		
		controlsocialservice.agregarescuela(comPermiso);
 	}
 
	return new ModelAndView("redirect:/bienestar/editar_control.htm?ida="+per.getId() + "");
	}
	
	

	public ModelAndView processSubmit(
			@RequestParam("dniAsistenta") String dniAsistenta) {

		persona_asistenta = this.controlsocialservice
				.findAsistentaByDni(dniAsistenta);
		asistenta_comedor = this.controlsocialservice
				.findAsistentainComedor(dniAsistenta);

		if (persona_asistenta != null && asistenta_comedor == null) {

			ComPermiso c = new ComPermiso();
			c.setPerfil(persona_asistenta);
			controlsocialservice.addPermiso(c);
			// ComRangoAsistenta a = new ComRangoAsistenta();
			// a.setComPermiso(c);
			// controlsocialservice.addComedorAsistenta(a);

			return new ModelAndView("redirect:/bienestar/control_social.htm");
		}

		else {

			return new ModelAndView("redirect:control_social.htm");

		}
	}

}
