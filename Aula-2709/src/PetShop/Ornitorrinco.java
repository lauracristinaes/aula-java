package PetShop;

public class Ornitorrinco extends Oviparo {

	private String reino;
	private Double larguraBicoEmMm;
	private boolean Voa;
	private int indiceVeneno;
	private int ovosPorDia;
	
public Ornitorrinco() {}

public Ornitorrinco(int veneno) {
	this.indiceVeneno = veneno;
}
	
	public void locomoverse() {
		System.out.println("ornitorrinco não sabe andar");
	}
	
	public boolean equal(Object obj) {
		
		
		return true;//(this.id == obj.id);
	}

	public int getIndiceVeneno() {
		return indiceVeneno;
	}

	
}
