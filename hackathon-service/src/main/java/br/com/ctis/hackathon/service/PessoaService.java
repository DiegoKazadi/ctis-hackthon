package br.com.ctis.hackathon.service;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.persistence.model.Pessoa;

@Local
public interface PessoaService extends GenericService<Long, Pessoa> {
	
	/**
	 * Listar todos os Pessoas cadastrados no sistema
	 * 
	 * @return {@link List<Pessoa>} - Lista com Pessoas cadastrados
	 */
	List<Pessoa> listarTodos();

	/**
	 * Cadastrar um novo Pessoa no sistema
	 * 
	 * @param PessoaDTO - Parâmetro de entrada para cadastro do Pessoa
	 */
	void cadastrar(PessoaDTO PessoaDTO);
	
	/**
	 * Recuperar Pessoa pelo Id
	 * 
	 * @param id - Identificado do Pessoa na base de dados
	 * 
	 * @return {@link Pessoa} - Representa um Pessoa cadastrado no sistema
	 */
	Pessoa buscarPessoaPorId(Long id);
}
