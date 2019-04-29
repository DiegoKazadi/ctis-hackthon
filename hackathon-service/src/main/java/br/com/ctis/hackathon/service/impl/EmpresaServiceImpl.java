package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.dto.EmpresaDTO;
import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.EmpresaDAO;
import br.com.ctis.hackathon.persistence.model.Empresa;
import br.com.ctis.hackathon.service.EmpresaService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class EmpresaServiceImpl extends GenericServiceImpl<Long, Empresa> implements EmpresaService {

	private static final long serialVersionUID = -4974991595955674384L;

	@EJB
	private EmpresaDAO EmpresaDAO;

	@Override
	public List<Empresa> listarTodos() {

		try {
			return EmpresaDAO.listarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(EmpresaDTO EmpresaDTO) {

		EmpresaDAO.gravar(mapper(EmpresaDTO));

	}

	@Override
	public Empresa buscarEmpresaPorId(Long id) {

		try {
			return EmpresaDAO.buscarEmpresaPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Empresa com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	/**
	 * Converter EmpresaDTO para entidade Empresa
	 * 
	 * @param EmpresaDTO - DTO que será convertido
	 * 
	 * @return {@link Empresa} - Entidade Empresa
	 */
	private Empresa mapper(EmpresaDTO EmpresaDTO) {

		Empresa Empresa = new Empresa();
		Empresa.setNomeFantasia(EmpresaDTO.getNome());

		return Empresa;

	}

	@Override
	public void atualizar(EmpresaDTO empresaDTO, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO, Long id) {
		// TODO Auto-generated method stub
		
	}

}
