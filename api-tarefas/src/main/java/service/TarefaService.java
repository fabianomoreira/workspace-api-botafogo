package service;

import java.util.List;

import dao.TarefaDAO;
import model.Tarefa;

public class TarefaService {
	public boolean excluirTarefa(Tarefa tarefa) {
		TarefaDAO dao = new TarefaDAO();
		return dao.excluir(tarefa);
	}
	
	public boolean alterarTarefa(Tarefa tarefa) {
		TarefaDAO dao = new TarefaDAO();
		return dao.alterar(tarefa);
	}
	
	public boolean incluirTarefa(Tarefa tarefa) {
		TarefaDAO dao = new TarefaDAO();
		return dao.incluir(tarefa);
	}
	
	public List<Tarefa> buscarPorDescricao(String valor){
		TarefaDAO dao = new TarefaDAO();
		return dao.buscarPorDescricao(valor);
	}	
	
	public Tarefa buscarPorId(Integer id) {
		TarefaDAO dao = new TarefaDAO();
		return dao.buscarPorId(id);
	}
	
	public List<Tarefa> listar(){
		TarefaDAO dao = new TarefaDAO();
		return dao.listar();
	}
}
