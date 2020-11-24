<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><h2><b>Profesor nuevo:</b></h2></div>
 
  <div class="w3-col s12 w3-center">
  <div class="w3-card-4 w3-margin w3-padding">
  <form class="w3-container" action="guardarProfesor" method="post">

<label class="w3-text-blue w3-left"><b>DNI</b></label>
<input class="w3-input w3-border" type="number" name="dni">
 
<label class="w3-text-blue w3-left"><b>Nombre:</b></label>
<input class="w3-input w3-border" type="text" name="nombre">

<label class="w3-text-blue w3-left"><b>Apellido:</b></label>
<input class="w3-input w3-border" type="text" name="apellido">

<label class="w3-text-blue w3-left"><b>Estado:</b></label>
<select class="w3-select" name="estado">
	<option value="" disabled selected>Elige estado</option>
	<option value="activo">ACTIVO</option>
	<option value="desactivo">DESACTIVO	</option>
	  
	
  </select>
<button class="w3-btn w3-blue">Registrar</button>
 
</form>
  </div></div>
  
  
</div>