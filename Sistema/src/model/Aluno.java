package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
	
	private String matricula;
	private int curso; // 1 = Java WEB; 2 = Cobol; 3 = .NET; 4 = Redes;  5 = Python;
	public List<String> erro;
	
	public Aluno() {
		erro = new ArrayList();
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	public boolean validate() {
		
		//cpf: obrigat�rio - num�rico - v�lido
		
		if(this.getCpf() == null) {
			erro.add("cpf � obrigat�rio");
			
			
		} else {
			String cpf = this.getCpf().replaceAll(".", "");
			cpf = cpf.replaceAll("-", "");
			if(!cpf.matches("[0-9]*")) {
				erro.add("cpf deve conter apenas n�meros");
			}	
			}
		if(!this.validaCPF()){
			erro.add("cpf inv�lido");
		}
		
		
		
		//matricula: obrigat�rio - num�rico - 9 digitos
		
		if(this.getMatricula() == null) {
			erro.add("matr�cula � obrigat�ria");
			
			
		} else if(!this.getMatricula().matches("[0-9]*")) {
				erro.add("matr�cula deve conter apenas n�meros");
			}else if(this.getMatricula().length()>9) {
				erro.add("matr�cula deve conter at� 9 d�gitos");
			}
			
		
		
		//data de nascimento: obrigat�rio - formato "DD/MM/AAAA"
		
		if(this.getDtNasc() == null) {
			erro.add("data de nascimento � obrigat�ria");
					
		} 
		
		//curso: obrigat�rio - v�lido (1-5)
		
		if(this.getCurso() == 0) {
			erro.add("curso � obrigat�rio");
					
		} 
		
		//sexo, telefone, email, endere�o: obrigat�rio
		
		
		
		if(this.getTelefone() == null) {
			erro.add("telefone � obrigat�rio");
					
		} 
		
		if(this.getEmail() == null) {
			erro.add("email � obrigat�rio");
					
		} 
		
		if(this.getEndereco() == null) {
			erro.add("endere�o � obrigat�rio");
					
		} 
		
		if(erro.isEmpty())
			return true;
		
		else
			return false;
	}

}
