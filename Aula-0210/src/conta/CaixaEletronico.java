package conta;

import java.util.Scanner;

public class CaixaEletronico {
	
	public static void main(String args[]) {
		Conta poupanca = new Poupanca();
		Conta corrente = new Corrente();
		System.out.println(poupanca == corrente);
		//corrente = poupanca;
		//System.out.println(poupanca == corrente);
		
		System.out.println("Equals: " + corrente.equals(poupanca));
		
		
		//System.out.println(corrente);
		//Scanner s = new Scanner(System.in);
//		int op = exibirMenu(s);
//		
//		while (op != 6) {
//			Double valor = Double.valueOf(0);
//			if (op >= 1 && op <= 4) {
//				System.out.println("Informe o valor: ");
//				valor = s.nextDouble();
//				s.nextLine();
//			}
//			
//			switch (op) {
//			case 1:
//				sacar(corrente, valor);
//				break;
//			case 2:
//				sacar(poupanca, valor);
//				break;
//			case 3:
//				depositar(corrente, valor);
//				break;
//			case 4:
//				depositar(poupanca, valor);
//				break;
//			default:
//				op = 6;
//				break;
//			}
//			op = exibirMenu(s);
//		}
	}
	
	private static void sacar(Conta c, Double valor) {
		c.sacar(valor);
	}
	
	private static void depositar(Conta c, Double valor) {
		c.depositar(valor);
	}

	private static int exibirMenu(Scanner s) {
		System.out.println("Informe a opcao: "
				+ "1. saque cc, "
				+ "2. saque cp, "
				+ "3. deposito cc "
				+ "4. deposito cp "
				+ "5. visualizar saldo"
				+ "6. sair ");
		int op = s.nextInt();
		s.nextLine();
		return op;
		
	}

}
