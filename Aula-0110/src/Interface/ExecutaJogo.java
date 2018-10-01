package Interface;

public class ExecutaJogo {

	
	public static void main(String[] args) {
		
		IPersonagem personagem = new Humano();
		
		personagem.andar();
		personagem.atacar();
		
		personagem = new Elfo();
		
		personagem.andar();
		personagem.atacar();
		
	}
}
