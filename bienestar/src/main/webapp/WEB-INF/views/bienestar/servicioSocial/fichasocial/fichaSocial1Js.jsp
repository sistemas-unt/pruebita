
<!--page specific plugin scripts-->

<script src="../assets/js/fuelux/fuelux.wizard.min.js"></script>
<script src="../assets/js/jquery.validate.min.js"></script>
<script src="../assets/js/additional-methods.min.js"></script>
<script src="../assets/js/bootbox.min.js"></script>
<script src="../assets/js/jquery.maskedinput.min.js"></script>
<script src="../assets/js/select2.min.js"></script>


<script type="text/javascript">

	
	function habilitaenfermedad() {
		var enf=$('#txtenfermedad').get(0);
		enf.removeAttribute('readonly');
	}

	function deshabilitaenfermedad() {
		var enf=$('#txtenfermedad').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}
	
	function habilitaoperacion()
	{
		var enf=$('#txtoperacion').get(0);
		enf.removeAttribute('readonly');
	}
		
	function deshabilitaoperacion()
	{
		var enf=$('#txtoperacion').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}
	
	function habilitainmunizacion()
	{
		var enf=$('#txtinmunizacion').get(0);
		enf.removeAttribute('readonly');
	
	}
	
	function deshabilitainmunizacion()
	{
		var enf=$('#txtinmunizacion').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}
	
	function habilitaaccidente()
	{
		
		var enf=$('#txtaccidente').get(0);
		enf.removeAttribute('readonly');
	}
	
	function deshabilitaaccidente()
	{
		
		var enf=$('#txtaccidente').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}
	
	function habilitaalergia()
	{
		
		var enf=$('#txtalergia').get(0);
		enf.removeAttribute('readonly');
	}
	
	function deshabilitaalergia()
	{
		
		var enf=$('#txtalergia').get(0);
		enf.setAttribute('readonly' , 'true');
		enf.value=null;
	}
	
	
</script>