package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.dto.ProdutoDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.ProdutoDAO;
import br.com.ctis.hackathon.persistence.model.Produto;
import br.com.ctis.hackathon.service.ProdutoService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProdutoServiceImpl extends GenericServiceImpl<Long, Produto> implements ProdutoService {

	private static final long serialVersionUID = -4974991595955674384L;

	@EJB
	private ProdutoDAO ProdutoDAO;

	@Override
	public List<Produto> listarTodos() {

		try {
			return ProdutoDAO.listarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(ProdutoDTO ProdutoDTO) {

		ProdutoDAO.gravar(mapper(ProdutoDTO));

	}

	@Override
	public Produto buscarProdutoPorId(Long id) {

		try {
			return ProdutoDAO.buscarProdutoPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Produto com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	/**
	 * Converter ProdutoDTO para entidade Produto
	 * 
	 * @param ProdutoDTO - DTO que será convertido
	 * 
	 * @return {@link Produto} - Entidade Produto
	 */
	private Produto mapper(ProdutoDTO ProdutoDTO) {

		Produto Produto = new Produto();
		Produto.setCodigo(ProdutoDTO.getCodigo());
		Produto.setNome(ProdutoDTO.getNome());

		return Produto;

	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO, Long id) {
		// TODO Auto-generated method stub
		
	}

}
