package string;

public class TestaReplace {
	
	public static void main(String args[]) {
	
		String codigoProduto = "BRPRushauidhuiashdfuiahdf2010";
			
			String pais = codigoProduto.substring(0, 2);
			
			String estado = codigoProduto.substring(2, 4);
			
			String ano = codigoProduto.substring(codigoProduto.length()-4);
			
			System.out.println("O pa�s � " + pais);
			System.out.println("O estado � " + estado);
			System.out.println("O ano � " + ano);
			
			
			String prefixo = codigoProduto.substring(0, 2);
			String sufixo = codigoProduto.substring(codigoProduto.length()-4);
			
			//substituindo trecho do texto
			
			codigoProduto = codigoProduto.replace(prefixo, "");
			codigoProduto = codigoProduto.replace(sufixo, "");	
			
			System.out.println(codigoProduto);
	
	}

}
