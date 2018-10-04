package Eleicao;

import java.util.Date;

public class Pessoa {
	
	//protected é o modificador que permite acesso às classes filhas e/ou presentes no mesmo pacote
	
	protected String nome;
	protected String cpf;
	protected String rg;
	protected Date dataNascimento;
	protected String telefone1;
	protected String telefone2;
	protected String email;
	
	public void setNome(String nome) {
		
		if(nome != null && !nome.isEmpty() && nome.split(" ").length > 1) {
			this.nome = nome;
		}
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
