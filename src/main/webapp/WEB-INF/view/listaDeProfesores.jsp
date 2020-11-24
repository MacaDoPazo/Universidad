<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><h2><b>Lista de Profesores:</b></h2></div>
 <div class="w3-col s12 w3-center">
 <a href="profesorNuevo" class="w3-bar-item w3-button w3-green w3-margin">Registrar Profesor</a>
 </div>
  <div class="w3-col s6 w3-center">
  <div class="w3-container">
  

  <table class="w3-table w3-striped w3-mobile">
    <tr>
      <th>DNI</th>
      <th>Apellido</th>
      <th>Nombre</th>
      <th>Estado</th>
    </tr>
    <c:forEach items="${listaProfesores}" var="profesor">
      <tr>
      <td>${profesor.dni}</td>
      <td>${profesor.apellido}</td>
      <td>${profesor.nombre} </td>
      <td>${profesor.estado }</td>
      <td>
      <from action="actualizarEstado" method="post">
      <select class="w3-select" name="estado">
	<option value="" disabled selected>Elige estado</option>
	<option value="activo">ACTIVO</option>
	<option value="desactivo">DESACTIVO	</option>
	
  </select>
  <button class="w3-btn w3-blue" type="submit">Cambiar</button>
      </from>
      </td>
      </tr>
    </c:forEach>
    
  </table>
</div>
  </div>
  <c:if test="${not empty error }">
  <div class="w3-col s12 w3-green w3-center">
  <b>${error }</b>
  </div>
  </c:if>
  
</div>