package edu.pe.unitru.controller.bienestar;

import java.io.IOException;
import java.math.BigDecimal;
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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.unitru.domain.bienestar.GrupoFamiliar;
import edu.pe.unitru.domain.bienestar.SaeEspecializacion;
import edu.pe.unitru.domain.bienestar.SaeFormaIngreso;
import edu.pe.unitru.domain.bienestar.SaeTipoColegio;
import edu.pe.unitru.domain.bienestar.SaeTurno;
import edu.pe.unitru.domain.bienestar.ServicioSocial;
import edu.pe.unitru.domain.bienestar.SocAficion;
import edu.pe.unitru.domain.bienestar.SocAlimentacion;
import edu.pe.unitru.domain.bienestar.SocAntEscolar;
import edu.pe.unitru.domain.bienestar.SocDeporte;
import edu.pe.unitru.domain.bienestar.SocDiagramaDomicilio;
import edu.pe.unitru.domain.bienestar.SocSalud;
import edu.pe.unitru.domain.bienestar.SocSituacionEconomica;
import edu.pe.unitru.domain.bienestar.SocVivienda;
import edu.pe.unitru.domain.bienestar.SsAcudeEnfermedad;
import edu.pe.unitru.domain.bienestar.SsMotivo;
import edu.pe.unitru.domain.bienestar.SseCondicion;
import edu.pe.unitru.domain.bienestar.SseDedicacion;
import edu.pe.unitru.domain.bienestar.SseEgreso;
import edu.pe.unitru.domain.bienestar.SseIngreso;
import edu.pe.unitru.domain.bienestar.SseOcupacionLaboral;
import edu.pe.unitru.domain.bienestar.SseTurnoTrabajo;
import edu.pe.unitru.domain.bienestar.SvAguaPotable;
import edu.pe.unitru.domain.bienestar.SvIluminacion;
import edu.pe.unitru.domain.bienestar.SvMatConstruccion;
import edu.pe.unitru.domain.bienestar.SvServiciosHigienico;
import edu.pe.unitru.domain.bienestar.SvTenencia;
import edu.pe.unitru.domain.bienestar.SvTipo;
import edu.pe.unitru.domain.bienestar.SvUbicacion;
import edu.pe.unitru.domain.bienestar.TipoVivienda;
import edu.pe.unitru.domain.generic.Perfil;
import edu.pe.unitru.domain.generic.Persona;
import edu.pe.unitru.domain.medico.CfhAccidente;
import edu.pe.unitru.domain.medico.CfhAlergia;
import edu.pe.unitru.domain.medico.CfhEnfermedad;
import edu.pe.unitru.domain.medico.CfhInmunizacion;
import edu.pe.unitru.domain.medico.CfhOperacion;
import edu.pe.unitru.domain.medico.CliFichaHistorial;
import edu.pe.unitru.domain.medico.Clinico;
import edu.pe.unitru.service.bienestar.CategoriaService;
import edu.pe.unitru.service.bienestar.ControlSocialService;
import edu.pe.unitru.service.bienestar.FichaComedorService;
import edu.pe.unitru.service.bienestar.FichaSocialService;
import edu.pe.unitru.service.generic.PerfilService;
import edu.pe.unitru.service.generic.PersonaService;
import edu.pe.unitru.service.security.UsuarioService;

@Controller
@RequestMapping(value = "/bienestar")
public class ServicioSocialController {
	
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
	
	List<Persona> per;
	Persona persona_asistenta;
	Persona asistenta_comedor;
	
	
	
	//RICHARD---------------------------------------------------------------
		@RequestMapping(value = "/buscar_paso.htm")
		public ModelAndView buscarpaso(HttpServletRequest request,
				HttpServletResponse response, Authentication auth)
				throws ServletException, IOException {
			Persona p = new Persona();
			String dni = auth.getName();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			ServicioSocial aux = fichasocialservice.buscarestado(perfil.getId());
			
			if (aux == null) {
				
				return new ModelAndView(
						"redirect:/bienestar/ficha_antecedentes_Personales.htm");
			} else {
				switch (aux.getEstado()) {
				case 1:
					return new ModelAndView(
							"redirect:/bienestar/ficha_grupo_Familiar.htm");
				case 2:
					return new ModelAndView(
							"redirect:/bienestar/ficha_vivienda_Familiar.htm");
				case 3:
					return new ModelAndView(
							"redirect:/bienestar/ficha_vivienda_Alumno.htm");
				case 4:
					return new ModelAndView(
							"redirect:/bienestar/ficha_situacion_Economica.htm");
				case 5:
					return new ModelAndView(
							"redirect:/bienestar/ficha_antecedentes_Escolares.htm");
				case 6:
					return new ModelAndView(
							"redirect:/bienestar/ficha_Salud.htm");
				case 7:
					return new ModelAndView(
							"redirect:/bienestar/ficha_alimentacion_Recreacion.htm");
				case 8:
					return new ModelAndView(
							"redirect:/bienestar/ficha_domicilio.htm");
				case 9:
					return new ModelAndView(
							"redirect:/bienestar/ficha_servicio_social_final.htm");
				default:
					return new ModelAndView(
							"redirect:/bienestar/ficha_antecedentes_Personales.htm");
				}
			}
		}

		@RequestMapping(value = "/ficha_antecedentes_Personales.htm")
		public ModelAndView fichaservicio1(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {			
			Map<String, Object> myModel = new HashMap<String, Object>();

			return new ModelAndView("fichaServicioSocial1", "model", myModel);
		}

		@RequestMapping(value = "/ficha_antecedentes_Personales.htm", method = RequestMethod.POST)
		public ModelAndView registrostep1(
				@RequestParam("enfermedadradio") int enfermedadradio,
				@RequestParam("operacionradio") int operacionradio,
				@RequestParam("inmunizacionradio") int inmunizacionradio,
				@RequestParam("accidenteradio") int accidenteradio,
				@RequestParam("alergiaradio") int alergiaradio,
				@RequestParam("lentesradio") int lentesradio,
				@RequestParam("txtenfermedad") String txtenfermedad,
				@RequestParam("txtoperacion") String txtoperacion,
				@RequestParam("txtinmunizacion") String txtinmunizacion,
				@RequestParam("txtaccidente") String txtaccidente,
				@RequestParam("txtalergia") String txtalergia, Authentication auth,ServicioSocial serviciosocial) {

			Persona p = new Persona();
			String dni = auth.getName();

			CliFichaHistorial historial = new CliFichaHistorial();
			historial.setLentes(lentesradio);
			fichasocialservice.addcliFichaHistorial(historial);

			CfhEnfermedad enf = new CfhEnfermedad();
			enf.setSano(enfermedadradio);
			enf.setNombre(txtenfermedad);
			enf.setCliFichaHistorial(historial);
			fichasocialservice.addCfhEnfermedad(enf);

			CfhOperacion ope = new CfhOperacion();
			ope.setSano(operacionradio);
			ope.setNombre(txtoperacion);
			ope.setCliFichaHistorial(historial);
			fichasocialservice.addCfhOperacion(ope);

			CfhInmunizacion inmu = new CfhInmunizacion();
			inmu.setSano(inmunizacionradio);
			inmu.setNombre(txtinmunizacion);
			inmu.setCliFichaHistorial(historial);
			fichasocialservice.addCfhInmunizacion(inmu);

			CfhAccidente acci = new CfhAccidente();
			acci.setSano(accidenteradio);
			acci.setNombre(txtaccidente);
			acci.setCliFichaHistorial(historial);
			fichasocialservice.addCfhAccidente(acci);

			CfhAlergia aler = new CfhAlergia();
			aler.setSano(alergiaradio);
			aler.setNombre(txtalergia);
			aler.setCliFichaHistorial(historial);
			fichasocialservice.addCfhAlergia(aler);

			p = personaService.findByDni(dni);

			Clinico clinico = new Clinico();
			//clinico.setCliFichaHistorial(historial);
			//clinico.setPersona(p);
			fichasocialservice.addClinico(clinico);

			// -------------------------------------------------------

			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial.setPerfil(perfil);
			serviciosocial.setEstado(1);
			fichasocialservice.addServicioSocial(serviciosocial);
			return new ModelAndView(
					"redirect:/bienestar/ficha_grupo_Familiar.htm");
		}
		
		
		// --------------------------------- Atras 1		
		
		@RequestMapping(value = "/actualizar_ficha_antecedentes_Personales.htm")
		public ModelAndView actualizar1(HttpServletRequest request,
				HttpServletResponse response, Authentication auth) throws ServletException, IOException {
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);	
			//Clinico cli= new Clinico();
			
			CliFichaHistorial fichahistorial=fichasocialservice.buscarFichaHistorial(p.getId());			
			CfhAccidente accidente=fichasocialservice.buscarAccidente(p.getId());
			CfhAlergia alergia=fichasocialservice.buscarAlergiae(p.getId());
			CfhEnfermedad enfermedad=fichasocialservice.buscarEnfermedad(p.getId());
			CfhInmunizacion inmunizacion=fichasocialservice.buscarInmunizacion(p.getId());
			CfhOperacion operacion=fichasocialservice.buscarOperacion (p.getId());
			
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("fichash",fichahistorial);
			myModel.put("accidentes",accidente);
			myModel.put("alergias",alergia);
			myModel.put("enfermdedad",enfermedad);
			myModel.put("operaciones",operacion);
			myModel.put("inmunizaciones",inmunizacion);
			
			return new ModelAndView("fichaServicioSocialActualizar1", "model", myModel);
		}
		
		// --------------------------------- Actualizar 1		
		
		@RequestMapping(value = "/actualizar_ficha_antecedentes_Personales.htm", method = RequestMethod.POST)
		public ModelAndView actualizarstep1(
				@RequestParam("enfermedadradio") int enfermedadradio,
				@RequestParam("operacionradio") int operacionradio,
				@RequestParam("inmunizacionradio") int inmunizacionradio,
				@RequestParam("accidenteradio") int accidenteradio,
				@RequestParam("alergiaradio") int alergiaradio,
				@RequestParam("lentesradio") int lentesradio,
				@RequestParam("txtenfermedad") String txtenfermedad,
				@RequestParam("txtoperacion") String txtoperacion,
				@RequestParam("txtinmunizacion") String txtinmunizacion,
				@RequestParam("txtaccidente") String txtaccidente,
				@RequestParam("txtalergia") String txtalergia, Authentication auth) {

			String dni = auth.getName();
			Persona p = personaService.findByDni(dni);
			
			CliFichaHistorial historial = fichasocialservice.buscarFichaHistorial(p.getId());
			historial.setLentes(lentesradio);
			fichasocialservice.updatecliFichaHistorial(historial);

			CfhEnfermedad enf = fichasocialservice.buscarEnfermedad(p.getId());
			enf.setSano(enfermedadradio);
			enf.setNombre(txtenfermedad);
			enf.setCliFichaHistorial(historial);
			fichasocialservice.updateCfhEnfermedad(enf);

			CfhOperacion ope =fichasocialservice.buscarOperacion(p.getId());
			ope.setSano(operacionradio);
			ope.setNombre(txtoperacion);
			ope.setCliFichaHistorial(historial);
			fichasocialservice.updateCfhOperacion(ope);

			CfhInmunizacion inmu =fichasocialservice.buscarInmunizacion(p.getId());
			inmu.setSano(inmunizacionradio);
			inmu.setNombre(txtinmunizacion);
			inmu.setCliFichaHistorial(historial);
			fichasocialservice.updateCfhInmunizacion(inmu);

			CfhAccidente acci = fichasocialservice.buscarAccidente(p.getId());
			acci.setSano(accidenteradio);
			acci.setNombre(txtaccidente);
			acci.setCliFichaHistorial(historial);
			fichasocialservice.updateCfhAccidente(acci);

			CfhAlergia aler = fichasocialservice.buscarAlergiae(p.getId());
			aler.setSano(alergiaradio);
			aler.setNombre(txtalergia);
			aler.setCliFichaHistorial(historial);
			fichasocialservice.updateCfhAlergia(aler);

			Clinico clinico = fichasocialservice.buscarClinico(p.getId());
			//clinico.setCliFichaHistorial(historial);
			//clinico.setPersona(p);
			fichasocialservice.updateClinico(clinico);

			// -------------------------------------------------------

			Perfil perfil = perfilService.findByPerfil(p.getId());
			ServicioSocial ssactualizar= fichasocialservice.buscarServicioSocial(perfil.getId());
			fichasocialservice.updateServicioSocial(ssactualizar);			
			return new ModelAndView(
					"redirect:/bienestar/ficha_grupo_Familiar.htm");
		}		
					

		// --------------------------------- STEP
		// 2-------------------------------------------
		@RequestMapping(value = "/ficha_grupo_Familiar.htm")
		public ModelAndView fichaservicio2(HttpServletRequest request,
				HttpServletResponse response, Authentication auth)
				throws ServletException, IOException {
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);

			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listafamilia",
					this.fichasocialservice.getListaFamilia(p.getId()));

			return new ModelAndView("fichaServicioSocial2", "model", myModel);

		}

		@RequestMapping(value = "/ficha_grupo_Familiar.htm", method = RequestMethod.POST)
		public ModelAndView registrostep2(@RequestParam("txtdni") String txtdni,
				@RequestParam("txtnombre") String txtnombre,
				@RequestParam("txtapellidopaterno") String txtapellidopaterno,
				@RequestParam("txtapellidomaterno") String txtapellidomaterno,
				@RequestParam("txtfechanac") String txtfechanac,
				@RequestParam("cboparentezco") int cboparentezco,
				@RequestParam("cboestadocivil") int cboestadocivil,
				@RequestParam("txtgradoi") String txtgradoi,
				@RequestParam("txtlugarna") String txtlugarna,
				@RequestParam("txtocupacion") String txtocupacion,
				@RequestParam("txtingreso") BigDecimal txtingreso,
				@RequestParam("rtbsano") int rtbsano,
				@RequestParam("rtbfallecido") int rtbfallecido,
				@RequestParam("txtenfermedad") String txtenfermedad,
				@RequestParam("txtfallecimiento") String txtfallecimiento,
				@RequestParam("rtbintegra") int rtbintegra,
				@RequestParam("txtobservaciones") String txtobservaciones,
				Authentication auth,ServicioSocial serviciosocial) {

			GrupoFamiliar grupofamilia = new GrupoFamiliar();
			grupofamilia.setDocIdentidad(txtdni);
			grupofamilia.setNombres(txtnombre);
			grupofamilia.setApellidoPaterno(txtapellidopaterno);
			grupofamilia.setApellidoMaterno(txtapellidomaterno);
			grupofamilia.setParentesco(cboparentezco);
			grupofamilia.setFechaNacimiento(Date.valueOf(txtfechanac));
			grupofamilia.setLugarNacimiento(txtlugarna);
			grupofamilia.setEstadoCivil(cboestadocivil);
			grupofamilia.setGradoInstruccion(txtgradoi);
			grupofamilia.setIngresos(txtingreso);
			grupofamilia.setSano(rtbsano);
			grupofamilia.setIntegra(rtbintegra);
			grupofamilia.setObservaciones(txtobservaciones);
			//if(rtbfallecido==1)
				grupofamilia.setFallecido(txtfallecimiento);
			//if(rtbsano==1)
				grupofamilia.setEnfermo(txtenfermedad);
			

			// Authentication auth =
			// SecurityContextHolder.getContext().getAuthentication();
			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni);

			grupofamilia.setPersona(p);

			fichasocialservice.addGrupoFamiliar(grupofamilia);

			
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			
			if(serviciosocial.getEstado()==1)
			{
			serviciosocial.setEstado(2);
			fichasocialservice.updateServicioSocial(serviciosocial);
			}
			else
			{fichasocialservice.updateServicioSocial(serviciosocial);}

			
			return new ModelAndView(
					"redirect:/bienestar/ficha_grupo_Familiar.htm");
		}

		
		@RequestMapping(value = "/eliminar_servicio_social2.htm", method = RequestMethod.GET)
		public ModelAndView eliminarstep2(
				@RequestParam("codigo") Long codigo,
				Authentication auth,ServicioSocial serviciosocial) 
		{

			fichasocialservice.EliminarGrupoFamiliar(codigo);
						
			return new ModelAndView(
					"redirect:/bienestar/ficha_grupo_Familiar.htm");
		}
		
		
		//---------Seleccionarq ue vista 3 a elegir
		@RequestMapping(value="/buscarVista3aElegir.htm")
		public ModelAndView buscarVista3(HttpServletRequest request,
				HttpServletResponse response, Authentication auth,ServicioSocial serviciosocial)
				throws ServletException, IOException {
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni); 
			Perfil perfil = perfilService.findByPerfil(p.getId());
			
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			
			if(serviciosocial.getEstado()==2)
			{

			return new ModelAndView(
					"redirect:/bienestar/ficha_vivienda_Familiar.htm");
			}
			else
			{
				return new ModelAndView(
						"redirect:/bienestar/actualizar_ficha_vivienda_Familiar.htm");
				
			}
		
		}
		
		
		
		// --------------------------------- STEP
		// 3-------------------------------------------
		@RequestMapping(value = "/ficha_vivienda_Familiar.htm")
		public ModelAndView fichaservicio3(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Map<String, Object> myModel = new HashMap<String, Object>();
		//	myModel.put("listaDepa", this.fichasocialservice.getDeparList());
			myModel.put("listaUbi", this.fichasocialservice.getListaUbicacion());
			myModel.put("listaMat", this.fichasocialservice.getListaMaterial());
			myModel.put("listaTen", this.fichasocialservice.getListaTenencia());
			myModel.put("listaTipo", this.fichasocialservice.getListaTipo());
			myModel.put("listaAgua", this.fichasocialservice.getListaAgua());
			myModel.put("listaServ", this.fichasocialservice.getListaServ());
			myModel.put("listaIlu", this.fichasocialservice.getListaIlumi());
			return new ModelAndView("fichaServicioSocial3", "model", myModel);

		}

		@ModelAttribute("tipovivienda")
		public TipoVivienda getUsuarioObject() {
			return new TipoVivienda();
		}

		@RequestMapping(value = "/ficha_vivienda_Familiar.htm", method = RequestMethod.POST)
		public ModelAndView processSubmit(@RequestParam("svUbicacion") Long svUbicacion,
				@RequestParam("svMatConstruccion") Long svMatConstruccion,
				@RequestParam("svTenencia") Long svTenencia,
				@RequestParam("svTipo") Long svTipo,
				@RequestParam("svAguaPotable") Long svAguaPotable,
				@RequestParam("svServiciosHigienico") Long svServiciosHigienico,
				@RequestParam("svIluminacion") Long svIluminacion, Authentication auth,ServicioSocial serviciosocial) {

			
			SvTipo t1 = new SvTipo();
			t1 = fichasocialservice.buscarSvTipo(svTipo);

			SvUbicacion u1 = new SvUbicacion();
			u1 = fichasocialservice.buscarSvUbicacion(svUbicacion);

			SvAguaPotable ap1 = new SvAguaPotable();
			ap1 = fichasocialservice.buscarSvAguaPotable(svAguaPotable);

			SvIluminacion il1 = new SvIluminacion();
			il1 = fichasocialservice.buscarSvIluminacion(svIluminacion);

			SvMatConstruccion mt1 = new SvMatConstruccion();
			mt1 = fichasocialservice.buscarSvMatConstruccion(svMatConstruccion);

			SvServiciosHigienico sh1 = new SvServiciosHigienico();
			sh1 = fichasocialservice.buscarSvServiciosHigienico(svServiciosHigienico);

			SvTenencia te1 = new SvTenencia();
			te1 = fichasocialservice.buscarSvTenencia(svTenencia);
			
			TipoVivienda vivienda = new TipoVivienda();
			vivienda.setSvTipo(t1);
			vivienda.setSvUbicacion(u1);
			vivienda.setSvMatConstruccion(mt1);
			vivienda.setSvTenencia(te1);
			vivienda.setSvIluminacion(il1);
			vivienda.setSvAguaPotable(ap1);
			vivienda.setSvServiciosHigienico(sh1);			
			vivienda.setTipo(0);
			;
			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni); 

			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			this.fichasocialservice.addTipoVivienda(vivienda);

			SocVivienda socvivienda = new SocVivienda();
			socvivienda.setEstado(3);
			socvivienda.setTipoVivienda(vivienda);
			socvivienda.setServicioSocial(serviciosocial);

			fichasocialservice.addSocVivienda(socvivienda);

			
			serviciosocial.setEstado(3);
			fichasocialservice.updateServicioSocial(serviciosocial);

			return new ModelAndView(
					"redirect:/bienestar/ficha_vivienda_Alumno.htm");
		}
		
		
		// --------------------------------- Atras 3		
				@RequestMapping(value = "/actualizar_ficha_vivienda_Familiar.htm")
				public ModelAndView actualizar3(HttpServletRequest request,
						HttpServletResponse response, Authentication auth) throws ServletException, IOException {
					
					String dni = auth.getName();
					Persona p = new Persona();
					p = personaService.findByDni(dni);	
										
					SvAguaPotable aguapotable=fichasocialservice.buscarAguaPotable(p.getId());			
					SvIluminacion iluminacion=fichasocialservice.buscarIlumincacion(p.getId());
					SvMatConstruccion matcons=fichasocialservice.buscarMateriales(p.getId());
					SvServiciosHigienico sshh=fichasocialservice.buscarServiciosH(p.getId());
					SvTenencia tenencia=fichasocialservice.buscarTenecia(p.getId());
					SvTipo tipo=fichasocialservice.buscarTipo(p.getId());
					SvUbicacion ubicacion=fichasocialservice.buscarUbicacion(p.getId());
					
					Map<String, Object> myModel = new HashMap<String, Object>();
					myModel.put("aguapot",aguapotable);
					myModel.put("iluminaciones",iluminacion);
					myModel.put("materialescons",matcons);
					myModel.put("sshhs",sshh);
					myModel.put("tenencias",tenencia);
					myModel.put("tipos",tipo);
					myModel.put("ubicaciones",ubicacion);
					
					
				//	myModel.put("listaDepa", this.fichasocialservice.getDeparList());
					myModel.put("listaUbi", this.fichasocialservice.getListaUbicacion());
					myModel.put("listaMat", this.fichasocialservice.getListaMaterial());
					myModel.put("listaTen", this.fichasocialservice.getListaTenencia());
					myModel.put("listaTipo", this.fichasocialservice.getListaTipo());
					myModel.put("listaAgua", this.fichasocialservice.getListaAgua());
					myModel.put("listaServ", this.fichasocialservice.getListaServ());
					myModel.put("listaIlu", this.fichasocialservice.getListaIlumi());

					return new ModelAndView("fichaServicioSocialActualizar3", "model", myModel);
				}
					
				
				// --------------------------------- Actualizar3	
				
				@RequestMapping(value = "/actualizar_ficha_vivienda_Familiar.htm", method = RequestMethod.POST)
				public ModelAndView processSubmitAct(
						@ModelAttribute(value = "tipovivienda") TipoVivienda tipovivienda2,
						BindingResult result, Authentication auth,ServicioSocial serviciosocial) {

					
					String dni = auth.getName();
					Persona p = new Persona();
					p = personaService.findByDni(dni); 
					Perfil perfil = perfilService.findByPerfil(p.getId());
					
					serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
					
					
					SocVivienda socvivienda=fichasocialservice.buscarSocvivienda(serviciosocial.getId());
					
					
					TipoVivienda tipovivienda=fichasocialservice.buscarTipovivienda(socvivienda.getId());					
					tipovivienda.setSvAguaPotable(tipovivienda2.getSvAguaPotable());
					tipovivienda.setSvIluminacion(tipovivienda2.getSvIluminacion());
					tipovivienda.setSvMatConstruccion(tipovivienda2.getSvMatConstruccion());
					tipovivienda.setSvServiciosHigienico(tipovivienda2.getSvServiciosHigienico());
					tipovivienda.setSvTenencia(tipovivienda2.getSvTenencia());
					tipovivienda.setSvTipo(tipovivienda2.getSvTipo());
					tipovivienda.setSvUbicacion(tipovivienda2.getSvUbicacion());
					//tipovivienda.setTipo(0);									
					this.fichasocialservice.updateTipoVivienda(tipovivienda);
					
					
					//------------------------------------------------------
					socvivienda.setTipoVivienda(tipovivienda);
					socvivienda.setServicioSocial(serviciosocial);
					fichasocialservice.updateSocVivienda(socvivienda);
					//--------------------------------------------------------
					
					//serviciosocial.setEstado(3);
					fichasocialservice.updateServicioSocial(serviciosocial);
					if(serviciosocial.getEstado()==3)
					{

					return new ModelAndView(
							"redirect:/bienestar/ficha_vivienda_Alumno.htm");
					}
					else
					{
						return new ModelAndView(
								"redirect:/bienestar/actualizar_ficha_vivienda_Alumno.htm");
						
					}
				}
				
				
				
				
				

		// -------------------------------- STEP 4
		// --------------------------------------
		@RequestMapping(value = "/ficha_vivienda_Alumno.htm")
		public ModelAndView fichaservicio4(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Map<String, Object> myModel = new HashMap<String, Object>();
			//myModel.put("listaDepa", this.fichasocialservice.getDeparList());
			myModel.put("listaUbi", this.fichasocialservice.getListaUbicacion());
			myModel.put("listaMat", this.fichasocialservice.getListaMaterial());
			myModel.put("listaTen", this.fichasocialservice.getListaTenencia());
			myModel.put("listaTipo", this.fichasocialservice.getListaTipo());
			myModel.put("listaAgua", this.fichasocialservice.getListaAgua());
			myModel.put("listaServ", this.fichasocialservice.getListaServ());
			myModel.put("listaIlu", this.fichasocialservice.getListaIlumi());
			return new ModelAndView("fichaServicioSocial4", "model", myModel);
		}

		@RequestMapping(value = "/ficha_vivienda_Alumno.htm", method = RequestMethod.POST)
		public ModelAndView registroStep4(
				@RequestParam("rdbpadres") int rdbpadres,
				@RequestParam(value = "motivo", required = false) String motivo,
				@RequestParam(value = "ubicacion", required = false) Long ubicacion,
				@RequestParam(value = "materialConstruccion", required = false) Long materialConstruccion,
				@RequestParam(value = "tenencia", required = false) Long tenencia,
				@RequestParam(value = "tipo", required = false) Long tipo,
				@RequestParam(value = "aguapotable", required = false) Long aguapotable,
				@RequestParam(value = "servicios", required = false) Long servicios,
				@RequestParam(value = "iluminacion", required = false) Long iluminacion,
				Authentication auth,ServicioSocial serviciosocial) {
			TipoVivienda vivienda = new TipoVivienda();
			
			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			if (rdbpadres == 1) // no vive con sus padres
			{
				SvTipo t1 = new SvTipo();
				t1 = fichasocialservice.buscarSvTipo(tipo);

				SvUbicacion u1 = new SvUbicacion();
				u1 = fichasocialservice.buscarSvUbicacion(ubicacion);

				SvAguaPotable ap1 = new SvAguaPotable();
				ap1 = fichasocialservice.buscarSvAguaPotable(aguapotable);

				SvIluminacion il1 = new SvIluminacion();
				il1 = fichasocialservice.buscarSvIluminacion(iluminacion);

				SvMatConstruccion mt1 = new SvMatConstruccion();
				mt1 = fichasocialservice
						.buscarSvMatConstruccion(materialConstruccion);

				SvServiciosHigienico sh1 = new SvServiciosHigienico();
				sh1 = fichasocialservice.buscarSvServiciosHigienico(servicios);

				SvTenencia te1 = new SvTenencia();
				te1 = fichasocialservice.buscarSvTenencia(tenencia);

				vivienda.setSvTipo(t1);
				vivienda.setSvUbicacion(u1);
				vivienda.setSvMatConstruccion(mt1);
				vivienda.setSvTenencia(te1);
				vivienda.setSvIluminacion(il1);
				vivienda.setSvAguaPotable(ap1);
				vivienda.setSvServiciosHigienico(sh1);
				vivienda.setTipo(rdbpadres);

				fichasocialservice.addTipoVivienda(vivienda);

				
				SocVivienda socvivienda = new SocVivienda();
				socvivienda.setEstado(4);
				socvivienda.setObservaciones(motivo);
				socvivienda.setServicioSocial(serviciosocial);
				socvivienda.setTipoVivienda(vivienda);
				fichasocialservice.addSocVivienda(socvivienda);

			} else // vive con sus padres actualiza al estado 2
			{
				Long id = fichasocialservice.Maximo();
				vivienda = fichasocialservice.FindbyTipoVivienda(id);
				vivienda.setTipo(rdbpadres);
				fichasocialservice.updateTipoVivienda(vivienda);
			}

			
			serviciosocial.setEstado(4);
			fichasocialservice.updateServicioSocial(serviciosocial);

			return new ModelAndView(
					"redirect:/bienestar/ficha_situacion_Economica.htm");
		}
		
		
		// --------------------------------- Atras 4	
				@RequestMapping(value = "/actualizar_ficha_vivienda_Alumno.htm")
				public ModelAndView actualizar4(HttpServletRequest request,
						HttpServletResponse response, Authentication auth) throws ServletException, IOException {
					
					String dni = auth.getName();
					Persona p = new Persona();
					p = personaService.findByDni(dni);	
					Perfil perfil = perfilService.findByPerfil(p.getId());
					ServicioSocial serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
					Long contador=fichasocialservice.contadordetalleVivienda(serviciosocial.getId());
					
					if(contador>1)
					{			
					SocVivienda socv=fichasocialservice.buscarSocvivienda4(serviciosocial.getId());					
					SvAguaPotable aguapotable=fichasocialservice.buscarAguaPotable4(p.getId());			
					SvIluminacion iluminacion=fichasocialservice.buscarIlumincacion4(p.getId());
					SvMatConstruccion matcons=fichasocialservice.buscarMateriales4(p.getId());
					SvServiciosHigienico sshh=fichasocialservice.buscarServiciosH4(p.getId());
					SvTenencia tenencia=fichasocialservice.buscarTenecia4(p.getId());
					SvTipo tipo=fichasocialservice.buscarTipo4(p.getId());
					SvUbicacion ubicacion=fichasocialservice.buscarUbicacion4(p.getId());
					
					Map<String, Object> myModel = new HashMap<String, Object>();
					myModel.put("aguapot",aguapotable);
					myModel.put("iluminaciones",iluminacion);
					myModel.put("materialescons",matcons);
					myModel.put("sshhs",sshh);
					myModel.put("tenencias",tenencia);
					myModel.put("tipos",tipo);
					myModel.put("ubicaciones",ubicacion);
					myModel.put("socvs",socv);
					
					
					//myModel.put("listaDepa", this.fichasocialservice.getDeparList());
					myModel.put("listaUbi", this.fichasocialservice.getListaUbicacion());
					myModel.put("listaMat", this.fichasocialservice.getListaMaterial());
					myModel.put("listaTen", this.fichasocialservice.getListaTenencia());
					myModel.put("listaTipo", this.fichasocialservice.getListaTipo());
					myModel.put("listaAgua", this.fichasocialservice.getListaAgua());
					myModel.put("listaServ", this.fichasocialservice.getListaServ());
					myModel.put("listaIlu", this.fichasocialservice.getListaIlumi());

					return new ModelAndView("fichaServicioSocialActualizar4", "model", myModel);
					}
					else
					{
						Map<String, Object> myModel = new HashMap<String, Object>();
						
						
						
					//	myModel.put("listaDepa", this.fichasocialservice.getDeparList());
						myModel.put("listaUbi", this.fichasocialservice.getListaUbicacion());
						myModel.put("listaMat", this.fichasocialservice.getListaMaterial());
						myModel.put("listaTen", this.fichasocialservice.getListaTenencia());
						myModel.put("listaTipo", this.fichasocialservice.getListaTipo());
						myModel.put("listaAgua", this.fichasocialservice.getListaAgua());
						myModel.put("listaServ", this.fichasocialservice.getListaServ());
						myModel.put("listaIlu", this.fichasocialservice.getListaIlumi());
						return new ModelAndView("fichaServicioSocialActualizar4", "model", myModel);}
					
					
				}
				
		
				
				
				// --------------------------------- Actualizar4					
				@RequestMapping(value = "/actualizar_ficha_vivienda_Alumno.htm", method = RequestMethod.POST)
				public ModelAndView processSubmitAct4(
						@RequestParam("rdbpadres") int rdbpadres,
						@RequestParam(value = "motivo", required = false) String motivo,
						@RequestParam(value = "ubicacion", required = false) Long ubicacion,
						@RequestParam(value = "materialConstruccion", required = false) Long materialConstruccion,
						@RequestParam(value = "tenencia", required = false) Long tenencia,
						@RequestParam(value = "tipo", required = false) Long tipo,
						@RequestParam(value = "aguapotable", required = false) Long aguapotable,
						@RequestParam(value = "servicios", required = false) Long servicios,
						@RequestParam(value = "iluminacion", required = false) Long iluminacion,
						Authentication auth,ServicioSocial serviciosocial) {
					
					
					String dni = auth.getName();
					Persona p = new Persona();
					p = personaService.findByDni(dni);
					Perfil perfil = perfilService.findByPerfil(p.getId());
					serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
					if (rdbpadres == 1) // no vive con sus padres
					{
						SvTipo t1 = new SvTipo();
						t1 = fichasocialservice.buscarSvTipo(tipo);
						SvUbicacion u1 = new SvUbicacion();
						u1 = fichasocialservice.buscarSvUbicacion(ubicacion);
						SvAguaPotable ap1 = new SvAguaPotable();
						ap1 = fichasocialservice.buscarSvAguaPotable(aguapotable);
						SvIluminacion il1 = new SvIluminacion();
						il1 = fichasocialservice.buscarSvIluminacion(iluminacion);
						SvMatConstruccion mt1 = new SvMatConstruccion();
						mt1 = fichasocialservice.buscarSvMatConstruccion(materialConstruccion);
						SvServiciosHigienico sh1 = new SvServiciosHigienico();
						sh1 = fichasocialservice.buscarSvServiciosHigienico(servicios);
						SvTenencia te1 = new SvTenencia();
						te1 = fichasocialservice.buscarSvTenencia(tenencia);
						
						
						Long contador=fichasocialservice.contadordetalleVivienda(serviciosocial.getId());
						
								if(contador>1)
								{
									SocVivienda socvivienda=fichasocialservice.buscarSocvivienda4(serviciosocial.getId());
									TipoVivienda vivienda = fichasocialservice.buscarTipovivienda(socvivienda.getId());
									vivienda.setSvTipo(t1);
									vivienda.setSvUbicacion(u1);
									vivienda.setSvMatConstruccion(mt1);
									vivienda.setSvTenencia(te1);
									vivienda.setSvIluminacion(il1);
									vivienda.setSvAguaPotable(ap1);
									vivienda.setSvServiciosHigienico(sh1);
									vivienda.setTipo(rdbpadres);
									fichasocialservice.updateTipoVivienda(vivienda);
									
									socvivienda.setServicioSocial(serviciosocial);
									socvivienda.setTipoVivienda(vivienda);
									socvivienda.setObservaciones(motivo);
									fichasocialservice.updateSocVivienda(socvivienda);
								}
								else
								{
									SocVivienda socvivienda=new SocVivienda();
									TipoVivienda vivienda = new TipoVivienda();
									vivienda.setSvTipo(t1);
									vivienda.setSvUbicacion(u1);
									vivienda.setSvMatConstruccion(mt1);
									vivienda.setSvTenencia(te1);
									vivienda.setSvIluminacion(il1);
									vivienda.setSvAguaPotable(ap1);
									vivienda.setSvServiciosHigienico(sh1);
									vivienda.setTipo(rdbpadres);
									fichasocialservice.addTipoVivienda(vivienda);
									
									TipoVivienda vivienda3=new TipoVivienda();
									vivienda3 = fichasocialservice.buscarTipo3(serviciosocial.getId());
									vivienda3.setTipo(0  );
									fichasocialservice.updateTipoVivienda(vivienda3);
									
									socvivienda.setEstado(4);
									socvivienda.setObservaciones(motivo);
									socvivienda.setServicioSocial(serviciosocial);
									socvivienda.setTipoVivienda(vivienda);
									fichasocialservice.addSocVivienda(socvivienda);
								}	
						

					} else // vive con sus padres actualiza al estado = 2
					{
						
						Long contador=fichasocialservice.contadordetalleVivienda(serviciosocial.getId());
						
						if(contador>1)
						{
							//Long id = fichasocialservice.Maximo();
							//eliminar el detalle con estado 4,y luego su respectivo tipovivienda.... mismo servicio social							
							SocVivienda detalle4= fichasocialservice.buscarSocVdetalle(serviciosocial.getId());
							Long id=detalle4.getId();
							Long socdetalle4tipo=detalle4.getTipoVivienda().getId();
							fichasocialservice.eliminarSocViviendadetalle4(id);
																	
							TipoVivienda viviendaE=new TipoVivienda();
							//viviendaE=fichasocialservice.buscarTipoViviendaid(socdetalle4tipo);
							fichasocialservice.eliminarTipovivienda4(socdetalle4tipo);
							
							
							//actualizar en el  detalle con estado 3....mismo servicio social
							TipoVivienda vivienda=new TipoVivienda();
							vivienda = fichasocialservice.buscarTipo3(serviciosocial.getId());
							vivienda.setTipo(rdbpadres);
							fichasocialservice.updateTipoVivienda(vivienda);
						}
						else
						{						
							//actualizar en el  detalle con estado 3....mismo servicio social
							TipoVivienda vivienda=new TipoVivienda();
							vivienda = fichasocialservice.buscarTipo3(serviciosocial.getId());
							vivienda.setTipo(rdbpadres);
							fichasocialservice.updateTipoVivienda(vivienda);
						}
					}
					
					if(serviciosocial.getEstado()==4)
					{

					return new ModelAndView(
							"redirect:/bienestar/ficha_situacion_Economica.htm");
					}
					else
					{
						return new ModelAndView(
								"redirect:/bienestar/actualizar_ficha_situacion_Economica.htm");
					}
				}
					
				
				
										


		// -------------------------------- STEP
		// 5--------------------------------------
		@RequestMapping(value = "/ficha_situacion_Economica.htm")
		public ModelAndView fichaservicio5(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listaOcupacion",
					this.fichasocialservice.getListaOcupacion());
			myModel.put("listaCondicion",
					this.fichasocialservice.getListaCondicion());
			myModel.put("listaDedicacion",
					this.fichasocialservice.getListaDedicacion());
			myModel.put("listaTrabajo",
					this.fichasocialservice.getListaTurnoTrabajo());
			return new ModelAndView("fichaServicioSocial5", "model", myModel);

		}

		@RequestMapping(value = "/ficha_situacion_Economica.htm", method = RequestMethod.POST)
		public ModelAndView egresos(
				@RequestParam("ocupacionLab") Long ocupacionLab,
				@RequestParam("sscondicion") Long sscondicion,
				@RequestParam("ssdedicacion") Long ssdedicacion,
				@RequestParam("turnotrabajo") Long turnotrabajo,
				@RequestParam("lugar") String lugar,
				@RequestParam("cantpadres") BigDecimal cantpadres,
				@RequestParam("canttrabajo") BigDecimal canttrabajo,
				@RequestParam("cantpension") BigDecimal cantpension,
				@RequestParam("cantabuelos") BigDecimal cantabuelos,
				@RequestParam("cantotros") BigDecimal cantotros,
				@RequestParam("cantepension") BigDecimal cantepension,
				@RequestParam("cantehabitacion") BigDecimal cantehabitacion,
				@RequestParam("cantemovilidad") BigDecimal cantemovilidad,
				@RequestParam("cantealimentacion") BigDecimal cantealimentacion,
				@RequestParam("cantevestimenta") BigDecimal cantevestimenta,
				@RequestParam("canteutiles") BigDecimal canteutiles,				
				Authentication auth,ServicioSocial serviciosocial) {
			
			SseEgreso n = new SseEgreso();
			n.setPensionUniversitaria(cantepension);
			n.setHabitacion(cantehabitacion);
			n.setMovilidad(cantemovilidad);
			n.setAlimentacion(cantealimentacion);
			n.setVestimenta(cantevestimenta);
			n.setUtiles(canteutiles);

			fichasocialservice.addEgresos(n);

			SseIngreso in = new SseIngreso();
			in.setPadres(cantpadres);
			in.setTrabajo(canttrabajo);
			in.setPension(cantpension);
			in.setAbuelos(cantabuelos);
			in.setOtrosParientes(cantotros);

			fichasocialservice.addIngresos(in);

			SocSituacionEconomica situ = new SocSituacionEconomica();

			SseOcupacionLaboral eee = new SseOcupacionLaboral();
			SseCondicion cond = new SseCondicion();
			SseDedicacion ded = new SseDedicacion();
			SseTurnoTrabajo ttrab = new SseTurnoTrabajo();

			eee.setId(ocupacionLab);
			cond.setId(sscondicion);
			ded.setId(ssdedicacion);
			ttrab.setId(turnotrabajo);

			situ.setSseOcupacionLaboral(eee);
			situ.setSseCondicion(cond);
			situ.setSseDedicacion(ded);
			situ.setSseTurnoTrabajo(ttrab);
			situ.setCentroTrabajo(lugar);

			situ.setSseIngreso(in);
			situ.setSseEgreso(n);

			fichasocialservice.addSituacionEconomica(situ);

			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());	
			serviciosocial.setSocSituacionEconomica(situ);
			serviciosocial.setEstado(5);
			fichasocialservice.updateServicioSocial(serviciosocial);

			return new ModelAndView(
					"redirect:/bienestar/ficha_antecedentes_Escolares.htm");
		}
		
		// --------------------------- atras 5-------------------------------------------
		@RequestMapping(value = "/actualizar_ficha_situacion_Economica.htm")
		public ModelAndView Actualizar5(HttpServletRequest request,
				HttpServletResponse response, Authentication auth,ServicioSocial serviciosocial) 
		{
			
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
						
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listaSituacionEconomica",this.fichasocialservice.getListaSituacionEconomica(perfil.getId()));
			
			myModel.put("listaOcupacion",
					this.fichasocialservice.getListaOcupacion());
			myModel.put("listaCondicion",
					this.fichasocialservice.getListaCondicion());
			myModel.put("listaDedicacion",
					this.fichasocialservice.getListaDedicacion());
			myModel.put("listaTrabajo",
					this.fichasocialservice.getListaTurnoTrabajo());
			return new ModelAndView("fichaServicioSocialActualizar5", "model", myModel);
		}
		
		@RequestMapping(value = "/actualizar_ficha_situacion_Economica.htm", method = RequestMethod.POST)
		public ModelAndView ActualizarStep5(@RequestParam("egresos") List<BigDecimal> egre,
				@RequestParam("ingresos") List<BigDecimal> ingresos,
				@RequestParam("situacion") List<Long> sit,
				@RequestParam("lugar") String lugar,
				@RequestParam("IdIngreso") Long IdIngreso,
				@RequestParam("IdEgreso") Long IdEgreso,
				Authentication auth,ServicioSocial serviciosocial) 
		{			
			
			SseIngreso ingreso= this.fichasocialservice.buscarIngreso(IdIngreso);
			ingreso.setPadres(ingresos.get(0));
			ingreso.setTrabajo(ingresos.get(1));
			ingreso.setPension(ingresos.get(2));
			ingreso.setAbuelos(ingresos.get(3));
			ingreso.setOtrosParientes(ingresos.get(4));
			fichasocialservice.updateSseIngreso(ingreso);
			
			SseEgreso egreso= this.fichasocialservice.buscarEgresos(IdEgreso);
			egreso.setPensionUniversitaria(egre.get(0));
			egreso.setHabitacion(egre.get(1));
			egreso.setMovilidad(egre.get(2));
			egreso.setAlimentacion(egre.get(3));
			egreso.setVestimenta(egre.get(4));
			egreso.setUtiles(egre.get(5));
			fichasocialservice.updateSseEgreso(egreso);
			
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());	
						
			
			SocSituacionEconomica economica= new SocSituacionEconomica();
			economica =fichasocialservice.buscarSocSituacionEconomica(serviciosocial.getSocSituacionEconomica().getId());
			
			SseOcupacionLaboral eee = new SseOcupacionLaboral();
			SseCondicion cond = new SseCondicion();
			SseDedicacion ded = new SseDedicacion();
			SseTurnoTrabajo ttrab = new SseTurnoTrabajo();

			eee.setId(sit.get(0));
			cond.setId(sit.get(1));
			ded.setId(sit.get(2));
			ttrab.setId(sit.get(3));

			economica.setSseOcupacionLaboral(eee);
			economica.setSseCondicion(cond);
			economica.setSseDedicacion(ded);
			economica.setSseTurnoTrabajo(ttrab);
			economica.setCentroTrabajo(lugar);
			
			economica.setSseIngreso(ingreso);
			economica.setSseEgreso(egreso);
			
			fichasocialservice.updateSituacionEconomica(economica);	
			
			//serviciosocial.setEstado(5);
			fichasocialservice.updateServicioSocial(serviciosocial);	
			
			if(serviciosocial.getEstado()==5)
			{
			return new ModelAndView(
					"redirect:/bienestar/ficha_antecedentes_Escolares.htm");
			}
			else
			{
				return new ModelAndView(
						"redirect:/bienestar/actualizar_ficha_antecedentes_Escolares.htm");
			}
		}
		

		// -------------------------------- STEP 6
		// --------------------------------------
		@RequestMapping(value = "/ficha_antecedentes_Escolares.htm")
		public ModelAndView fichaservicio6(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listaTipoColegio",
					this.fichasocialservice.getListaColegio());
			myModel.put("listaTurno", this.fichasocialservice.getListaTurno());
			myModel.put("listaEspecialidad",
					this.fichasocialservice.getListaEspecialidad());
			myModel.put("listaFormaIngreso",
					this.fichasocialservice.getListaFormaIngreso());
			return new ModelAndView("fichaServicioSocial6", "model", myModel);

		}

		@ModelAttribute("antecedentesEscolares")
		public SocAntEscolar antEscolar() {
			return new SocAntEscolar();
		}

		@RequestMapping(value = "/ficha_antecedentes_Escolares.htm", method = RequestMethod.POST)
		public ModelAndView processSubmit(
				@RequestParam("saeTipoColegio") Long saeTipoColegio,
				@RequestParam("saeTurno") Long saeTurno,
				@RequestParam("saeEspecializacion") Long saeEspecializacion,
				@RequestParam("colegioTermino") String colegioTermino,
				@RequestParam("numPostulaciones") int numPostulaciones,
				@RequestParam("saeFormaIngreso") Long saeFormaIngreso,
				Authentication auth,ServicioSocial serviciosocial) {

			SocAntEscolar antecedentes= new SocAntEscolar();
			
			SaeTipoColegio tipo = new SaeTipoColegio();
			tipo.setId(saeTipoColegio);
			
			SaeTurno turno= new  SaeTurno();
			turno.setId(saeTurno);
			
			SaeEspecializacion espe= new SaeEspecializacion();
			espe.setId(saeEspecializacion);
			
			SaeFormaIngreso ingreso= new SaeFormaIngreso();
			ingreso.setId(saeFormaIngreso);
			
			antecedentes.setSaeTipoColegio(tipo);
			antecedentes.setSaeTurno(turno);
			antecedentes.setSaeEspecializacion(espe);
			antecedentes.setSaeFormaIngreso(ingreso);
			antecedentes.setColegioTermino(colegioTermino);
			antecedentes.setNumPostulaciones(numPostulaciones);
			
			
			this.fichasocialservice.addAntEscolar(antecedentes);


			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			serviciosocial.setSocAntEscolare(antecedentes);
			serviciosocial.setEstado(6);
			fichasocialservice.updateServicioSocial(serviciosocial);

			return new ModelAndView(
					"redirect:/bienestar/ficha_Salud.htm");
		}

		// --------------------------- atras 6-------------------------------------------
		@RequestMapping(value = "/actualizar_ficha_antecedentes_Escolares.htm")
		public ModelAndView Actualizar6(HttpServletRequest request,
				HttpServletResponse response, Authentication auth,ServicioSocial serviciosocial) 
		{
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listaAntEscolar", this.fichasocialservice.buscarAntEscolar(perfil.getId()));
			myModel.put("listaTipoColegio",
					this.fichasocialservice.getListaColegio());
			myModel.put("listaTurno", this.fichasocialservice.getListaTurno());
			myModel.put("listaEspecialidad",
					this.fichasocialservice.getListaEspecialidad());
			myModel.put("listaFormaIngreso",
					this.fichasocialservice.getListaFormaIngreso());
			return new ModelAndView("fichaServicioSocialActualizar6", "model", myModel);
			
		}
		
		@RequestMapping(value = "/actualizar_ficha_antecedentes_Escolares.htm", method = RequestMethod.POST)
		public ModelAndView ActualizarStep6(@ModelAttribute("antecedentesEscolares") SocAntEscolar antecedentes,
				BindingResult result,Authentication auth,ServicioSocial serviciosocial)
		{
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			
			SocAntEscolar antEscolar= this.fichasocialservice.buscarSocAntEscolar1(perfil.getId());
			antEscolar.setSaeTipoColegio(antecedentes.getSaeTipoColegio());
			antEscolar.setSaeTurno(antecedentes.getSaeTurno());
			antEscolar.setSaeEspecializacion(antecedentes.getSaeEspecializacion());
			antEscolar.setColegioTermino(antecedentes.getColegioTermino());
			antEscolar.setNumPostulaciones(antecedentes.getNumPostulaciones());
			antEscolar.setSaeFormaIngreso(antecedentes.getSaeFormaIngreso());
			
			fichasocialservice.updateSocAntEscolar(antEscolar);
			
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			serviciosocial.setSocAntEscolare(antEscolar);
			//serviciosocial.setEstado(6);
			fichasocialservice.updateServicioSocial(serviciosocial);
			
			if(serviciosocial.getEstado()==6)
			{
			return new ModelAndView(
					"redirect:/bienestar/ficha_Salud.htm");
			}
			else
			{
				return new ModelAndView(
						"redirect:/bienestar/actualizar_ficha_Salud.htm");
			}
		}
		
		
		
		
		
		// -------------------------------- STEP
		// 7--------------------------------------

		@RequestMapping(value = "/ficha_Salud.htm")
		public ModelAndView fichaservicio7(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listaAcudeEm", this.fichasocialservice.getListaAcudeEm());
			myModel.put("listaMotivo", this.fichasocialservice.getListaMotivo());

			return new ModelAndView("fichaServicioSocial7", "model", myModel);
		}

		@ModelAttribute("socSalud")
		public SocSalud socsalud() {
			return new SocSalud();
		}

		@RequestMapping(value = "/ficha_Salud.htm", method = RequestMethod.POST)
		public ModelAndView processSubmit(
				@RequestParam("ssAcudeEnfermedad") Long ssAcudeEnfermedad,
				@RequestParam("ssMotivo") Long ssMotivo,
				Authentication auth,ServicioSocial serviciosocial) {
			
			SsAcudeEnfermedad enfer= new SsAcudeEnfermedad();
			enfer.setId(ssAcudeEnfermedad);
			
			SsMotivo motivo= new SsMotivo();
			motivo.setId(ssMotivo);
			
			SocSalud salud= new SocSalud();
			salud.setSsAcudeEnfermedad(enfer);
			salud.setSsMotivo(motivo);
			this.fichasocialservice.addSocSalud(salud);
			

			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
			serviciosocial.setSocSalud(salud);
			serviciosocial.setEstado(7);
			fichasocialservice.updateServicioSocial(serviciosocial);

			return new ModelAndView(
					"redirect:/bienestar/ficha_alimentacion_Recreacion.htm");
		}

		
		// --------------------------- atras 7-------------------------------------------
				@RequestMapping(value = "/actualizar_ficha_Salud.htm")
				public ModelAndView Actualizar7(HttpServletRequest request,
						HttpServletResponse response, Authentication auth,ServicioSocial serviciosocial) 
				{
					String dni = auth.getName();
					Persona p = new Persona();
					p = personaService.findByDni(dni);
					Perfil perfil = perfilService.findByPerfil(p.getId());
					
					Map<String, Object> myModel = new HashMap<String, Object>();
					myModel.put("listaSalud", this.fichasocialservice.buscarSocSalud(perfil.getId()));
					myModel.put("listaAcudeEm", this.fichasocialservice.getListaAcudeEm());
					myModel.put("listaMotivo", this.fichasocialservice.getListaMotivo());
					return new ModelAndView("fichaServicioSocialActualizar7", "model", myModel);
					
				}
		
				@RequestMapping(value = "/actualizar_ficha_Salud.htm", method = RequestMethod.POST)
				public ModelAndView ActualizarStep7(
						@ModelAttribute("socSalud") SocSalud salud, BindingResult result,Authentication auth,ServicioSocial serviciosocial) 
				{
					String dni = auth.getName();
					Persona p = new Persona();
					p = personaService.findByDni(dni);
					Perfil perfil = perfilService.findByPerfil(p.getId());
					serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());
					
					SocSalud salud2= fichasocialservice.buscarSocSalud(perfil.getId());
					salud2.setSsAcudeEnfermedad(salud.getSsAcudeEnfermedad());
					salud2.setSsMotivo(salud.getSsMotivo());
					fichasocialservice.updateSocSalud(salud2);
													
					if(serviciosocial.getEstado()==7)
					{
						return new ModelAndView(
								"redirect:/bienestar/ficha_alimentacion_Recreacion.htm");
					}
					else
					{
						return new ModelAndView(
								"redirect:/bienestar/actualizar_ficha_alimentacion_Recreacion.htm");
					}
				}
				
		
		// -------------------------------- STEP
		// 8--------------------------------------

		@RequestMapping(value = "/ficha_alimentacion_Recreacion.htm")
		public ModelAndView fichaservicio8(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			return new ModelAndView("fichaServicioSocial8");

		}

		@RequestMapping(value = "/ficha_alimentacion_Recreacion.htm", method = RequestMethod.POST)
		public ModelAndView deportes(
				@RequestParam(value="listaDeportes",required= false) List<String> listaDeportes,
				@RequestParam(value="listaAficiones",required= false) List<String> listaAficiones,
				@RequestParam(value="txtLugarAlimentos",required = false) String LugarAlimentos,
				Authentication auth,ServicioSocial serviciosocial) {
			
			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());						
			
			for (String dep : listaDeportes) {
				SocDeporte deporte= new SocDeporte();
				deporte.setDeporte(dep);
				deporte.setEstado(1);
				deporte.setServicioSocial(serviciosocial);
				fichasocialservice.addSrDeporte(deporte);
			}	
			
			for (String afi : listaAficiones) {
				SocAficion aficion= new SocAficion();
				aficion.setAficion(afi);
				aficion.setEstado(1);
				aficion.setServicioSocial(serviciosocial);
				fichasocialservice.addSrAficion(aficion);
			}		
					
			SocAlimentacion alimentos = new SocAlimentacion();
			alimentos.setAlimentacion(LugarAlimentos);
			fichasocialservice.addSocAlimentacion(alimentos);			
		
			serviciosocial.setSocAlimentacion(alimentos);
			serviciosocial.setEstado(8);
			fichasocialservice.updateServicioSocial(serviciosocial);
			return new ModelAndView(
					"redirect:/bienestar/ficha_domicilio.htm");
		}

		// --------------------------- atras 8-------------------------------------------
		@RequestMapping(value = "/actualizar_ficha_alimentacion_Recreacion.htm")
		public ModelAndView Actualizar8(HttpServletRequest request,
				HttpServletResponse response, Authentication auth,ServicioSocial serviciosocial) 
		{
			String dni = auth.getName();
			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
						
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("listaAlimentacion", this.fichasocialservice.buscarSocAlimentacion(perfil.getId()));
			//myModel.put("listaidSocDeportes", this.fichasocialservice.buscaridSocDeportes(perfil.getId()));
			myModel.put("listaSocDeportes", this.fichasocialservice.buscarSocDeportes(perfil.getId()));
			//myModel.put("listaidSocAficiones", this.fichasocialservice.buscaridSocAficiones(perfil.getId()));
			myModel.put("listaSocAficiones", this.fichasocialservice.buscarSocAficiones(perfil.getId()));
			
			
			return new ModelAndView("fichaServicioSocialActualizar8", "model", myModel);
			
		}
		
		@RequestMapping(value = "/actualizar_ficha_alimentacion_Recreacion.htm", method = RequestMethod.POST)
		public ModelAndView ActualizarStep8(
				@RequestParam(value="listaDeportes",required= false) List<String> listaDeportes,
				@RequestParam(value="listaAficiones",required= false) List<String> listaAficiones,
				@RequestParam(value="txtLugarAlimentos",required = false) String LugarAlimentos,
				Authentication auth,ServicioSocial serviciosocial)
		{
			
			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());	
			 List<Long> idDep = (List<Long>) fichasocialservice.buscaridSocDeportes(serviciosocial.getId());
			 List<Long> idAfic=(List<Long>) fichasocialservice.buscaridSocAficiones(serviciosocial.getId());
			 
			 for (int i=0;i<idDep.size();i++) {			
				 fichasocialservice.eliminarDeportes(idDep.get(i));
			 }
			 
			 for (int i=0;i<idAfic.size();i++) {
				 fichasocialservice.eliminarAficion(idAfic.get(i));
			 }
			
			for (String dep : listaDeportes) {
				SocDeporte deporte= new SocDeporte();
				deporte.setDeporte(dep);
				deporte.setEstado(1);
				deporte.setServicioSocial(serviciosocial);				
				fichasocialservice.addSrDeporte(deporte);
			}	
			
			for (String afi : listaAficiones) {
				SocAficion aficion= new SocAficion();
				aficion.setAficion(afi);
				aficion.setEstado(1);
				aficion.setServicioSocial(serviciosocial);				
				fichasocialservice.addSrAficion(aficion);
			}		
					
			SocAlimentacion alimentos = new SocAlimentacion();
			alimentos.setAlimentacion(LugarAlimentos);
			Long id=fichasocialservice.buscaridSocAlimentacion(serviciosocial.getId());
			alimentos.setId(id);
			fichasocialservice.updateSocAlimentacion(alimentos);			
		
			
			serviciosocial.setSocAlimentacion(alimentos);
			//serviciosocial.setEstado(8);
			fichasocialservice.updateServicioSocial(serviciosocial);
			
			return new ModelAndView(
					"redirect:/bienestar/ficha_domicilio.htm");
			
			
			
		}
		
		
		// -------------------------------- STEP 9
		// --------------------------------------
		@RequestMapping(value = "/ficha_domicilio.htm")
		public ModelAndView fichaservicio9(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Map<String, Object> myModel = new HashMap<String, Object>();
			return new ModelAndView("fichaServicioSocial9", "model", myModel);

		}
		
		
		@RequestMapping(value = "/ficha_domicilio.htm", method = RequestMethod.POST)
		public ModelAndView grabar9(@RequestParam("txtdireccion") String txtdireccion,Authentication auth,ServicioSocial serviciosocial) throws ServletException, IOException 
		{
			SocDiagramaDomicilio domicilo= new SocDiagramaDomicilio();
			domicilo.setUrl(txtdireccion);
			fichasocialservice.addSocDiagramaDomicilo(domicilo);
			

			String dni = auth.getName();

			Persona p = new Persona();
			p = personaService.findByDni(dni);
			Perfil perfil = perfilService.findByPerfil(p.getId());
			serviciosocial=fichasocialservice.buscarServicioSocial(perfil.getId());			
			serviciosocial.setSocDiagramaDomicilio(domicilo);
		    serviciosocial.setEstado(9);
			fichasocialservice.updateServicioSocial(serviciosocial);
			return new ModelAndView(
					"redirect:/bienestar/ficha_servicio_social_final.htm");
		}
		
		// --------------------------------- final ------------------------------------------------
		@RequestMapping(value = "/ficha_servicio_social_final.htm")
		public ModelAndView fichaservicio10(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Map<String, Object> myModel = new HashMap<String, Object>();
			return new ModelAndView("fichaServicioSocialfinal", "model", myModel);

		}
		
		
		  @RequestMapping(value="/ficha_imprimir.htm")
		  public ModelAndView generarDataSourceReport(ModelMap model, 
				  HttpServletResponse response,ModelAndView modelAndView,
				  Authentication auth,HttpServletRequest request)  {
			  
			  	String dni = auth.getName();
			  	String path = request.getSession().getServletContext().getRealPath("/WEB-INF/views/reportes/");
		        Map<String,Object> parameterMap = new HashMap<String,Object>();		        
		        parameterMap.put("dni", dni);
		        parameterMap.put("ROOT_DIR", path);

		        modelAndView = new ModelAndView("dataReport",parameterMap);
		 
		        return modelAndView;
		  }
		
		
		
		
		
		


}
