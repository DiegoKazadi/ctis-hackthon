package br.com.ctis.hackathon.dto;

import javax.persistence.CascadeType;


import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.sun.mail.imap.protocol.Status;

import br.com.ctis.hackathon.persistence.model.Endereco;
import br.com.ctis.hackathon.persistence.model.Telefone;
import io.swagger.v3.oas.annotations.media.Schema;

public class PessoaDTO extends BaseDTO {

	private static final long serialVersionUID = 4538327150278203065L;

	@NotNull
	@Schema(description= "Código do recurso", required = true)
	private Long codigo;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	private String nome;
	
	@NotNull(message = "SobreNome não pode ser nulo")
	@NotBlank(message = "SobreNome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	private String SobreNome;
	
	@NotNull(message = "CPF não pode ser nulo")
	@NotBlank(message = "CPF não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "hackathon", required = false)
	@org.hibernate.validator.constraints.br.CPF
	private String CPF;
	
	
	@NotNull(message = "e-mail não pode ser nulo")
	@NotBlank(message = "e-mail não pode ser vazio")
	@Length(max = 30, message = "e-mail deve possuir até 30 caracteres")
	@Schema(description= "hackathon", required = false)
	@Email
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Telefone telefone;
	
	private Status status;
	
	/**
	 * @return the status
	 */
	public Status getEstatus() {
		return status;
	}

	/**
	 * @param estatusEnum the estatusEnum to set
	 */
	public void setEstatusEnum(Status status) {
		this.status = status;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	 * @return the cPF
	 */
	public String getCPF() {
		return CPF;
	}

	/**
	 * @param cPF the cPF to set
	 */
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	/**
	 * @return the sobreNome
	 */
	public String getSobreNome() {
		return SobreNome;
	}

	/**
	 * @param sobreNome the sobreNome to set
	 */
	public void setSobreNome(String sobreNome) {
		SobreNome = sobreNome;
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

