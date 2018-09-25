package pizzaria;

public class Pedido {

	private int numero;
	private String nomeCliente;
	private String cpf;
	private boolean cpfnaNota;
	private itemPedido itens[];
	
	public Pedido(int num) {
		if(num > 0) {
		this.numero = num;
		this.itens = new itemPedido[10];
		}
	}
	
	public boolean cadastroPedido(String cliente, String cpf, boolean cpfNota) {
		
		
		this.nomeCliente = cliente;
		this.cpf = cpf;
		this.cpfnaNota = cpfNota;
		return true;
		
		
	}
	
	public void pizzasPedido(int qnt, Pizza pizza, String obs, int indice) {
		
		for(int i = 0; i< qnt; i++) {
			
			
		}
		
	}
		
	
	
	
}
