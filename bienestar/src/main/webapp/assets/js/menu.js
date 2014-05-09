//Codigo para nuevos modulos y activar los stylos
$(document).ready(function() {

	var url2 = $(location).attr('pathname').split('/');
	var module = "";
	var item = "";
	var proceso = "";

	switch (url2[$(url2).size() - 1]) {

	// INICIO
	case "bienvenida.htm": {
		module = "#inicio";
		item = "#inicio_bienvenida";
		break;
	}
	case "perfil.htm": {
		module = "#inicio";
		item = "#inicio_perfil";
		break;
	}
	case "editarperfil.htm": {
		module = "#inicio";
		item = "#inicio_perfil";
		break;
	}
	case "configuracion.htm": {
		module = "#inicio";
		item = "#inicio_configuracion";
		break;
	}

	// BIENESTAR UNIVERSITARIO
	case "lista_comedor.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaComedor";
		break;
	}
	case "ficha_antecedentes_Personales.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_antecedentes_Personales.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_grupo_Familiar.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_vivienda_Familiar.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_vivienda_Familiar.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_vivienda_Alumno.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_vivienda_Alumno.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_situacion_Economica.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_situacion_Economica.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_antecedentes_Escolares.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_antecedentes_Escolares.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_Salud.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_Salud.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_alimentacion_Recreacion.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_alimentacion_Recreacion.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "ficha_domicilio.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "actualizar_ficha_domicilio.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "control_social.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_controlSocial";
		break;
	}
	case "historiaSocial.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_historial";
		break;
	}
	case "ficha_servicio_social_final.htm": {
		module = "#bienestar";
		proceso = "#bienestarSocial";
		item = "#bienestar_fichaSocial";
		break;
	}
	case "verificar_padron.htm": {
		module = "#bienestar";
		proceso = "#bienestarComedor";
		item = "#bienestar_verificarPadron";
		break;
	}
	case "ticket_comedor.htm": {
		module = "#bienestar";
		proceso = "#bienestarComedor";
		item = "#bienestar_verificarPadron";
		break;
	}
	
	case "registrar_comensal.htm": {
		module = "#bienestar";
		proceso = "#bienestarComedor";
		item = "#bienestar_registrarComensal";
		break;
	}

	
//	<---------------Servicio Clinico ------------------------------->
	
	case "servicioclinicosecretaria.htm": {
		module = "#bienestar";
		proceso = "#serviciomedico";
		item = "#secretaria";
		break;
	}
	case "servicioclinicolaboratorio.htm": {
		module = "#bienestar";
		proceso = "#serviciomedico";
		item = "#laboratorio";
		break;
	}
	case "fichalaboratorio.htm": {
		module = "#bienestar";
		proceso = "#serviciomedico";
		item = "#laboratorio";
		break;
	}
	case "servicioclinicotopico.htm": {
		module = "#bienestar";
		proceso = "#serviciomedico";
		item = "#topico";
		break;
	}
	case "fichatopico.htm": {
		module = "#bienestar";
		proceso = "#serviciomedico";
		item = "#topico";
		break;
	}
	default:
		break;
	}

	$(module).addClass("active open");
	if (proceso != "")
		$(proceso).addClass("active open");
	$(item).addClass("active");
});