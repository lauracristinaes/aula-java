package string;

public class TestaReplace {
	
	public static void main(String args[]) {
	
		String codigoProduto = "BRPRushauidhuiashdfuiahdf2010";
			
			String pais = codigoProduto.substring(0, 2);
			
			String estado = codigoProduto.substring(2, 4);
			
			String ano = codigoProduto.substring(codigoProduto.length()-4);
			
			System.out.println("O país é " + pais);
			System.out.println("O estado é " + estado);
			System.out.println("O ano é " + ano);
			
			
			String prefixo = codigoProduto.substring(0, 2);
			String sufixo = codigoProduto.substring(codigoProduto.length()-4);
			
			//substituindo trecho do texto
			
			codigoProduto = codigoProduto.replace(prefixo, "");
			codigoProduto = codigoProduto.replace(sufixo, "");	
			
			System.out.println(codigoProduto);
	
	}

}
