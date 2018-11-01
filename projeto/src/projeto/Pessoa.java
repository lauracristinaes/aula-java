package projeto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import projeto.BancoDados;

public class Pessoa {
	
	//cpf int(11) primary key,
	//nome varchar(80) not null,
	//sexo varchar(1) not null,
	//dtNasc date
	
	public int cpf;
	public String nome;
	public String sexo; //F ou M
	//private java.sql.Date dtNasc;
	public Date dtNasc;
	
	public Pessoa(int cpf, String nome, String sexo, Date dt) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dtNasc = dt;
		
	}
	
	public void addBanco() {
		
	
		
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
			
			
	
			String sql = "INSERT INTO pessoa (cpf, nome, sexo, dtNasc) values (?, ?, ?, ?);";
			
			
			
			
			
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, this.cpf);
			stmt.setString(2, this.nome);
			stmt.setString(3, this.sexo);
			
			java.sql.Date d = new java.sql.Date(dtNasc.getTime());
			stmt.setDate(4, d);
			//stmt.setDate(4, (java.sql.Date) this.dtNasc);
				
			
			
			
		
			
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
	
	public List<Pessoa> ListaPessoasBanco() {
		
		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		
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
			String sql = "SELECT * FROM pessoa";

			stmt = conn.prepareStatement(sql.toString());

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				String strDt = "2015-11-15";
				Date dt = null;
				try {
					dt = formato.parse(strDt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Pessoa pessoa = new Pessoa(rs.getInt("cpf"), rs.getString("nome"), rs.getString("sexo"),dt);
				listaPessoa.add(pessoa);
			}
					
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
		
		return listaPessoa;

		
		
	}
	
	public static void main(String[] args) throws ParseException {
		
		int cpf = 000;
		String nome = "teste";
		String sexo = "F";
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String strDt = "2015-11-15";
		Date dt = formato.parse(strDt);
		
		Pessoa pessoa = new Pessoa(cpf, nome, sexo, dt);
		pessoa.addBanco();
	}
}
