<%@ include file="/WEB-INF/views/include.jsp"%>

<script src="<c:url value="/assets/js/date-time/bootstrap-datepicker.min.js"/>"></script>
		<script type="text/javascript">
		
		
		$(document).ready(function() {
			estadoCivil();
			
			$('.date-picker').datepicker().next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			
			$('#telefono').validCampoFranz('0123456789');
			$('#celular').validCampoFranz('0123456789');
			 
			lugarNacimiento();
			lugarProcedencia();
			lugarActual();
		});
		
				
// 		function calcularEdad() {
// 			var f = new Date();
// 			var año = f.getFullYear();
// 			var mes = f.getMonth() + 1;
// 			var dia = f.getDate();

// 			var añon = "${model.persona[13]}".substring(0, 4);
// 			var mesn = "${model.persona[13]}".substring(5, 7);
// 			var dian = "${model.persona[13]}".substring(8, 10);

// 			var edad = año - añon;

// 			if ((mes < mesn) || (mes == mesn && dia < dian)) {
// 				edad--;
// 			}
			
// 			Miedad.value = edad;
			
// 		}
		
	
			function validar() {
				provincia_nac = document.getElementById('provincia_nac');
				provincia_proc = document.getElementById('provincia_proc');
				provincia_act = document.getElementById('provincia_act');

				distrito_nac = document.getElementById('distrito_nac');
				distrito_proc = document.getElementById('distrito_proc');
				distrito_act = document.getElementById('distrito_act');

				if (provincia_nac.value == "0" || provincia_proc.value == "0"
						|| provincia_act.value == "0") {
					alert('Seleccionar una Provincia');
					return false;
				} else if (distrito_nac.value == "0"
						|| distrito_proc.value == "0"
						|| distrito_act.value == "0") {
					alert('Seleccionar un Distrito');
					return false;
				} else {
					return true;
				}
			}

			function estadoCivil() {
				var estado = "${model.persona[12]}";

				var estado_2 = document.getElementById("estadoCivil");
				estado_2.options[estado].selected = true;
				/* estado_2.options[estado].selected = true;
				estado_2.options[estado].selected = true;
				estado_2.options[estado].selected = true; */

			}

			function lugarNacimiento() {
				var idDepartamento = "${model.persona[26]}";
				var idProvincia = "${model.persona[27]}";
				var idDistrito = "${model.persona[28]}";

				var departamento_nac = document
						.getElementById("departamento_nac");
				setSelectedIndex(departamento_nac, idDepartamento);
				setProvinciasNac();
				var provincia_nac = document.getElementById("provincia_nac");
				provincia_nac.options[idProvincia].selected = true;

				setDistritosNac();
				var distrito_nac = document.getElementById("distrito_nac");
				distrito_nac.options[idDistrito].selected = true;
			}

			function lugarProcedencia() {
				var idDepartamento = "${model.persona[33]}";
				var idProvincia = "${model.persona[34]}";
				var idDistrito = "${model.persona[35]}";

				var departamento_nac = document
						.getElementById("departamento_proc");
				// 				departamento_nac.options[idDepartamento].selected = true;
				setSelectedIndex(departamento_nac, idDepartamento);
				setProvincias();
				var provincia_nac = document.getElementById("provincia_proc");
				provincia_nac.options[idProvincia].selected = true;

				setDistritos();
				var distrito_nac = document.getElementById("distrito_proc");
				distrito_nac.options[idDistrito].selected = true;
			}

			function lugarActual() {
				var idDepartamento = "${model.persona[40]}";
				var idProvincia = "${model.persona[41]}";
				var idDistrito = "${model.persona[42]}";

				var departamento_nac = document
						.getElementById("departamento_act");
				// 				departamento_nac.options[idDepartamento].selected = true;
				setSelectedIndex(departamento_nac, idDepartamento);

				setProvinciasAct();
				var provincia_nac = document.getElementById("provincia_act");
				provincia_nac.options[idProvincia].selected = true;

				setDistritosAct();
				var distrito_nac = document.getElementById("distrito_act");
				distrito_nac.options[idDistrito].selected = true;
			}

			function setSelectedIndex(s, v) {
				for (var i = 0; i < s.options.length; i++) {
					if (s.options[i].value == v) {
						s.options[i].selected = true;
						return;
					}
				}
			}

			// 		calcularEdad();

			$(function() {

				try {//ie8 throws some harmless exception, so let's catch it

					//it seems that editable plugin calls appendChild, and as Image doesn't have it, it causes errors on IE at unpredicted points
					//so let's have a fake appendChild for it!
					if (/msie\s*(8|7|6)/
							.test(navigator.userAgent.toLowerCase()))
						Image.prototype.appendChild = function(el) {
						}

					var last_gritter
					$('#avatar')
							.editable(
									{
										type : 'image',
										name : 'avatar',
										value : null,
										image : {
											//specify ace file input plugin's options here
											btn_choose : 'Cambiar Imagen',
											droppable : true,
											/**
											//this will override the default before_change that only accepts image files
											before_change: function(files, dropped) {
												return true;
											},
											 */

											//and a few extra ones here
											name : 'avatar',//put the field name here as well, will be used inside the custom plugin
											max_size : 110000,//~100Kb
											on_error : function(code) {//on_error function will be called when the selected file has a problem
												if (last_gritter)
													$.gritter
															.remove(last_gritter);
												if (code == 1) {//file format error
													last_gritter = $.gritter
															.add({
																title : 'File is not an image!',
																text : 'Please choose a jpg|gif|png image!',
																class_name : 'gritter-error gritter-center'
															});
												} else if (code == 2) {//file size rror
													last_gritter = $.gritter
															.add({
																title : 'File too big!',
																text : 'Image size should not exceed 100Kb!',
																class_name : 'gritter-error gritter-center'
															});
												} else {//other error
												}
											},
											on_success : function() {
												$.gritter.removeAll();
											}
										},
										url : function(params) {
											// ***UPDATE AVATAR HERE*** //
											//You can replace the contents of this function with examples/profile-avatar-update.js for actual upload

											var deferred = new $.Deferred

											//if value is empty, means no valid files were selected
											//but it may still be submitted by the plugin, because "" (empty string) is different from previous non-empty value whatever it was
											//so we return just here to prevent problems
											var value = $('#avatar')
													.next()
													.find(
															'input[type=hidden]:eq(0)')
													.val();
											if (!value || value.length == 0) {
												deferred.resolve();
												return deferred.promise();
											}

											//dummy upload
											setTimeout(
													function() {
														if ("FileReader" in window) {
															//for browsers that have a thumbnail of selected image
															var thumb = $(
																	'#avatar')
																	.next()
																	.find('img')
																	.data(
																			'thumb');
															if (thumb)
																$('#avatar')
																		.get(0).src = thumb;
														}

														deferred.resolve({
															'status' : 'OK'
														});

														if (last_gritter)
															$.gritter
																	.remove(last_gritter);
														last_gritter = $.gritter
																.add({
																	title : 'Avatar Updated!',
																	text : 'Uploading to server can be easily implemented. A working example is included with the template.',
																	class_name : 'gritter-info gritter-center'
																});

													},
													parseInt(Math.random() * 800 + 800))

											return deferred.promise();
										},

										success : function(response, newValue) {
										}
									})
				} catch (e) {
				}

				//another option is using modals
				$('#avatar2')
						.on(
								'click',
								function() {
									var modal = '<div class="modal hide fade">\
						<div class="modal-header">\
							<button type="button" class="close" data-dismiss="modal">&times;</button>\
							<h4 class="blue">Cambiar Imagen</h4>\
						</div>\
						\
						<form class="no-margin">\
						<div class="modal-body">\
							<div class="space-4"></div>\
							<div style="width:75%;margin-left:12%;"><input type="file" name="file-input" /></div>\
						</div>\
						\
						<div class="modal-footer center">\
							<button type="submit" class="btn btn-small btn-success"><i class="icon-ok"></i> Aceptar</button>\
							<button type="button" class="btn btn-small" data-dismiss="modal"><i class="icon-remove"></i> Cancelar</button>\
						</div>\
						</form>\
					</div>';

									var modal = $(modal);
									modal.modal("show").on("hidden",
											function() {
												modal.remove();
											});

									var working = false;

									var form = modal.find('form:eq(0)');
									var file = form.find('input[type=file]')
											.eq(0);
									file
											.ace_file_input({
												style : 'well',
												btn_choose : 'Click para escoger nueva imagen',
												btn_change : null,
												no_icon : 'icon-picture',
												thumbnail : 'small',
												before_remove : function() {
													//don't remove/reset files while being uploaded
													return !working;
												},
												before_change : function(files,
														dropped) {
													var file = files[0];
													if (typeof file === "string") {
														//file is just a file name here (in browsers that don't support FileReader API)
														if (!(/\.(jpe?g|png|gif)$/i)
																.test(file))
															return false;
													} else {//file is a File object
														var type = $
																.trim(file.type);
														if ((type.length > 0 && !(/^image\/(jpe?g|png|gif)$/i)
																.test(type))
																|| (type.length == 0 && !(/\.(jpe?g|png|gif)$/i)
																		.test(file.name))//for android default browser!
														)
															return false;

														if (file.size > 110000) {//~100Kb
															return false;
														}
													}

													return true;
												}
											});

									form
											.on(
													'submit',
													function() {
														if (!file
																.data('ace_input_files'))
															return false;

														file
																.ace_file_input('disable');
														form
																.find('button')
																.attr(
																		'disabled',
																		'disabled');
														form
																.find(
																		'.modal-body')
																.append(
																		"<div class='center'><i class='icon-spinner icon-spin bigger-150 orange'></i></div>");

														var deferred = new $.Deferred;
														working = true;
														deferred
																.done(function() {
																	form
																			.find(
																					'button')
																			.removeAttr(
																					'disabled');
																	form
																			.find(
																					'input[type=file]')
																			.ace_file_input(
																					'enable');
																	form
																			.find(
																					'.modal-body > :last-child')
																			.remove();

																	modal
																			.modal("hide");

																	var thumb = file
																			.next()
																			.find(
																					'img')
																			.data(
																					'thumb');
																	if (thumb)
																		$(
																				'#avatar2')
																				.get(
																						0).src = thumb;

																	working = false;
																});

														setTimeout(
																function() {
																	deferred
																			.resolve();
																},
																parseInt(Math
																		.random() * 800 + 800));

														return false;
													});

								});

				$('#id-disable-check').on('click', function() {
					var inp = $('#form-input-readonly').get(0);
					if (inp.hasAttribute('disabled')) {
						inp.setAttribute('readonly', 'true');
						inp.removeAttribute('disabled');
						inp.value = "This text field is readonly!";
					} else {
						inp.setAttribute('disabled', 'disabled');
						inp.removeAttribute('readonly');
						inp.value = "This text field is disabled!";
					}
				});

				$(".chzn-select").chosen();

				$('[data-rel=tooltip]').tooltip({
					container : 'body'
				});
				$('[data-rel=popover]').popover({
					container : 'body'
				});

				$('textarea[class*=autosize]').autosize({
					append : "\n"
				});
				$('textarea[class*=limited]')
						.each(
								function() {
									var limit = parseInt($(this).attr(
											'data-maxlength')) || 100;
									$(this)
											.inputlimiter(
													{
														"limit" : limit,
														remText : '%n character%s remaining...',
														limitText : 'max allowed : %n.'
													});
								});

				$.mask.definitions['~'] = '[+-]';
				$('.input-mask-date').mask('99/99/9999');
				$('.input-mask-phone').mask('(999) 999-9999');
				$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
				$(".input-mask-product").mask("a*-999-a999", {
					placeholder : " ",
					completed : function() {
						alert("You typed the following: " + this.val());
					}
				});

				$("#input-size-slider").css('width', '200px').slider(
						{
							value : 1,
							range : "min",
							min : 1,
							max : 6,
							step : 1,
							slide : function(event, ui) {
								var sizing = [ '', 'input-mini', 'input-small',
										'input-medium', 'input-large',
										'input-xlarge', 'input-xxlarge' ];
								var val = parseInt(ui.value);
								$('#form-field-4').attr('class', sizing[val])
										.val('.' + sizing[val]);
							}
						});

				$("#input-span-slider").slider(
						{
							value : 1,
							range : "min",
							min : 1,
							max : 11,
							step : 1,
							slide : function(event, ui) {
								var val = parseInt(ui.value);
								$('#form-field-5').attr('class', 'span' + val)
										.val('.span' + val).next().attr(
												'class', 'span' + (12 - val))
										.val('.span' + (12 - val));
							}
						});

				$("#eq > span").css({
					width : '90%',
					'float' : 'left',
					margin : '15px'
				}).each(function() {
					// read initial values from markup and remove that
					var value = parseInt($(this).text(), 10);
					$(this).empty().slider({
						value : value,
						range : "min",
						animate : true

					});
				});

				$('#id-input-file-1 , #id-input-file-2').ace_file_input({
					no_file : 'No File ...',
					btn_choose : 'Choose',
					btn_change : 'Change',
					droppable : false,
					onchange : null,
					thumbnail : false
				//| true | large
				//whitelist:'gif|png|jpg|jpeg'
				//blacklist:'exe|php'
				//onchange:''
				//
				});

				$('#id-input-file-3').ace_file_input({
					style : 'well',
					btn_choose : 'Drop files here or click to choose',
					btn_change : null,
					no_icon : 'icon-cloud-upload',
					droppable : true,
					thumbnail : 'small'
					//,icon_remove:null//set null, to hide remove/reset button
					/**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
					/**,before_remove : function() {
						return true;
					}*/
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}

				}).on('change', function() {
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});

				//dynamically change allowed formats by changing before_change callback function
				$('#id-file-format')
						.removeAttr('checked')
						.on(
								'change',
								function() {
									var before_change
									var btn_choose
									var no_icon
									if (this.checked) {
										btn_choose = "Drop images here or click to choose";
										no_icon = "icon-picture";
										before_change = function(files, dropped) {
											var allowed_files = [];
											for (var i = 0; i < files.length; i++) {
												var file = files[i];
												if (typeof file === "string") {
													//IE8 and browsers that don't support File Object
													if (!(/\.(jpe?g|png|gif|bmp)$/i)
															.test(file))
														return false;
												} else {
													var type = $
															.trim(file.type);
													if ((type.length > 0 && !(/^image\/(jpe?g|png|gif|bmp)$/i)
															.test(type))
															|| (type.length == 0 && !(/\.(jpe?g|png|gif|bmp)$/i)
																	.test(file.name))//for android's default browser which gives an empty string for file.type
													)
														continue;//not an image so don't keep this file
												}

												allowed_files.push(file);
											}
											if (allowed_files.length == 0)
												return false;

											return allowed_files;
										}
									} else {
										btn_choose = "Drop files here or click to choose";
										no_icon = "icon-cloud-upload";
										before_change = function(files, dropped) {
											return files;
										}
									}
									var file_input = $('#id-input-file-3');
									file_input
											.ace_file_input(
													'update_settings',
													{
														'before_change' : before_change,
														'btn_choose' : btn_choose,
														'no_icon' : no_icon
													})
									file_input.ace_file_input('reset_input');
								});

				$('#spinner1').ace_spinner({
					value : 0,
					min : 0,
					max : 200,
					step : 10,
					btn_up_class : 'btn-info',
					btn_down_class : 'btn-info'
				}).on('change', function() {
					//alert(this.value)
				});
				$('#spinner2').ace_spinner({
					value : 0,
					min : 0,
					max : 10000,
					step : 100,
					icon_up : 'icon-caret-up',
					icon_down : 'icon-caret-down'
				});
				$('#spinner3').ace_spinner({
					value : 0,
					min : -100,
					max : 100,
					step : 10,
					icon_up : 'icon-plus',
					icon_down : 'icon-minus',
					btn_up_class : 'btn-success',
					btn_down_class : 'btn-danger'
				});

				$('.date-picker').datepicker().next().on(ace.click_event,
						function() {
							$(this).prev().focus();
						});
				$('#id-date-range-picker-1').daterangepicker().prev().on(
						ace.click_event, function() {
							$(this).next().focus();
						});

				$('#timepicker1').timepicker({
					minuteStep : 1,
					showSeconds : true,
					showMeridian : false
				})

				$('#colorpicker1').colorpicker();
				$('#simple-colorpicker-1').ace_colorpicker();

				$(".knob").knob();

				//we could just set the data-provide="tag" of the element inside HTML, but IE8 fails!
				var tag_input = $('#form-field-tags');
				if (!(/msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase())))
					tag_input.tag({
						placeholder : tag_input.attr('placeholder')
					});
				else {
					//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
					tag_input.after(
							'<textarea id="' + tag_input.attr('id')
									+ '" name="' + tag_input.attr('name')
									+ '" rows="3">' + tag_input.val()
									+ '</textarea>').remove();
					//$('#form-field-tags').autosize({append: "\n"});
				}

				/////////
				$('#modal-form input[type=file]').ace_file_input({
					style : 'well',
					btn_choose : 'Drop files here or click to choose',
					btn_change : null,
					no_icon : 'icon-cloud-upload',
					droppable : true,
					thumbnail : 'large'
				})

				//chosen plugin inside a modal will have a zero width because the select element is originally hidden
				//and its width cannot be determined.
				//so we set the width after modal is show
				$('#modal-form').on(
						'show',
						function() {
							$(this).find('.chzn-container').each(
									function() {
										$(this).find('a:first-child').css(
												'width', '200px');
										$(this).find('.chzn-drop').css('width',
												'210px');
										$(this).find('.chzn-search input').css(
												'width', '200px');
									});
						})
				/**
				//or you can activate the chosen plugin after modal is shown
				//this way select element has a width now and chosen works as expected
				$('#modal-form').on('shown', function () {
					$(this).find('.modal-chosen').chosen();
				})
				 */

			});
		</script>	
		
		
		
<script type="text/javascript">


	//provincias lists
	var provincias = new Array();

	provincias['1'] = new Array('CHACHAPOYAS', 'BAGUA', 'BONGARA','LUYA','RODRIGUEZ DE MENDOZA','CONDORCANQUI','UTCUBAMBA');
	provincias['2'] = new Array('HUARAZ', 'AIJA', 'BOLOGNESI','CARHUAZ','CASMA','CORONGO','HUAYLAS','HUARI','MARISCAL LUZURIAGA','PALLASCA','POMABAMBA','RECUAY','SANTA','SIHUAS','YUNGAY','ANTONIO RAIMONDI','CARLOS FERMIN FITZCARRALD','ASUNCION','HUARMEY','OCROS');
	provincias['3'] = new Array('ABANCAY', 'AYMARAES', 'ANDAHUAYLAS','ANTABAMBA','COTABAMBAS','GRAU','CHINCHEROS');
	provincias['4'] = new Array('AREQUIPA', 'CAYLLOMA', 'CAMANA','CARAVELI','CASTILLA','CONDESUYOS','ISLAY','LA UNION');
	provincias['5'] = new Array('HUAMANGA', 'CANGALLO', 'HUANTA','LA MAR','LUCANAS','PARINACOCHAS','VICTOR FAJARDO','HUANCA SANCOS','VILCAS HUAMAN','PAUCAR DEL SARA SARA','SUCRE');
	provincias['6'] = new Array('CAJAMARCA', 'CAJABAMBA','CELENDIN', 'CONTUMAZA','CUTERVO','CHOTA','HUALGAYOC','JAEN','SANTA CRUZ','SAN MIGUEL','SAN IGNACIO','SAN MARCOS','SAN PABLO');
	provincias['7'] = new Array('CUSCO', 'ACOMAYO', 'ANTA','CALCA','CANAS','CANCHIS','CHUMBIVILCAS','ESPINAR','LA CONVENCION','PARURO','PAUCARTAMBO','QUISPICANCHI','URUBAMBA');
	provincias['8'] = new Array('HUANCAVELICA', 'ACOBAMBA', 'ANGARAES','CASTROVIRREYNA','TAYACAJA','HUAYTARA','CHURCAMPA');
	provincias['9'] = new Array('HUANUCO', 'AMBO', 'DOS DE MAYO','HUAMALIES','MARAÑON','LEONCIO PRADO','PACHITEA','PUERTO INCA','HUACAYBAMBA','LAURICOCHA','YAROWILCA');
	provincias['10'] = new Array('ICA', 'CHINCHA', 'NAZCA','PISCO','PALPA');
	provincias['11'] = new Array('HUANCAYO', 'CONCEPCION', 'JAUJA','JUNIN','TARMA','YAULI','SATIPO','CHANCHAMAYO','CHUPACA');
	provincias['12'] = new Array('TRUJILLO', 'BOLIVAR','SANCHEZ CARRION', 'OTUZCO','PACASMAYO','PATAZ','SANTIAGO DE CHUCO','ASCOPE','CHEPEN','JULCAN','GRAN CHIMU','VIRU');
	provincias['13'] = new Array('CHICLAYO', 'FERREÑAFE', 'LAMBAYEQUE');
	provincias['14'] = new Array('LIMA', 'CAJATAMBO', 'CANTA','CAÑETE','HUAURA','HUAROCHIRI','YAUYOS','HUARAL','BARRANCA','OYON');
	provincias['15'] = new Array('MAYNAS', 'ALTO AMAZONAS', 'LORETO','REQUENA','UCAYALI','MARISCAL RAMON CASTILLA','DATEM DEL MARAÑON');
	provincias['16'] = new Array('TAMBOPATA', 'MANUS', 'TAHUAMANU'); 
	provincias['17'] = new Array('MARISCAL NIETO', 'GENERAL SANCHEZ CERRO', 'ILO'); 
	provincias['18'] = new Array('PASCO', 'DANIEL ALCIDES CARRION', 'OXAPAMPA'); 
	provincias['19'] = new Array('PIURA', 'AYABACA', 'HUANCABAMBA','MORROPON','PAITA','SULLANA','TALARA','SECHURA'); 
	provincias['20'] = new Array('PUNO', 'AZANGARO', 'CARABAYA','CHUCUITO','HUANCANE','LAMPA','MELGAR','SANDIA','SAN ROMAN','YUNGUYO','SAN ANTONIO DE PUTINA','EL COLLAO','MOHO'); 
	provincias['21'] = new Array('MOYOBAMBA', 'HUALLAGA', 'LAMAS','MARISCAL CACERES','RIOJA','SAN MARTIN','BELLAVISTA','TOCACHE','PICOTA','EL DORADO'); 
	provincias['22'] = new Array('TACNA', 'TARATA', 'JORGE BASADRE','CANDARAVE');  
	provincias['23'] = new Array('TUMBES', 'CONTRALMIRANTE VILLAR', 'ZARUMILLA');  
	provincias['24'] = new Array('CALLAO');  
	provincias['25'] = new Array('CORONEL PORTILLO','PADRE ABAD','ATALAYA','PURUS');  

	// distritos lists
	var distritos = new Array();

	distritos['1'] = new Array();
	distritos['1']['1'] = new Array('CHACHAPOYAS','ASUNCION','BALSAS','CHETO','CHILIQUIN','CHUQUIBAMBA','GRANADA','HUANCAS','LA JALCA','LEIMEBAMBA','LEVANTO','MAGDALENA','MARISCAL CASTILLA','MOLINOPAMPA','MONTEVIDEO','OLLEROS','QUINJALCA','SAN FRANCISCO DE DAGUAS','SAN ISIDRO DE MAINO','SOLOCO','SONCHE');
	distritos['1']['2'] = new Array('LA PECA','ARAMANGO','COPALLIN','EL PARCO','BAGUA','IMAZA');
	distritos['1']['3'] = new Array('JUMBILLA','COROSHA','CUISPES','CHISQUILLA','CHURUJA','FLORIDA','RECTA','SAN CARLOS','SHIPASBAMBA','VALERA','YAMBRASBAMBA','JAZAN');
	distritos['1']['4'] = new Array('LAMUD','CAMPORREDONDO','COCABAMBA','COLCAMAR','CONILA','INGUILPATA','LONGUITA','LONYA CHICO','LUYA','LUYA VIEJO','MARIA','OCALLI','OCUMAL','PISUQUIA','SAN CRISTOBAL','SAN FRANCISCO DE YESO','SAN JERONIMO','SAN JUAN DE LOPECANCHA','SANTA CATALINA','SANTO TOMAS','TINGO','TRITA','PROVIDENCIA');
	distritos['1']['5'] = new Array('SAN NICOLAS','COCHAMAL','CHIRIMOTO','HUAMBO','LIMABAMBA','LONGAR','MILPUCC','MARISCAL BENAVIDES','OMIA','SANTA ROSA','TOTORA','VISTA ALEGRE');
	distritos['1']['6'] = new Array('NIEVA','RIO SANTIAGO','EL CENEPA');
	distritos['1']['7'] = new Array('BAGUA GRANDE','CAJARURO','CUMBA','EL MILAGRO','JAMALCA','LONYA GRANDE','YAMON');
	
	distritos['2'] = new Array();
	distritos['2']['1'] = new Array('HUARAZ','INDEPENDENCIA','COCHABAMBA','COLCABAMBA','HUANCHAY','JANGAS','LA LIBERTAD','OLLEROS','PAMPAS GRANDE','PARIACOTO','PIRA','TARICA');
	distritos['2']['2'] = new Array('AIJA', 'CORIS','HUACLLAN','LA MERCED','SUCCHA');
	distritos['2']['3'] = new Array('CHIQUIAN', 'ABELARDO PARDO LEZAMETA','AQUIA','CAJACAY','HUAYLLACAYAN','HUASTA','MANGAS','PACLLON','SAN MIGUEL DE CORPANQUI','TICLLOS','ANTONIO RAIMONDI','CANIS','COLQUIOC','LA PRIMAVERA','HUALLANCA');
	distritos['2']['4'] = new Array('CARHUAZ', 'ACOPAMPA','AMASHCA','ANTA','ATAQUERO','MARCARA', 'PARIAHUANCA','SAN MIGUEL DE ACO','SHILLA','TINCO','YUNGAR');
	distritos['2']['5'] = new Array('CASMA', 'BUENA VISTA ALTA','COMANDANTE NOEL','YAUTAN');
	distritos['2']['6'] = new Array('CORONGO', 'ACO','BAMBAS','CUSCA','LA PAMPA','YANAC','YUPAN');
	distritos['2']['7'] = new Array('CARAZ', 'HUALLANCA','HUATA','HUAYLAS','MATO','PAMPAROMAS','PUEBLO LIBRE','SANTA CRUZ','YURACMARCA','SANTO TORIBIO');
	distritos['2']['8'] = new Array('HUARI', 'CAJAY','CHAVIN DE HUANTAR','HUACACHI','HUACCHIS','HUANTAR','MASIN','PAUCAS','PONTO','RAHUAPAMPA','RAPAYAN','SAN MARCOS','SAN PEDRO DE CHANA','UCO','ANRA');
	distritos['2']['9'] = new Array('PISCOBAMBA', 'CASCA','LUCMA','FIDEL OLIVAS ESCUDERO','LLAMA','LLUMPA','MUSGA','ELEAZAR GUZMAN BARRON');
	distritos['2']['10'] = new Array('CABANA', 'BOLOGNESI','CONCHUCOS','HUASCACHUQUE','HUANDOVAL','LACABAMBA','LLAPO','PALLASCA','PAMPAS','SANTA ROSA','TAUCA');
	distritos['2']['11'] = new Array('POMABAMBA', 'HUAYLLAN','PAROBAMBA','QUINUABAMBA');
	distritos['2']['12'] = new Array('RECUAY', 'COTAPARACO','HUAYLLAPAMPA','MARCA','PAMPAS CHICO','PARARIN','TAPACOCHA','TICAPAMPA','LLACLLIN','CATAC');
	distritos['2']['13'] = new Array('CHIMBOTE', 'CACERES DEL PERU','MACATE','MORO','NEPEÑA','SAMANCO','COISHCO','NUEVO CHIMBOTE');
	distritos['2']['14'] = new Array('SIHUAS', 'ALFONSO UGARTE','CHINGALPO','HUAYLLABAMBA','QUICHES','SICSIBAMBA','ACOBAMBA','CASHAPAMPA','RAGASH','SAN JUAN');
	distritos['2']['15'] = new Array('YUNGAY', 'CASCAPARA','MANCOS','MATACOTO','QUILLO','RANRAHIRCA','SHUPLUY','YANAMA');
	distritos['2']['16'] = new Array('LLAMELLIN', 'ACZO','CHACCHO','CHINGAS','MIRGAS','SAN JUAN DE RONTOY');
	distritos['2']['17'] = new Array('SAN LUIS', 'YAUYA','SAN NICOLAS');
	distritos['2']['18'] = new Array('CHACAS', 'ACOCHACA');
	distritos['2']['19'] = new Array('HUARMEY', 'COCHAPETI','HUAYAN','MALVAS','CULEBRAS');
	distritos['2']['20'] = new Array('ACAS', 'CAJAMARQUILLA','ARHUAPAMPA', 'COCHAS','CONGAS', 'LLIPA','OCROS', 'SAN CRISTOBAL DE RAJAN','SAN PEDRO', 'SANTIAGO DE CHILCAS');
	
	
	
	distritos['3'] = new Array();
	distritos['3']['1'] = new Array('ABANCAY','CIRCA','CURAHUASI','CHACOCHE','HUANIPACA','LAMBRAMA','PICHIRHUA','SAN PEDRO DE CACHORA','TAMBURCO');
	distritos['3']['2'] = new Array('CHALHUANCA', 'CAPAYA','CARAYBAMBA','COLCABAMBA','COTARUSE','CHAPIMARCA','HUAYLLO','LUCRE','POCOHUANCA','SAÑAYCA','SORAYA','TAPAIRIHUA','TINTAY','TORAYA','YANACA','SAN JUAN DE CHACÑA','JUSTO APU SAHUARAURA');
	distritos['3']['3'] = new Array('ANDAHUAYLAS', 'ANDARAPA','CHIARA','HUANCARAMA','HUANCARAY','KISHUARA','PACOBAMBA','PAMPACHIRI','SAN ANTONIO DE CACHI','SAN JETRONIMO','TALAVERA','TURPO','PACUCHA','POMACOCHA','SANTA MARIA DE CHICMO','TUMAY HUARACA','HUAYANA','SAN MIGUEL DE CHACCRAMPA','KAQUIABAMBA');
	distritos['3']['4'] = new Array('ANTABAMBA','EL ORO','HUAQUIRCA','JUAN ESPINOZA MEDRANO','OROPESA','PACHACONAS','SABAINO');
	distritos['3']['5'] = new Array('TAMBOBAMBA','COYLLURQUI','COTABAMBAS','HAQUIRA','MARA','CHALLHUAHUACHO');
	distritos['3']['6'] = new Array('CHUQUIBAMBILLA','CURPAHUASI','HUAILLATI','MAMARA','MARISCAL GAMARRA','MICAELA BASTIDAS','PROGRESO','PATAYPAMPA','SAN ANTONIO','TURPAY','VILCABAMBA','VIRUNDO','SANTA ROSA','CURASCO');
	distritos['3']['7'] = new Array('CHINCHEROS','ONGOY','OCOBAMBA','COCHARCAS','ANCO HUALLO','HUACCANA','URANMARCA','RANRACANCHA');
	
	
	distritos['4'] = new Array();
	distritos['4']['1'] = new Array('AREQUIPA','CAYMA','CERRO COLORADO','CHARACATO','CHIGUATA','LA JOYA','MIRAFLORES','MOLLEBAYA','PAUCARPATA','POCSI','POLOBAYA','QUEQUEÑA','SABANDIA','SACHACA','SAN JUAN DE SIGUAS','SAN JUAN DE TARUCANI','SANTA ISABEL DE SIGUAS','SANTA RITA DE SIHUAS','SOCABAYA','TIABAYA','UCHUMAYO','VITOR','YANAHUARA','YARABAMBA','YURA','MARIANO MELGAR','JACOBO HUNTER','ALTO SELVA ALEGRE','JOSE LUIS BUSTAMANTE Y RIVERO');
	distritos['4']['2'] = new Array('CHIVAY', 'ACHOMA','CABANACONDE','CAYLLOMA','CALLALLI','COPORAQUE','HUAMBO','HUANCA','ICHUPAMPA','LARI','LLUTA','MACA','MADRIGAL','SAN ANTONIO DE CHUCA','SIBAYO','TAPAY','TISCO','TUTI','YANQUE','MAJES');
	distritos['4']['3'] = new Array('CAMANA', 'JOSE MARIA QUIMPER','MARIANO NICOLAS VALCARCEL','MARISCAL CACERES','NICOLAS DE PIEROLA','OCOÑA','QUILCA','SAMUEL PASTOR');
	distritos['4']['4'] = new Array('CARAVELI','ACARI','ATICO','ATIQUIPA','BELLA UNION','CAHUACHO','CHALA','CHAPARRA','HUANUHUANU','JAQUI','LOMAS','QUICACHA','YAUCA');
	distritos['4']['5'] = new Array('APLAO', 'ANDAGUA','AYO','CHACHAS','CHILCAYMARCA','CHOCO','HUANCARQUI','MACHAGUAY','ORCOPAMPA','TIPAN','URACA','UÑON','VIRACO');
	distritos['4']['6'] = new Array('CHUQUIBAMBA', 'ANDARAY','CAYARANI','CHICHAS','IRAY','SALAMANCA','YANAQUIHUA','RIO GRANDE');
	distritos['4']['7'] = new Array('MOLLENDO', 'COCACHACRA','DEAN VALDIVIA','ISLAY','MEJIA','PUNTA DE BOMBON');
	distritos['4']['8'] = new Array('COTAHUASI', 'ALCA','CHARCANA','HUAYNACOTAS','PAMPAMARCA','PUYCA','QUECHUALLA','SAYLA','TAURIA','TOMEPAMPA','TORO');

	
	
	distritos['5'] = new Array();
	distritos['5']['1'] = new Array('AYACUCHO','ACOS VINCHOS','CARMEN ALTO','CHIARA','QUINUA','SAN JOSE BAUTISTA','SANTIAGO DE PISCHA','VINCHOS','TAMBILLO','ACOCRO','SOCOS','OCROS','PACAYCASA','JESUS DE NAZARENO');
	distritos['5']['2'] = new Array('CANGALLO', 'CHUSCHI','LOS MOROCHUCOS','PARAS','TOTOS','MARIA PARADO DE BELLIDO');
	distritos['5']['3'] = new Array('HUANTA', 'AYAHUANCO','HUAMANGUILLA','IGUAIN','LURICOCHA','SANTILLANA','SIVIA','LLOCHEGUA');
	distritos['5']['4'] = new Array('SAN MIGUEL','ANCO','AYNA','CHILCAS','CHUNGUI','TAMBO','LUIS CARRANZA','SANTA ROSA','SAMUGARI');
	distritos['5']['5'] = new Array('PUQUIO', 'AUCARA','CABANA','CARMEN SALCEDO','CHAVIÑA','CHIPAO','HUAC-HUAS','LARAMATE','LEONCIO PRADO','LUCANAS','LLAUTA','OCAÑA','OTOCA','SANCOS','SAN JUAN','SAN PEDRO','SANTA ANA DE HUAYCAHUACHO','SANTA LUCIA','SAISA','SAN PEDRO DE PALCO','SAN CRISTOBAL');
	distritos['5']['6'] = new Array('CORACORA', 'CORONEL CASTAÑEDA','CHUMPI','PACAPAUSA','PULLO','PUYUSCA','SAN FRANCISCO DE RAVACAYCO','UPAHUACHO');
	distritos['5']['7'] = new Array('HUANCAPI', 'ALCAMENCA','APONGO','CANARIA','CAYARA','COLCA','HUALLA','HUAMANQUIQUIA','HUANCARAYLLA','SARHUA','VILCANCHOS','ASQUIPATA');
	distritos['5']['8'] = new Array('SANCOS', 'SACSAMARCA','SANTIAGO DE LUCANAMARCA','CARAPO','VILCAS HUAMAN','VISCHONGO','ACCOMARCA','CARHUANCA','CONCEPCION','HUAMBALPA','SAURAMA','INDEPENDENCIA');
	distritos['5']['9'] = new Array('PAUSA', 'COLTA','CORCULLA','LAMPA','MARCABAMBA','OYOLO','PARARCA','SAN JAVIER DE ALPABAMBA','SAN JOSE DE USHUA','SARA SARA');
	distritos['5']['10'] = new Array('QUEROBAMBA', 'BELEN','CHALCOS','SAN SALVADO DE QUIJE','PAICO','SANTIAGO DE PAUCARAY','SAN PEDRO DE LARCAY','SORAS','HUACAÑA','CHILCAYOC','MORCOLLA');
	
	
	distritos['6'] = new Array();
	distritos['6']['1'] = new Array('CAJAMARCA','ASUNCION','COSPAN','CHETILLA','ENCAÑADA','JESUS','LOS BAÑOS DEL INCA','LLACANORA','MAGDALENA','MATARA','NAMORA','SAN JUAN');
	distritos['6']['2'] = new Array('CAJABAMBA', 'CACHACHI','CONDEBAMBA','SITACOCHA');
	distritos['6']['3'] = new Array('CELENDIN', 'CORTEGANA','CHUMUCH','HUASMIN','JORGE CHAVEZ','JOSE GALVEZ','MIGUEL IGLESIAS','OXAMARCA','SOROCHUCO','SUCRE','UTCO','LA LIBERTAD DE PALLAN');
	distritos['6']['4'] = new Array('CONTUMAZA','CHILETE','GUZMANGO','SAN BENITO','CUPISNIQUE','TANTARICA','YONAN','SANTA CRUZ DE TOLED');
	distritos['6']['5'] = new Array('CUTERVO', 'CALLAYUC','CUJILLO','CHOROS','LA RAMADA','PIMPINGOS','QUEROCOTILLO','SAN ANDRES DE CURTERVO','SAN JUAN DE CUTERVO','SAN LUIS DE LUCMA','SANTA CRUZ','SANTO DOMINGO DE LA CAPILLA','SANTO TOMAS','SOCOTA','TORIBIO CASANOVA');
	distritos['6']['6'] = new Array('CHOTA', 'ANGUIA','COCHABAMBA','CONCHAN','CHADIN','CHIGUIRIP','CHIMBAN','HUAMBOS','LAJAS','LLAMA','MIRACOSTA','PACCHA','PION','QUEROCOTO','TACABAMBA','TOCMOCHE','SAN JUAN DE LICUPIS','CHOROPAMPA','CHALAMARCA');
	distritos['6']['7'] = new Array('BAMBAMARCA', 'CHUGUR','HUALGAYOC');
	distritos['6']['8'] = new Array('JAEN', 'BELLAVISTA','COLASAY','CHONTALI','POMAHUACA','PUCARA','SALLIQUE','SAN FELIPE','SAN JOSE DEL ALTO','SANTA ROSA','LAS PIRIAS','HUABAL');
	distritos['6']['9'] = new Array('SANTA CRUZ', 'CATACHE','CHANCAYBAÑOS','LA ESPERANZA','NINABAMBA','PULAN','SEXI','UTICYACU','YAUYUCAN','ANDABAMBA','SAUCEPAMPA');
	distritos['6']['10'] = new Array('SAN MIGUEL', 'CALQUIS','LA FLORIDA','LLAPA','NANCHOC','NIEPOS','SAN GREGORIO','SAN SILVESTRE DE COCHAN','EL PRADO','UNIO AGUA BLANCA','TONGOD','CATILLUC','BOLIVAR');
	distritos['6']['11'] = new Array('SAN IGNACIO', 'CHIRINOS','HUARANGO','NAMBALLE','LA COIPA','SAN JOSE DE LOURDES','TABACONAS');	
	distritos['6']['12'] = new Array('PEDRO GALVEZ', 'ICHOCAN','GREGORIO PITA','JOSE MANUEL QUIROZ','EDUARDO VILLANUEVA','JOSE SABOGAL','CHANCAY');
	distritos['6']['13'] = new Array('SAN PABLO', 'SAN BERNARDINO','SAN LUIS','TUMBADEN');
	
	distritos['7'] = new Array();
	distritos['7']['1'] = new Array('CUSCO','CCORCA','POROY','SAN JERONIMO','SAN SEBASTIAN','SANTIAGO','SAYLLA','WANCHAQ');
	distritos['7']['2'] = new Array('ACOMAYO', 'ACOPIA','ACOS','POMACANCHI','RONDOCAN','SANGARARA','MOSOC LLACTA');
	distritos['7']['3'] = new Array('ANTA', 'CHINCHAYPUJIO','HUAROCONDO','LIMATAMBO','MOLLEPATA','PUCYURA','ZURITE','CACHIMAYO');
	distritos['7']['4'] = new Array('CALCA','COYA','LAMAY','LARES','PISAC','SAN SALVADOR','TARAY','YANATILE');
	distritos['7']['5'] = new Array('YANAOCA', 'CHECCA','KUNTURKANKI','LANGUI','LAYO','PAMPAMARCA','QUEHUE','TUPAC AMARU');
	distritos['7']['6'] = new Array('SICUANI', 'COMBAPATA','CHECACUPE','MARANGANI','PITUMARCA','SAN PABLO','SAN PEDRO','TINTA');
	distritos['7']['7'] = new Array('SANTO TOMAS', 'CAPACMARCA','COLQUEMARCA','CHAMACA','LIVITACA','LLUSCO','QUIÑOTA','VELILLE');
	distritos['7']['8'] = new Array('ESPINAR', 'CONDOROMA','COPORAQUE','OCORURO','PALLPATA','PICHIGUA','SUYCKUTAMBO','ALTO PICHIGUA');
	distritos['7']['9'] = new Array('SANTA ANA', 'ECHARATE','HUAYOPATA','MARANURA','OCOBAMBA','SANTA TERESA','VILCABAMBA','QUELLOUNO','KIMBIRI','PICHARI');
	distritos['7']['10'] = new Array('PARURO', 'ACCHA','CCAPI','COLCHA','HUANOQUITE','OMACHA','YAURISQUE','PACCARITAMBO','PILLPINTO');
	distritos['7']['11'] = new Array('PAUCARTAMBO', 'CAICAY','COLQUEPATA','CHALLABAMBA','KOSÑIPATA','HUANCARANI');	
	distritos['7']['12'] = new Array('URCOS', 'ANDAHUAYLILLAS','CAMANTI','CCARHUAYO','CCATCA','CUSIPATA','HUARO','LUCRE','MARCAPATA','OCONGATE','OROPESA','QUIQUIJANA');	
	distritos['7']['13'] = new Array('URUBAMBA', 'CHINCHERO','HUAYLLABAMBA','MACHUPICCHU','MARAS','OLLANTAYTAMBO','YUCAY');	
	
	
	
	
	distritos['8'] = new Array();
	distritos['8']['1'] = new Array('HUANCAVELICA','ACOBAMBILLA','ACORIA','CONAYCA','CUENCA','HUACHOCOLPA','HUAYLLAHUARA','IZCUCHACA','LARIA','MANTA','MARISCAL CACERES','MOYA','NUEVO OCCORO','PALCA','PILCHACA','VILCA','YAULI','ASCENSION','HUANDO');
	distritos['8']['2'] = new Array('ACOBAMBA', 'ANTA','ANDABAMBA','CAJA','MARCAS','PAUCARA','POMACOCHA','ROSARIO');
	distritos['8']['3'] = new Array('LIRCAY', 'ANCHONGA','CALLANMARCA','CONGALLA','CHINCHO','HUALLAY-GRANDE','HUANCA-HUANCA','JULCAMARCA','SAN ANTONIO DE ANTAPARCO','SANTO TOMAS DE PATA','SECCLLA','CCOCHACCASA');
	distritos['8']['4'] = new Array('CASTROVIRREYNA','ARMA','AURAHUA','CAPILLAS','COCAS','CHUPAMARCA','HUACHOS','HUAMATAMBO','MOLLEPAMPA','SAN JUAN','TANTARA','TICRAPO','SANTA ANA');
	distritos['8']['5'] = new Array('PAMPAS', 'ACOSTAMBO','ACRAQUIA','AHUAYCHA','COLCABAMBA','DANIEL HERNANDEZ','HUACHOCOLPA','HUARIBAMBA','ÑAHUIMPUQUIO','PAZOS','QUISHUAR','SALCUBAMBA','SAN MARCOS DE ROCCHAC','SURCUBAMBA','TINTAY PUNCU','SALCAHUASI');
	distritos['8']['6'] = new Array('AYAVI', 'CORDOVA','HUAYACUNDO ARMA','HUAYTARA','LARAMARCA','OCOYO','PILPICHACA','QUERCO','QUITO ARMA','SAN ANTONIO DE CUSICANCHA','SAN FRANCISCO DE SANGAYAICO','SAN ISIDRO','SANTIAGO DE CHOCORVOS','SANTIAGO DE QUIRAHUARA','SANTO DOMINGO DE CAPILLAS','TAMBO');
	distritos['8']['7'] = new Array('CHURCAMPA', 'ANCO','CHINCHIHUASI','EL CARMEN','LA MERCED','LOCROJA','PAUCARBAMBA','SAN MIGUEL DE MAYOCC','SAN PEDRO DE CORIS','PACHAMARCA','COSME');
	
	
	
	distritos['9'] = new Array();
	distritos['9']['1'] = new Array('HUANUCO','CHINCHAO','CHURUBAMBA','MARGOS','QUISQUI','SAN FRANCISCO DE CAYRAN','SAN PEDRO DE CHAULAN','SANTA MARIA DEL VALLE','YARUMAYO','AMARILIS','PILLO MARCA','YACUS');
	distritos['9']['2'] = new Array('AMBO', 'CAYNA','COLPAS','CONCHAMARCA','HUACAR','SAN FRANCISCO','SAN RAFAEL','TOMAY-KICHWA');
	distritos['9']['3'] = new Array('LA UNION', 'CHUQUIS','MARIAS','PACHAS','QUIVILLA','RIPAN','SHUNQUI','SILLAPATA','YANAS');
	distritos['9']['4'] = new Array('LLATA','ARANCAY','CHAVIN DE PARIARCA','JACAS GRANDE','JIRCAN','MIRAFLORES','MONZON','PUNCHAO','PUÑOS','SINGA','TANTAMAYO');
	distritos['9']['5'] = new Array('HUACRACHUCO', 'CHOLON','SAN BUENAVENTURA');
	distritos['9']['6'] = new Array('RUPA-RUPA', 'DANIEL ALOMIA ROBLES','HERMILIO VALDIZAN','LUYANDO','MARIANO DAMASO BERAUN','JOSE CRESPO Y CASTILLO');
	distritos['9']['7'] = new Array('PANAO', 'CHAGLLA','MOLINO','UMARI');
	distritos['9']['8'] = new Array('HONORIA', 'PUERTO INCA','CODO DEL POZUZO','TOURNAVISTA','YUYAPICHIS');
	distritos['9']['9'] = new Array('HUACAYBAMBA', 'PINRA','CANCHABAMBA','COCHABAMBA');
	distritos['9']['10'] = new Array('JESUS', 'BAÑOS','SAN FRANCISCO DE ASIS','QUEROPALCA','SAN MIGUEL DE CAURI','RONDOS','JIVIA');
	distritos['9']['11'] = new Array('CHAVINILLO', 'APARICIO POMARES','CAHUAC','CHACABAMBA','JACAS CHICO','OBAS','PAMPAMARCA','CHORAS');
	
	
	distritos['10'] = new Array();
	distritos['10']['1'] = new Array('ICA','LA TINGUIÑA','LOS AQUIJES','PARCONA','PUEBLO NUEVO','SALAS','SAN JOSE DE LOS MOLINOS','SAN JUAN BAUTISTA','SANTIAGO','SUBTANJALLA','YAUCA DEL ROSARIO','TATE','PACHACUTEC','OCUCAJE');
	distritos['10']['2'] = new Array('CHINCHA ALTA', 'CHAVIN','CHINCHA BAJA','EL CARMEN','GROCIO PRADO','SAN PEDRO DE HUACARPANA','SUNAMPE','TAMBO DE MORA','ALTO LARAN','PUEBLO NUEVO','SAN JUAN DE YANAC');
	distritos['10']['3'] = new Array('NAZCA', 'CHANQUILLO','EL INGENIO','MARCONA','VISTA ALEGRE');
	distritos['10']['4'] = new Array('PISCO','HUANCANO','HUMAY','INDEPENDENCIA','PARACAS','SAN ANDRES','SAN CLEMENTE','TUPAC AMARU INCA');
	distritos['10']['5'] = new Array('PALPA', 'LLIPATA','RIO GRANDE','SANTA CRUZ','TIBILLO');
	
	
	distritos['11'] = new Array();
	distritos['11']['1'] = new Array('HUANCAYO','CARHUACALLANGA','COLCA','CULLHUAS','CHACAPAMPA','CHICCHE','CHILCA','CHONGOS ALTO','CHUPURO','EL TAMBO','HUACRAPUQUIO','HUALHUAS','HUANCAN','HUASICACHI','HUAYUCACHI','INGENIO','PARIAHUANCA','PILCOMAYO','PUCARA','QUICHUAY','QUILCAS','SAN AGUSTIN','SAN JERONIMO DE TUNAM','SANTO DOMINGO DE ACOBAMBA','SAÑO','SAPALLANGA','SICAYA','VIQUES');
	distritos['11']['2'] = new Array('CONCEPCION', 'ACO','ANDAMARCA','COMAS','COCHAS','CHAMBARA','HEROINAS TOLEDO','MANZANARES','MARISCAL CASTILLA','MATAHUASI','MITO','NUEVE DE JULIO','ORCUTANA','SANTA ROSA DE OCOPA','SAN JOSE DE QUERO');
	distritos['11']['3'] = new Array('JAUJA', 'ACOLLA','APATA','ATAURA','CANCHAYLLO','EL MANTARO','HUAMALI','HUARIPAMPA','HUERTAS','JANJAILLO','JULCAN','LEONOR ORDOÑEZ','LLOCLLAPAMPA','MARCO','MASMA','MOLINOS','MONOBAMBA','MUQUI','MUQUIYAUYO','PACA','PACCHA','PANCAN','PARCO','POMACANCHA','RICRAN','SAN LORENZO','SAN PEDRO DE CHUNAN','SINCOS','TUNAN MARCA','YAULI','CURICACA','MASMA CHICCHE','SAUSA','YAUYOS');
	distritos['11']['4'] = new Array('JUNIN','CARHUAMAYO','ONDORES','ULCUMAYO');
	distritos['11']['5'] = new Array('TARMA', 'ACOBAMBA','HUARICOLCA','HUASAHUASI','LA UNION','PALCA','PALCAMAYO','SAN PEDRO DE CAJAS','TAPO');
	distritos['11']['6'] = new Array('LA OROYA', 'CHACAPALPA','HUAY HUAY','MARCAPOMACOCHA','MOROCOCHA','PACCHA','SANTA BARBARA DE CARHUACAYAN','SUITUCANCHA','YAULI','SANTA ROSA DE SACCO');
	distritos['11']['7'] = new Array('SATIPO', 'COVIRIALI','LLAYLLA','MAZAMARI','PAMPA HERMOSA','PANGOA','RIO NEGRO','RIO TAMBO');
	distritos['11']['8'] = new Array('CHANCHAMAYO', 'SAN RAMON','VITOC','SAN LUIS DE SHUARO','PICHANAQUI','PERENE');
	distritos['11']['9'] = new Array('CHUPACA', 'AHUAC','CHONGOS BAJO','HUACHAC','HUAMANCACA CHICO','SAN JUAN DE YSCOS','SAN JUAN DE JARPA','TRES DE DICIEMBRE','YANACANCHA');
	

	distritos['12'] = new Array();
	distritos['12']['1'] = new Array('TRUJILLO','HUANCHACO','LAREDO','MOCHE','SALAVERRY','SIMBAL','VICTOR LARCO HERRERA','POROTO','EL PORVENIR','LA ESPERANZA','FLORENCIA DE MORA');
	distritos['12']['2'] = new Array('BOLIVAR','BAMBAMARCA','CONDORMARCA','LONGOTEA','UCUNCHA','UCHUMARCA');
	distritos['12']['3'] = new Array('HUAMACHUCO','COCHORCO','CURGOS','CHUGAY','MARCABAL','SANAGORAN','SARIN','SARTIMBAMBA');
	distritos['12']['4'] = new Array('OTUZCO','AGALLPAMPA','CHARAT','HUARANCHAL','LA CUESTA','PARANDAY','SALPO','SINSICAP','USQUIL','MACHE');
	distritos['12']['5'] = new Array('SAN PEDRO DE LLOC','GUADALUPE','JEQUETEPEQUE','PACASMAYO','SAN JOSE');
	distritos['12']['6'] = new Array('TAYABAMBA','BULDIBUYO','CHILLIA','HUAYLILLAS','HUANCASPATA','HUAYO','ONGON','PARCOY','PATAZ','PIAS','TAURIJA','URPAY','SANTIAGO DE CHALLAS');
	distritos['12']['7'] = new Array('SANTIAGO DE CHUCO','CACHICADAN','MOLLEBAMBA','MOLLEPATA','QUIRUVILCA','SANTA CRUZ DE CHUCA','SITABAMBA','ANGASMARCA');
	distritos['12']['8'] = new Array('ASCOPE','CHICAMA','CHOCOPE','SANTIAGO DE CAO','MAGDALENA DE CAO','PAIJAN','RAZURI','CASA GRANDE');
	distritos['12']['9'] = new Array('CHEPEN','PACANGA','PUEBLO NUEVO');
	distritos['12']['10'] = new Array('JULCAN','CARABAMBA','CALAMARCA','HUASO');
	distritos['12']['11'] = new Array('CASCAS','LUCMA','MARMOT','SAYAPULLO');
	distritos['12']['12'] = new Array('VIRU','CHAO','GUADALUPITO');
	
	distritos['13'] = new Array();
	distritos['13']['1'] = new Array('CHICLAYO','CHONGOYAPE','ETEN','ETEN PUERTO','LAGUNAS','MONSEFU','NUEVA ARICA','OYOTUN','PICSI','PIMENTEL','REQUE','JOSE LEONARDO ORTIZ','SANTA ROSA','SAÑA','LA VICTORIA','CAYALTI','PATAPO','POMALCA','PUCALA','TUMAN');
	distritos['13']['2'] = new Array('FERREÑAFE','INCAHUASI','CAÑARIS','PITIPO','PUEBLO NUEVO','MANUEL ANTONIO MESONES MURO');
	distritos['13']['3'] = new Array('LAMBAYEQUE','CHOCHOPE','ILLIMO','JAYANCA','MOCHUMI','MORROPE','MOTUPE','OLMOS','PACORA','SALAS','SAN JOSE','TUCUME');
	
	distritos['14'] = new Array();
	distritos['14']['1'] = new Array('LIMA','ANCON','ATE','BREÑA','CARABAYLLO','COMAS','CHACLACAYO','CHORRILLOS','LA VICTORIA','LA MOLINA','LINCE','LURIGANCHO','LURIN','MAGDALENA DEL MAR','MIRAFLORES','PACHACAMAC','PUEBLO LIBRE','PUCUSANA','PUENTE PIEDRA','PUNTA HERMOSA','PUNTA NEGRA','RIMAC','SAN BARTOLO','SAN ISIDRO','BARRANCO','SAN MARTIN DE PORRES','SAN MIGUEL','SANTA MARIA DEL MAR','SANTA ROSA','SANTIAGO DE SURCO','SURQUILLO','VILLA MARIA DEL TRIUNFO','JESUS MARIA','INDEPENDENCIA','EL AGUSTINO','SAN JUAN DE MIRAFLORES','SAN JUAN DE LURIGANCHO','SAN LUIS','CIENEGUILLA','SAN BORJA','VILLA EL SALVADOR','LOS OLIVOS','SANTA ANITA');
	distritos['14']['2'] = new Array('CAJATAMBO','COPA','GORGOR','HUANCAPON','MANAS');
	distritos['14']['3'] = new Array('CANTA','ARAHUAY','HUAMANTANGA','HUAROS','LACHAQUI','SAN BUENAVENTURA','SANTA ROSA DE QUIVES');
	distritos['14']['4'] = new Array('SAN VICENTE DE CAÑETE','CALANGO','CERRO AZUL','COAYLLO','CHILCA','IMPERIAL','LUNAHUANA','MALA','NUEVO IMPERIAL','PACARAN','QUILMANA','SAN ANTONIO','SAN LUIS','SANTA CRUZ DE FLORES','ZUÑIGA','ASIA');
	distritos['14']['5'] = new Array('HUACHO','AMBAR','CALETA DE CARQUIN','CHECRAS','HUALMAY','HUAURA','LEONCIO PRADO','PACCHO','SANTA LEONOR','SANTA MARIA','SAYAN','VEGUETA');
	distritos['14']['6'] = new Array('MATUCANA','ANTIOQUIA','CALLAHUANCA','CARAMPOMA','CASTA','SAN JOSE DE LOS CHORRILLOS','CHICLA','HUANZA','HUAROCHIRI','LAHUAYTAMBO','LANGA','MARIATANA','RICARDO PALMA','SAN ANDRES DE TUPICOCHA','SAN ANTONIO','SAN BARTOLOME','SAN DAMIAN','SANGALLAYA','SAN JUAN DE TANTARANCHE','SAN LORENZO DE QUINTI','SAN MATEO','SAN MATEO DE OTAO','SAN PEDRO DE HUANCAYRE','SANTA CRUZ DE COCACHACRA','SANTA EULALIA','SANTIAGO DE ANCHUCAYA','SANTIAGO DE TUNA','SANTO DOMINGO DE LOS OLLEROS','SURCO','HUACHUPAMPA','LARAOS','SAN JUAN DE IRIS');
	distritos['14']['7'] = new Array('YAUYOS','ALIS','ALLAUCA','AYAVIRI','AZANGARO','CACRA','CARANIA','COCHAS','COLONIA','CHOCOS','HUAMPARA','HUANCAYA','HUANGASCAR','HUANTAN','HUAÑEC','LARAOS','LINCHA','MIRAFLORES','OMAS','QUINCHES','QUINOCAY','SAN JOAQUIN','SAN PEDRO DE PILAS','TANTA','TAURIPAMPA','TUPE','TOMAS','VIÑAC','VITIS','HONGOS','MADEAN','PUTINZA','CATAHUASI');
	distritos['14']['8'] = new Array('HUARAL','ATAVILLOS ALTO','ATAVILLOS BAJO','AUCALLAMA','CHANCAY','IHUARI','LAMPIAN','PACARAOS','SAN MIGUEL DE ACOS','VEINTISIETE DE NOVIEMBRE','SANTA CRUZ DE ANDAMARCA','SUMBILCA');
	distritos['14']['9'] = new Array('BARRANCA','PARAMONGA','PATIVILCA','SUPE','SUPE PUERTO');
	distritos['14']['10'] = new Array('OYON','NAVAN','CAUJUL','ANDAJES','PACHANGARA','COCHAMARCA');
		
	distritos['15'] = new Array();
	distritos['15']['1'] = new Array('IQUITOS','ALTO NANAY','FERNANDO LORES','LAS AMAZONAS','MAZAN','NAPO','PUTUMAYO','TORRES CAUSANA','INDIANA','PUNCHANA','BELEN','SAN JUAN BAUTISTA','TENIENTE MANUEL CLAVERO');
	distritos['15']['2'] = new Array('YURIMAGUAS','BALSAPUERTO','JEBEROS','LAGUNAS','SANTA CRUZ','TENIENTE CESAR LOPEZ ROJAS');
	distritos['15']['3'] = new Array('NAUTA','PARINARI','TIGRE','URARINAS','TROMPETEROS');
	distritos['15']['4'] = new Array('REQUENA','ALTO TAPICHE','CAPELO','EMILIO SAN MARTIN','MAQUIA','PUINAHUA','SAQUENA','SOPLIN','TAPICHE','JENARO HERRERA','YAQUERANA');
	distritos['15']['5'] = new Array('CONTAMANA','VARGAS GUERRA','PADRE MARQUEZ','PAMPA HERMOSA','SARAYACU','INAHUAYA');
	distritos['15']['6'] = new Array('RAMON CASTILLA','PEBAS','YAVARI','SAN PABLO');
	distritos['15']['7'] = new Array('BARRANCA','ANDOAS','CAHUAPANAS','MANSERICHE','MORONA','PASTAZA');
		
	distritos['16'] = new Array();
	distritos['16']['1'] = new Array('TAMBOPATA','INAMBARI','LAS PIEDRAS','LABERINTO');
	distritos['16']['2'] = new Array('MANU','ITZCARRALD','MADRE DE DIOS','HUEPETUHE');
	distritos['16']['3'] = new Array('IÑAPARI','IBERIA','TAHUAMANU');
	
	distritos['17'] = new Array();
	distritos['17']['1'] = new Array('MOQUEGUA','CARUMAS','CUCHUMBAYA','SAN CRISTOBAL','TORATA','SAMEGUA');
	distritos['17']['2'] = new Array('OMATE','COALAQUE','CHOJATA','ICHUÑA','LA CAPILLA','LLOQUE','MATALAQUE','PUQUINA','QUINISTAQUILLAS','UBINAS','YUNGA');
	distritos['17']['3'] = new Array('ILO','EL ALGARROBAL','PACOCHA');
	
	distritos['18'] = new Array();
	distritos['18']['1'] = new Array('CHAUPIMARCA','HUACHON','HUARIACA','HUAYLLAY','NINACACA','PALLANCHACRA','PAUCARTAMBO','SAN FCO DE ASIS DE YARUSYACAN','SIMON BOLIVAR','TICLACAYAN','TINYAHUARCO','VICCO','YANACANCHA');
	distritos['18']['2'] = new Array('YANAHUANCA','CHACAYAN','GOYLLARISQUIZGA','PAUCAR','SAN PEDRO DE PILLAO','SANTA ANA DE TUSI','TAPUC','VILCABAMBA');
	distritos['18']['3'] = new Array('OXAPAMPA','CHONTABAMBA','HUANCABAMBA','PUERTO BERMUDEZ','VILLA RICA','POZUZO','PALCAZU','CONSTITUCION');
	
	distritos['19'] = new Array();
	distritos['19']['1'] = new Array('PIURA','CASTILLA','CATACAOS','LA ARENA','LA UNION','LAS LOMAS','TAMBO GRANDE','CURA MORI','EL TALLAN','VEINTISEIS DE OCTUBRE');
	distritos['19']['2'] = new Array('AYABACA','FRIAS','LAGUNAS','MONTERO','PACAIPAMPA','SAPILLICA','SICCHEZ','SUYO','JILILI','PAIMAS');
	distritos['19']['3'] = new Array('HUANCABAMBA','CANCHAQUE','HUARMACA','SONDOR','SONDORILLO','EL CARMEN DE LA FRONTERA','SAN MIGUEL DE EL FAIQUE','LALAQUIZ');
	distritos['19']['4'] = new Array('CHULUCANAS','BUENOS AIRES','CHALACO','MORROPON','SALITRAL','SANTA CATALINA DE MOSSA','SANTO DOMINGO','LA MATANZA','YAMANGO','SAN JUAN DE BIGOTE');
	distritos['19']['5'] = new Array('PAITA','AMOTAPE','ARENAL','LA HUACA','COLAN','TAMARINDO','VICHAYAL');
	distritos['19']['6'] = new Array('SULLANA','BELLAVISTA','LANCONES','MARCAVELICA','MIGUEL CHECA','QUERECOTILLO','SALITRAL','IGNACIO ESCUDERO');
	distritos['19']['7'] = new Array('PARIÑAS','EL ALTO','LA BREA','LOBITOS','MANCORA','LOS ORGANOS');
	distritos['19']['8'] = new Array('SECHURA','VICE','BERNAL','BELLAVISTA DE LA UNION','CRISTO NOS VALGA','RINCONADA-LLICUAR');
	
	distritos['20'] = new Array();
	distritos['20']['1'] = new Array('PUNO','ACORA','ATUNCOLLA','CAPACHICA','COATA','CHUCUITO','HUATA','MAÑAZO','PAUCARCOLLA','PICHACANI','SAN ANTONIO','TIQUILLACA','VILQUE','PLATERIA','AMANTANI');
	distritos['20']['2'] = new Array('AZANGARO','ACHAYA','ARAPA','ASILLO','CAMINACA','CHUPA','JOSE DOMINGO CHOQUEHUANCA','MUÑANI','POTONI','SAMAN','SAN ANTON','SAN JOSE','SAN JUAN DE SALINAS','SANTIAGO DE PUPUJA','TIRAPATA');
	distritos['20']['3'] = new Array('MACUSANI','AJOYANI','AYAPATA','COASA','CORANI','CRUCERO','ITUATA','OLLACHEA','SAN GABAN','USICAYOS');
	distritos['20']['4'] = new Array('JULI','DESAGUADERO','HUACULLANI','PISACOMA','POMATA','ZEPITA','KELLUYO');
	distritos['20']['5'] = new Array('HUANCANE','COJATA','INCHUPALLA','PUSI','ROSASPATA','TARACO','VILQUE CHICO','HUATASANI');
	distritos['20']['6'] = new Array('LAMPA','CABANILLA','CALAPUJA','NICASIO','OCUVIRI','PALCA','PARATIA','PUCARA','SANTA LUCIA','VILAVILA');
	distritos['20']['7'] = new Array('AYAVIRI','ANTAUTA','CUPI','LLALLI','MACARI','NUÑOA','ORURILLO','SANTA ROSA','UMACHIRI');
	distritos['20']['8'] = new Array('SANDIA','CUYOCUYO','LIMBANI','PHARA','PATAMBUCO','QUIACA','SAN JUAN DEL ORO','YANAHUAYA','ALTO INAMBARI','SAN PEDRO DE PUTINA PUNCO');
	distritos['20']['9'] = new Array('JULIACA','CABANA','CABANILLAS','CARACOTO');
	distritos['20']['10'] = new Array('YUNGUYO','UNICACHI','ANAPIA','COPANI','CUTURAPI','OLLARAYA','TINICACHI');
	distritos['20']['11'] = new Array('PUTINA','PEDRO VILCA APAZA','QUILCAPUNCU','ANANEA','SINA');
	distritos['20']['12'] = new Array('ILAVE','PILCUYO','SANTA ROSA','CAPASO','CONDURIRI');
	distritos['20']['13'] = new Array('MOHO','CONIMA','TILALI','HUAYRAPATA');
	
	distritos['21'] = new Array();
	distritos['21']['1'] = new Array('MOYOBAMBA','CALZADA','HABANA','JEPELACIO','SORITOR','YANTALO');
	distritos['21']['2'] = new Array('SAPOSOA','PISCOYACU','SACANCHE','TINGO DE SAPOSOA','ALTO SAPOSOA','EL ESLABON');
	distritos['21']['3'] = new Array('LAMAS','BARRANQUITA','CAYNARACHI','CUÑUMBUQUI','PINTO RECODO','RUMISAPA','SHANAO','TABALOSOS','ZAPATERO','ALONSO DE ALVARADO','SAN ROQUE DE CUMBAZA');
	distritos['21']['4'] = new Array('JUANJUI','CAMPANILLA','HUICUNGO','PACHIZA','PAJARILLO');
	distritos['21']['5'] = new Array('RIOJA','POSIC','YORONGOS','YURACYACU','NUEVA CAJAMARCA','ELIAS SOPLIN VARGAS','SAN FERNANDO','PARDO MIGUEL','AWAJUN');
	distritos['21']['6'] = new Array('TARAPOTO','ALBERTO LEVEAU','CACATACHI','CHAZUTA','CHIPURANA','EL PORVENIR','HUIMBAYOC','JUAN GUERRA','MORALES','PAPAPLAYA','SAN ANTONIO','SAUCE','SHAPAJA','LA BANDA DE SHILCAYO');
	distritos['21']['7'] = new Array('BELLAVISTA','SAN RAFAEL','SAN PABLO','ALTO BIAVO','HUALLAGA','BAJO BIAVO');
	distritos['21']['8'] = new Array('TOCACHE','NUEVO PROGRESO','POLVORA','SHUNTE','UCHIZA');
	distritos['21']['9'] = new Array('PICOTA','BUENOS AIRES','CASPIZAPA','PILLUANA','PUCACACA','SAN CRISTOBAL','SAN HILARION','TINGO DE PONASA','TRES UNIDOS','SHAMBOYACU');
	distritos['21']['10'] = new Array('SAN JOSE DE SISA','AGUA BLANCA','SHATOJA','SAN MARTIN','SANTA ROSA');
	
	distritos['22'] = new Array();
	distritos['22']['1'] = new Array('TACNA','CALANA','INCLAN','PACHIA','PALCA','POCOLLAY','SAMA','ALTO DE LA ALIANZA','CIUDAD NUEVA','CORONEL GREGORIO ALBARRACIN L.');
	distritos['22']['2'] = new Array('TARATA','HEROES ALBARRACIN','ESTIQUE','ESTIQUE PAMPA','SITAJARA','SUSAPAYA','TARUCACHI','TICACO');
	distritos['22']['3'] = new Array('LOCUMBA','ITE','ILABAYA');
	distritos['22']['4'] = new Array('CANDARAVE','CAIRANI','CURIBAYA','HUANUARA','QUILAHUANI','CAMILACA');
	
	distritos['23'] = new Array();
	distritos['23']['1'] = new Array('TUMBES','CORRALES','LA CRUZ','PAMPAS DE HOSPITAL','SAN JACINTO','SAN JUAN DE LA VIRGEN');
	distritos['23']['2'] = new Array('ZORRITOS','CASITAS','CANOAS DE PUNTA SAL');
	distritos['23']['3'] = new Array('ZARUMILLA','MATAPALO','PAPAYAL','AGUAS VERDES');
	
	distritos['24'] = new Array();
	distritos['24']['1'] = new Array('CALLAO','BELLAVISTA','LA PUNTA','CARMEN DE LA LEGUA-REYNOSO','LA PERLA','VENTANILLA');
	
	distritos['25'] = new Array();
	distritos['25']['1'] = new Array('CALLERIA','YARINACOCHA','MASISEA','CAMPOVERDE','IPARIA','NUEVA REQUENA','MANANTAY');
	distritos['25']['2'] = new Array('PADRE ABAD','IRAZOLA','CURIMANA');
	distritos['25']['3'] = new Array('RAIMONDI','TAHUANIA','YURUA','SEPAHUA');
	distritos['25']['4'] = new Array('PURUS');

	
	
	function setProvincias() {
		departamentoSel = document.getElementById('departamento_proc');
		provinciaList = provincias[departamentoSel.value];
		changeSelect('provincia_proc', provinciaList);
		distritosField = document.getElementById("distrito_proc");
		distritosField.options.length = 0;
	}

	function setDistritos() {
		departamentoSel = document.getElementById('departamento_proc');
		provinciaSel = document.getElementById('provincia_proc');
					
		if(provinciaSel.value == "0"){
			distritosField = document.getElementById("distrito_proc");
			distritosField.options.length = 0;
			return false;
		}else{
			distritoList = distritos[departamentoSel.value][provinciaSel.value];
			changeSelect('distrito_proc', distritoList);
		}		
	}
	
	function setProvinciasNac() {
		departamentoSel = document.getElementById('departamento_nac');
		provinciaList = provincias[departamentoSel.value];
		changeSelect('provincia_nac', provinciaList);
		distritosField = document.getElementById("distrito_nac");
		distritosField.options.length = 0;
	}

	function setDistritosNac() {
		departamentoSel = document.getElementById('departamento_nac');
		provinciaSel = document.getElementById('provincia_nac');
		if(provinciaSel.value == "0"){
			distritosField = document.getElementById("distrito_nac");
			distritosField.options.length = 0;
			return false;
		}else{
			distritoList = distritos[departamentoSel.value][provinciaSel.value];
			changeSelect('distrito_nac', distritoList);
		}
	}
	
	function setProvinciasAct() {
		departamentoSel = document.getElementById('departamento_act');
		provinciaList = provincias[departamentoSel.value];
		changeSelect('provincia_act', provinciaList);
		distritosField = document.getElementById("distrito_act");
		distritosField.options.length = 0;
	}

	function setDistritosAct() {
		departamentoSel = document.getElementById('departamento_act');
		provinciaSel = document.getElementById('provincia_act');
		if(provinciaSel.value == "0"){
			distritosField = document.getElementById("distrito_act");
			distritosField.options.length = 0;
			return false;
		}else{
			distritoList = distritos[departamentoSel.value][provinciaSel.value];
			changeSelect('distrito_act', distritoList);
		}
	}

	function changeSelect(fieldID, newOptions) {
		selectField = document.getElementById(fieldID);
		selectField.options.length = 0;
		selectField.options[selectField.options.length] = new Option('Seleccionar una Opcion', '0',"defaultSelected");
		var j = 1;
		for (i = 0; i < newOptions.length; i++) {
			selectField.options[selectField.length] = new Option(newOptions[i],	j);
			j++;
		}	
		
		
	}

// 	function registrar(provincia) {
// 		if (provincia == 1) {
// 			document.getElementById('Depar_nac').innerHTML = '+'
// 					+ '<option value="1">Callao</option>'
// 					+ '<option value="2">Matute</option>'
// 					+ ' <option value="3">Ate</option>';

// 		}

// 		else if (provincia == 2)
// 			document.getElementById('Depar_nac').innerHTML = '<option value="4">Noria</option><option value="5">Salaverry</option><option value="6">esperanza</option>';

// 	}
</script>
		
		
		
		
		
		