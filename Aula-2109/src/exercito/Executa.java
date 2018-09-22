package exercito;

public class Executa {
	
	public static void main(String args[]) {
		
		//testando sobrecargas de operadores-construtores
		
		Soldado s1 = new Soldado();
		Soldado s2 = new Soldado("nome","sobrenome");
		Soldado s3 = new Soldado("nome","sobrenome","data de nascimento");
		
		System.out.println(
				s2.nome + " "+
				s2.sobrenome + " " +
				s2.dataNascimento + " "
				);
		
	}

}
