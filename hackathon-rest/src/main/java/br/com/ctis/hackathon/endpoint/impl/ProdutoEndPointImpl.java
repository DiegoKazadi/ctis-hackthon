package br.com.ctis.hackathon.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.hackathon.dto.ProdutoDTO;
import br.com.ctis.hackathon.dto.MensagemRetornoDTO;
import br.com.ctis.hackathon.endpoint.ProdutoEndPoint;
import br.com.ctis.hackathon.service.ProdutoService;

public class ProdutoEndPointImpl implements ProdutoEndPoint {

	@EJB
	private ProdutoService ProdutoService;
	
	@Override
	public Response listar() {
		return Response.status(Status.OK).entity(ProdutoService.listarTodos()).build();
	}

	@Override
	public Response cadastrar(ProdutoDTO ProdutoDTO) {
		ProdutoService.cadastrar(ProdutoDTO);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Produto cadastrado com sucesso!")).build();
	}

	@Override
	public Response buscarProdutoPorId(Long id) {
		return Response.status(Status.OK).entity(ProdutoService.buscarProdutoPorId(id)).build();
	}


}
