package testesSobrecarga;

public class testaSobrecarga {

	public void Imprimir() {
		System.out.println("este m�todo imprime");
		
	}
	
	public void Imprimir(String texto) {}
	

	public void ImprimirNomeidade(String nome, int idade) {}
	

	public void ImprimirNomeidade(int idade, String nome) {}
	
}
