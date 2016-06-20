package br.aprendendoweb.persistencia.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.aprendendoweb.persistencia.entidade.Usuario;

public class UsuarioRequisicoes {
	/**
	 * Metodo que delega responsabilidades para o servelet controler. atravéns das ações que o usuarios fazem.
	 * @param request pega uma requisição do cliente processa
	 * @param response devolve uma resposta para o cliente.
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void executa(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
		 String acao = request.getParameter("acao"); 
		 if(acao.equals("exc")){
			 String idUsuario = request.getParameter("idUsuario");
			 Usuario usuario = new Usuario();
			 if(idUsuario != null){
				 usuario.setIdUsuario(Integer.parseInt(idUsuario));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
					usuarioDAO.excluir(usuario);
					/*
					 * Após o usuario clica em excluir ele retorna para a mesma pagina.
					 */
					response.sendRedirect("testeServelet?acao=lista");
			 }	 
		 }else if(acao.equals("lista")){
			 UsuarioDAO usuarioDAO = new UsuarioDAO();
			 List<Usuario> list = usuarioDAO.buscarTodos();
			 
			request.setAttribute("lista", list);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/listaUsuario.jsp");
			requestDispatcher.forward(request, response); 

			
			
			

		 }else if(acao.equals("altera")){
			 
			 String idUsuario = request.getParameter("idUsuario");
			 
			 UsuarioDAO usuarioDAO = new UsuarioDAO();
			 Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(idUsuario));
			 request.setAttribute("altera", usuario);
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("formCadastra.jsp");
			 requestDispatcher.forward(request, response);
			 if(idUsuario != null){
					usuarioDAO.salvar(usuario);
			 }
			 
		 }else if (acao.equals("cad")){
			 Usuario usuario = new Usuario();
			 usuario.setIdUsuario(0);
			 usuario.setNome("");
			 usuario.setLogin("");
			 usuario.setSenha("");
			 request.setAttribute("cadastra", usuario);
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("formCadastra2.jsp");
			 requestDispatcher.forward(request, response);
		 }
	}
	
	public void efetuarCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idUsuario = request.getParameter("idUsuario");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		if(idUsuario != null){
			usuario.setIdUsuario(Integer.parseInt(idUsuario));
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuarioDAO.salvar(usuario);
		}	
	
		response.getWriter().print("Salvo");
	}

}
