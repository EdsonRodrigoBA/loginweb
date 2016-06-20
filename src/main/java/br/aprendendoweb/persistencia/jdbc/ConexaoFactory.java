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
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoweb", "postgres", "tel24M20");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
