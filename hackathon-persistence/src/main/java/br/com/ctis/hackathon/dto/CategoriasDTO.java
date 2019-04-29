package br.com.ctis.hackathon.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.ctis.hackathon.persistence.model.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriasDTO extends BaseDTO {

	private static final long serialVersionUID = 4538327150278203065L;

	@NotNull
	@Schema(description= "Código do recurso", required = true)
	private Long codigo;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "Nome do recurso", required = false)
	private String nome;

	@NotNull(message = "Departamento não pode ser nulo")
	@NotBlank(message = "Departamento não pode ser vazio")
	@Length(max = 255, message = "Departamento deve possuir até 255 caracteres")
	@Column(name = "hackathon", nullable = false)
	private String departamento;
	
	
	@Column(name = "setor", nullable = false)
	private String setor;
	
	@OneToMany
	private List<Produto> ListaProduto;
	
	
	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the setor
	 */
	public String getSetor() {
		return setor;
	}

	/**
	 * @param setor the setor to set
	 */
	public void setSetor(String setor) {
		this.setor = setor;
	}

	/**
	 * @return the listaProduto
	 */
	public List<Produto> getListaProduto() {
		return ListaProduto;
	}

	/**
	 * @param listaProduto the listaProduto to set
	 */
	public void setListaProduto(List<Produto> listaProduto) {
		ListaProduto = listaProduto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

