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
		/*
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
		*/
		
		// EXCLUSÃO
		/*
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Qual tarefa você quer excluir?");
		int criterio2 = scanner2.nextInt();
		
		Tarefa t = new Tarefa();
		
		t = service.buscarPorId(criterio2);
		
		if(service.excluirTarefa(t)) {
			System.out.println("Excluído com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro");
		}
		*/
		
		// ALTERAÇÃO
		Scanner scanner2 = new Scanner(System.in);
		Scanner item = new Scanner(System.in);
		
		System.out.println("Qual tarefa você quer alterar?");
		int criterio2 = scanner2.nextInt();
		
		Tarefa t = new Tarefa();
		
		t = service.buscarPorId(criterio2);
		
		System.out.println("Escolha o que você quer alterar");
		System.out.println("1 - Descrição, 2 - Prazo, 3 - Status");
		int escolha = item.nextInt();
		
		if(escolha == 1) {
			Scanner descricao = new Scanner(System.in);
			System.out.println("Digite a Descrição");
			String valorDescricao = descricao.nextLine();
			t.setDescricao(valorDescricao);
		} else if(escolha == 2) {
			Scanner prazo = new Scanner(System.in);
			System.out.println("Digite o Prazo");
			int valorPrazo = prazo.nextInt();
			t.setPrazo(valorPrazo);			
		} else {
			Scanner status = new Scanner(System.in);
			System.out.println("Digite o Status (true ou false)");
			boolean valorStatus = status.nextBoolean();
			t.setFinalizada(valorStatus);			
		}
		
		if(service.alterarTarefa(t)) {
			System.out.println("Alterado com sucesso!");
		} else {
			System.out.println("Ocorreu algum erro");
		}

	}

}
