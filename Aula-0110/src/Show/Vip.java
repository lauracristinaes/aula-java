package Show;

public class Vip extends Ingresso{
	
	/*
	 *  Crie uma classe VIP, que herda Ingresso e possui um valor adicional.
	 *  Crie um m�todo que retorne o valor do ingresso VIP (com o adicional inclu�do).
	 * */

	private Double valorAdd;
	
	public Double getValorVIP() {
		
		return this.valor + valorAdd;
	}
	
	
}
