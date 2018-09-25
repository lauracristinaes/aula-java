package pizzaria;

import java.util.Scanner;

public class ExecutaPizzaria {
	
	private static Sabor sabores[];

	public static void main(String[] args) {
		//1. lista de sabores
		lerSabores();
		
		//2. menu
		int controle = 1;
		while (controle != 0) {

			Scanner ler = new Scanner(System.in);
			int menu;
			System.out.println("-----PIZZARIA----------");
			System.out.println("1 - Ver Cardápio");
			System.out.println("2 - Efetuar Pedido");
			
			menu = ler.nextInt();
			
			switch(menu) {
			
			case 1:
				imprimirSabores();
				
			case 2:
				//efetuarPedido();
				
			default:
				System.out.println("Digite uma opção válida");
			
			}
			
		}
	}
	
	public static void imprimirSabores() {
		
		for(int i=0; i<4; i++) {
			
			System.out.println(""
					+ sabores[i].getDescricao()
					
					);
			
		}
	}
	
	public static void lerSabores() {
		int quantidade = 0;
		sabores = new Sabor[4];
		while (quantidade < 4) {
			Scanner ler = new Scanner(System.in);
			System.out.println("Digite a descrição do sabor"
					+ (quantidade + 1) + ": ");
			String descricaoSabor = ler.nextLine();
			System.out.println("Digite a qtd de ingredientes do sabor"
					+ (quantidade + 1) + ": ");
			int qtdIngredientes = ler.nextInt();
			ler.nextLine();
			Sabor novoSabor = new Sabor(descricaoSabor, qtdIngredientes);
			sabores[quantidade] = novoSabor;
			for (int i = 0; i < qtdIngredientes; i++) {
				System.out.println("Digite o ingrediente " 
						+ (i + 1) + ": ");
				novoSabor.addIngrediente(ler.nextLine());
			}
			quantidade++;
		}
	}

}
