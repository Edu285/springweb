<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<center>
		Seleccione Tema:
		
			<option value="0">-Todos-</option>
			<option value="${t.idTema}">${t.nombreTema}</option>
			</c:forEach>
	
		<br><br>
		<div id="tbLibros">
		
		</div>
		<br>
		<h2>Carrito</h2>
		<div id="tbCarrito">
		
		</div>
	</center>
	<script type="text/javascript">
		$("#temaSel").change(function(){
			var url="librosTema";
			var params={"idTema":$("#temaSel").val()};
			gestionarPeticion(url,params);
		});
	
	function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>Titulo</th><th>Precio</th><th>Páginas</th><th></th></tr>";
			$.each(data,function(i,p){
				tabla+="<tr><td>"+p.titulo+"</td><td>"+p.precio+"</td><td>"+p.paginas+"</td><td><a href='#' onclick='agregarCarrito("+p.isbn+")'>Agregar</a></td></tr>";
			});
			tabla+="</table>";
			$("#tbLibros").html(tabla);
		});
	}
	function agregarCarrito(isbn){		
		var params={"isbn":isbn};
		pintarCarrito(params,"agregarCarrito");
	}
	
	function quitarCarrito(pos){		
		var params={"pos":pos};
		pintarCarrito(params,"eliminarCarrito");
	}
	function pintarCarrito(params){
		$.get(url,params,function(data){
			var tabla="<table border='1'><tr><th>Titulo</th><th>Tematica</th><th>Precio</th><th>Páginas</th><th></th></tr>";
			$.each(data,function(i,p){
				tabla+="<tr><td>"+p.titulo+"</td><td>"+p.temaDto.nombreTema+"</td><td>"+p.precio+"</td><td>"+p.paginas+"</td><td><a href='#' onclick='quitarCarrito("+i+")'>Quitar</a></td></tr>";
			});
			tabla+="</table>";
			$("#tbCarrito").html(tabla);
		});
	}
	</script>
</body>
</html>