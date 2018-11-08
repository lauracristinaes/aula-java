package model;



public class Aluno extends Pessoa{
	
	private int matricula;
	private int curso; // 1 = Java WEB; 2 = Cobol; 3 = .NET; 4 = Redes;  5 = Python;

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	

}
