package Show;

public class CamaroteInferior extends Vip{
	
	/*
	 * 
	 * Crie uma classe CamaroteInferior 
	 * (que possui a localização do ingresso e métodos para acessar e imprimir esta localização)
	 * 
	 *  Ambas as classes herdam a classe VIP.
	 * 
	 * */
	
	private String localIngresso;
	
	
	public String getLocalIngresso() {
		
		return localIngresso;
	}

	
	public void imprimirLocalIngresso() {
		
		System.out.println("Local do Ingresso é: " + this.localIngresso);
	}
}
