package br.aprendendoweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoweb", "postgres", "1233");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
