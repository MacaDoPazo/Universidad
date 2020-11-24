<%@include file="header.jsp" %>
<div class="w3-row">
	<c:if test="${sessionScope.usuario_nombre != null}">
  <div class="w3-col s12 w3-green w3-center"><p><b>Materias</b></p></div>
  
  <c:forEach items="${listaMaterias}" var="materia" >
  <div class="w3-col s4 w3-center w3-mobile">
  <div class="w3-card w3-margin">
  <div class="w3-container w3-center w3-dark-grey w3-padding">
      <p><b>${materia.nombre}</b><br>
    ${materia.profesor.nombre } ${materia.profesor.apellido }<br>
  		${materia.horario }<br>
  		Capacidad alumnos: ${materia.maximoAlumnos }</p>
  		<c:if test="${sessionScope.usuario_rol != 'Admin'}">
  		<a class="w3-btn w3-red"href="detalle?idMateria=${materia.id }">Anotarse</a>
  		</c:if>
    
  </div>
  </div>
  </div>
  </c:forEach>
 </c:if>
 <c:if test="${sessionScope.usuario_nombre == null}">
 <img class="w3-image" src="img/universidad.jpg"  width="1500" height="800">
</c:if>
</div>
