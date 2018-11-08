package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Filho;

public class FilhoDao {
	
	private BancoDados db = null;
	
	public FilhoDao() {
			try {
				db = new BancoDados("aulajava");
			} catch (NamingException e) {
				System.out.println("Erro ao instanciar o Banco de Dados: " + e);
			}
		}
		
	public void cadastrarFilho(Filho filho) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				conn = db.obterConexao();
				conn.setAutoCommit(false);

				StringBuffer sql = new StringBuffer();
				
				sql.append("INSERT INTO  Filhos (descricao, finalizado, dataFinalizacao)");
				sql.append("VALUES(?,?,?)");

				stmt = conn.prepareStatement(sql.toString());

				//stmt.setString(1, String.valueOf(Filho.getDescricao()));
				//stmt.setBoolean(2, Filho.isFinalizado());
				
//				Calendar vdata = Calendar.getInstance(); //alterar para pegar data da Filho
//				java.sql.Date date =new java.sql.Date(vdata.getTime().getTime() );
				
				//java.util.Date vdata = Filho.getDataFinalizacao();
				//java.sql.Date date =new java.sql.Date(vdata.getTime());
				//stmt.setDate(3, date);
				

				stmt.execute();
				conn.commit();
			} catch (SQLException e) {
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						System.out.println("Erro no método cadastrarFilho - rollback");
					}
				}
				System.out.println("Erro no método cadastrarFilho");
				e.printStackTrace();
			} finally {
				db.finalizaObjetos(rs, stmt, conn);
			}
			
			System.out.println("Filho: " + filho.getNome() + "cadastrado com sucesso!");
		}


	public List<Filho> consultarListaFilho() {

		List<Filho> listaFilho = new ArrayList<Filho>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT * "
					+ "FROM  Filhos";

			stmt = conn.prepareStatement(sql.toString());

			rs = stmt.executeQuery();

			while (rs.next()) {
				Filho filho = new Filho();
				//Filho.setId(rs.getLong("id")); 
				//Filho.setDescricao(rs.getString("descricao"));
				//Filho.setFinalizado(rs.getBoolean("finalizado"));
				//Filho.setDataFinalizacao(rs.getDate("dataFinalizacao");
				
				listaFilho.add(filho);
			}

		} catch (SQLException e) {
			System.out.println("Erro no método consultarListaFilho");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listaFilho;
	}

	public void deletarFilho(Long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM Filhos WHERE ID = ?");
		

			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, id);

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método deletarFilho - rollback");
				}
			}
			System.out.println("Erro no método deletarFilho");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
	}

	public void alterarFilho(Filho Filho) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE Filhos SET descricao = ?, finalizado = ?, dataFinalizacao = ?");
			sql.append("WHERE id = ?;");

			stmt = conn.prepareStatement(sql.toString());
			//stmt.setString(1, Filho.getDescricao());
			//stmt.setBoolean(2, Filho.isFinalizado());
			
			//java.util.Date vdata = Filho.getDataFinalizacao();
			//java.sql.Date date =new java.sql.Date(vdata.getTime());
			
			//stmt.setDate(3, date);
			//stmt.setLong(4, Filho.getId());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método alterarFilho - rollback");
				}
			}
			System.out.println("Erro no método alterarFilho");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}	

}
