package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Aluno;



public class AlunoDao {
	
private BancoDados db = null;
	
	public AlunoDao() {
		try {
			db = new BancoDados("aulajava");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
public void cadastrarAluno(Aluno aluno) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO  Alunos (descricao, finalizado, dataFinalizacao)");
			sql.append("VALUES(?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			//stmt.setString(1, String.valueOf(Aluno.getDescricao()));
			//stmt.setBoolean(2, Aluno.isFinalizado());
			
//			Calendar vdata = Calendar.getInstance(); //alterar para pegar data da Aluno
//			java.sql.Date date =new java.sql.Date(vdata.getTime().getTime() );
			
			//java.util.Date vdata = Aluno.getDataFinalizacao();
			//java.sql.Date date =new java.sql.Date(vdata.getTime());
			//stmt.setDate(3, date);
			

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método cadastrarAluno - rollback");
				}
			}
			System.out.println("Erro no método cadastrarAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		System.out.println("Aluno: " + aluno.getName() + "cadastrado com sucesso!");
	}


public List<Aluno> consultarListaAluno() {

	List<Aluno> listaAluno = new ArrayList<Aluno>();

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();

		String sql = "SELECT * "
				+ "FROM  Alunos";

		stmt = conn.prepareStatement(sql.toString());

		rs = stmt.executeQuery();

		while (rs.next()) {
			Aluno aluno = new Aluno();
			//aluno.setId(rs.getLong("id")); 
			//aluno.setDescricao(rs.getString("descricao"));
			//aluno.setFinalizado(rs.getBoolean("finalizado"));
			//Aluno.setDataFinalizacao(rs.getDate("dataFinalizacao");
			
			listaAluno.add(aluno);
		}

	} catch (SQLException e) {
		System.out.println("Erro no método consultarListaAluno");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	return listaAluno;
}

public void deletarAluno(Long id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE FROM Alunos WHERE ID = ?");
	

		stmt = conn.prepareStatement(sql.toString());
		stmt.setLong(1, id);

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método deletarAluno - rollback");
			}
		}
		System.out.println("Erro no método deletarAluno");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	
}

public void finaliza(long id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE Alunos SET finalizado = ?, dataFinalizacao = ?");
		sql.append("WHERE id = ?;");

		stmt = conn.prepareStatement(sql.toString());
		stmt.setBoolean(1, true);
		
		java.util.Date vdata = new Date(System.currentTimeMillis());
		java.sql.Date date =new java.sql.Date(vdata.getTime());
		
		stmt.setDate(2, date);
		stmt.setLong(3, id);

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método finalizarAluno - rollback");
			}
		}
		System.out.println("Erro no método finalizarAluno");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	
}

public void alterarAluno(Aluno aluno) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE Alunos SET descricao = ?, finalizado = ?, dataFinalizacao = ?");
		sql.append("WHERE id = ?;");

		stmt = conn.prepareStatement(sql.toString());
		//stmt.setString(1, aluno.getDescricao());
		//stmt.setBoolean(2, aluno.isFinalizado());
		
		//java.util.Date vdata = aluno.getDataFinalizacao();
		//java.sql.Date date =new java.sql.Date(vdata.getTime());
		
		//stmt.setDate(3, date);
		//stmt.setLong(4, aluno.getId());

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método alterarAluno - rollback");
			}
		}
		System.out.println("Erro no método alterarAluno");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
}	


}
