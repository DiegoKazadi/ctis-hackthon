package br.com.ctis.hackathon.service;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.dto.ProdutoDTO;
import br.com.ctis.hackathon.persistence.model.Produto;

@Local
public interface ProdutoService extends GenericService<Long, Produto> {
	
	/**
	 * Listar todos os Produtos cadastrados no sistema
	 * 
	 * @return {@link List<Produto>} - Lista com Produtos cadastrados
	 */
	List<Produto> listarTodos();

	/**
	 * Cadastrar um novo Produto no sistema
	 * 
	 * @param ProdutoDTO - Parâmetro de entrada para cadastro do Produto
	 */
	void cadastrar(ProdutoDTO ProdutoDTO);
	
	/**
	 * Recuperar Produto pelo Id
	 * 
	 * @param id - Identificado do Produto na base de dados
	 * 
	 * @return {@link Produto} - Representa um Produto cadastrado no sistema
	 */
	Produto buscarProdutoPorId(Long id);
}
