package edu.pe.unitru.service.bienestar.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import edu.pe.unitru.repository.bienestar.FichaSocialDao;
import edu.pe.unitru.service.bienestar.FichaSocialService;

@Service
public class FichaSocialServiceImpl implements FichaSocialService {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FichaSocialDao ubigeoDao;

//	public List<UbigeoReniec> getDeparList() {
//		// TODO Auto-generated method stub
//		return ubigeoDao.getDeparList();
//	}
//
//	public List<UbigeoReniec> getProvList(UbigeoReniec ubigeo) {
//		// TODO Auto-generated method stub
//		return ubigeoDao.getProvList(ubigeo);
//	}

	public List<SvUbicacion> getListaUbicacion() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaUbicacion();
	}

	public List<SvMatConstruccion> getListaMaterial() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaMaterial();
	}

	public List<SvTenencia> getListaTenencia() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaTenencia();
	}

	public List<SvTipo> getListaTipo() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaTipo();
	}

	public List<SvAguaPotable> getListaAgua() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaAgua();
	}

	public List<SvServiciosHigienico> getListaServ() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaServ();
	}

	public List<SvIluminacion> getListaIlumi() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaIlumi();
	}

	// ----------------------------------------------------------
	public List<SseOcupacionLaboral> getListaOcupacion() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaOcupacion();
	}

	public List<SseCondicion> getListaCondicion() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaCondicion();
	}

	public List<SseDedicacion> getListaDedicacion() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaDedicacion();
	}

	public List<SseTurnoTrabajo> getListaTurnoTrabajo() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaTurnoTrabajo();
	}

	// ----------------------------------------------------------
	public List<SaeTipoColegio> getListaColegio() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaColegio();
	}

	public List<SaeTurno> getListaTurno() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaTurno();
	}

	public List<SaeEspecializacion> getListaEspecialidad() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaEspecialidad();
	}

	public List<SaeFormaIngreso> getListaFormaIngreso() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaFormaIngreso();
	}

	// ----------------------------------------------------------
	public List<SsAcudeEnfermedad> getListaAcudeEm() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaAcudeEm();
	}

	public List<SsMotivo> getListaMotivo() {
		// TODO Auto-generated method stub
		return ubigeoDao.getListaMotivo();
	}

	// -------------------------------------------------------------
	public void addTipoVivienda(TipoVivienda tipovivienda) {
		// TODO Auto-generated method stub
		ubigeoDao.addTipoVivienda(tipovivienda);
	}

	public void addAntEscolar(SocAntEscolar antecedentes) {
		// TODO Auto-generated method stub
		ubigeoDao.addAntEscolar(antecedentes);
	}
	
	public void addSocSalud(SocSalud salud){
		// TODO Auto-generated method stub
		ubigeoDao.addSocSalud(salud);
	}
	
	public void	addEgresos(SseEgreso egreso){
		// TODO Auto-generated method stub
		ubigeoDao.addEgresos(egreso);
	}
	
	public void addIngresos(SseIngreso ingreso){
		// TODO Auto-generated method stub
		ubigeoDao.addIngresos(ingreso);
	}
	public void addSituacionEconomica(SocSituacionEconomica economica){
		// TODO Auto-generated method stub
		ubigeoDao.addSituacionEconomica(economica);
	}
	
	// -------------------------- AÑADIR step1----------------------------------------
	public void addcliFichaHistorial(CliFichaHistorial fichaHistorial)
	{
		ubigeoDao.addcliFichaHistorial(fichaHistorial);
	}
	
	public void addCfhEnfermedad(CfhEnfermedad enfermedad)
	{
		ubigeoDao.addCfhEnfermedad(enfermedad);
	}
	
	public void addCfhOperacion(CfhOperacion operacion)
	{
		ubigeoDao.addCfhOperacion(operacion);
	}
	
	public void addCfhInmunizacion(CfhInmunizacion inmunizacion)
	{
		ubigeoDao.addCfhInmunizacion(inmunizacion);
	}
	
	public void addCfhAccidente(CfhAccidente accidente)
	{
		ubigeoDao.addCfhAccidente(accidente);
	}
	
	public void addCfhAlergia(CfhAlergia alergia)
	{
		ubigeoDao.addCfhAlergia(alergia);
	}
	
	public void addClinico(Clinico clinico)
	{
		ubigeoDao.addClinico(clinico);
	}
	
	// -------------------------- AÑADIR STEP2----------------------------------------
		public void addGrupoFamiliar(GrupoFamiliar familia) {
			// TODO Auto-generated method stub
			ubigeoDao.addGrupoFamiliar(familia);
		}

		public List<GrupoFamiliar> getListaFamilia(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.getListaFamilia(id);
		}
		
	// -------------------------- AÑADIR STEP3----------------------------------------
		public void addSocVivienda(SocVivienda socvivienda)	{
			// TODO Auto-generated method stub
			ubigeoDao.addSocVivienda(socvivienda);
		}
		
		public Long Maximo() {
			// TODO Auto-generated method stub
			return ubigeoDao.Maximo();
		}

		public TipoVivienda FindbyTipoVivienda(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.FindbyTipoVivienda(id);
		}
		
		public void updateTipoVivienda(TipoVivienda tipovivienda) {
			// TODO Auto-generated method stub
			ubigeoDao.updateTipoVivienda(tipovivienda);
		}	
		
		
		
		// -------------------------- step4----------------------------------------
		public SvTipo buscarSvTipo(Long tipo)
		{
			return ubigeoDao.buscarSvTipo(tipo);
		}
		
		public SvUbicacion buscarSvUbicacion(Long ubicacion){
			return ubigeoDao.buscarSvUbicacion(ubicacion);
		}
		
		public SvAguaPotable buscarSvAguaPotable(Long agua){
			return ubigeoDao.buscarSvAguaPotable(agua);
		}
		
		public SvIluminacion buscarSvIluminacion(Long iluminacion){
			return ubigeoDao.buscarSvIluminacion(iluminacion);
		}
		
		public SvMatConstruccion buscarSvMatConstruccion(Long materiales){
			return ubigeoDao.buscarSvMatConstruccion(materiales);
		}
		
		public SvServiciosHigienico buscarSvServiciosHigienico(Long servicios){
			return ubigeoDao.buscarSvServiciosHigienico(servicios);
		}
		
		public SvTenencia buscarSvTenencia(Long tenencia){
			return ubigeoDao.buscarSvTenencia(tenencia);
		}
		
		
		
		// -------------------------- step8----------------------------------------
		public void addSrDeporte(SocDeporte deporte)
		{
			// TODO Auto-generated method stub
			ubigeoDao.addSrDeporte(deporte);
		}
		
		
		public void addSrAficion(SocAficion aficion)
		{
			// TODO Auto-generated method stub
			 ubigeoDao.addSrAficion(aficion);
		}
	
		public void addSocAlimentacion(SocAlimentacion alimentacion) {
			// TODO Auto-generated method stub
			ubigeoDao.addSocAlimentacion(alimentacion);
		}

		
		
	// -------------------------- step9----------------------------------------
		public void addSocDiagramaDomicilo(SocDiagramaDomicilio domicilo) {
			// TODO Auto-generated method stub
			ubigeoDao.addSocDiagramaDomicilo(domicilo);
		}
		
	// -------------------------- Ficha Social----------------------------------------
		public void addServicioSocial(ServicioSocial serviciosocial) {
			// TODO Auto-generated method stub
			ubigeoDao.addServicioSocial(serviciosocial);
		}

		public void updateServicioSocial(ServicioSocial serviciosocial) {
			// TODO Auto-generated method stub
			ubigeoDao.updateServicioSocial(serviciosocial);
		}

		public ServicioSocial buscarServicioSocial(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarServicioSocial(id);
		}

		public ServicioSocial buscarestado(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarestado(id);
		}

		// --------------------------atras 1----------------------------------------
		public CfhAccidente buscarAccidente(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarAccidente(id);
		}

		public CfhAlergia buscarAlergiae(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarAlergiae(id);
		}

		public CfhEnfermedad buscarEnfermedad(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarEnfermedad(id);
		}

		public CfhInmunizacion buscarInmunizacion(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarInmunizacion(id);
		}

		public CfhOperacion buscarOperacion(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarOperacion(id);
		}

		public CliFichaHistorial buscarFichaHistorial(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarFichaHistorial(id);
		}
		
		public Clinico buscarClinico(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarClinico(id);
		}

		
		public void updatecliFichaHistorial(CliFichaHistorial fichaHistorial) {
			// TODO Auto-generated method stub
			ubigeoDao.updatecliFichaHistorial(fichaHistorial);
		}

		public void updateCfhEnfermedad(CfhEnfermedad enfermedad) {
			// TODO Auto-generated method stub
			ubigeoDao.updateCfhEnfermedad(enfermedad);
		}

		public void updateCfhOperacion(CfhOperacion operacion) {
			// TODO Auto-generated method stub
			ubigeoDao.updateCfhOperacion(operacion);
		}

		public void updateCfhInmunizacion(CfhInmunizacion inmunizacion) {
			// TODO Auto-generated method stub
			ubigeoDao.updateCfhInmunizacion(inmunizacion);
		}

		public void updateCfhAccidente(CfhAccidente accidente) {
			// TODO Auto-generated method stub
			ubigeoDao.updateCfhAccidente(accidente);
		}

		public void updateCfhAlergia(CfhAlergia alergia) {
			// TODO Auto-generated method stub
			ubigeoDao.updateCfhAlergia(alergia);
		}

		public void updateClinico(Clinico clinico) {
			// TODO Auto-generated method stub
			ubigeoDao.updateClinico(clinico);
		}

		public SvAguaPotable buscarAguaPotable(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarAguaPotable(id);
		}

		public SvIluminacion buscarIlumincacion(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarIlumincacion(id);
		}

		public SvMatConstruccion buscarMateriales(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarMateriales(id);
		}

		public SvServiciosHigienico buscarServiciosH(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarServiciosH(id);
		}

		public SvTenencia buscarTenecia(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarTenecia(id);
		}

		public SvTipo buscarTipo(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarTipo(id);
		}

		public SvUbicacion buscarUbicacion(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarUbicacion(id);
		}

		public SocVivienda buscarSocvivienda(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocvivienda(id);
		}

		public TipoVivienda buscarTipovivienda(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarTipovivienda(id);
		}

		public void updateSocVivienda(SocVivienda socvivienda) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSocVivienda(socvivienda);
			
		}

		public void EliminarGrupoFamiliar(Long id) {
			// TODO Auto-generated method stub
			ubigeoDao.EliminarGrupoFamiliar(id);
		}

		
		
		public List<SocSituacionEconomica> getListaSituacionEconomica(
				Long idperfil) {
			// TODO Auto-generated method stub
			return ubigeoDao.getListaSituacionEconomica(idperfil);
		}

		public SseIngreso buscarIngreso(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarIngreso(id);
		}

		public void updateSseIngreso(SseIngreso ingreso) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSseIngreso(ingreso);
		}

		public SseEgreso buscarEgresos(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarEgresos(id);
		}

		public void updateSseEgreso(SseEgreso egreso) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSseEgreso(egreso);
		}

		public SocSituacionEconomica buscarSocSituacionEconomica(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocSituacionEconomica(id);
		}

		public void updateSituacionEconomica(SocSituacionEconomica situacion) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSituacionEconomica(situacion);
		}

		public List<SocAntEscolar> buscarAntEscolar(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarAntEscolar(id);
		}

		public SocAntEscolar buscarSocAntEscolar1(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocAntEscolar1(id);
		}

		public void updateSocAntEscolar(SocAntEscolar escolar) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSocAntEscolar(escolar);
		}


		public SocSalud buscarSocSalud(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocSalud(id);
		}
		public Long contadordetalleVivienda(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.contadordetalleVivienda(id);
		}



		public void updateSocSalud(SocSalud salud) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSocSalud(salud);
		}

		public SocAlimentacion buscarSocAlimentacion(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocAlimentacion(id);
		}

		public  List<Object[]> buscarSocDeportes(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocDeportes(id);
		}
		
		public  List<Object[]> buscarSocAficiones(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocAficiones(id);
		}

		public List<Long> buscaridSocDeportes(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscaridSocDeportes(id);
		}

		public  List<Long> buscaridSocAficiones(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscaridSocAficiones(id);
		}


		//---paso4 MOSTRAR DATOS
		public SvAguaPotable buscarAguaPotable4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarAguaPotable4(id);
		}

		public SvIluminacion buscarIlumincacion4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarIlumincacion4(id);
		}

		public SvMatConstruccion buscarMateriales4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarMateriales4(id);
		}

		public SvServiciosHigienico buscarServiciosH4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarServiciosH4(id);
		}

		public SvTenencia buscarTenecia4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarTenecia4(id);
		}

		public SvTipo buscarTipo4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarTipo4(id);
		}

		public SvUbicacion buscarUbicacion4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarUbicacion4(id);
		}

		public SocVivienda buscarSocvivienda4(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocvivienda4(id);
		}

		public TipoVivienda buscarTipo3(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarTipo3(id);
		}

		public SocVivienda buscarSocVdetalle(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscarSocVdetalle(id);
		}

		public void eliminarSocViviendadetalle4(Long id) {
			// TODO Auto-generated method stub
			ubigeoDao.eliminarSocViviendadetalle4(id);
		}

//		public TipoVivienda buscarTipoViviendaid(Long id) {
//			// TODO Auto-generated method stub
//			return ubigeoDao.buscarTipoViviendaid(id);
//		}

		public void eliminarTipovivienda4(Long id) {
			// TODO Auto-generated method stub
			ubigeoDao.eliminarTipovivienda4(id);
		}

		public void eliminarDeportes(Long id) {
			// TODO Auto-generated method stub
			ubigeoDao.eliminarDeportes(id);
		}

		public void eliminarAficion(Long id) {
			// TODO Auto-generated method stub
			ubigeoDao.eliminarAficion(id);
			
		}

		public Long buscaridSocAlimentacion(Long id) {
			// TODO Auto-generated method stub
			return ubigeoDao.buscaridSocAlimentacion(id);
		}

		public void updateSocAlimentacion(SocAlimentacion alimentos) {
			// TODO Auto-generated method stub
			ubigeoDao.updateSocAlimentacion(alimentos);
		}



}
