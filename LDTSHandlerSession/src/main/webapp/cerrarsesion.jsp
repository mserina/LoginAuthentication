<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<%
//En esta linea se accede a la clase de la sesion y se invalida, lo que nos impide
//acceder a la informacion de dicha sesion
session.invalidate();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Sesi&oacute;n Cerrada.<br/>
<a href="index.jsp">Volver</a>
</body>
</html> 