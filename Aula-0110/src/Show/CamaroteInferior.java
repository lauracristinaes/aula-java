package Show;

public class CamaroteInferior extends Vip{
	
	/*
	 * 
	 * Crie uma classe CamaroteInferior 
	 * (que possui a localiza��o do ingresso e m�todos para acessar e imprimir esta localiza��o)
	 * 
	 *  Ambas as classes herdam a classe VIP.
	 * 
	 * */
	
	private String localIngresso;
	
	
	public String getLocalIngresso() {
		
		return localIngresso;
	}

	
	public void imprimirLocalIngresso() {
		
		System.out.println("Local do Ingresso �: " + this.localIngresso);
	}
}
