package Excessoes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Conta {
	
	private String titular;
	public  Double saldo = new Double(0);
	public ESexo sexo = ESexo.F;
	
	private static final String VERSAO  = "1234";
	
	//final - n�o permite que altere o valor da vari�vel
	//constante: costuma-se inicializar na declara��o, mas pode ser inicializada no construtor
	//costuma-se identificar as constantes utilizando identificador em maiuscula
	
	public Conta() {
		
		
		
	}
	
	public void setSexo(String sexo) throws FileNotFoundException   {
		
	try {
		
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	}
	
	public Conta(String titular) {
		this.titular = titular;
		
	}

	public String getTitular() {
		return titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void depositar(Double valor) {
		if (valor != null && valor > 0) {
			//saldo = saldo + valor;
			System.out.println("Deposito na conta alterado");
		}
	}
	
	public void sacar(Double valor) {
		if (valor != null && valor <= saldo) { 
			saldo = saldo - valor;
			System.out.println("Saque da conta");
		}
	}

	@Override
	public boolean equals(Object obj) {
		Conta other = (Conta) obj;
		if (saldo == null) {
			if (other.saldo != null) {
				return false;
			}
		} else if (!saldo.equals(other.saldo)) {
			return false;
		}
		return true;
	}
	

}