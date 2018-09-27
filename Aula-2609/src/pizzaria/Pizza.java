package pizzaria;

public class Pizza {
	
	private String tamanho;
	private int qtdPedacos;
	private Sabor sabor;
	private boolean borda;
	private String saborBorda;
	
	public Pizza (int tamanho, Sabor sabor, boolean borda, String saborBorda) {
		this.qtdPedacos = tamanho;
		this.sabor = sabor;
		this.borda = borda;
		this.saborBorda = saborBorda;
	}
	
	public void preencherBorda(
			boolean borda, 
			String saborBorda) {
		if (borda) {
			this.borda = borda;
			this.saborBorda = saborBorda;
		}
	}
	
	public void selecionarSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	
	public void trocarTamanho(
			String tamanho, 
			int qtdPedacos) {
		this.tamanho = tamanho;
		this.qtdPedacos = qtdPedacos;
	}
}
