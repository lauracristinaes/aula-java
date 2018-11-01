package controller;

import java.util.ArrayList;

import model.Professor;

public class ProfessorController {
	
	public static ArrayList<Professor> listaProfessores; 
	
	public ProfessorController() {
		if (listaProfessores == null) {
			listaProfessores = new ArrayList<Professor>();
		}
	}
	
	public void cadastrarProfessor(Professor professor) {
		listaProfessores.add(professor);
		System.out.println("Professor " + professor.getNome() + " da disciplina " + professor.getDisciplina() + " cadastrado com sucesso!");
		System.out.println("Qtd professores: " +  listaProfessores.size());
	}
}
