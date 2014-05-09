package edu.pe.unitru.controller.generic;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.domain.generic.UbigeoReniec;
import edu.pe.unitru.domain.security.SecurityUser;
import edu.pe.unitru.service.generic.PersonaService;
import edu.pe.unitru.service.generic.UbigeoService;
import edu.pe.unitru.service.security.UsuarioService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PersonaService personaService;

	@Autowired
	private UbigeoService ubigeoService;

	

	List<Persona> per;

	// SEGUNDO----------------------------------------------
	@RequestMapping(value = "/bienvenida.htm")
	public ModelAndView bienvenida(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// CustomerUser auth =
		// (CustomerUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// String nombre = auth.getNombre();
		// Map<String, Object> myModel = new HashMap<String, Object>();
		// myModel.put("nombre", nombre);
		// return new ModelAndView("bienvenida","model",myModel);

		// myModel.put("nombre", nombre);
		return new ModelAndView("bienvenida");
	}

	@RequestMapping(value = "/configuracion.htm")
	public ModelAndView cambiarcontra(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {

		String dni = auth.getName();
		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("persona", this.personaService.getPersonaByDni(dni));
		myModel.put("persona", this.personaService.findEmailByDni(dni));
		return new ModelAndView("cambiarContra", "model", myModel);
	}

	@RequestMapping(value = "/configuracion.htm", method = RequestMethod.POST)
	public ModelAndView Correo(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Authentication auth) {

//		Persona p = new Persona();
		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Boolean resultado = this.usuarioService.validarPassword(password, dni);
		if(resultado) {
			Persona p = personaService.findByDni(dni);
			
			p.setEmail(email);		
			personaService.updateEmail(p);

			return new ModelAndView("redirect:/home/configuracion.htm?success=true");
		}else {
			return new ModelAndView("redirect:/home/configuracion.htm?error=true");
		}
		
	}
	
	@RequestMapping(value = "/cambiar_password.htm", method = RequestMethod.POST)
	public ModelAndView changePassword(	@RequestParam("passwordActual") String passwordActual,
			@RequestParam("nuevaPassword") String nuevaPassword,
			Authentication auth) {

//		Persona p = new Persona();
		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Boolean resultado = this.usuarioService.validarPassword(passwordActual, dni);
		if(resultado) {			
			this.usuarioService.cambiarPassword(nuevaPassword, dni);
			return new ModelAndView("redirect:/home/configuracion.htm?success=true");
		}else {
			return new ModelAndView("redirect:/home/configuracion.htm?error=true");
		}
		
	}

	// SANDRA Y LIZETH--------------------------------------
	@RequestMapping(value = "/perfil.htm")
	public ModelAndView perfil(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {

		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("persona", this.personaService.findDatosPersonalesByDni(dni));
		return new ModelAndView("perfil", "model", myModel);
	}

	@RequestMapping(value = "/editarperfil.htm")
	public ModelAndView editarperfil(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {

		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Map<String, Object> myModel = new HashMap<String, Object>();

//		myModel.put("persona", this.personaService.getPersonaByDni(dni));
		myModel.put("persona", this.personaService.findDatosPersonalesByDni(dni));

		myModel.put("ubigeo", this.ubigeoService.getDepartamentos());

		return new ModelAndView("editarperfil", "model", myModel);
	}

	@ModelAttribute("persona")
	public Persona persona() {
		return new Persona();
	}

	@RequestMapping(value = "/editarperfil.htm", method = RequestMethod.POST)
	public ModelAndView processSubmit(
			@RequestParam("telefono") String telefono,
			@RequestParam("celular") String celular,
			@RequestParam("fechaNacimiento") String fechaNacimiento,
			@RequestParam("domicilioActual") String domicilioActual,
			@RequestParam("estadoCivil") String estadoCivil,
			@RequestParam("departamento_nac") Integer depNacimiento,
			@RequestParam("provincia_nac") Integer provNacimiento,
			@RequestParam("distrito_nac") Integer distNacimiento,
			@RequestParam("departamento_proc") Integer depProcedencia,
			@RequestParam("provincia_proc") Integer provProcedencia,
			@RequestParam("distrito_proc") Integer distProcedencia,
			@RequestParam("departamento_act") Integer depActual,
			@RequestParam("provincia_act") Integer provActual,
			@RequestParam("distrito_act") Integer distActual,
			Authentication auth) {

		String dni = auth.getName();
		UbigeoReniec nacimiento = this.ubigeoService.getUbigeo(depNacimiento, provNacimiento, distNacimiento);
		UbigeoReniec procedencia = this.ubigeoService.getUbigeo(depProcedencia, provProcedencia, distProcedencia);
		UbigeoReniec actual = this.ubigeoService.getUbigeo(depActual, provActual, distActual);
		
		Persona p = personaService.findByDni(dni);
		
		p.setTelefono(telefono);
		p.setCelular(celular);
		p.setDomicilioActual(domicilioActual);
		p.setEstadoCivil(Integer.parseInt(estadoCivil));
		p.setIdLugarNacimiento(nacimiento);
		p.setLugarProcedencia(procedencia);
		p.setLugarActual(actual);
		String[] fecha = fechaNacimiento.split("-");
		p.setFechaNacimiento(Date.valueOf(fecha[2]+'-'+fecha[1]+'-'+fecha[0]));
//		Timestamp timestamp = Timestamp.valueOf(fechaNacimiento);
//		p.setFechaNacimiento(timestamp);
		personaService.updateUsuario(p);

		// this.personaService.updateUsuario(personas);
		return new ModelAndView("redirect:perfil.htm?success=true");

	}

	// PILAR----------------------------------------------
	@RequestMapping(value = "/fichaComedor.htm")
	public ModelAndView fichacomedor(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws ServletException, IOException {

		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("persona", this.personaService.getPersonaByDni(dni));
		return new ModelAndView("fichaComedor", "model", myModel);
	}

	// SAMUEL TEST
	
	//DEMO---------------
	
	@RequestMapping(value = "/demo.htm")
	public ModelAndView demo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// CustomerUser auth =
		// (CustomerUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// String nombre = auth.getNombre();
		// Map<String, Object> myModel = new HashMap<String, Object>();
		// myModel.put("nombre", nombre);
		// return new ModelAndView("bienvenida","model",myModel);

		// myModel.put("nombre", nombre);
		return new ModelAndView("demo");
	}

}
