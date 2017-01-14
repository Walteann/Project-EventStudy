package servlet;


import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginAutenticacao")
public class LoginAutenticacao extends HttpServlet {

	// wal teste
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAutenticacao() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	
	// fim wal teste
	
	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String connectionURL = "jdbc:mysql://localhost/eventstudy";
		Connection connection = null;
		ResultSet rs;
		String email = new String("");
		String senha = new String("");
		response.setContentType("text/html");
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "walteann", "123456");
			// Add the data into the database
			String sql = "select email,senha from Usuario";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				email = rs.getString("email");
				 senha = rs.getString("senha");
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (email.equals(request.getParameter("email")) && senha.equals(request.getParameter("senha"))) {
			  RequestDispatcher rd = 
		                request.getRequestDispatcher("paginas/paginaPosLogin.jsp");
		            rd.forward(request, response);
		} else {
			out.println("Por favor Entre com Email e Senha");
			out.println("<a href='AutenticacaoLogin.jsp'><br>Login again</a>");
		}
	}
}