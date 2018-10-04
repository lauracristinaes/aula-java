package Eleicao.Servico;

import Eleicao.Candidato;
import Eleicao.exception.ValidacaoException;

public class CandidatoServico {
	
	public void gravar(Candidato candidato) {
		
		try {
		candidato.validarPreenchimento();
		}catch(ValidacaoException e) {
		System.out.println(e.getMessage());	
		}
		
	}
	
	public void ler() {
		
	}

}
