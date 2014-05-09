package edu.pe.unitru.controller.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.unitru.service.generic.PersonaService;
import edu.pe.unitru.service.security.UsuarioService;

@Controller
public class LoginController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PersonaService personaService;

	@RequestMapping(value = "/login.htm")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("templatelogin");
	}
	
//	
//	@ModelAttribute("cuenta")
//	public Cuenta getCuenta() {
//		return new Cuenta();
//	}
//	
	//@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	//public String processSubmit(@ModelAttribute("cuenta") Cuenta cuenta, BindingResult result) {
		
		//List<Persona> persona=this.usuarioService.verificaLogin(cuenta);
		
		//if (!persona.isEmpty())
			//return "redirect:/home/bienvenida.htm";
		//else
			//return "redirect:login.htm";
	//}
//	@Autowired
//	private UserDetailsManager userDetailsManager;
	
	@RequestMapping(value="/list.htm", method=RequestMethod.GET )
	public String processSubmit() {
		return "redirect:/home/bienvenida.htm";
	}
	
	
	@RequestMapping(value = "/accessDenied.htm")
	public ModelAndView accessDenied(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("error403");
	}
	
	@RequestMapping(value = "/noFound.htm")
	public ModelAndView noFound(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("error404");
	}
	
	
	
	
	
	
	

}
