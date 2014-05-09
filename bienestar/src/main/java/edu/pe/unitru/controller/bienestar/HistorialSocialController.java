package edu.pe.unitru.controller.bienestar;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.bienestar.SocObservacion;
import edu.pe.unitru.domain.bienestar.SocPrestacionAsistencial;
import edu.pe.unitru.domain.bienestar.SocProblematica;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.domain.security.CustomerUser;
import edu.pe.unitru.service.bienestar.FichaSocialService;
import edu.pe.unitru.service.bienestar.HistorialSocialService;
import edu.pe.unitru.service.generic.PerfilService;
import edu.pe.unitru.service.generic.PersonaService;

@Controller
@RequestMapping(value = "/bienestar")
public class HistorialSocialController {
	
	protected final Log logger = LogFactory.getLog(getClass());
		
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private FichaSocialService fichaSocialservice;
	
	@Autowired
	private HistorialSocialService historialSocialService;
	
	
	@RequestMapping(value = "/historiaSocial.htm")
	public ModelAndView historiaSocial(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws ServletException, IOException {
		
		return new ModelAndView("historiaSocial");	
		
	}
	
	@RequestMapping(value="/historiaSocial.htm", method = RequestMethod.POST)
	public ModelAndView buscarDni(
			@RequestParam("dni") String dni,			
			Authentication auth) {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		Persona buscar = this.personaService.findByDni(dni);
		String buscarFicha = this.historialSocialService.findFichaByDni(dni);
		if(buscar == null) {
			myModel.put("dniNoExiste",true);
			return new ModelAndView("historiaSocial","model",myModel);
		}else if(buscarFicha == null) {
			myModel.put("fichaNoExiste",true);
			return new ModelAndView("historiaSocial","model",myModel);
		}else if(buscar != null && buscarFicha != null) {
			myModel.put("persona", this.personaService.findDatosPersonalesByDni(dni));
			myModel.put("clinico", this.historialSocialService.getFichaHistorial(dni));
			myModel.put("grupofamiliar", this.historialSocialService.getGrupoFamiliar(dni));
			myModel.put("vivienda", this.historialSocialService.getSocialVivienda(dni));
			myModel.put("economica", this.historialSocialService.getSocialSituacionEconomica(dni));
			myModel.put("antescolares", this.historialSocialService.getSocialAntecdentesEscolares(dni));
			myModel.put("deportes", this.historialSocialService.getSocialDeportes(dni));
			myModel.put("aficiones", this.historialSocialService.getSocialAficiones(dni));
			myModel.put("observaciones", this.historialSocialService.getSocialObservaciones(dni));
			myModel.put("problematica", this.historialSocialService.getSocialProblematica(dni));
			myModel.put("prestaciones", this.historialSocialService.getSocialPrestaciones(dni));
			myModel.put("buscar",true);
		
		return new ModelAndView("historiaSocial","model",myModel);
		}else {
			return null;
		}
	}
	
	
	@RequestMapping(value="/observacion.htm", method = RequestMethod.POST)
	public @ResponseBody String guardarObservaciones(
			@RequestParam("idSocial") long idSocial,
			@RequestParam("message") String message,
			Authentication auth){
		
		CustomerUser user = (CustomerUser) auth.getPrincipal();
		Perfil perfil = this.perfilService.findById(user.getPerfil());
		ServicioSocial fichaSocial = historialSocialService.getFichaSocial(idSocial);
		
		SocObservacion observacion = new SocObservacion();
		observacion.setObservaciones(message);
		observacion.setServicioSocial(fichaSocial);
		observacion.setEstado(1);
		Date date = new Date();
		observacion.setFecha(new Timestamp(date.getTime()));
		observacion.setPerfil(perfil);
		
		historialSocialService.addObservacion(observacion);			
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("buscar", true);
//		return new ModelAndView("redirect:/bienestar/historiaSocial.htm","model",myModel);
		
		String persona = observacion.getPerfil().getPersona().getNombres()+' '+
				 observacion.getPerfil().getPersona().getApellidoPaterno()+ ' '+
				 observacion.getPerfil().getPersona().getApellidoMaterno();
		String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(observacion.getFecha()).toString();
//		String fecha = problematica.getFecha().;
		String messageRequest = observacion.getObservaciones();
		String messageFinal = persona+','+fecha+','+messageRequest;
//		String messageReturn = "Se Registro Correctamente";
		return messageFinal;
	}
	
	@RequestMapping(value="/problematica.htm", method = RequestMethod.POST)
	@ResponseBody
	public  String guardarProblematica(
			@RequestParam("idSocial") long idSocial,
			@RequestParam("message") String message,
			Authentication auth,HttpServletRequest request){
		
		CustomerUser user = (CustomerUser) auth.getPrincipal();
		Perfil perfil = this.perfilService.findById(user.getPerfil());
		ServicioSocial fichaSocial = historialSocialService.getFichaSocial(idSocial);
		
		SocProblematica problematica = new SocProblematica();
		problematica.setProblematica(message);
		problematica.setEstado(1);
		Date date = new Date();
		problematica.setFecha(new Timestamp(date.getTime()));
		problematica.setServicioSocial(fichaSocial);
		problematica.setPerfil(perfil);
		
		historialSocialService.addProblematica(problematica);			
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("message", problematica.getProblematica());		
//		myModel.put("fecha", problematica.getFecha());		
//		myModel.put("persona", problematica.getPerfil().getPersona().getNombres()+' '+
//				 problematica.getPerfil().getPersona().getApellidoPaterno()+ ' '+
//				 problematica.getPerfil().getPersona().getApellidoMaterno());	
		String persona = problematica.getPerfil().getPersona().getNombres()+' '+
				 problematica.getPerfil().getPersona().getApellidoPaterno()+ ' '+
				 problematica.getPerfil().getPersona().getApellidoMaterno();
		String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(problematica.getFecha()).toString();
//		String fecha = problematica.getFecha().;
		String messageRequest = problematica.getProblematica();
		String messageFinal = persona+','+fecha+','+messageRequest;
		return messageFinal;
	}
	
	@RequestMapping(value="/prestacion.htm", method = RequestMethod.POST)
	public @ResponseBody String guardarPrestaciones(
			@RequestParam("idSocial") long idSocial,
			@RequestParam("problematicaSocial") String problematicaSocial,
			@RequestParam("resultado") String resultado,
			Authentication auth){
		
		CustomerUser user = (CustomerUser) auth.getPrincipal();
		Perfil perfil = this.perfilService.findById(user.getPerfil());
		ServicioSocial fichaSocial = historialSocialService.getFichaSocial(idSocial);
		Date date = new Date();
		
		SocPrestacionAsistencial prestacion = new SocPrestacionAsistencial();		
		prestacion.setProblematicaSocial(problematicaSocial);
		prestacion.setResultado(resultado);
		prestacion.setServicioSocial(fichaSocial);		
		prestacion.setFecha(new Timestamp(date.getTime()));
		prestacion.setPerfil(perfil);
		prestacion.setEstado(1);			
		
		historialSocialService.addPrestacion(prestacion);			
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("buscar", true);		
//		return new ModelAndView("redirect:/bienestar/historiaSocial.htm","model",myModel);
//		String messageReturn = "Se Registro Correctamente";
		String persona = prestacion.getPerfil().getPersona().getNombres()+' '+
				 prestacion.getPerfil().getPersona().getApellidoPaterno()+ ' '+
				 prestacion.getPerfil().getPersona().getApellidoMaterno();
		String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(prestacion.getFecha()).toString();
		String problematicaSocialFinal = prestacion.getProblematicaSocial();
		String resultadoFinal = prestacion.getResultado();
		Long total = this.historialSocialService.countPrestacion(idSocial);
		String count = total.toString();
		return persona+','+fecha+','+problematicaSocialFinal+','+resultadoFinal+','+count;
	}
	
	@RequestMapping(value="/cambiar_categoria.htm", method = RequestMethod.POST)
	public @ResponseBody String guardarCategoria(
			@RequestParam("idSocial") long idSocial,
			@RequestParam("select_categoria") Integer categoria,
			@RequestParam("categoria_motivo") String motivo,
			Authentication auth){
		
		CustomerUser user = (CustomerUser) auth.getPrincipal();
		this.historialSocialService.addCategoria(idSocial, categoria, motivo, user);
		
		String categoriaActual = categoria.toString();
		
		return categoriaActual;
		
		
		
//		
//		SocPrestacionAsistencial prestacion = new SocPrestacionAsistencial();		
//		prestacion.setProblematicaSocial(problematicaSocial);
//		prestacion.setResultado(resultado);
//		prestacion.setServicioSocial(fichaSocial);		
//		prestacion.setFecha(new Timestamp(date.getTime()));
//		prestacion.setPerfil(perfil);
//		prestacion.setEstado(1);			
		
//		historialSocialService.addPrestacion(prestacion);			
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("buscar", true);		
//		return new ModelAndView("redirect:/bienestar/historiaSocial.htm","model",myModel);
//		String messageReturn = "Se Registro Correctamente";
//		String persona = prestacion.getPerfil().getPersona().getNombres()+' '+
//				 prestacion.getPerfil().getPersona().getApellidoPaterno()+ ' '+
//				 prestacion.getPerfil().getPersona().getApellidoMaterno();
//		String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(prestacion.getFecha()).toString();
//		String problematicaSocialFinal = prestacion.getProblematicaSocial();
//		String resultadoFinal = prestacion.getResultado();
//		Long total = this.historialSocialService.countPrestacion(idSocial);
//		String count = total.toString();
//		return persona+','+fecha+','+problematicaSocialFinal+','+resultadoFinal+','+count;
	}
	
}
