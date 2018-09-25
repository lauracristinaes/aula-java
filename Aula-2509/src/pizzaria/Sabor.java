package pizzaria;

public class Sabor {
	private String descricao;
	private String ingredientes[];
	
	public Sabor(String descricao, Integer qtdIngredientes) {
		this.setDescricao(descricao);
		this.ingredientes = new String[qtdIngredientes];
	}
	
	public void addIngrediente(String ingrediente) {
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] == null) {
				ingredientes[i] = ingrediente;
				break;
			}
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
