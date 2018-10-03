package conta;

import java.util.Date;

public class Poupanca extends Conta {
	
	private Double taxaRendimentoAoMes;
	private boolean aplicacaoProgramada;
	private Date dataAplicacaoProgramada;
	private Double valorAplicacaoProgramada;
	
	public void programarAplicacao(
			Date dataAplicacaoProgramada, 
			Double valorAplicacaoProgramada) {
		this.dataAplicacaoProgramada = dataAplicacaoProgramada;
		this.valorAplicacaoProgramada = valorAplicacaoProgramada;
		this.aplicacaoProgramada = true;
	}
	
	public void cancelarAplicacaoProgramada() {
		this.dataAplicacaoProgramada = null;
		this.valorAplicacaoProgramada = null;
		this.aplicacaoProgramada = false;
	}
	
}
