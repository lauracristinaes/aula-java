package Show;

public class CamaroteSuperior extends Vip{
	
	/*
	 *  Crie uma classe CamaroteSuperior,
	 *  que � mais cara (possui valor adicional). 
	 *  Esta possui um m�todo para retornar o valor do ingresso. 
	 *  
	 *   Ambas as classes herdam a classe VIP.
	 *  
	 * */
	
	private Double AddCamaroteSup;
	
	public Double valorIngressoCamaroteSup() {
		
		return this.getValorVIP() + AddCamaroteSup;
	}
	
	
}
