package br.com.fiap.carrosapi;

import java.util.List;

import br.com.fiap.carrosapi.model.Carro;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.CarroService;

@Path("carro")
public class CarroResource {
	
	private CarroService service = new CarroService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carro> listAll() {
		return service.findAll();
	}

	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
    	var carro = service.findById(id);
    	
    	if(carro == null) {
    		return Response.status(404).build();
    		 
    	}
    	
    	return Response.ok(carro).build();
    	
    }
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		var carro = service.findById(id);
		if(carro == null)
			return Response.status(404).build();
		
		service.delete(carro);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar (Carro carro) {
		if (!service.save(carro)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(carro).build();
	}
	
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, Carro carro) {
		var carroEncontrado = service.findById(id);
		
		if(carroEncontrado == null)
			return Response.status(Response.Status.NOT_FOUND).build();
		
		if (!service.update(carro))
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(carro).build();
		}
	
	
}
