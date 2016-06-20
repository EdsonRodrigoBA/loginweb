package br.aprendendoweb.Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.aprendendoweb.persistencia.entidade.Usuario;
import br.aprendendoweb.persistencia.jdbc.UsuarioDAO;
import br.aprendendoweb.persistencia.jdbc.UsuarioRequisicoes;

@WebServlet("/testeServelet")
public class UsuarioControler extends HttpServlet{
	 @Override
	public void init() throws ServletException {
		System.out.println("Iniciou");
	}
	
	 /*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Sucesso");
	} */
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 /**
		  * Verificar a ação que o usuario vai fazer se for excluir ele cai no if do exclir se nao vai para outro
		  */
		resp.setContentType("text/html");
		UsuarioRequisicoes requisicao = new UsuarioRequisicoes();
		requisicao.executa(req, resp);
 
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 UsuarioRequisicoes usuarioRequisicoes = new UsuarioRequisicoes();
		 usuarioRequisicoes.efetuarCadastro(req, resp);
		 
	}
	public UsuarioControler() {
		System.out.println("Iniciando Servelet");
	}
	
}
