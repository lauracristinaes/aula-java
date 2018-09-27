package string;

public class TestaIndexOf {
	public static void main(String args[]) {
	
		//codigo com caracteres especiais
		
		String codigo = "azul$dozekg$1,20m$pr";
		
		
		
		int cifrao = codigo.indexOf("$");
		String cor = codigo.substring(0, cifrao);
		
		codigo = codigo.substring(cifrao+1);

		cifrao = codigo.indexOf("$");
		String peso = codigo.substring(0, cifrao);
		
		
		
		System.out.println(cor);
		System.out.println(peso);
	}

}
