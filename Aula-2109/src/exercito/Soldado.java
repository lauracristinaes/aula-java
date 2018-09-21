package exercito;

public class Soldado {
	
	//Não é boa prática fazer tratamento de dados no construtor,
	//deve-se efetuar em uma etapa anterior à sua chamada
	
	
	/*
	 * Métodos no infinitivo - ex: Executar()
	 * Classes com nomes de substantivos, etc ex: Executa, Execução
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
		
		//utilizar this para indicar que está usando um método, objeto que está no nível da classe e não escopo mais local
		//em caso de mesmo nome sempre vale o escopo mais próximo (de dentro)
	}


}
