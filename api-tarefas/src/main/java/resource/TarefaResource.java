package resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Tarefa;
import service.TarefaService;

@Path("tarefas")
public class TarefaResource {
	
	@GET
	@Path("buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTarefa(@PathParam("id") Integer id) {
		TarefaService service = new TarefaService();
		Tarefa tarefa = service.buscarPorId(id);
		
		Response response = null;
		
		if(tarefa != null) {
			response = Response.status(Response.Status.OK).entity(tarefa).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND)
					           .entity("Não encontrado.").build();
		}
		
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postTarefa(Tarefa tarefa) {
		TarefaService service = new TarefaService();
		Boolean retorno = service.incluirTarefa(tarefa);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(tarefa).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND)
					           .entity("Não foi possível realizar a inclusão").build();
		}
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getTarefas() {
		TarefaService service = new TarefaService();
		List<Tarefa> lista = service.listar();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
}
