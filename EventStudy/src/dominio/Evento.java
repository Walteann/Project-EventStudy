package dominio;

public class Evento{
	private int idEvento;
	private String turma;
	private String cargaHoraria;
	private String investimento;
	private String localizacao;
	private String ministrante;
	
	
	public Evento(){
		idEvento = 0;
		turma = "";
		cargaHoraria="";
		investimento="";
		localizacao="";
		ministrante = "";
	}


	public int getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}


	public String getTurma() {
		return turma;
	}


	public void setTurma(String turma) {
		this.turma = turma;
	}


	public String getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public String getInvestimento() {
		return investimento;
	}


	public void setInvestimento(String investimento) {
		this.investimento = investimento;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public String getMinistrante() {
		return ministrante;
	}


	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}
	
	
	
}