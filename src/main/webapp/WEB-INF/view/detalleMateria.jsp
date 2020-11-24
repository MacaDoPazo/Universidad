<%@include file="header.jsp" %>
<div class="w3-row">
  <div class="w3-col s12 w3-green w3-center"><p><b>Detalle de la materia</b></p></div>
  <div class="w3-col s6 w3-center">
  <p><b>Nombre:<br>
    Profesor:<br>
  		Horario:<br>
  		Descripcion: <br>
  		</b>
  </p><br>
    
  </div>
   <div class="w3-col s6 w3-center w3-mobile">
  <div class="w3-card w3-margin">
  <div class="w3-container w3-center w3-dark-grey w3-padding">
      <p><b>${materia.nombre}</b><br>
    ${materia.profesor.nombre } ${materia.profesor.apellido }<br>
  		${materia.horario }<br>
  		
  		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
  		</p>
    
  </div>
  </div>
  </div>
  <c:if test="${not empty error }">
  <div class="w3-col s12 w3-green w3-center">
  <b>${error }</b>
  </div>
  </c:if>
  <div class="w3-col s12 w3-green w3-center">
  <form  class="w3-row-padding" action="anotarse" method="POST" modelAttribute="usuario">
                    
                    <input type="hidden" name="dni" value=${sessionScope.usuario_dni }>
                    <input type="hidden" name="idMateria" value=${materia.id }>
                   <button type="submit" class="w3-bar-item w3-button w3-red">Anotarse</button>
                </form>
  </div>
</div>
