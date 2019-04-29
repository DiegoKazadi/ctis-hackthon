/**
 * 
 */
package br.com.ctis.hackathon.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctis.hackathon.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author ctis
 *
 */
public interface PessoaEndPoint {
	@GET
	@Produces("application/json")
	@Operation(description = "Lista os Pessoa's cadastrados no sistema", summary = "Listar Pessoa's", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response listar();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para cadastro de um novo Pessoa no sistema", summary = "Adicionar novo Pessoa", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
	    }
	  )
	Response cadastrar(@RequestBody(description = "Objeto Pessoa que será adicionado", required = true, content = @Content(schema = @Schema(implementation = PessoaDTO.class))) @Valid PessoaDTO PessoaDTO);
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Recupera Pessoa pelo Id", summary = "Recuperar Pessoas", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response buscarPessoaPorId(@PathParam(value="id") Long id);
}
