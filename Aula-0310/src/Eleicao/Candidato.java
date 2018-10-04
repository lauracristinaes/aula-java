package Eleicao;

import Eleicao.exception.ValidacaoException;

public class Candidato extends Pessoa {
	
	private EPartidoPolitico partido;
	private Integer numeroEleitoral;
	
	
	public void validarPreenchimento() throws ValidacaoException {
		
		StringBuilder validacao = new StringBuilder();
		
		if(this.nome == null || this.nome.isEmpty()) {
			validacao.append("campo nome obrigatório \n");
		} else if(nome.split("").length < 2) {
			validacao.append("O nome deve ser completo \n");
		}
		
		
		if(this.getCpf() == null || this.getCpf().isEmpty()) {
			validacao.append("campo cpf obrigatório \n");
		} else if(getCpf().length() != 11) {
			validacao.append("cpf informado é inválido \n");
		}
		
		if(validacao.length() > 0) {
			throw new ValidacaoException(validacao.toString());
		}
		
		
		
	}

}
