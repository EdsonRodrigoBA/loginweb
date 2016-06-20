package br.aprendendoweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.aprendendoweb.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	
	
	/**
	 * Metodo responsavel por fazer o registro na base de dados.
	 * @param usuario objeto que sera cadastrado no banco de dados.
	 */
	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario(nome, login,senha)values(?,?,?)";
		try(PreparedStatement preparestatement = con.prepareStatement(sql)) {
			
			preparestatement.setString(1, usuario.getNome()); //substitui o ? pelo dado do usuario
			preparestatement.setString(2, usuario.getLogin());
			preparestatement.setString(3, usuario.getSenha());
			
			//executando comando sql
			
			preparestatement.execute();
			preparestatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Metodo que faz a alteração / update de um registro .
	 * @param usuario objeto que sera alterado quando esse metodo for chamado.
	 */
	public void aleterar(Usuario usuario){
		String sql = "update usuario set nome = ?, login = ?, senha = ? where idusuario = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getLogin());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setInt(4, usuario.getIdUsuario());
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo responsavel por excluir um registro atraves da chave unica que é o ID.
	 * @param usuario objeto que sera excluido da base a partir do seu ID.
	 */
	public void excluir(Usuario usuario){
		String sql = "delete from usuario where idusuario = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setInt(1, usuario.getIdUsuario());
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que salvar usuario no banco de dados.
	 * Caso o usuario passado ja exista ou seja for diferente de null, entende-se que é para fazer uma alteração.
	 * Ou caso o usuario passado nao exista na base de dados ele salva como um novo.
	 * @param usuario objeto que sera salvo na base de dados.
	 */
	public void salvar(Usuario usuario){
		if(usuario.getIdUsuario() != null && usuario.getIdUsuario()!=0 ){
			aleterar(usuario);
		}else {
			cadastrar(usuario);
		}
	}
	
	/**
	 * Metodo que faz a busca dos registros através do ID do usuario.
	 * @param id é um inteiro que representa um reistro unico no banco de dados.
	 * @return caso o id especificado na chamada no metodo seja encontrado na base de dados, retorna um objeto usuario.
	 * para buscar um unico registro ultiliza-se if(resultSet.next).
	 */
	public Usuario buscarPorId(Integer id){
		String sql = "Select * from usuario where idUsuario = ?";
		Usuario usuario = null ;
		
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(result.getInt("idUsuario"));
				usuario.setNome(result.getString("Nome"));
				usuario.setLogin(result.getString("Login"));
				usuario.setSenha(result.getString("senha"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	/**
	 * Metodo que retorna uma lista de todos os registro do banco de dados.
	 * 
	 * @return uma lista com todos os objetos Usuario que estejam registrados na base de dados.
	 */
	public List<Usuario> buscarTodos(){
		List<Usuario> listarUsuarios = new ArrayList<>();
		
		String sql = "Select * from usuario";
		Usuario usuario = null ;
		
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			
			ResultSet result = preparedStatement.executeQuery();
			
			/*
			 * Dentro do while estou verificando se tem registro no banco de dados, enquanto tiver registro vai 
			 * adcionando um a um na lista e no final fora do while retorna todos os registro encontrados. 
			 */
			while(result.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(result.getInt("idUsuario"));
				usuario.setNome(result.getString("Nome"));
				usuario.setLogin(result.getString("Login"));
				usuario.setSenha(result.getString("senha"));
				
				// Adcionando cada registro encontro, na lista .
				listarUsuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listarUsuarios;
	}
	
	public Usuario autenciar(Usuario usuarioConsulta){
		String sql = " select * from usuario where login = ? and senha = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)){
			
			statement.setString(1, usuarioConsulta.getLogin());
			statement.setString(2, usuarioConsulta.getSenha());
			
			ResultSet result = statement.executeQuery();
			if(result.next()){
				Usuario usuario = new Usuario();
				//pegando os dados do banco e retornando
			usuario.setIdUsuario(result.getInt("idUsuario"));
			usuario.setLogin(result.getString("Login"));
			usuario.setSenha(result.getString("Senha"));
			return usuario;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
