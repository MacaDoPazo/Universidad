<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Universidad</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
</head>
<body>
    
        <div class="w3-bar">
        <header class="w3-container w3-teal">
        <c:choose>
		<c:when test="${sessionScope.usuario_nombre ==null}">
   
            <a href="inicio" class="w3-bar-item w3-button w3-margin">Universidad</a>
            <div class="w3-right w3-margin">
                <form  class="w3-row-padding" action="login" method="POST" modelAttribute="usuario">
                    <div class="w3-third">
                    <input type="text" name="dni" class="w3-input w3-border" placeholder="DNI">
                    </div>
                    <div class="w3-third">
                    <input type="text" name="legajo" class="w3-input w3-border" placeholder="legajo">
                    </div>
                    <button type="submit" class="w3-bar-item w3-button w3-green">Ingresar</button>
                </form>
            </div>
          </div>
        </c:when>
	<c:when test="${sessionScope.usuario_rol == 'Admin'}">
	<a href="inicio" class="w3-bar-item w3-button w3-margin">Universidad</a>
            <div class="w3-right w3-margin">
                
                    <div class="w3-bar-item w3-button" >
                    <p><b>Bienvenido</b>  ${sessionScope.usuario_nombre}</p>
                    </div>
                    <div class="w3-bar-item w3-button w3-green">
                    <a href="logout">Salir</a>
               		</div>
            </div>
<%@include file="navAdmin.jsp" %>  
	</c:when>
	<c:when test="${sessionScope.usuario_nombre != null}">
	<a href="inicio" class="w3-bar-item w3-button w3-margin">Universidad</a>
            <div class="w3-right w3-margin">
                <div class="w3-bar-item w3-button" >
                    <p><b>Bienvenido</b>  ${sessionScope.usuario_nombre}</p>
                    </div>
                    <div class="w3-bar-item w3-button w3-green">
                    <a href="listarMateriasAnotadas">Mis materias</a>
               		</div>
                    <div class="w3-bar-item w3-button w3-green">
                    <a href="logout">Salir</a>
               		</div>
            </div>
          
	</c:when>
	</c:choose>
      </header>
      </div>
</body>
</html>