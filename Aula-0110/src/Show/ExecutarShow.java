package Show;

import java.util.Scanner;

public class ExecutarShow {
	
	/**
	 * 
	 * Na classe de execucao do programa crie um ingresso. 
	 * Peça para o usuário digitar 1 para normal e 2 para VIP.
	 * Conforme a escolha do usuário, diga se o ingresso é do tipo normal ou VIP.
	 * Se for VIP, peça para ele digitar 1 para camarote superior e 2 para camarote inferior.
	 * Conforme a escolha do usuário, diga se que o VIP é camarote superior ou inferior.
	 * Imprima o valor do ingresso.
	 * 
	 */
	
	public static void main(String[] args) {
		Ingresso ticket;
		Integer menu;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("***Compra de Ingressos***");
		System.out.println("1 - Ingresso Normal");
		System.out.println("2 - Ingresso Vip");
		
		menu = ler.nextInt();
		ler.nextLine();
		
		switch(menu) {
		
		case 1:
			ticket = new Normal();
			ticket.imprimeValor();
			break;
			
		case 2:
			System.out.println("***Compra de Ingressos VIP***");
			System.out.println("1 - Camarote Inferior");
			System.out.println("2 - Camarote Superior");
			menu = ler.nextInt();
			ler.nextLine();
			switch(menu) {
			
			case 1:
				ticket = new CamaroteInferior();
				//System.out.println("O valor do ingresso é: " + ticket.getValorVip());
				break;
				
			case 2:
				ticket = new CamaroteSuperior();
				break;
			
			default:
			}
						
			break;
			
		default: 
		
		}
		}
		
		
	

}
