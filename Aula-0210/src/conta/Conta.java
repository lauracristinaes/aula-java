package conta;

public class Conta {
	
	private String titular;
	public  Double saldo = new Double(0);
	public ESexo sexo = ESexo.F;
	
	private static final String VERSAO  = "1234";
	
	//final - não permite que altere o valor da variável
	//constante: costuma-se inicializar na declaração, mas pode ser inicializada no construtor
	//costuma-se identificar as constantes utilizando identificador em maiuscula
	
	public Conta() {
		
		
		
	}
	
	public void setSexo(String sexo) {
		
		ESexo sexoselecionado = null;
		sexoselecionado  = ESexo.valueOf(sexo);
		try {
			
			
		} catch (IllegalArgumentException e) {
			System.out.println("erro");
			e.printStackTrace();
			
		}
		
		
		
		if (sexoselecionado == null) {
			System.out.println("Sexo não encontrado: "+ sexoselecionado);
			
		} else {
			this.sexo = sexoselecionado;
			System.out.println("sexo selecionado: "+ sexoselecionado);

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
