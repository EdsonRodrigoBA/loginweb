<%@page import="br.aprendendoweb.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%Usuario usuario = (Usuario)request.getAttribute("altera");
		 
		
		%>
		<form action="testeServelet" method="post" >
		Login:<input type="text" name="idUsuario" value="<%=usuario.getIdUsuario()%>"/><br>
		Nome:<input type="text" name="nome" value="<%= usuario.getNome() %>" /><br>
		Login:<input type="text" name="login" value="<%= usuario.getLogin()%>"/><br>
		Senha:<input type="text" name=senha value="<%= usuario.getSenha()%>"><br>
		
		<input type="submit" value="salvar">
	
	
	</form>

</body>
</html>