package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Usuario;

public class UsuarioDao {
private BancoDados db = null;
	
	public UsuarioDao() {
			try {
				db = new BancoDados("aulajava");
			} catch (NamingException e) {
				System.out.println("Erro ao instanciar o Banco de Dados: " + e);
			}
		}
		
	public void cadastrarusuario(Usuario usuario) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {
				conn = db.obterConexao();
				conn.setAutoCommit(false);

				StringBuffer sql = new StringBuffer();
				
				sql.append("INSERT INTO  usuarios (usuario, senha)");
				sql.append("VALUES(?,?)");

				stmt = conn.prepareStatement(sql.toString());

				//stmt.setString(1, String.valueOf(usuario.getDescricao()));
				//stmt.setBoolean(2, usuario.isFinalizado());
				
//				Calendar vdata = Calendar.getInstance(); //alterar para pegar data da usuario
//				java.sql.Date date =new java.sql.Date(vdata.getTime().getTime() );
				
				//java.util.Date vdata = usuario.getDataFinalizacao();
				//java.sql.Date date =new java.sql.Date(vdata.getTime());
				//stmt.setDate(3, date);
				

				stmt.execute();
				conn.commit();
			} catch (SQLException e) {
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						System.out.println("Erro no método cadastrarusuario - rollback");
					}
				}
				System.out.println("Erro no método cadastrarusuario");
				e.printStackTrace();
			} finally {
				db.finalizaObjetos(rs, stmt, conn);
			}
			
		//	System.out.println("usuario: " + usuario.getNome() + "cadastrado com sucesso!");
		}


	public List<Usuario> consultarListausuario() {

		List<Usuario> listausuario = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();

			String sql = "SELECT * "
					+ "FROM  usuarios";

			stmt = conn.prepareStatement(sql.toString());

			rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				//usuario.setId(rs.getLong("id")); 
				//usuario.setDescricao(rs.getString("descricao"));
				//usuario.setFinalizado(rs.getBoolean("finalizado"));
				//usuario.setDataFinalizacao(rs.getDate("dataFinalizacao");
				
				listausuario.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println("Erro no método consultarListausuario");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listausuario;
	}

	public void deletarusuario(Long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM usuarios WHERE login = ?");
		

			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, id);

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método deletarusuario - rollback");
				}
			}
			System.out.println("Erro no método deletarusuario");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
	}

	public void alterarusuario(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE usuarios SET login = ?, senha = ?");
			sql.append("WHERE login = ?;");

			stmt = conn.prepareStatement(sql.toString());
			//stmt.setString(1, usuario.getDescricao());
			//stmt.setBoolean(2, usuario.isFinalizado());
			
			//java.util.Date vdata = usuario.getDataFinalizacao();
			//java.sql.Date date =new java.sql.Date(vdata.getTime());
			
			//stmt.setDate(3, date);
			//stmt.setLong(4, usuario.getId());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método alterarusuario - rollback");
				}
			}
			System.out.println("Erro no método alterarusuario");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		System.out.println("entrou na função existe usuário");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			System.out.println("conectou com o banco");
			conn = db.obterConexao();

			String sql = "SELECT * "
					+ "FROM  usuarios where login = ? and senha = ?";

			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			
			System.out.println("query montada: " + stmt);

			rs = stmt.executeQuery();

			if(rs.next()) {
				//usuário existe
				System.out.println("usuário encontrado");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro no método consultarUsuario");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		
		
		return false;
	}	
}
