/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author alunofg
 */
public class Conexao {
	 static Connection conexao=null;

	private Conexao() {
	}

	public static synchronized Connection getConexao() {
		if (conexao == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/eventstudy", "walteann", "123456");
				System.out.println("Conectado");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Open: ClassNotFound: " + e.getMessage());
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Open: SQLException: " + e.getMessage());
			}
		}
		return (conexao);
	}

	public static synchronized void close() {
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Close: SQLException: " + e.getMessage());
		}
	}

	
}