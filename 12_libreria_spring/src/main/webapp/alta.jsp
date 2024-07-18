<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	USUARIO:<b th: text="$session.usuario"></b>	
	<center>
		ISBN: <input type="text" id="isbn"><br>
		T�tulo: <input type="text" id="titulo"><br>
		Autor: <input type="text" id="autor"><br>
		Precio: <input type="text" id="precio"><br>
		P�ginas: <input type="text" id="paginas"><br>
		Tem�tica:<select id="tematica" >
		<option th:each="t:${temas}" th:value="${t.idTema}" th:text="${t.nombreTema}"></option>
		
		<input type="button" value="Alta" id="alta">
		<br><br>
		<a href="FrontController?operation=doInicio">Volver</a>
	</center>
	<script type="text/javascript">
		$("#alta").click(function(){
			var url="FrontController";
			var params={"operation":"doAltaLibro",
					"isbn":$("#isbn").val(),
					"titulo":$("#titulo").val(),
					"autor":$("#autor").val(),
					"precio":$("#precio").val(),
					"paginas":$("#paginas").val(),
					"idTema":$("#tematica").val()};
			$.get(url,params,function(data){
				let mensaje;
				if(data=="true"){
					mensaje="Libro a�adido!";
				}else{
					mensaje="ISBN duplicado!!, no se ha podido a�adir el libro";
				}
				alert(mensaje);
			});
		});
	
	</script>
</body>
</html>