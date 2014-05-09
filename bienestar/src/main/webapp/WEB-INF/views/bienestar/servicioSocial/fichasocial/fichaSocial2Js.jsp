<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<script src="../assets/js/fuelux/fuelux.wizard.min.js"></script>
<script src="../assets/js/jquery.validate.min.js"></script>
<script src="../assets/js/additional-methods.min.js"></script>
<script src="../assets/js/bootbox.min.js"></script>
<script src="../assets/js/jquery.maskedinput.min.js"></script>
<script src="../assets/js/select2.min.js"></script>

<script src="../assets/js/validarCampos.js"></script>
<script src="../assets/js/date-time/bootstrap-datepicker.min.js"></script>


<script type="text/javascript">
	
window.onload = function () {
    if (typeof history.pushState === "function") {
        history.pushState("jibberish", null, null);
        window.onpopstate = function () {
            history.pushState('newjibberish', null, null);
            // Handle the back (or forward) buttons here
            // Will NOT handle refresh, use onbeforeunload for this.
        };
    }
    else {
        var ignoreHashChange = true;
        window.onhashchange = function () {
            if (!ignoreHashChange) {
                ignoreHashChange = true;
                window.location.hash = Math.random();
                // Detect and redirect change here
                // Works in older FF and IE9
                // * it does mess with your hash symbol (anchor?) pound sign
                // delimiter on the end of the URL
            }
            else {
                ignoreHashChange = false;   
            }
        };
    }
};
	
	
	function reset_campos() {
		$("#dni").val("");
		$("#nombre").val("");
		$("#apellidopaterno").val("");
		$("#apellidomaterno").val("");
		$("#edad").val("");
		$("#parentezco").val("");
		$("#estadocivil").val("");
		$("#gradoi").val("");
		$("#lugarna").val("");
		$("#edad").val("");
		$("#enfermedad").val("");
		$("#fallecimiento").val("");
	}
	
	$(document).ready(function() {
		//Para escribir solo numeros    
		$('#txtdni').validCampoFranz('0123456789');
		$('#txtingreso').validCampoFranz('0123456789');

	});
	
	$('.date-picker').datepicker().next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	
	function habilitafallecido()
	{
		var enf=$('#fallecimiento').get(0);
		enf.removeAttribute('readonly');
		
		document.getElementById('enferNo').checked = true;
		
		deshabilitaenfermedad();
	}

	function deshabilitafallecido()
	{
		var enf=$('#fallecimiento').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}

	function deshabilitaenfermedad()
	{
		var enf=$('#enfermedad').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}

	function habilitaenfermedad()
	{
		var enf=$('#enfermedad').get(0);
		enf.removeAttribute('readonly');
		
		document.getElementById('falleNo').checked = true;
		deshabilitafallecido();
	}
		

	
</script>