package obj;

import java.util.Scanner;

public class ExecutaprogramaBolo {
	
	public static void main(String[] args) {
		
		Bolo meusBolos[] = cadastrar();
		Imprimir(meusBolos);
		
		
		//testando git
	}
	
	public static void Imprimir(Bolo bolos[]) {
		
		for(int i = 0; i < 2; i++) {

			System.out.println("recheio do bolo:" + bolos[i].recheio);			
			System.out.println("peso do bolo:" + bolos[i].peso + "gramas");
		}
		
		
	}
	
	
	public static Bolo[] cadastrar() {
		
		Integer contador = 0;
		Bolo bolos[] = new Bolo[2];
		Scanner ler;
		
		while (contador != 2) {
			
			ler = new Scanner(System.in);
			//referencia
			Bolo bolo;
			
			//construindo objeto
			//construtor
			
			bolo = new Bolo();
			
			System.out.println("digite o sabor:");
			bolo.recheio = ler.nextLine();
			System.out.println("digite o peso:");
			bolo.peso = ler.nextDouble();
			bolos[contador] = bolo;
			System.out.println("Bolo adicionado com sucesso");
			
			contador++; //contador +=1
			
		}
		
		return bolos;
	} 

}
