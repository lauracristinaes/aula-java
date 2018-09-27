package pizzaria;

public class Pedido {
	private int numero;
	private String nomeCliente;
	private String cpf;
	private boolean cpfNaNota;
	private ItemPedido itens[];
	
	public Pedido(int numero, String nomeCliente) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
	}
	
	public void solicitarCpfnaNota(
			boolean cpfNaNota, 
			String cpf) {
		if (cpfNaNota) {
			this.cpfNaNota = true;
			this.cpf = cpf;
		}
	}
	
	public void adicionarItem(ItemPedido item) {
		int x = 0;
		if (itens == null) {
			itens = new ItemPedido[1];
			itens[x] = item;
		} else {
			x = itens.length + 1;
			ItemPedido novosItens[] = new ItemPedido[x];
			for (int i = 0; i < (x - 1); i++) {
				novosItens[i] = itens[i];
			}
			novosItens[x-1] = item;
			itens = novosItens;
		}
	}
	
}
