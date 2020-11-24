<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><h2><b>Lista de Materias:</b></h2></div>
 <div class="w3-col s12 w3-center">
 <a href="materiaNueva" class="w3-bar-item w3-button w3-green w3-margin">Registrar Materia Nueva</a>
 </div>
  <div class="w3-col s6 w3-center">
  <div class="w3-container">
  

  <table class="w3-table w3-striped">
    <tr>
      <th>Nombre</th>
      <th>Horario</th>
      <th>Profesor</th>
      <th>Capacidad alumnos</th>
    </tr>
    <c:forEach items="${listaMaterias}" var="materia">
      <tr>
      <td>${materia.nombre}</td>
      <td>${materia.horario}</td>
      <td>${materia.profesor.nombre} ${materia.profesor.apellido}</td>
      <td>${materia.maximoAlumnos }</td>
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