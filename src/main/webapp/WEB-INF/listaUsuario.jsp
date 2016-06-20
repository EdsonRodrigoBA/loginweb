<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.aprendendoweb.persistencia.entidade.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="validador.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("lista");
	%>
<table border="1">
	<tr>
		<td>ID</td>
		<td>Nome </td>
		<td>Login</td>
		<td>Senha</td>
		<td>Ação </td>
	</tr>
	
	<%for(Usuario u : listaUsuario){%>
	<tr>
		<td><%=u.getIdUsuario() %></td>
		<td><%= u.getNome() %></td>
		<td><%= u.getLogin() %></td>
		<td><%= u.getSenha() %></td>
		
		<td><a href="javascript:confirmaExclusao(<%=u.getIdUsuario()%>)">Excluir</a>
		<a href="testeServelet?acao=altera&idUsuario=<%=u.getIdUsuario()%>">Alterar</a></td>
	</tr>
	
	<%} %>
</table>


</body>
</html>