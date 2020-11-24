<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><h2><b>Materia Nueva:</b></h2></div>
 
  <div class="w3-col s12 w3-center">
  <div class="w3-card-4 w3-margin w3-padding">
  <form class="w3-container" action="guardarMateria" method="post">

<label class="w3-text-blue w3-left"><b>Nombre</b></label>
<input class="w3-input w3-border" type="text" name="nombre">
 
<label class="w3-text-blue w3-left"><b>Capacidad de alumnos:</b></label>
<input class="w3-input w3-border" type="number" name="capacidad">

<label class="w3-text-blue w3-left"><b>Horario:</b></label>
<input class="w3-input w3-border" type="text" name="horario">

<label class="w3-text-blue w3-left"><b>Profesor:</b></label>
<select class="w3-select" name="dni">
	<option value="" disabled selected>Elige profesor disponible</option>
	<c:forEach items="${listaProfesores}" var="profesor">
	  <option value="${profesor.dni }">${profesor.nombre } ${profesor.apellido }</option>
	</c:forEach>
  </select>
<button class="w3-btn w3-blue">Registrar</button>
 
</form>
  </div></div>
  <c:if test="${not empty error }">
  <div class="w3-col s12 w3-green w3-center">
  <b>${error }</b>
  </div>
  </c:if>
  
</div>