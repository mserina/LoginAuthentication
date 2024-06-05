<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
	<h1>Controlador de sesiones</h1>
	<p>Revisando si tu sesion ha sido autenticada...<p>
	<br>
	
	<%
		
		
		//SE ACCEDE A LA SESION, AL ATRIBUTO1 (EN FORMATO STRING) QUE CONTIENE LA AUTENTICACION DEL USUARIO
		//SI NO ES NULL, SI EL ATRIBUTO NO ES NULL SE VERIFICA LA ENTRADA A LA SESION
		if ((String) session.getAttribute("nivel") != null) {
			
			out.print("Ha entrado en la sesion");

		} 
		//POR LO CONTRARIO SI NO SE PUDIERA ACCEDER A LA SESSION ENTONCES NOS SALE EL MENSAJE
		//DE QUE EL USUARIO HA SALIDO DE LA SESSION
		else 
		{
			out.print("Ha salido de la sesion");

		}
		%>
	

</body>
</html>
