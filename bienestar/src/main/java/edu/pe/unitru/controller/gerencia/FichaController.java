package edu.pe.unitru.controller.gerencia;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import edu.pe.unitru.service.gerencia.UCAService;

@Controller
@RequestMapping(value = "/gerencia")
public class FichaController {
		
	protected final Log logger = LogFactory.getLog(getClass()); //log del sistema -> errores
	
	@Autowired
	private UCAService fichacontrolservice;
	
	@RequestMapping(value = "/ficha_cas.htm")
	public ModelAndView ficha(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("fichaPer", this.fichacontrolservice.seleccionarPersonalAdmin());
		return new ModelAndView("fichaCas","model",myModel);
	}
	
}
