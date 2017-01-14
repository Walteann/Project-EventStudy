package dominio;

public class Usuario {
	
	
private int IdUsuario;
private String email;
private String senha;
private String nome;
private String cpf; 


public Usuario() {
	IdUsuario = 0;
	email = "";
	senha = "";
	nome = "";
	cpf = "";
}

public int getIdUsuario() {
	return IdUsuario;
}

public void setIdUsuario(int idUsuario) {
	IdUsuario = idUsuario;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

}
