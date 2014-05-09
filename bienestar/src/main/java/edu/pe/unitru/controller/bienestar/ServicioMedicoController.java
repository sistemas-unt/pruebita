package edu.pe.unitru.controller.bienestar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.unitru.service.bienestar.ServicioClinicoService;


@Controller
@RequestMapping(value = "/bienestar")
public class ServicioMedicoController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ServicioClinicoService servicioClinicoService;
	

	
	@RequestMapping(value = "/servicioclinicosecretaria.htm")
	public ModelAndView servicioclinicosecretaria(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("listasocial", this.servicioClinicoService.getListaSocial());
		return new ModelAndView("servicioclinicosecretaria", "model", myModel);
	}
	
	
//	----------------------SERVICIO CLINICO LABORATORIO-----------------------------------
	@RequestMapping(value = "/servicioclinicolaboratorio.htm")
	public ModelAndView servicioclinicolaboratorio(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		//myModel.put("listaatendidos", this.servicioClinicoService.getListaAtendidos());
		return new ModelAndView("servicioclinicolaboratorio", "model", myModel);
	}
	@RequestMapping(value = "/fichalaboratorio.htm")
	public ModelAndView fichalaboratorio(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//Map<String, Object> myModel = new HashMap<String, Object>();
		//myModel.put("listaatendidos", this.servicioClinicoService.getListaAtendidos());
		return new ModelAndView("fichalaboratorio");
	}
	
	
//	----------------------SERVICIO CLINICO TOPICO -----------------------------------
	@RequestMapping(value = "/servicioclinicotopico.htm")
	public ModelAndView servicioclinicotopico(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		//myModel.put("listaatendidos", this.servicioClinicoService.getListaAtendidos());
		return new ModelAndView("servicioclinicotopico", "model", myModel);
	}
	@RequestMapping(value = "/fichatopico.htm")
	public ModelAndView fichatopico(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//Map<String, Object> myModel = new HashMap<String, Object>();
		//myModel.put("listaatendidos", this.servicioClinicoService.getListaAtendidos());
		return new ModelAndView("fichatopico");
	}
	@RequestMapping(value = "/fichamedica2.htm")
	public ModelAndView fichamedica2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		//myModel.put("padron", this.fichacomedorsevice.getListaVerificarPadron());
		return new ModelAndView("fichamedica2", "model", myModel);
	}
}
