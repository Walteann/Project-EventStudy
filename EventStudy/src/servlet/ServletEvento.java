package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.EventoDao;
import dominio.Evento;

/**
 * Servlet implementation class ServletTeste
 */
@WebServlet("/ServletEvento")
public class ServletEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEvento() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service (HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        
    	String turma = request.getParameter("NovaTurma");
        String cargaHoraria = request.getParameter("NovaCargaHoraria");
        String investimento = request.getParameter("NovoInvestimento");
        String localizacao = request.getParameter("NovaLocalizacao");
        String ministrante = request.getParameter("NovoMinistrante");
        
               
        // monta o objeto usuario
        Evento evento = new Evento();
        evento.setTurma(turma);
        evento.setCargaHoraria(cargaHoraria);
        evento.setInvestimento(investimento);
        evento.setLocalizacao(localizacao);
        evento.setMinistrante(ministrante);
                
        // salva o contato
        EventoDao cadastro = new EventoDao();
        cadastro.incluir(evento);
        
        // imprime o nome do contato que foi adicionado
        RequestDispatcher rd = 
                request.getRequestDispatcher("/paginaEventosTeste.jsp");
            rd.forward(request, response);

    }
  
  
  
  

    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
