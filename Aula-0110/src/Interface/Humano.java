package Interface;

public class Humano implements IPersonagem {

	@Override
	public void andar() {
		System.out.println("Humano andando");
		
	}
	
	@Override
	public void atacar() {
		System.out.println("Humano atacando");
		
	}

	public boolean trocar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void comprar(Double valorItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void falar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gesticular() {
		// TODO Auto-generated method stub
		
	}
	

}
