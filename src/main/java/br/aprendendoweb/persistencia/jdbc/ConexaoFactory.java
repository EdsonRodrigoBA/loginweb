package br.aprendendoweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ConexaoFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			//Usei o Class.forname para que possamos manipular os dados do banco via java web
			//ou seja estou forçando....
			Class.forName("org.postgresql.Driver");
<<<<<<< HEAD
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoweb", "postgres", "1234");
=======
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoweb", "postgres", "11111");
>>>>>>> a9f9466ea31a72eab1d7fd56cb2629fed73dd642
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
