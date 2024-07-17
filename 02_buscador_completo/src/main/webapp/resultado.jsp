<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BUSQUEDA POR URL</title>
</head>
<body>
	
		<h2>URL:${requestScope.url}"</h2><br>
		<h2>TEMATICA: ${requestScope.tematica}</h2><br>
		<h2>DESCRIPCION: ${requestScope.descripcion}</h2><br>
		<br>
		<a href="toInicio">Volver</a>
	
</body>
</html>