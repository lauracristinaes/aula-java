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
		
		System.out.println("entrou no dao do aluno");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO  Alunos (nome, cpf, dataNascimento, telefone, endereco, email, sexo, matricula, curso)");
			sql.append("VALUES(?,?,?,?,?,?,?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			
			java.util.Date vdata = aluno.getDtNasc();
			java.sql.Date date =new java.sql.Date(vdata.getTime());
			stmt.setDate(3, date);
			
			stmt.setString(4, aluno.getTelefone());
			stmt.setString(5, aluno.getEndereco());
			stmt.setString(6, aluno.getEmail());
			
			stmt.setBoolean(7, aluno.isSexo());
			stmt.setString(8, aluno.getMatricula());
			stmt.setInt(9, aluno.getCursoInt());

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
		
		System.out.println("Aluno: " + aluno.getNome() + " cadastrado com sucesso!");
	}


public List<Aluno> consultarListaAluno() {
	
	System.out.println("entrou no dao alunos");

	List<Aluno> listaAluno = new ArrayList<Aluno>();

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		System.out.println("entrou no banco");
		conn = db.obterConexao();

		String sql = "SELECT * FROM  Alunos";

		stmt = conn.prepareStatement(sql.toString());

		rs = stmt.executeQuery();

		while (rs.next()) {
			Aluno aluno = new Aluno();			
			
			aluno.setId(rs.getLong("id"));
			
			aluno.setNome(rs.getString("nome"));
			aluno.setCpf(rs.getString("cpf"));
			aluno.setDtNascDate(rs.getDate("dataNascimento"));
			
			aluno.setEmail(rs.getString("email"));			
			aluno.setEndereco(rs.getString("endereco"));
			aluno.setTelefone(rs.getString("telefone"));
			
			aluno.setSexo(rs.getBoolean("sexo"));
			aluno.setMatricula(rs.getString("matricula"));
			aluno.setCursoInt(rs.getInt("curso"));
			
			listaAluno.add(aluno);System.out.println("setou um aluno");
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

public Aluno recuperarAluno(Long id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	Aluno aluno = new Aluno();	

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM Alunos WHERE ID = ?");
	

		stmt = conn.prepareStatement(sql.toString());
		stmt.setLong(1, id);

		rs = stmt.executeQuery();

		while (rs.next()) {
					
			
			aluno.setId(rs.getLong("id"));
			
			aluno.setNome(rs.getString("nome"));
			aluno.setCpf(rs.getString("cpf"));
			aluno.setDtNascDate(rs.getDate("dataNascimento"));
			
			aluno.setEmail(rs.getString("email"));			
			aluno.setEndereco(rs.getString("endereco"));
			aluno.setTelefone(rs.getString("telefone"));
			
			aluno.setSexo(rs.getBoolean("sexo"));
			aluno.setMatricula(rs.getString("matricula"));
			aluno.setCursoInt(rs.getInt("curso"));
			
			System.out.println("recuperou um aluno");
		}
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método recuperarAluno - rollback");
			}
		}
		System.out.println("Erro no método recuperarAluno");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	return aluno;
	
}


public void alterarAluno(Aluno aluno) {
	
	System.out.println("atualizando aluno");
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE Alunos SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, endereco = ?, email = ?, sexo = ?, matricula = ?, curso = ?"); // 
		sql.append("WHERE id = ?;");

		stmt = conn.prepareStatement(sql.toString());
		
		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getCpf());
		
		java.util.Date vdata = aluno.getDtNasc();
		java.sql.Date date =new java.sql.Date(vdata.getTime());
		stmt.setDate(3, date);
		
		stmt.setString(4, aluno.getTelefone());
		stmt.setString(5, aluno.getEndereco());
		stmt.setString(6, aluno.getEmail());
		
		stmt.setBoolean(7, aluno.isSexo());
		stmt.setString(8, aluno.getMatricula());
		stmt.setInt(9, aluno.getCursoInt());
	
		stmt.setLong(10, aluno.getId());

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
