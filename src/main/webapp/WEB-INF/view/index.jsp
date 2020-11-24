<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><p><b>Materias</b></p></div>
  <c:forEach items="${listaMaterias}" var="materia" >
  <div class="w3-col s4 w3-center">
  <div class="w3-card w3-margin">
  <div class="w3-container w3-center w3-dark-grey w3-padding">
      <p><b>${materia.nombre}</b><br>
    ${materia.profesor.nombre } ${materia.profesor.apellido }<br>
  		${materia.horario }<br>
  		Capacidad alumnos: ${materia.maximoAlumnos }</p>
  		<c:if test="${sessionScope.usuario_rol != 'Admin'}">
  		<a href="detalle?idMateria=${materia.id }">Anotarse</a>
  		</c:if>
    
  </div>
  </div>
  </div>
  </c:forEach>
 
</div>
