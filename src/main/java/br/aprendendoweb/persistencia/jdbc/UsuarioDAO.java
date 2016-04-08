package br.aprendendoweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.aprendendoweb.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	
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
	
	public void excluir(Usuario usuario){
		String sql = "delete from usuario where idusuario = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setString(1, usuario.getNome());
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void salvar(Usuario usuario){
		if(usuario.getIdUsuario() != 0){
			aleterar(usuario);
		}else {
			cadastrar(usuario);
		}
	}

}
