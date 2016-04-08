package y;

import br.aprendendoweb.persistencia.entidade.Usuario;
import br.aprendendoweb.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastra();
		//testeAltera(4);
		testeExcluir(4);
	
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

}
