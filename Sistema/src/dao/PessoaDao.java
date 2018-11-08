package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Pessoa;

public class PessoaDao {
	
private BancoDados db = null;
	
public PessoaDao() {
		try {
			db = new BancoDados("aulajava");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
public void cadastrarPessoa(Pessoa pessoa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO  Pessoas (descricao, finalizado, dataFinalizacao)");
			sql.append("VALUES(?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			//stmt.setString(1, String.valueOf(Pessoa.getDescricao()));
			//stmt.setBoolean(2, Pessoa.isFinalizado());
			
//			Calendar vdata = Calendar.getInstance(); //alterar para pegar data da Pessoa
//			java.sql.Date date =new java.sql.Date(vdata.getTime().getTime() );
			
			//java.util.Date vdata = Pessoa.getDataFinalizacao();
			//java.sql.Date date =new java.sql.Date(vdata.getTime());
			//stmt.setDate(3, date);
			

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método cadastrarPessoa - rollback");
				}
			}
			System.out.println("Erro no método cadastrarPessoa");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		System.out.println("Pessoa: " + pessoa.getName() + "cadastrado com sucesso!");
	}


public List<Pessoa> consultarListaPessoa() {

	List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();

		String sql = "SELECT * "
				+ "FROM  Pessoas";

		stmt = conn.prepareStatement(sql.toString());

		rs = stmt.executeQuery();

		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			//Pessoa.setId(rs.getLong("id")); 
			//Pessoa.setDescricao(rs.getString("descricao"));
			//Pessoa.setFinalizado(rs.getBoolean("finalizado"));
			//Pessoa.setDataFinalizacao(rs.getDate("dataFinalizacao");
			
			listaPessoa.add(pessoa);
		}

	} catch (SQLException e) {
		System.out.println("Erro no método consultarListaPessoa");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	return listaPessoa;
}

public void deletarPessoa(Long id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE FROM Pessoas WHERE ID = ?");
	

		stmt = conn.prepareStatement(sql.toString());
		stmt.setLong(1, id);

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método deletarPessoa - rollback");
			}
		}
		System.out.println("Erro no método deletarPessoa");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	
}

public void alterarPessoa(Pessoa pessoa) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE Pessoas SET descricao = ?, finalizado = ?, dataFinalizacao = ?");
		sql.append("WHERE id = ?;");

		stmt = conn.prepareStatement(sql.toString());
		//stmt.setString(1, Pessoa.getDescricao());
		//stmt.setBoolean(2, Pessoa.isFinalizado());
		
		//java.util.Date vdata = Pessoa.getDataFinalizacao();
		//java.sql.Date date =new java.sql.Date(vdata.getTime());
		
		//stmt.setDate(3, date);
		//stmt.setLong(4, Pessoa.getId());

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método alterarPessoa - rollback");
			}
		}
		System.out.println("Erro no método alterarPessoa");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
}	


}
