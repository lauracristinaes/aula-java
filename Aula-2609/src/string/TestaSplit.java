package string;

import java.util.Scanner;

public class TestaSplit {
	
	public static void main(String args[]) {

	//Exercicio: receba uma string com nome endere�o separado por ;
	//endere�o separado por ,
	//imprimir somente o primeiro e ultimo nome (nome do meio abreviado)
	//imprimir cada info do endere�o por linha
	
	Scanner ler = new Scanner(System.in);
	String cadastro = ler.nextLine();
	String dados[]= cadastro.split(";");
			
	String nomes[]=dados[0].split(" ");
			
	//imprimir primeiro nome
	System.out.printf("Sr." + nomes[0]);
			
	//Abreviar nomes do meio
	for(int i = 1; i < nomes.length-1; i++) {
				
		System.out.printf(" "+ nomes[i].charAt(0) + ".");
	}
	//imprime ultimo nome
	System.out.println(nomes[nomes.length-1]);
			
	String infosEndereco[] = dados[1].split(",");
	for(int i = 0; i < infosEndereco.length; i++) {
			System.out.println(infosEndereco[i].trim()); //trim retira os espa�os em branco no incio ou final da string
		}
	}	
}
