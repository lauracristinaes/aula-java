package exercito;

public class Soldado {
	
	//N�o � boa pr�tica fazer tratamento de dados no construtor,
	//deve-se efetuar em uma etapa anterior � sua chamada
	
	
	/*
	 * M�todos no infinitivo - ex: Executar()
	 * Classes com nomes de substantivos, etc ex: Executa, Execu��o
	 * 
	 * */
	
	public boolean homem;
	public String nome;
	public String sobrenome;
	public String dataNascimento;
	
	public Soldado() { //construtor sem parametros
		homem = true;	
		
	}
	
	public Soldado(String primeiroNome, String segundoNome) {
		//construtor com 2 parametros
	
		nome = primeiroNome;
		sobrenome = segundoNome;
		
	}
	
	public Soldado(String primeiroNome, String segundoNome, String dataNascimento) {
		//construtor com 3 parametros
	
		nome = primeiroNome;
		sobrenome = segundoNome;
		this.dataNascimento = dataNascimento;
		
		//utilizar this para indicar que est� usando um m�todo, objeto que est� no n�vel da classe e n�o escopo mais local
		//em caso de mesmo nome sempre vale o escopo mais pr�ximo (de dentro)
	}


}
