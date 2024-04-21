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
	<h1>Información del Libro</h1>
    <p>Título: ${libroid.titulo}</p>
    <p>Descripcion: ${libroid.descripcion}</p>
    <p>Lenguaje: ${libroid.lenguaje}</p>
    <p>Numeros De Paginas: ${libroid.numerosDePaginas}</p>
    
    <form:form action="/libro/editar/${libroid.id}" method="GET">
		<button>Modificar</button>
	</form:form>
	<form action="/libro/borrar/${libroid.id}" method="POST">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>


	
</body>
</html>