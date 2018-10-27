package ProjetoJavaDesktop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;

import Testes.BancoDados;

public class Pessoa {
	
	//cpf int(11) primary key,
	//nome varchar(80) not null,
	//sexo varchar(1) not null,
	//dtNasc date
	
	public int cpf;
	public String nome;
	public String sexo; //F ou M
	//public Date dtNasc;
	
	public Pessoa(int cpf, String nome, String sexo) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		//this.dtNasc = dt;
		
	}
	
	public void AddBanco() {
		
		System.out.println("Entrou na função de add banco");
		
		BancoDados db = null;
		try {
			
			db = new BancoDados("aulajava");//LOCALHOST
			
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
	
			conn = db.obterConexao();
			
			
	
			String sql = "INSERT INTO pessoa (cpf, nome, sexo) values (?, ?, ?);";
			
			
			
			
			
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, this.cpf);
			stmt.setString(2, this.nome);
			stmt.setString(3, this.sexo);
			//sqlPrepare.setDate(4, (java.sql.Date) this.dtNasc);
				
			System.out.println("ok até aqui");
			System.out.println("meu stmt é: " + stmt);
			
			
		
			
			stmt.execute();
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			db.finalizaObjetos(rs, stmt, conn);

		}

	}
	
	public void BuscarPessoaBanco() {
		
		
	}
	
	public static void main(String[] args) throws ParseException {
		
		int cpf = 000;
		String nome = "teste";
		String sexo = "F";
		//SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy");
		//Date dt = formato.parse("23/11/2015");
		
		Pessoa pessoa = new Pessoa(cpf, nome, sexo);
		pessoa.AddBanco();
	}
}
