package Pessoa;

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
	

	
}
