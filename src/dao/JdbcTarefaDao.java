package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;

import controller.DataUtil;
import model.Professor;
import model.Tarefa;

public class JdbcTarefaDao {

	private BancoDados db = null;
	
	public JdbcTarefaDao() {
		try {
			db = new BancoDados("curso_java");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
	public void adiciona(Tarefa tarefa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO tarefas (descricao, finalizado) ");
			sql.append("VALUES(?,?);");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, false);

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método adiciona - rollback");
				}
			}
			System.out.println("Erro no método adiciona");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}

	public List<Tarefa> lista() {
		List<Tarefa> listaTarefa = new ArrayList<Tarefa>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT * "
					+ "FROM tarefas "
					+ "ORDER BY descricao";

			stmt = conn.prepareStatement(sql.toString());

			rs = stmt.executeQuery();

			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				if (rs.getDate("dataFinalizacao") != null) {
					Calendar dataFinalizacao = Calendar.getInstance();  
					dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(dataFinalizacao);
				}
				listaTarefa.add(tarefa);
			}

		} catch (SQLException e) {
			System.out.println("Erro no método lista");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listaTarefa;
	}

	public void remove(Tarefa tarefa) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM tarefas WHERE id = ?;");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setLong(1, tarefa.getId());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método remove - rollback");
				}
			}
			System.out.println("Erro no método remove");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
	}

	public Tarefa buscaPorId(Long id) {
		Tarefa tarefa = new Tarefa();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT * "
					+ "FROM tarefas "
					+ "WHERE id = ?;";

			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				if (rs.getDate("dataFinalizacao") != null) {
					Calendar dataFinalizacao = Calendar.getInstance();  
					dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(dataFinalizacao);
				}
			}

		} catch (SQLException e) {
			System.out.println("Erro no método buscaPorId");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return tarefa;
	}

	public void finaliza(Long id) {
		// TODO Auto-generated method stub
		
	}	
}
