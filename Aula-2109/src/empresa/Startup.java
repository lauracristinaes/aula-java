package empresa;

public class Startup {
	
	public static void main(String[] args) {
		
		Colaborador colab = new Colaborador();
		colab.cargo = "CEO";
		colab.salario = 15000.00;
		colab.cpf = "000.000.000-00";
		colab.dataNascimento = new Date();
		colab.nome = "Colaborador";
		colab.dependente = new Dependente();
		
		System.out.println(colab.dependente.nome);
	}

}
