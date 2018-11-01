package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.NamingException;


import model.Tarefa;


public class TarefaDAO {
	
	private BancoDados db = null;
	
	public TarefaDAO() {
		try {
			db = new BancoDados("aulajava");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
public void cadastrarTarefa(Tarefa tarefa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO  tarefas (descricao, finalizado, dataFinalizacao)");
			sql.append("VALUES(?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, String.valueOf(tarefa.getDescricao()));
			stmt.setBoolean(2, tarefa.isFinalizado());
			
//			Calendar vdata = Calendar.getInstance(); //alterar para pegar data da tarefa
//			java.sql.Date date =new java.sql.Date(vdata.getTime().getTime() );
			
			java.util.Date vdata = tarefa.getDataFinalizacao();
			java.sql.Date date =new java.sql.Date(vdata.getTime());
			stmt.setDate(3, date);
			

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método cadastrarTarefa - rollback");
				}
			}
			System.out.println("Erro no método cadastrarTarefa");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		System.out.println("Tarefa: " + tarefa.getDescricao() + " com data de finalização " + tarefa.getDataFinalizacao() + " com status: " + tarefa.isFinalizado() + " cadastrado com sucesso!");
	}


public List<Tarefa> consultarListaTarefa() {

	List<Tarefa> listaTarefa = new ArrayList<Tarefa>();

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();

		String sql = "SELECT * "
				+ "FROM  tarefas";

		stmt = conn.prepareStatement(sql.toString());

		rs = stmt.executeQuery();

		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getLong("id")); 
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			//tarefa.setDataFinalizacao(rs.getDate("dataFinalizacao");
			
			listaTarefa.add(tarefa);
		}

	} catch (SQLException e) {
		System.out.println("Erro no método consultarListaTarefa");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	return listaTarefa;
}

public void deletarTarefa(Long id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE FROM tarefas WHERE ID = ?");
	

		stmt = conn.prepareStatement(sql.toString());
		stmt.setLong(1, id);

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método deletarTarefa - rollback");
			}
		}
		System.out.println("Erro no método deletarTarefa");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
	
}

public void alterarTarefa(Tarefa tarefa) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		conn = db.obterConexao();
		conn.setAutoCommit(false);

		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE tarefas SET descricao = ?, finalizado = ?, dataFinalizacao = ?");
		sql.append("WHERE id = ?;");

		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1, tarefa.getDescricao());
		stmt.setBoolean(2, tarefa.isFinalizado());
		
		java.util.Date vdata = tarefa.getDataFinalizacao();
		java.sql.Date date =new java.sql.Date(vdata.getTime());
		
		stmt.setDate(3, date);
		stmt.setLong(4, tarefa.getId());

		stmt.execute();
		conn.commit();
	} catch (SQLException e) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro no método alterarTarefa - rollback");
			}
		}
		System.out.println("Erro no método alterarTarefa");
		e.printStackTrace();
	} finally {
		db.finalizaObjetos(rs, stmt, conn);
	}
}	

}
