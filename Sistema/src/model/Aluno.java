package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="alunos")
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
	
	public int getCursoInt() {
		
		return curso;
	}

	public String getCurso() {
		
		return Integer.toString(curso);
	}
	public void setCurso(String curso) {
		
		this.curso = Integer.parseInt(curso);
	}
public void setCursoInt(int curso) {
		
		this.curso = curso;
	}
	public boolean validate() {
		
		//cpf: obrigatório - numérico - válido
		
		if(this.getCpf() == null) {
			erro.add("cpf é obrigatório");
			
			
		} else {
			if(!this.validaCPF()){
				erro.add("cpf inválido");
			}
			}
		
		
		
		
		//matricula: obrigatório - numérico - 9 digitos
		
		if(this.getMatricula() == null) {
			erro.add("matrícula é obrigatória");
			
			
		} else if(!this.getMatricula().matches("[0-9]*")) {
				erro.add("matrícula deve conter apenas números");
			}else if(this.getMatricula().length()>9) {
				erro.add("matrícula deve conter até 9 dígitos");
			}
			
		
		
		//data de nascimento: obrigatório - formato "DD/MM/AAAA"
		
		if(this.getDtNasc() == null) {
			erro.add("data de nascimento é obrigatória");
					
		} 
		
		//curso: obrigatório - válido (1-5)
		
		if(this.getCurso() == null) {
			erro.add("curso é obrigatório");
					
		} 
		
		//sexo, telefone, email, endereço: obrigatório
		
		
		
		if(this.getTelefone() == null) {
			erro.add("telefone é obrigatório");
					
		} 
		
		if(this.getEmail() == null) {
			erro.add("email é obrigatório");
					
		} 
		
		if(this.getEndereco() == null) {
			erro.add("endereço é obrigatório");
					
		} 
		
		if(erro.isEmpty())
			return true;
		
		else
			return false;
	}

}
