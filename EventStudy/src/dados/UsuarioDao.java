package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Usuario;

public class UsuarioDao {
//A conexão com o Banco
private Connection conexao = null;
private PreparedStatement stmt = null;
ResultSet resultadoSql = null;

//Instanciando a conexão
public UsuarioDao(){
	conexao =  Conexao.getConexao();
}

//Metodo Incluir
public void incluir(Usuario usuario){	
	try{
		//PreparedStatement pra inserir
		conexao.setAutoCommit(false);
		stmt = conexao.prepareStatement("INSERT INTO usuario (id_usuario,nome, cpf, email, senha ) " +
                "VALUES (?, ?,?,?,?) ");

		//Setar os valores
		stmt.setInt(1, usuario.getIdUsuario());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getCpf());
		stmt.setString(4, usuario.getEmail());
		stmt.setString(5, usuario.getSenha());
		
		//Executar e fechar
		stmt.execute();
		stmt.close();
		conexao.commit();
		} catch(SQLException e){
			try{
				System.out.println(e.getMessage());
				conexao.rollback();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
}

//Metodo consultar
public Usuario consultar(int idUsuario){
	Usuario usuario = null;

	try{
		stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
		stmt.setInt(1, idUsuario);
		resultadoSql = stmt.executeQuery();
		
		if(resultadoSql.next()){
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultadoSql.getInt("id_usuario"));
			usuario.setNome(resultadoSql.getString("nome"));
			usuario.setEmail(resultadoSql.getString("email"));
			usuario.setCpf(resultadoSql.getString("cpf"));
			
		}
	} catch(SQLException e){
		throw new RuntimeException(e);
	}
	return usuario;
}

// Vamos tentar colocar aki o Consultar do EMAIL:
public Usuario consultarEmail(String meuEmail){
	Usuario usuario = null;

	try{
		stmt = conexao.prepareStatement("SELECT email from usuario where email = '?' ;");
		stmt.setString(1, meuEmail);
		resultadoSql = stmt.executeQuery();
		
		if(resultadoSql.next()){
			usuario = new Usuario();
			
			
			usuario.setNome(resultadoSql.getString("nome"));
			usuario.setEmail(resultadoSql.getString("email"));
			usuario.setSenha(resultadoSql.getString("senha"));
			conexao.commit();
		}
		} catch(SQLException e){
				try{
					System.out.println(e.getMessage());
					conexao.rollback();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
			return usuario;
	}




//Método Alterar
public void alterar(Usuario usuario){
	Usuario alterarUsuario =consultar(usuario.getIdUsuario());
	
	if(alterarUsuario != null){ //O Usuario Existe
		String sql = "UPDATE trabalho.usuario SET nome = ?, senha = ?, login = ?" + "where id_usuario = ?";
		try{
			//Setar os valores
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			
			stmt.setInt(4, usuario.getIdUsuario()); // wal Editou. pra testar. 
			
			//Executar e fechar
			stmt.execute();
			stmt.close();
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}

//Método Remover
public void remover(int idUsuario){
Usuario removerUsuario = new Usuario();
removerUsuario = consultar(idUsuario);

if(removerUsuario != null){
	String sql = "delete" + "from trabalho.usuario where id_usuario = ?";
	try{
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, idUsuario);
		
		stmt.execute();
		stmt.close();
	} 
	catch(SQLException e){
		throw new RuntimeException(e);
	}
}
}

public List<Usuario> listar(){
	try {

        List<Usuario> contatos = new ArrayList<Usuario>();

        stmt = conexao.prepareStatement("select * from usuario");

        resultadoSql = stmt.executeQuery();

        while (resultadoSql.next()) {

            // criando o objeto Usuario

            Usuario usuario = new Usuario();
            usuario.setIdUsuario(resultadoSql.getInt("id_usuario"));
            usuario.setNome(resultadoSql.getString("nome"));
            usuario.setEmail(resultadoSql.getString("email"));
            usuario.setCpf(resultadoSql.getString("cpf"));
            

            // adicionando o objeto à lista

            contatos.add(usuario);

        }

        resultadoSql.close();

        stmt.close();

        return contatos;

    } catch (SQLException e) {

        throw new RuntimeException(e);  

}
	
	

}
}

