package User;

import java.util.Date;

public class Person {
	
	private int id;
	private String cpf;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private String telefoneWhats;
	private Date dt_nasc;
	private String login;
	
	private String senha;
	
	public void checkFields() {
		
		/*
		 * Método para verificar campos de pessoa
		 * 
		 * */
		
		StringBuilder validacao = new StringBuilder();
		
		//verificar cpf
		
		if(this.getCpf() == null || this.getCpf().isEmpty()) {
			validacao.append("campo cpf obrigatório \n");
		} else if(getCpf().length() != 11) {
			validacao.append("cpf informado é inválido \n");
		}
		
		//verificar nome
		
		if(this.getNomeCompleto() == null || this.getNomeCompleto().isEmpty()) {
			validacao.append("campo nome obrigatório \n");
		} else if(getNomeCompleto().split("").length < 2) {
			validacao.append("O nome deve ser completo \n");
		}
		
		
		//verificar email
		
		
		//verificar data de nascimento
		
		
		
		
		
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneWhats() {
		return telefoneWhats;
	}

	public void setTelefoneWhats(String telefoneWhats) {
		this.telefoneWhats = telefoneWhats;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	
	
	

}
