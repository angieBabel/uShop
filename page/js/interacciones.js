var c='';
var nc='';

$(document).click(function() {
	$(".colores").click(function() {
		nc= $(this).css('backgroundColor');//Color seleccionado
		alert('color nuevo: '+nc);
		$(".columnas").click(function() {
			$(this).css('background-color', nc);
			c= $(this).css('backgroundColor');//obtener color actual
			alert('Color : '+c);// mostrar mensaje
		});
	});
});
$(document).ready(function(){
  Parse.initialize("vzNlzf2N5gNdmSyt9Gwlzta4q0nRLU5ymkft364y", "nyn2TRm46wDovGNMU6slwOj5YneM3ufuwLHj3gMw");
});
