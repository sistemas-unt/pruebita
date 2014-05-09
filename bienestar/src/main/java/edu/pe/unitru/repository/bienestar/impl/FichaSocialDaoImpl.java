package edu.pe.unitru.repository.bienestar.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

@Repository(value = "ubigeoDao")
public class FichaSocialDaoImpl implements FichaSocialDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
//	//SAMUEL
//	@Transactional(readOnly = true)
//	@SuppressWarnings("unchecked")
//	public List<UbigeoReniec> getDeparList() {
//		// TODO Auto-generated method stub
//		return em.createQuery("SELECT u FROM Ubigeo u WHERE u.provincia = 0 AND u.distrito = 0 ").getResultList();
//	}
	
//	@Transactional(readOnly = true)
//	@SuppressWarnings("unchecked")
//	public List<UbigeoReniec> getProvList(UbigeoReniec ubigeo) {
//		// TODO Auto-generated method stub
//		return em.createQuery("select u.nombre from Ubigeo u where u.departamento="+ubigeo.getDepartamento()
//						+" and u.distrito=0 and u.provincia<>0").getResultList();
//	}
//	
//	@Transactional(readOnly = true)
//	@SuppressWarnings("unchecked")
//	public List<UbigeoReniec> getDistList() {
//		// TODO Auto-generated method stub
//		return em.createQuery("select distinct u from Ubigeo u").getResultList();
//	}
	
	//-------------------------------------------------------------------------
	
//	@Transactional(readOnly = true)
//	@SuppressWarnings("unchecked")
//	public List<UbigeoReniec> getDeparList2() {
//		// TODO Auto-generated method stub
//		return em.createQuery("select distinct u from Ubigeo u").getResultList();
//	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvUbicacion> getListaUbicacion() {
		// TODO Auto-generated method stub
		return em.createQuery("select su from SvUbicacion su").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvMatConstruccion> getListaMaterial() {
		// TODO Auto-generated method stub
		return em.createQuery("select sm from SvMatConstruccion sm").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvTenencia> getListaTenencia(){
		// TODO Auto-generated method stub
		return em.createQuery("select st from SvTenencia st").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvTipo> getListaTipo(){
		// TODO Auto-generated method stub
		return em.createQuery(" select st from SvTipo st").getResultList(); 
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvAguaPotable> getListaAgua(){
		// TODO Auto-generated method stub
		return em.createQuery("  select sa from SvAguaPotable sa").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvServiciosHigienico> getListaServ(){
		// TODO Auto-generated method stub
		return em.createQuery("select ss from SvServiciosHigienico ss").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SvIluminacion> getListaIlumi(){
		// TODO Auto-generated method stub
		return em.createQuery("select si from SvIluminacion si").getResultList();
	}
		
	
	// ---------------------------------------------------------------------------------
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SseOcupacionLaboral> getListaOcupacion(){
		// TODO Auto-generated method stub
				return em.createQuery("select se from SseOcupacionLaboral se").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SseCondicion> getListaCondicion(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SseCondicion sc").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SseDedicacion> getListaDedicacion(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SseDedicacion sc").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SseTurnoTrabajo> getListaTurnoTrabajo(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SseTurnoTrabajo sc").getResultList();
	}
	
	// ---------------------------------------------------------------------------------
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SaeTipoColegio> getListaColegio(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SaeTipoColegio sc").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SaeTurno> getListaTurno(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SaeTurno sc").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SaeEspecializacion> getListaEspecialidad(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SaeEspecializacion sc").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SaeFormaIngreso> getListaFormaIngreso(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SaeFormaIngreso sc").getResultList();
	}
	
	// ---------------------------------------------------------------------------------
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SsAcudeEnfermedad> getListaAcudeEm(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SsAcudeEnfermedad sc").getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SsMotivo> getListaMotivo(){
		// TODO Auto-generated method stub
		return em.createQuery("select sc from SsMotivo sc").getResultList();
	}
	
	//-------------------------------- METODOS PARA AÑADIR--------------------------------------------------
		
	@Transactional(readOnly = false)
	public void addAntEscolar(SocAntEscolar antecedentes){
		// TODO Auto-generated method stub
		em.persist(antecedentes);
	}
	
	@Transactional(readOnly = false)
	public void addSocSalud(SocSalud salud){
		// TODO Auto-generated method stub
		em.persist(salud);
	}
	
	@Transactional(readOnly = false)
	public void	addEgresos(SseEgreso egreso){
		// TODO Auto-generated method stub
		em.persist(egreso);
	}
	
	@Transactional(readOnly = false)
	public void addIngresos(SseIngreso ingreso){
		// TODO Auto-generated method stub
		em.persist(ingreso);
	}
	
	@Transactional(readOnly = false)
	public void addSituacionEconomica(SocSituacionEconomica economica){
		// TODO Auto-generated method stub
		em.persist(economica);
	}
	
	// -------------------------- AÑADIR step1----------------------------------------
	@Transactional(readOnly = false)
	public void addcliFichaHistorial(CliFichaHistorial fichaHistorial)
	{
		em.persist(fichaHistorial);
	}
	
	@Transactional(readOnly = false)
	public void addCfhEnfermedad(CfhEnfermedad enfermedad)
	{
		em.persist(enfermedad);
	}
	
	@Transactional(readOnly = false)
	public void addCfhOperacion(CfhOperacion operacion)
	{
		em.persist(operacion);
	}
	
	@Transactional(readOnly = false)
	public void addCfhInmunizacion(CfhInmunizacion inmunizacion)
	{
		em.persist(inmunizacion);
	}
	
	@Transactional(readOnly = false)
	public void addCfhAccidente(CfhAccidente accidente)
	{
		em.persist(accidente);
	}
	
	@Transactional(readOnly = false)
	public void addCfhAlergia(CfhAlergia alergia)
	{
		em.persist(alergia);
	}
	
	@Transactional(readOnly = false)
	public void addClinico(Clinico clinico)
	{
		em.persist(clinico);
	}
	
	// -------------------------- AÑADIR step2----------------------------------------
	@Transactional(readOnly = false)	
	public void addGrupoFamiliar(GrupoFamiliar familia) {
			// TODO Auto-generated method stub
			em.persist(familia);
		}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<GrupoFamiliar> getListaFamilia(Long id) {
		// TODO Auto-generated method stub 
		return em.createQuery("select sc from GrupoFamiliar sc where sc.persona.id="+id).getResultList();
	}	

	@Transactional
	public void EliminarGrupoFamiliar(Long id) {
		 GrupoFamiliar familiar = em.find(GrupoFamiliar.class,id );
		  em.remove(familiar);
	}

	// -------------------------- AÑADIR step3----------------------------------------
	@Transactional(readOnly = false)
	public void addTipoVivienda(TipoVivienda tipovivienda) {
		// TODO Auto-generated method stub
		em.persist(tipovivienda);
	}
	
	@Transactional(readOnly = false)
	public void addSocVivienda(SocVivienda socvivienda){
		// TODO Auto-generated method stub
		em.persist(socvivienda);
	}
	
	public Long Maximo() {
		// TODO Auto-generated method stub
		return (Long)em.createQuery("select  max(t.id) from TipoVivienda t ").getSingleResult();
	}

	public TipoVivienda FindbyTipoVivienda(Long id) {
		// TODO Auto-generated method stub
		return (TipoVivienda)em.createQuery("select t from TipoVivienda  t where t.id="+id).getSingleResult();
	}
	
	@Transactional(readOnly = false)
	public void updateTipoVivienda(TipoVivienda tipovivienda) {
		// TODO Auto-generated method stub
		em.merge(tipovivienda);
	}

	
	
	//-------------------------- AÑADIR step4----------------------------------------
	@Transactional(readOnly = true)
	public SvTipo buscarSvTipo(Long tipo)
	{
		
		return (SvTipo) em.createQuery("select st from SvTipo st where st.id="+tipo).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public SvUbicacion buscarSvUbicacion(Long ubicacion)
	{
		return (SvUbicacion) em.createQuery("select su from SvUbicacion su where su.id="+ubicacion).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public SvAguaPotable buscarSvAguaPotable(Long agua)
	{
		return (SvAguaPotable) em.createQuery("select sa from SvAguaPotable sa where sa.id="+agua).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public SvIluminacion buscarSvIluminacion(Long iluminacion)
	{
		return (SvIluminacion) em.createQuery("select sil from SvIluminacion sil where sil.id="+iluminacion).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public SvMatConstruccion buscarSvMatConstruccion(Long materiales)
	{
		return (SvMatConstruccion) em.createQuery("select smat from SvMatConstruccion smat where smat.id="+materiales).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public SvServiciosHigienico buscarSvServiciosHigienico(Long servicios)
	{
		return (SvServiciosHigienico) em.createQuery("select ser from SvServiciosHigienico ser where ser.id="+servicios).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public SvTenencia buscarSvTenencia(Long tenencia)
	{
		return (SvTenencia) em.createQuery("select sten from SvTenencia sten where sten.id="+tenencia).getSingleResult();
	}
	
	
	
	// -------------------------- AÑADIR step8----------------------------------------
	
	@Transactional(readOnly = false)
	public void addSrDeporte(SocDeporte deporte){
		em.persist(deporte);
	}
	
	@Transactional(readOnly = false)
	public void addSrAficion(SocAficion aficion)
	{
		em.persist(aficion);
	}
	
	@Transactional(readOnly = false)
	public void addSocAlimentacion(SocAlimentacion alimentacion) {
		// TODO Auto-generated method stub
		em.persist(alimentacion);
	}

	// -------------------------- step9----------------------------------------
	@Transactional(readOnly = false)
	public void addSocDiagramaDomicilo(SocDiagramaDomicilio domicilo) {
		// TODO Auto-generated method stub
		em.persist(domicilo);
	}
	// -------------------------- Ficha Social----------------------------------------
	@Transactional(readOnly = false)
	public void addServicioSocial(ServicioSocial serviciosocial) {
		// TODO Auto-generated method stub
		em.persist(serviciosocial);
		
	}

	@Transactional(readOnly = false)
	public void updateServicioSocial(ServicioSocial serviciosocial) {
		em.merge(serviciosocial);
	}

	public ServicioSocial buscarServicioSocial(Long id) {
		// TODO Auto-generated method stub
		return (ServicioSocial) em.createQuery("Select s from ServicioSocial s where s.perfil.id="+id).getSingleResult();		
	}

	public ServicioSocial buscarestado(Long id) {
		// TODO Auto-generated method stub
		
			try{
			return (ServicioSocial) em.createQuery("Select s from ServicioSocial s where s.perfil.id="+id).getSingleResult();
			} catch (NoResultException e)
			{
			return null;
			}
	}

	public CfhAccidente buscarAccidente(Long id) {
		// TODO Auto-generated method stub
		return (CfhAccidente) em.createQuery("Select ca"
				+ "								from Clinico c,CfhAccidente ca "
				+ "								inner join c.persona per "
				+ "								inner join c.cliFichaHistorial cfh "
				+ "								inner join ca.cliFichaHistorial cacfh"
				+ "								where ca.cliFichaHistorial=c.cliFichaHistorial and c.persona.id="+id).getSingleResult();
	}

	public CfhAlergia buscarAlergiae(Long id) {
		// TODO Auto-generated method stub
		return (CfhAlergia) em.createQuery("select cal "
				+ "from Clinico c,CfhAlergia cal "
				+ "inner join c.persona per "
				+ "inner join c.cliFichaHistorial cfh"
				+ " inner join cal.cliFichaHistorial cacfh"
				+ " where cal.cliFichaHistorial=c.cliFichaHistorial and c.persona.id="+id).getSingleResult();
	}

	public CfhEnfermedad buscarEnfermedad(Long id) {
		// TODO Auto-generated method stub
		return (CfhEnfermedad) em.createQuery("select enf "
				+ "from Clinico c,CfhEnfermedad enf "
				+ "inner join c.persona per "
				+ "inner join c.cliFichaHistorial cfh"
				+ " inner join enf.cliFichaHistorial cacfh"
				+ " where enf.cliFichaHistorial=c.cliFichaHistorial and c.persona.id="+id).getSingleResult();
	}

	public CfhInmunizacion buscarInmunizacion(Long id) {
		// TODO Auto-generated method stub
		return (CfhInmunizacion) em.createQuery("select inm "
				+ "from Clinico c,CfhInmunizacion inm "
				+ "inner join c.persona per "
				+ "inner join c.cliFichaHistorial cfh"
				+ " inner join inm.cliFichaHistorial cacfh"
				+ " where inm.cliFichaHistorial=c.cliFichaHistorial and c.persona.id="+id).getSingleResult();
	}

	
	public CfhOperacion buscarOperacion(Long id) {
		// TODO Auto-generated method stub
		return (CfhOperacion) em.createQuery("select op "
				+ "from Clinico c,CfhOperacion op "
				+ "inner join c.persona per "
				+ "inner join c.cliFichaHistorial cfh"
				+ " inner join op.cliFichaHistorial cacfh"
				+ " where op.cliFichaHistorial=c.cliFichaHistorial and c.persona.id="+id).getSingleResult();
	}

	public CliFichaHistorial buscarFichaHistorial(Long id) {
		// TODO Auto-generated method stub
		return (CliFichaHistorial) em.createQuery("select cfh "
				+ "from Clinico c "
				+ "inner join c.persona per "
				+ "inner join c.cliFichaHistorial cfh "
				+ "where c.persona.id="+id).getSingleResult();
	}

	public Clinico buscarClinico(Long id) {
		// TODO Auto-generated method stub
		return (Clinico) em.createQuery("select c "
				+ "from Clinico c "
				+ "inner join c.persona "
				+ "	where c.persona.id="+id).getSingleResult();
	}

	
	
	
	@Transactional(readOnly = false)
	public void updatecliFichaHistorial(CliFichaHistorial fichaHistorial) {
		// TODO Auto-generated method stub
		em.merge(fichaHistorial);
	}
	
	
	@Transactional(readOnly = false)
	public void updateCfhEnfermedad(CfhEnfermedad enfermedad) {
		// TODO Auto-generated method stub
		em.merge(enfermedad);
	}

	
	@Transactional(readOnly = false)
	public void updateCfhOperacion(CfhOperacion operacion) {
		// TODO Auto-generated method stub
		em.merge(operacion);
	}

	
	@Transactional(readOnly = false)
	public void updateCfhInmunizacion(CfhInmunizacion inmunizacion) {
		// TODO Auto-generated method stub
		em.merge(inmunizacion);
	}

	@Transactional(readOnly = false)
	public void updateCfhAccidente(CfhAccidente accidente) {
		// TODO Auto-generated method stub
		em.merge(accidente);
	}

	@Transactional(readOnly = false)
	public void updateCfhAlergia(CfhAlergia alergia) {
		// TODO Auto-generated method stub
		em.merge(alergia);
	}

	@Transactional(readOnly = false)
	public void updateClinico(Clinico clinico) {
		// TODO Auto-generated method stub
		em.merge(clinico);
	}

	

	public SvAguaPotable buscarAguaPotable(Long id) {
		// TODO Auto-generated method stub
		return (SvAguaPotable) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svAguaPotable mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}
	
	public SvIluminacion buscarIlumincacion(Long id) {
		// TODO Auto-generated method stub
		return (SvIluminacion) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svIluminacion mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}

	public SvMatConstruccion buscarMateriales(Long id) {
		// TODO Auto-generated method stub
		return (SvMatConstruccion) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svMatConstruccion mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}

	public SvServiciosHigienico buscarServiciosH(Long id) {
		// TODO Auto-generated method stub
		return (SvServiciosHigienico) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svServiciosHigienico mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}

	public SvTenencia buscarTenecia(Long id) {
		// TODO Auto-generated method stub
		return (SvTenencia) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svTenencia mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}

	public SvTipo buscarTipo(Long id) {
		// TODO Auto-generated method stub
		return (SvTipo) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svTipo mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}

	public SvUbicacion buscarUbicacion(Long id) {
		// TODO Auto-generated method stub
		return (SvUbicacion) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svUbicacion mc "
				+ "where socv.estado=3 and persona.id="+id).getSingleResult();
	}

	public SocVivienda buscarSocvivienda(Long id) {
		// TODO Auto-generated method stub
		return (SocVivienda) em.createQuery("select socv "
				+ "from SocVivienda socv "
				+ "where socv.estado=3 and socv.servicioSocial="+id).getSingleResult();
	}

	public TipoVivienda buscarTipovivienda(Long id) {
		// TODO Auto-generated method stub
		return (TipoVivienda) em.createQuery("select tv "
				+ "from SocVivienda socv "
				+ "inner join socv.tipoVivienda tv "
				+ "where socv.id="+id).getSingleResult();
	}

	@Transactional
	public void updateSocVivienda(SocVivienda socvivienda) {
		// TODO Auto-generated method stub
		em.merge(socvivienda);
		
		
	}

	
	// --------------------------------- atras Step5 -----------------------------------------------
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SocSituacionEconomica> getListaSituacionEconomica(Long idperfil) {
		// TODO Auto-generated method stub
		return em.createQuery("select s.sseOcupacionLaboral.id,s.sseCondicion.id,s.sseDedicacion.id,"
				+ "s.sseTurnoTrabajo.id,s.centroTrabajo,s.sseIngreso.padres,s.sseIngreso.trabajo,s.sseIngreso.pension,"
				+ "s.sseIngreso.abuelos,s.sseIngreso.otrosParientes,s.sseEgreso.pensionUniversitaria,"
				+ " s.sseEgreso.habitacion,s.sseEgreso.movilidad,s.sseEgreso.alimentacion,"
				+ " s.sseEgreso.vestimenta,s.sseEgreso.utiles,s.sseIngreso.id,"
				+ " s.sseEgreso.id from ServicioSocial ss inner join ss.socSituacionEconomica s  where ss.perfil="+idperfil).getResultList();
	}

	
	public SseIngreso buscarIngreso(Long id) {
		// TODO Auto-generated method stub
		return (SseIngreso) em.createQuery("select i from SseIngreso i where i.id="+id).getSingleResult();
	}

	@Transactional(readOnly = false)
	public void updateSseIngreso(SseIngreso ingreso) {
		// TODO Auto-generated method stub
		em.merge(ingreso);
	}

	public SseEgreso buscarEgresos(Long id) {
		// TODO Auto-generated method stub
		return (SseEgreso) em.createQuery("select e from SseEgreso e where e.id="+id).getSingleResult();
	}

	@Transactional(readOnly = false)
	public void updateSseEgreso(SseEgreso egreso) {
		// TODO Auto-generated method stub
		em.merge(egreso);
	}

	public SocSituacionEconomica buscarSocSituacionEconomica(Long id) {
		// TODO Auto-generated method stub
		return (SocSituacionEconomica)em.createQuery("select e from SocSituacionEconomica e where e.id="+id).getSingleResult();
	}

	@Transactional(readOnly = false)
	public void updateSituacionEconomica(SocSituacionEconomica situacion) {
		// TODO Auto-generated method stub
		em.merge(situacion);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<SocAntEscolar> buscarAntEscolar(Long id) {
		// TODO Auto-generated method stub
		return  em.createQuery("select a.saeTipoColegio.id,a.saeTurno.id,a.saeEspecializacion.id,"
				+ " a.colegioTermino,a.numPostulaciones,a.saeFormaIngreso.id from ServicioSocial s inner join"
				+ " s.socAntEscolare a where s.perfil.id="+id).getResultList();
	}

	@Transactional(readOnly = true)
	public SocAntEscolar buscarSocAntEscolar1(Long id) {
		// TODO Auto-generated method stub
		return (SocAntEscolar)em.createQuery("select a from ServicioSocial s inner join "
				+ "s.socAntEscolare a where s.perfil.id="+id).getSingleResult();
	}

	@Transactional(readOnly = false)
	public void updateSocAntEscolar(SocAntEscolar escolar) {
		// TODO Auto-generated method stub
		em.merge(escolar);
	}


	public SocSalud buscarSocSalud(Long id) {
		// TODO Auto-generated method stub
		return (SocSalud)em.createQuery("select ss from ServicioSocial s inner join s.socSalud ss where s.perfil.id="+id).getSingleResult();
	}
			
	@Transactional(readOnly = false)
	public void updateSocSalud(SocSalud salud)
	{
		em.merge(salud);
	}



	public Long contadordetalleVivienda(Long id) {
		// TODO Auto-generated method stub
		return (Long) em.createQuery("select count(*) from SocVivienda socv where socv.servicioSocial="+id).getSingleResult();
	}

	public SvAguaPotable buscarAguaPotable4(Long id) {
		// TODO Auto-generated method stub
		return (SvAguaPotable) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svAguaPotable mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult(); 
	}

	public SvIluminacion buscarIlumincacion4(Long id) {
		// TODO Auto-generated method stub
		return (SvIluminacion) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svIluminacion mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult();
	}

	public SvMatConstruccion buscarMateriales4(Long id) {
		// TODO Auto-generated method stub
		return (SvMatConstruccion) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svMatConstruccion mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult();
	}

	public SvServiciosHigienico buscarServiciosH4(Long id) {
		// TODO Auto-generated method stub
		return (SvServiciosHigienico) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svServiciosHigienico mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult();
	}

	public SvTenencia buscarTenecia4(Long id) {
		// TODO Auto-generated method stub
		return (SvTenencia) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svTenencia mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult();
	}

	public SvTipo buscarTipo4(Long id) {
		// TODO Auto-generated method stub
		return (SvTipo) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svTipo mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult();
	}

	public SvUbicacion buscarUbicacion4(Long id) {
		// TODO Auto-generated method stub
		return (SvUbicacion) em.createQuery("select mc "
				+ "from SocVivienda socv "
				+ "inner join socv.servicioSocial servicios "
				+ "inner join servicios.perfil perfil "
				+ "inner join perfil.persona persona "
				+ "inner join socv.tipoVivienda tipovivienda "
				+ "inner join tipovivienda.svUbicacion mc "
				+ "where socv.estado=4 and persona.id="+id).getSingleResult();
	}

	public SocVivienda buscarSocvivienda4(Long id) {
		// TODO Auto-generated method stub
		return (SocVivienda) em.createQuery("select socv "
				+ "from SocVivienda socv "
				+ "where socv.estado=4 and socv.servicioSocial="+id).getSingleResult();
	}

	public TipoVivienda buscarTipo3(Long id) {
		// TODO Auto-generated method stub
		return (TipoVivienda) em.createQuery("select t from SocVivienda socv "
				+ "inner join socv.tipoVivienda t "
				+ "inner join socv.servicioSocial ss "
				+ "where socv.estado=3 and ss.id= "+id).getSingleResult();
	}

	public SocVivienda buscarSocVdetalle(Long id) {
		// TODO Auto-generated method stub
		return (SocVivienda) em.createQuery("select socv from SocVivienda socv "
				+ "inner join socv.servicioSocial ss "
				+ "where socv.estado=4 and ss.id="+id).getSingleResult();
	}

	@Transactional
	public void eliminarSocViviendadetalle4(Long id) {
		// TODO Auto-generated method stub
		
		SocVivienda socv = em.find(SocVivienda.class,id );
		  em.remove(socv);
	}

//	public TipoVivienda buscarTipoViviendaid(Long id) {
//		// TODO Auto-generated method stub
//		return (TipoVivienda) em.createQuery("select t. from TipoVivienda t "
//				+ "where t.id="+id).getSingleResult();
//	}

	@Transactional
	public void eliminarTipovivienda4(Long id) {
		// TODO Auto-generated method stub
		TipoVivienda tv=em.find(TipoVivienda.class, id);
		em.remove(tv);
		
	}

	
	//--------------------------------------------------------------------------------------------
	public SocAlimentacion buscarSocAlimentacion(Long id) {
		// TODO Auto-generated method stub
		return (SocAlimentacion)em.createQuery("select ss from ServicioSocial s inner join s.socAlimentacion ss where s.perfil.id="+id).getSingleResult();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Long> buscaridSocDeportes(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("select  sd.id from SocDeporte sd inner join sd.servicioSocial s where s.id="+id).getResultList();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Object[]> buscarSocDeportes(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("select  sd.deporte from SocDeporte sd inner join sd.servicioSocial s where s.perfil.id="+id).getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Object[]> buscarSocAficiones(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("select sa.aficion from SocAficion sa inner join sa.servicioSocial s where s.perfil.id="+id).getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Long> buscaridSocAficiones(Long id) {
		// TODO Auto-generated method stub
		return  em.createQuery("select  sa.id from SocAficion sa inner join sa.servicioSocial s where s.id="+id).getResultList();
	}


	@Transactional
	public void eliminarDeportes(Long id)
	{
		SocDeporte dep=em.find(SocDeporte.class, id);
		em.remove(dep);
	}
	
	@Transactional
	public void eliminarAficion(Long id)
	{
		SocAficion afi=em.find(SocAficion.class, id);
		em.remove(afi);
	}

	@Transactional(readOnly = true)
	public Long buscaridSocAlimentacion(Long id) {
		// TODO Auto-generated method stub
		return (Long) em.createQuery("select sv.socAlimentacion.id from ServicioSocial sv where sv.id="+id).getSingleResult();
	}

	
	@Transactional(readOnly = false)
	public void updateSocAlimentacion(SocAlimentacion alimentos) {
		// TODO Auto-generated method stub
		em.merge(alimentos);
	}
	
}
