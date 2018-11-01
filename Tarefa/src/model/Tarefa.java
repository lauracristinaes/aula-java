package model;


import java.util.Date;

import javax.validation.constraints.Size;

public class Tarefa {

	
	private	Long id;
	
	@Size(min=5)
	private	String descricao;
	private boolean	finalizado;
	private String dtFinalizacao;
	private	Date dataFinalizacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public String getDtFinalizacao() {
		return dtFinalizacao;
	}
	public void setDtFinalizacao(String dtFinalizacao) {
		this.dtFinalizacao = dtFinalizacao;
	}
	
	
}
