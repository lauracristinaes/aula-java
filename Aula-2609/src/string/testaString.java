package string;

import java.util.Scanner;

public class testaString {

	public static void main(String args[]) {
		
		//String nome = "Laura Cristina";
		
		//retornar o char na posição solicitada por parametro
		//System.out.println("charAt(1): "+ nome.charAt(1));
		
		//separando num array de string com split
		//String nomes[]= nome.split(" ");
		//int ultimoindex = nomes.length -1;
		//System.out.println("Olá Srt " + nomes[ultimoindex]);
		
		
		//String outroNome = "LAURA CRISTINA";
		//System.out.println("String upper case: " + outroNome);
		//System.out.println("Para lower case: " + outroNome.toLowerCase());
		//System.out.println("String camel case: " + nome);
		//System.out.println("Para upper case: " + outroNome.toUpperCase());
		
		
		
		
		//Exercicio: receba uma string com nome endereço separado por ;
		//endereço separado por ,
		//imprimir somente o primeiro e ultimo nome (nome do meio abreviado)
		//imprimir cada info do endereço por linha
		//Scanner ler = new Scanner(System.in);
		//String cadastro = ler.nextLine();
		//String dados[]= cadastro.split(";");
		
		//String nomes[]=dados[0].split(" ");
		
		//imprimir primeiro nome
		//System.out.printf("Sr." + nomes[0]);
		
		//Abreviar nomes do meio
		//for(int i =1; i < nomes.length-1; i++) {
			
		//	System.out.printf(" "+ nomes[i].charAt(0) + ".");
		//}
		//imprime ultimo nome
		//System.out.println(nomes[nomes.length-1]);
		
		//String infosEndereco[] = dados[1].split(",");
		//for(int i =0; i < infosEndereco.length; i++) {
		//System.out.println(infosEndereco[i].trim());} //trim retira os espaços em branco no incio ou final da string
		
	String codigoProduto = "BRPRushauidhuiashdfuiahdf2010";
	
	String pais = codigoProduto.substring(0, 2);
	
	String estado = codigoProduto.substring(2, 4);
	
	String ano = codigoProduto.substring(codigoProduto.length()-4);
	
	System.out.println("O país é " + pais);
	System.out.println("O estado é " + estado);
	System.out.println("O ano é " + ano);
	
	
	String prefixo = codigoProduto.substring(0, 2);
	String sufixo = codigoProduto.substring(codigoProduto.length()-4);
	
	//substituindo trecho do texto
	
	codigoProduto = codigoProduto.replace(prefixo, "");
	codigoProduto = codigoProduto.replace(sufixo, "");	
	
	System.out.println(codigoProduto);
	
	

	
	
	//Faça um programa que receba um telefone e verifique se é válido 
			//(com 10 ou 11 posicoes), 
			//caso positivo formate este telefone (00) 0 0000-0000 ou (00) 0000-0000
	}	
	
}
