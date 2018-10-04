package Eleicao.Executavel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Eleicao.Candidato;

public class CadastrarCandidato {
	
	public static void main(String[] args) {
		Candidato c = new Candidato();
		Scanner s = new Scanner(System.in);
		System.out.println("Informe o Nome: ");
		c.setNome(s.nextLine());
		System.out.println("Informe o CPF: ");
		c.setCpf(s.nextLine());
		System.out.println("Informe o RG: ");
		c.setRg(s.nextLine());
		System.out.println("Informe a Data de Nascimento: ");
		String DataNascimento = s.nextLine();
		System.out.println("Informe o Telefone1: ");
		c.setTelefone1(s.nextLine());
		System.out.println("Informe o Telefone2: ");
		c.setTelefone2(s.nextLine());
		System.out.println("Informe o Email: ");
		c.setEmail(s.nextLine());
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	}

}
