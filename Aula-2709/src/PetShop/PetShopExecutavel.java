 package PetShop;

public class PetShopExecutavel {
	
	//todo objeto extende classe object
	
	//referencia acessa o objeto, mas quem chama o m�todo � o objeto
	
	public static void main(String[] args) {
		Animal s = new Animal();
		s.locomoverse();
		
		Ornitorrinco o = new Ornitorrinco();
		o.locomoverse();
		
		//s = o;
		
		Animal refTipoAnimal = new Ornitorrinco(50);
		refTipoAnimal.locomoverse(); //encontra o m�todo em Animal, mas chama o m�todo de Ornitorrinco
		
		o.getIndiceVeneno();
		//refTipoAnimal.getIndiceVeneno(); ***n�o encontra o m�todo
		
		
		Cobra c = new Cobra();
		c.nome = "celeste";
		
		Galinha g = new Galinha();
		g.nome ="Zaza";
		
		Lagarto l = new Lagarto();
		l.nome = "Rango";
		
		Vacinar(c);
		Vacinar(g);
		Vacinar(l);
		
		
		Ornitorrinco o2 = (Ornitorrinco) refTipoAnimal;
		System.out.println("indice veneno: "
				+o2.getIndiceVeneno());
		
		
	}
	
	public static void Vacinar(Animal a) {
		System.out.println("o animal "
				+ a.nome
				+ " est� sendo vacinado"
				);
		
	}

}
