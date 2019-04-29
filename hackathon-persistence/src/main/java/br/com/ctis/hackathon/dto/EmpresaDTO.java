package br.com.ctis.hackathon.dto;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.ctis.hackathon.enumeration.Status;
import br.com.ctis.hackathon.persistence.model.Endereco;
import br.com.ctis.hackathon.persistence.model.Telefone;
import io.swagger.v3.oas.annotations.media.Schema;

public class EmpresaDTO extends BaseDTO {

	private static final long serialVersionUID = 4538327150278203065L;

	@NotNull
	@Schema(description= "Código do recurso", required = true)
	private Long codigo;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "Nome do recurso", required = false)
	private String nome;
	
	@NotNull(message = "Razao Social não pode ser nulo")
	@NotBlank(message = "Razao Social não pode ser vazio")
	@Length(max = 255, message = "RazaoSocial deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	private String razaoSocial;
	
	@NotNull(message = "CNPJ não pode ser nulo")
	@NotBlank(message = "CNPJ não pode ser vazio")
	@Length(max = 255, message = "CNPJ deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	@CNPJ
	private String cnpj;
	
	@NotNull(message = "E-mail não pode ser nulo")
	@NotBlank(message = "E-mail não pode ser vazio")
	@Length(max = 30, message = "E-maildeve possuir até 30 caracteres")
	@Schema(description= "hackathon", required = false)
	@Email
	private String email;
	
	
	@NotNull(message = "Nome Fantasia não pode ser nulo")
	@NotBlank(message = "Nome Fantasia não pode ser vazio")
	@Length(max = 255, message = "Nome Fantasia deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	private String nomeFantasia;
	
	@NotNull(message = "Telefone não pode ser nulo")
	@NotBlank(message = "Telefone não pode ser vazio")
	@Length(max = 255, message = "Telefone deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	@OneToMany
	private List<Telefone> telefone;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "empresas")
	private List<Endereco> endereco;
	
	
	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ser vazio")
	@Length(max = 255, message = "Status deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	@OneToMany
	private Status status;
	

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * @param nomeFantasia the nomeFantasia to set
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * @return the telefone
	 */
	public List<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the endereco
	 */
	public List<Endereco> getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the statusEnum
	 */
	public Status getStatusEnum() {
		return status;
	}

	/**
	 * @param statusEnum the statusEnum to set
	 */
	public void setStatusEnum(Status status) {
		this.status = status;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}

