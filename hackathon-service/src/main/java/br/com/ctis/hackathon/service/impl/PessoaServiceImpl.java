package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.converter.Converter;
import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.PessoaDAO;
import br.com.ctis.hackathon.persistence.model.Pessoa;
import br.com.ctis.hackathon.service.PessoaService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaServiceImpl extends GenericServiceImpl<Long, Pessoa> implements PessoaService {

	private static final long serialVersionUID = -4974991595955674384L;

	@EJB
	private PessoaDAO PessoaDAO;

	@Override
	public List<Pessoa> listarTodos() {

		try {
			return PessoaDAO.listarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(PessoaDTO pessoaDTO) {

		PessoaDAO.gravar(Converter.getInstance().converter(pessoaDTO, Pessoa.class));

	}

	@Override
	public Pessoa buscarPessoaPorId(Long id) {

		try {
			return PessoaDAO.buscarPessoaPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Pessoa com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	/**
	 * Converter PessoaDTO para entidade Pessoa
	 * 
	 * @param PessoaDTO - DTO que será convertido
	 * 
	 * @return {@link Pessoa} - Entidade Pessoa
	 */
	private Pessoa mapper(PessoaDTO PessoaDTO) {

		Pessoa Pessoa = new Pessoa();
		Pessoa.setNome(PessoaDTO.getNome());

		return Pessoa;

	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO, Long id) {
		// TODO Auto-generated method stub
		
	}

}
