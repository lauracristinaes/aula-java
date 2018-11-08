package model;

public class Funcionario extends Pessoa{
	
	private int cod_cadastro;
	private int cargo; 
	/*
	 * 1 - Professor
	 * 2 - Analista Mainframe
	 * 3 - Analista Baixa Plataforma
	 * 4 - Programador Mainframe
	 * 5 - Programador Baixa Plataforma
	 * 6 - Líder de Projetos
	 * 7 - Gerente
	 * */
	private double salario;
	private float valor_alimentacao;
	private float valor_refeicao;
	private float valor_transporte;
	public int getCod_cadastro() {
		return cod_cadastro;
	}
	public void setCod_cadastro(int cod_cadastro) {
		this.cod_cadastro = cod_cadastro;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public float getValor_alimentacao() {
		return valor_alimentacao;
	}
	public void setValor_alimentacao(float valor_alimentacao) {
		this.valor_alimentacao = valor_alimentacao;
	}
	public float getValor_refeicao() {
		return valor_refeicao;
	}
	public void setValor_refeicao(float valor_refeicao) {
		this.valor_refeicao = valor_refeicao;
	}
	public float getValor_transporte() {
		return valor_transporte;
	}
	public void setValor_transporte(float valor_transporte) {
		this.valor_transporte = valor_transporte;
	}
	

}
