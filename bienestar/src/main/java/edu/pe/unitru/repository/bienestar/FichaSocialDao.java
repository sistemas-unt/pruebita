package edu.pe.unitru.repository.bienestar;

import java.util.List;

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
import edu.pe.unitru.domain.medico.CfhAccidente;
import edu.pe.unitru.domain.medico.CfhAlergia;
import edu.pe.unitru.domain.medico.CfhEnfermedad;
import edu.pe.unitru.domain.medico.CfhInmunizacion;
import edu.pe.unitru.domain.medico.CfhOperacion;
import edu.pe.unitru.domain.medico.CliFichaHistorial;
import edu.pe.unitru.domain.medico.Clinico;



public interface FichaSocialDao 
{
//	public List<UbigeoReniec> getDeparList();
//	public List<UbigeoReniec> getProvList(UbigeoReniec ubigeo);
		
	// -------------------------- step1----------------------------------------
	public void addcliFichaHistorial(CliFichaHistorial fichaHistorial);
	public void addCfhEnfermedad(CfhEnfermedad enfermedad);
	public void addCfhOperacion(CfhOperacion operacion);
	public void addCfhInmunizacion(CfhInmunizacion inmunizacion);
	public void addCfhAccidente(CfhAccidente accidente);
	public void addCfhAlergia(CfhAlergia alergia);
	public void addClinico(Clinico clinico);

	// -------------------------- step2----------------------------------------
	public void addGrupoFamiliar(GrupoFamiliar familia);
	public List<GrupoFamiliar> getListaFamilia(Long id);
	public void EliminarGrupoFamiliar(Long id);
	
	// -------------------------- step3----------------------------------------
	public List<SvUbicacion> getListaUbicacion();
	public List<SvMatConstruccion> getListaMaterial();
	public List<SvTenencia> getListaTenencia();
	public List<SvTipo> getListaTipo();
	public List<SvAguaPotable> getListaAgua();
	public List<SvServiciosHigienico> getListaServ();
	public List<SvIluminacion> getListaIlumi();
	
	public void addTipoVivienda(TipoVivienda tipovivienda);
	public void addSocVivienda(SocVivienda socvivienda);
	public Long Maximo();
	public TipoVivienda FindbyTipoVivienda(Long id);
	public void updateTipoVivienda(TipoVivienda tipovivienda);
	
	
	// -------------------------- step4----------------------------------------
	public SvTipo buscarSvTipo(Long tipo);
	public SvUbicacion buscarSvUbicacion(Long ubicacion);
	public SvAguaPotable buscarSvAguaPotable(Long agua);
	public SvIluminacion buscarSvIluminacion(Long iluminacion);
	public SvMatConstruccion buscarSvMatConstruccion(Long materiales);
	public SvServiciosHigienico buscarSvServiciosHigienico(Long servicios);
	public SvTenencia buscarSvTenencia(Long tenencia);
	
	
	
	// -------------------------- step5----------------------------------------
	public List<SseOcupacionLaboral> getListaOcupacion();
	public List<SseCondicion> getListaCondicion();
	public List<SseDedicacion> getListaDedicacion();
	public List<SseTurnoTrabajo> getListaTurnoTrabajo();
	
	public void	addEgresos(SseEgreso egreso);
	public void addIngresos(SseIngreso ingreso);
	public void addSituacionEconomica(SocSituacionEconomica economica);
	
	public List<SocSituacionEconomica> getListaSituacionEconomica(Long idperfil);	
	public SseIngreso buscarIngreso(Long id);
	public void updateSseIngreso(SseIngreso ingreso);
	public SseEgreso buscarEgresos(Long id);
	public void updateSseEgreso(SseEgreso egreso);
	public SocSituacionEconomica buscarSocSituacionEconomica(Long id);
	public void updateSituacionEconomica(SocSituacionEconomica situacion);
	
	// -------------------------- step6----------------------------------------
	public List<SaeTipoColegio> getListaColegio();
	public List<SaeTurno> getListaTurno();
	public List<SaeEspecializacion> getListaEspecialidad();
	public List<SaeFormaIngreso> getListaFormaIngreso();
	
	public void addAntEscolar(SocAntEscolar antecedentes);
	
	public List<SocAntEscolar> buscarAntEscolar(Long id);
	
	public SocAntEscolar buscarSocAntEscolar1(Long id);
	public void updateSocAntEscolar(SocAntEscolar escolar);
	
	
	// -------------------------- step7----------------------------------------
	public List<SsAcudeEnfermedad> getListaAcudeEm();
	public List<SsMotivo> getListaMotivo();
	
	public void addSocSalud(SocSalud salud);
	
	public SocSalud buscarSocSalud(Long id);
	public void updateSocSalud(SocSalud salud);
	
	// -------------------------- step8----------------------------------------
	public void addSrDeporte(SocDeporte deporte);
	public void addSrAficion(SocAficion aficion);
	public void addSocAlimentacion(SocAlimentacion alimentacion);
	
	public SocAlimentacion buscarSocAlimentacion(Long id);
	public List<Long> buscaridSocDeportes(Long id);
	public  List<Object[]> buscarSocDeportes(Long id);
	public List<Object[]> buscarSocAficiones(Long id);
	public  List<Long>  buscaridSocAficiones(Long id);
	
	// -------------------------- step9----------------------------------------
	public void addSocDiagramaDomicilo(SocDiagramaDomicilio domicilo);
	
	// -------------------------- Ficha Social----------------------------------------
	public void addServicioSocial(ServicioSocial serviciosocial);
	public void updateServicioSocial(ServicioSocial serviciosocial);
	public ServicioSocial buscarServicioSocial(Long id);
	
	// --------------------------  verificacion de paso----------------------------------------
	public ServicioSocial buscarestado(Long id);
	
	
	// --------------------------  atras1----------------------------------------
	//mostrar datos en vista paso 1
	public CliFichaHistorial buscarFichaHistorial(Long id);
	public CfhAccidente buscarAccidente(Long id);
	public CfhAlergia buscarAlergiae(Long id);
	public CfhEnfermedad buscarEnfermedad(Long id);
	public CfhInmunizacion buscarInmunizacion(Long id);
	public CfhOperacion buscarOperacion(Long id);
	public Clinico buscarClinico(Long id);
	//actualizar datos
	public void updatecliFichaHistorial(CliFichaHistorial fichaHistorial);
	public void updateCfhEnfermedad(CfhEnfermedad enfermedad);
	public void updateCfhOperacion(CfhOperacion operacion);
	public void updateCfhInmunizacion(CfhInmunizacion inmunizacion);
	public void updateCfhAccidente(CfhAccidente accidente);
	public void updateCfhAlergia(CfhAlergia alergia);
	public void updateClinico(Clinico clinico);
	
	
	// --------------------------atras 3----------------------------------------
	//mostrar datos en vista paso 3
		public SvAguaPotable buscarAguaPotable(Long id);
		public SvIluminacion buscarIlumincacion(Long id);
		public SvMatConstruccion buscarMateriales(Long id);
		public SvServiciosHigienico buscarServiciosH(Long id);
		public SvTenencia buscarTenecia(Long id);
		public SvTipo buscarTipo(Long id);
		public SvUbicacion buscarUbicacion(Long id);
		//actualizar datos
		public SocVivienda buscarSocvivienda(Long id);
		public TipoVivienda buscarTipovivienda(Long id);
		public void updateSocVivienda(SocVivienda socvivienda);
		
	// --------------------------atras 4----------------------------------------
		public Long contadordetalleVivienda(Long id);
		//mostrar datos en vista paso 4	
		public SvAguaPotable buscarAguaPotable4(Long id);
		public SvIluminacion buscarIlumincacion4(Long id);
		public SvMatConstruccion buscarMateriales4(Long id);
		public SvServiciosHigienico buscarServiciosH4(Long id);
		public SvTenencia buscarTenecia4(Long id);
		public SvTipo buscarTipo4(Long id);
		public SvUbicacion buscarUbicacion4(Long id);
		public 	SocVivienda buscarSocvivienda4(Long id);
		//actualizar datos
		public 	TipoVivienda buscarTipo3(Long id);
		public 	SocVivienda buscarSocVdetalle(Long id);
		public void eliminarSocViviendadetalle4(Long id);
		//public 	TipoVivienda buscarTipoViviendaid(Long id);
		public void eliminarTipovivienda4(Long id);
		
		//actualizar datos		
				public void eliminarDeportes(Long id);
				public void eliminarAficion(Long id);
				public Long buscaridSocAlimentacion(Long id);
				public void updateSocAlimentacion(SocAlimentacion alimentos);
				
}

