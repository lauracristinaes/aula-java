package Show;

public class Vip extends Ingresso{
	
	/*
	 *  Crie uma classe VIP, que herda Ingresso e possui um valor adicional.
	 *  Crie um método que retorne o valor do ingresso VIP (com o adicional incluído).
	 * */

	private Double valorAdd;
	
	public Double getValorVIP() {
		
		return this.valor + valorAdd;
	}
	
	
}
