package conta;

import java.util.Date;

public class Corrente extends Conta {
	
	private Double limite = Double.valueOf(0);
	private Date dataChequeEspecial;
	
	@Override
	public void sacar(Double valor) {
		if (valor != null) {
			Double saldoTotal = getSaldo() + limite;
			if (saldoTotal >= valor) {
				//verificar se o saldo é > 0
				//se sim subtrair dele o valor
				//o que faltar, subtrair do limite
				//se o limite vai ser utilizado e 
				//dataChequeEspecial == null entao seta a dataChequeEspecial
				System.out.println("Saque da conta corrente");
			}
		}
	}
	
	@Override
	public String toString() {
		return "limite=" +limite+", dataChequeEspecial="+dataChequeEspecial;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corrente other = (Corrente) obj;
		if (dataChequeEspecial == null) {
			if (other.dataChequeEspecial != null)
				return false;
		} else if (!dataChequeEspecial.equals(other.dataChequeEspecial))
			return false;
		if (limite == null) {
			if (other.limite != null)
				return false;
		} else if (!limite.equals(other.limite))
			return false;
		return true;
	}
}
