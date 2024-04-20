<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Modificar Libro</title>
	</head>
	<body>
		<h1>Modificar</h1>
		
		<form:form action="/editar" method="POST" modelAttribute="LibrosModelo">
				
			
				<form:label for="titulo" path="titulo">Titulo: </form:label>
				<form:input path="titulo" type="text" value="${libroid.titulo}"/>
				
				<form:label for="descripcion" path="descripcion">Descripcion: </form:label>
				<form:input path="descripcion" type="text" value="${libroid.descripcion}"/>
				
				<form:label for="lenguaje" path="lenguaje">Lenguaje: </form:label>
				<form:input path="lenguaje" type="text" value="${libroid.lenguaje}"/>
				
				<form:label for="numerosDePaginas" path="numerosDePaginas">Lenguaje: </form:label>
				<form:input path="numerosDePaginas" type="text" value="${libroid.numerosDePaginas}"/>
				
				<button>Modificar</button>
			</form:form>
	</body>
</html>