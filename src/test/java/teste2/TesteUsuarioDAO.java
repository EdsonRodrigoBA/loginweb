package teste2;

import java.util.List;

import javax.swing.JOptionPane;

import br.aprendendoweb.persistencia.entidade.Usuario;
import br.aprendendoweb.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastra();
		//testeAltera(4);
		//testeExcluir(4);
		//testeSalvar();
		//testeBusca();
		testeBuscaTodos();
	
	}
	
	public static void testeCadastra(){
		Usuario usuario = new Usuario();
		usuario.setNome("Daniel");
		usuario.setLogin("Coutinho");
		usuario.setSenha("123456");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		System.out.println("Cadastrado com Sucesso");
	}
	
	public static void testeAltera(int idUsuario){
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNome("teste");
		usuario.setLogin("teste");
		usuario.setSenha("123456");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		System.out.println("Aleterado com Sucesso");
	}
	
	public static void testeExcluir(int idUsuario){
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
		
		System.out.println("Excluido com Sucesso");
	}
	
	public static void testeSalvar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("edsonnnn");
		usuario.setNome("Anderson");
		usuario.setSenha("12345678");
		usuarioDAO.salvar(usuario);
		JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
	}
	
	
	public static void testeBusca(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.buscarPorId(1);

		System.out.println(usuario);
		
	}
	
	public static void testeBuscaTodos (){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		lista.forEach(System.out::println);
		
	}

}
