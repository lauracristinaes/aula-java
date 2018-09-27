package pizzaria;

import java.util.Scanner;

public class ExecutaPizzaria {
	
	private static Sabor sabores[];

	public static void main(String[] args) {
		//1. lista de sabores
		lerSabores();
		
		//2. menu
		int controle = 1;
		while (controle != 3) {
			Scanner ler = new Scanner(System.in);
			System.out.println("Informe a opção: ");
			System.out.print("1 - menu; 2 - pedido; 3 - sair;");
			controle = ler.nextInt();
			ler.nextLine(); 
			switch (controle) {
			case 1:
				//menu
				imprimirCardapio();
				break;
			case 2:
				//pedido
				System.out.println("Informe o número do pedido: ");
				int numero = ler.nextInt();
				ler.nextLine();
				System.out.println("Informe o nome: ");
				String nome = ler.nextLine();
				Pedido p = new Pedido(numero, nome);
				int c = 0;
				while (c != 3) {
					System.out.println("Informe uma opcao: ");
					System.out.println("1 - add item ao pedido");
					System.out.println("2 - finalizar pedido");
					System.out.println("3 - cancelar");
					c = ler.nextInt();
					ler.nextLine();
					switch (c) {
					case 1:
												
						System.out.println("Informe o nome do sabor da pizza: ");
						imprimirCardapio();
						int numSabor = ler.nextInt();
						ler.nextLine();
						
						System.out.println("Informe o tamanho da pizza (4, 8 ou 12 pedaços)");
						int qtdPedacos = ler.nextInt();
						
						System.out.println("Informe se tem borda:");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						
						int borda = ler.nextInt();
						ler.nextLine();
						boolean bordaBorda;
						String saborBorda;
						
						if (borda == 1) {
							bordaBorda = true;
							System.out.println("Informe o sabor da borda:");
							System.out.println("1 - Catupiry");
							System.out.println("2 - Cheddar");
							saborBorda = ler.nextLine();
							switch (saborBorda) {
							case "1":
								saborBorda = "Catupiry";

							case "2":
								saborBorda = "Cheddar";
							}
						} else {
							bordaBorda = false;
							saborBorda = "Pizza sem borda recheada!";
						}

						Pizza pizza = new Pizza(qtdPedacos, sabores[numSabor], bordaBorda, saborBorda);
						System.out.println("Quantas pizzas o cliente vai querer?");
						int quantidade = ler.nextInt();
						System.out.println("Observação: ");
						String observacao = ler.nextLine();
						ItemPedido item = new ItemPedido(quantidade, pizza, observacao);
						System.out.println(item);
						break;
						
						//___________________________________________________________
						//System.out.println("Informe o nome do sabor da pizza: ");
						//imprimirCardapio();
						//int numSabor = ler.nextInt();
						//ler.nextLine();
						//System.out.println("Informe o tamanho da pizza: (4, 8 ou 12 pedaços)");
						//int qtdPedacos = lerInt(ler);
						//System.out.println("Gostaria de acrescentar borda?");
						
						//terminar de ler atributos da pizza
						//criar a pizza
						//criar o item pedido
						//ler observacao e qtd da pizza
						//add o item pedido ao pedido
						//ItemPedido item = new ItemPedido(quantidade, pizza, observacao);
						//break;
					case 2:
						//imprimir o pedido
						break;
					default:
						c = 3;
						break;
					}
				}
				break;
			default:
				controle = 3;
				break;
			}
			
			
			
		}
		
	}
	
	
	private static int lerInt(Scanner leitor) {
		int i = leitor.nextInt();
		leitor.nextLine();
		return i;
	}
	
	private static void imprimirCardapio() {
		System.out.println("CARDÁPIO");
		for (int i = 0; i < sabores.length; i++) {
			System.out.println((i + 1) + " - " + sabores[i]);
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
