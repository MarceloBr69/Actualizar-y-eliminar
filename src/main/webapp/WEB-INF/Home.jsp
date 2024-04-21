<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Libros:</h1>
		
		<ul>
			
			<c:forEach var="Libro" items="${libros}"><!-- libros es proveniente del nombre de la tabla -->
			
			
			
			
			
			
			
			
			
				<c:forEach var="Libro" items="${libros}">
    				<form:form action="/libro/${Libro.id}" method="POST">
        				<button type="submit"><c:out value="${Libro.titulo}"/></button>
   					</form:form>
				</c:forEach>

				
				
				
				
				
				<form:form action="/borrar/{id}" method="POST" modelAttribute="LibrosModelo">
		    		<button>Eliminar</button>
		    	</form:form>
		    	
		    	
		    	
			
			</c:forEach>
		</ul>
		<div>
			<h1>Crea un libro</h1>
			<form:form action="/crearLibro" method="POST" modelAttribute="LibrosModelo">
				<form:label for="titulo" path="titulo">Titulo: </form:label>
				<form:input path="titulo" type="text" />
				
				<form:label for="descripcion" path="descripcion">Descripcion: </form:label>
				<form:input path="descripcion" type="text" />
				
				<form:label for="lenguaje" path="lenguaje">Lenguaje: </form:label>
				<form:input path="lenguaje" type="text" />
				
				<form:label for="numerosDePaginas" path="numerosDePaginas">Paginas: </form:label>
				<form:input path="numerosDePaginas" type="text" />
				
				<button>Enviar</button>
			</form:form>
		</div>
		<div>
		    <h1>Elimina un libro:</h1>
		    <form action="/borrar/{id}" method="POST">
		        <label for="id">Según el ID:</label>
		        <input type="text" name="id" />
		        <input type="submit" value="Eliminar" />
		    </form>
		</div>
	</body>
</html>