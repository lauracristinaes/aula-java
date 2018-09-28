package PetShop;

import java.util.Date;

public class Animal {

	protected int id;
	public String nome;
	private String raca;
	private Date dataNascimento;
	private Double peso;
	private String nomeCientifico;
	
	public void locomoverse() {
		System.out.println("estou a me locomover");
	}
	
}
