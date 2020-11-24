<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><h2><b>Materias Anotadas:</b></h2></div>
  <div class="w3-col s6 w3-center">
  <div class="w3-container">
  

  <table class="w3-table w3-striped">
    <tr>
      <th>Nombre</th>
      <th>Horario</th>
      <th>Profesor</th>
    </tr>
    <c:forEach items="${listaMateriasAnotadas}" var="materia">
      <tr>
      <td>${materia.materia.nombre}</td>
      <td>${materia.materia.horario}</td>
      <td>${materia.materia.profesor.nombre} ${materia.materia.profesor.apellido}</td>
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