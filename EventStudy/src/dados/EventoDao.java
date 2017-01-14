package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Evento;


public class EventoDao {
//A conexão com o Banco
private Connection conexao = null;
private PreparedStatement stmt = null;
ResultSet resultadoSql = null;

//Instanciando a conexão
public EventoDao(){
		conexao = Conexao.getConexao();
	}
	
//Metodo Incluir
public void incluir(Evento evento){

	
	try{
		//PreparedStatement pra inserir
		stmt = conexao.prepareStatement("INSERT INTO evento (id_evento, turma, cargaHoraria,investimento, localizacao, ministrante) VALUES (?, ?, ?, ?, ?,?)");
		
		//Setar os valores
		stmt.setInt(1, evento.getIdEvento()); //IdEvento
		stmt.setString(2, evento.getTurma()); //NomeEvento
		stmt.setString(3, evento.getCargaHoraria());
		stmt.setString(4, evento.getInvestimento()); //Investimento
		stmt.setString(5, evento.getLocalizacao()); //Localização
		stmt.setString(6, evento.getMinistrante()); //Localização
		
	

		//Executar e Fechar
		stmt.execute();
		stmt.close();
		conexao.commit();
		
	}
	catch(SQLException e){
		try{
			System.out.println(e.getMessage());
			conexao.rollback();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
		
	}

//Metodo Consultar
public Evento consultar(int IdEvento){
	Evento evento = null;
	
	String sql = "SELECT FROM evento where id_evento = ?";
	
	try{
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, IdEvento);
		resultadoSql = stmt.executeQuery();
		
		if(resultadoSql.next()){
			evento = new Evento();
			
			
			evento.setIdEvento(resultadoSql.getInt("ID_evento"));
			evento.setTurma(resultadoSql.getString("turma"));
			evento.setCargaHoraria(resultadoSql.getString("cargaHoraria"));
			evento.setLocalizacao(resultadoSql.getString("Localizacao"));
			evento.setInvestimento(resultadoSql.getString("investimento"));
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	return evento;
}

//Metodo Alterar
public void alterar(Evento evento){
	Evento alterarEvento = consultar(evento.getIdEvento());
	
	if(alterarEvento!= null){
		String sql = "UPDATE evento set turma =?, "
									+ "localizacao=?, cargaHoraria=?, "
												+ "investimento=?" + "where id_evento=?";
		try{
			//Setar os valores
			stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, evento.getTurma()); //Alterar Nome
			stmt.setString(2, evento.getLocalizacao()); //Alterar Local

		
			stmt.setString(5, evento.getInvestimento()); //Alterar Preço
			
			//Executar e fechar
			stmt.execute();
			stmt.close();
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}

//Metodo Remover
public void remover(int idEvento){
	Evento removerEvento = new Evento();
	removerEvento = consultar(idEvento);
	
	if(removerEvento != null){
		String sql = "delete from evento where id_evento = ?";
		try{
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idEvento);
			
			//Executar e Fechar
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}

//Metodo Listar
public List<Evento> listar(){
	try{
		List<Evento> eventos = new ArrayList<Evento>();
		
		stmt= conexao.prepareStatement("select * from evento");
		
		resultadoSql = stmt.executeQuery();
		
		while(resultadoSql.next()){
			//Criando o objeto Evento
			
			Evento evento = new Evento();
			
		
			evento.setTurma(resultadoSql.getString("turma"));
			evento.setCargaHoraria(resultadoSql.getString("cargaHoraria"));
			evento.setInvestimento(resultadoSql.getString("investimento"));
			evento.setLocalizacao(resultadoSql.getString("localizacao"));
			evento.setMinistrante(resultadoSql.getString("ministrante"));

			
			
			//adicionando o objeto a lista
			eventos.add(evento);
		}
		
		resultadoSql.close();
		stmt.close();
		return eventos;
	} catch(SQLException e){
		throw new RuntimeException(e);
	}
}

}
