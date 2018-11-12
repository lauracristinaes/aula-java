package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Funcionario;

public class FuncionarioDao {
	
private BancoDados db = null;
	
public FuncionarioDao() {
		try {
			db = new BancoDados("aulajava");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
public void cadastrarFuncionario(Funcionario funcionario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO  Funcionarios (descricao, finalizado, dataFinalizacao)");
			sql.append("VALUES(?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			//stmt.setString(1, String.valueOf(Funcionario.getDescricao()));
			//stmt.setBoolean(2, Funcionario.isFinalizado());
			
//			Calendar vdata = Calendar.getInstance(); //alterar para pegar data da Funcionario
//			java.sql.Date date =new java.sql.Date(vdata.getTime().getTime() );
			
			//java.util.Date vdata = Funcionario.getDataFinalizacao();
			//java.sql.Date date =new java.sql.Date(vdata.getTime());
			//stmt.setDate(3, date);
			

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método cadastrarFuncionario - rollback");
				}
			}
			System.out.println("Erro no método cadastrarFuncionario");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		//System.out.println("Funcionario: " + funcionario.getName() + "cadastrado com sucesso!");
	}


public List<Funcionario> consultarListaFuncionario() {

	List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();

		String sql = "SELECT * "
				+ "FROM  Funcionarios";

		stmt = conn.prepareStatement(sql.toString());

		rs = stmt.executeQuery();

		while (rs.next()) {
			Funcionario funcionario = new Funcionario();
			//Funcionario.setId(rs.getLong("id")); 
			//Funcionario.setDescricao(rs.getString("descricao"));
			//Funcionario.setFinalizado(rs.getBoolean("finalizado"));
			//Funcionario.setDataFinalizacao(rs.getDate("dataFinalizacao");
			
			listaFuncionario.add(funcionario);
		}

	} catch (SQLException e) {
		System.out.println("Erro no método consultarListaFuncionario");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	return listaFuncionario;
}

public void deletarFuncionario(Long id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE FROM Funcionarios WHERE ID = ?");
	

		stmt = conn.prepareStatement(sql.toString());
		stmt.setLong(1, id);

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método deletarFuncionario - rollback");
			}
		}
		System.out.println("Erro no método deletarFuncionario");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	
}


public void alterarFuncionario(Funcionario funcionario) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE Funcionarios SET descricao = ?, finalizado = ?, dataFinalizacao = ?");
		sql.append("WHERE id = ?;");

		stmt = conn.prepareStatement(sql.toString());
		//stmt.setString(1, Funcionario.getDescricao());
		//stmt.setBoolean(2, Funcionario.isFinalizado());
		
		//java.util.Date vdata = Funcionario.getDataFinalizacao();
		//java.sql.Date date =new java.sql.Date(vdata.getTime());
		
		//stmt.setDate(3, date);
		//stmt.setLong(4, Funcionario.getId());

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método alterarFuncionario - rollback");
			}
		}
		System.out.println("Erro no método alterarFuncionario");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
}	


}
