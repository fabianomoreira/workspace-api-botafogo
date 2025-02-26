package dao;

import java.util.List;
import java.util.Scanner;

import model.Tarefa;
import service.TarefaService;

public class TesteBanco {

	public static void main(String[] args) {
		/*
		System.out.println(Dao.getStatusConexao());
		Connection conexao = Dao.getConexao();
		System.out.println(Dao.getStatusConexao());
		*/
		
		TarefaService service = new TarefaService();
		
		List<Tarefa> lista = service.listar();
		
		for(Tarefa t: lista) {
			System.out.println(t);
		}
		
		System.out.println("--------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual tarefa você quer consultar?");
		int criterio = scanner.nextInt();
		
		Tarefa t = service.buscarPorId(criterio);
		System.out.println(t.getDescricao());
		
		System.out.println("--------------------------------------");
		
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Qual tarefa você quer consultar (descrição)?");
		String criterio2 = scanner2.nextLine();
		
		List<Tarefa> lista2 = service.buscarPorDescricao(criterio2);
		
		for(Tarefa t2: lista2) {
			System.out.println(t2);
		}		
		
		Tarefa tarefaIncluir = new Tarefa();
		tarefaIncluir.setDescricao("Comer biscoito");
		tarefaIncluir.setPrazo(5);
		tarefaIncluir.setFinalizada(false);
		
		if(service.incluirTarefa(tarefaIncluir)) {
			System.out.println("Registro incluido com sucesso");
		} else {
			System.out.println("Ocorreu algum erro");
		}
	}

}
