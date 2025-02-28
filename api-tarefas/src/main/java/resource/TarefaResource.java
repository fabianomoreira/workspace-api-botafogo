package resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("tarefas")
public class TarefaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public String getTarefas() {
		return "meu primeiro servlet";
	}
}
