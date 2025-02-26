package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;

public class TarefaDAO {

	public boolean excluir(Tarefa tarefa) {
		boolean status = false;
		
		Connection cnx = Dao.getConexao();
 
		StringBuilder QUERY = new StringBuilder();
		QUERY.append("DELETE FROM tarefas WHERE ID = ?");
			   
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());
			
			ps.setInt(1, tarefa.getId());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean alterar(Tarefa tarefa) {
		boolean status = false;
		
		Connection cnx = Dao.getConexao();
 
		StringBuilder QUERY = new StringBuilder();
		QUERY.append("UPDATE SET tarefas DESCRICAO = ?, PRAZO = ?, FINALIZADA = ? ");
		QUERY.append("WHERE ID = ?");
			   
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());
			
			ps.setString(1, tarefa.getDescricao());
			ps.setInt(2, tarefa.getPrazo());
			ps.setBoolean(3, tarefa.getFinalizada());
			ps.setInt(4, tarefa.getId());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean incluir(Tarefa tarefa) {
		boolean status = false;
		
		Connection cnx = Dao.getConexao();
		/*
		String SQL = "INSERT INTO tarefas(DESCRICAO, PRAZO, FINALIZADA) ";
			   SQL = SQL + "VALUES(?, ?, ?)";
		*/	   
		StringBuilder QUERY = new StringBuilder();
		QUERY.append("INSERT INTO tarefas(DESCRICAO, PRAZO, FINALIZADA) ");
		QUERY.append("VALUES(?, ?, ?)");
			   
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(QUERY.toString());
			
			ps.setString(1, tarefa.getDescricao());
			ps.setInt(2, tarefa.getPrazo());
			ps.setBoolean(3, tarefa.getFinalizada());
			
			int x = ps.executeUpdate();
			
			status = x > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public List<Tarefa> buscarPorDescricao(String valor){
		List<Tarefa> lista = new ArrayList<Tarefa>();
		Tarefa tarefa = null;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "SELECT * FROM tarefas WHERE descricao LIKE ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			ps.setString(1, valor + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tarefa = new Tarefa();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setPrazo(rs.getInt("prazo"));
				tarefa.setFinalizada(rs.getBoolean("finalizada"));
				
				lista.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Tarefa buscarPorId(Integer id) {
		Tarefa tarefa = null;
		Connection cnx = Dao.getConexao();
		PreparedStatement ps;
		
		String SQL = "SELECT * FROM tarefas WHERE id = ?";
		
		try {
			ps = cnx.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				tarefa = new Tarefa();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setPrazo(rs.getInt("prazo"));
				tarefa.setFinalizada(rs.getBoolean("finalizada"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tarefa;
	}
	
	public List<Tarefa> listar(){
		List<Tarefa> lista = new ArrayList<Tarefa>();
		Tarefa tarefa = null;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "SELECT * FROM tarefas";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tarefa = new Tarefa();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setPrazo(rs.getInt("prazo"));
				tarefa.setFinalizada(rs.getBoolean("finalizada"));
				
				lista.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
