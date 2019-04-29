package br.com.ctis.hackathon.dto;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.sun.mail.imap.protocol.Status;

import br.com.ctis.hackathon.persistence.model.Categorias;
import io.swagger.v3.oas.annotations.media.Schema;

public class ProdutoDTO extends BaseDTO {

	private static final long serialVersionUID = 4538327150278203065L;

	@NotNull
	@Schema(description= "Código do recurso", required = true)
	private Long codigo;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "hackathono", required = false)
	private String nome;
	
	@NotNull(message = "Preco não pode ser nulo")
	@NotBlank(message = "Preco não pode ser vazio")
	@Length(max = 9, message = "preco deve possuir até 9 caracteres")
	@Schema(description= "hackathono", required = false)
	private String preco;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 10, message = "Data de criação deve possuir até 10 caracteres")
	@Schema(description= "hackathono", required = false)
	private String dataCriacao;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "hackathono", required = false)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produtos")
	private List<Categorias> ListaCategorias;

	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ser vazio")
	@Length(max = 255, message = "Status deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	@OneToMany
	private Status status;
	
	/**
	 * @return the preco
	 */
	public String getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(String preco) {
		this.preco = preco;
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

