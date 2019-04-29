/**
 * 
 */
package br.com.ctis.hackathon.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author ctis
 *
 */
public class EnderecoDTO extends BaseDTO {

	private static final long serialVersionUID = 3826130311753635697L;
	
	@NotNull
	@NotBlank(message = "Logradouro não pode ser vazio")
	@Length(max = 25, message = "Logradouro deve possuir até 25 caracteres")
	@Schema(description= "logradouro não pode ser vazio", required = true)
	private String logradouro;
	
	@NotNull
	@NotBlank(message = "Complemento não pode ser vazio")
	@Length(max = 5, message = "Complemento deve possuir até 5 caracteres")
	@Schema(description= "Complemento não pode ser vazio", required = true)
	private String complemento;
	
	@NotNull
	@NotBlank(message = "Bairro não pode ser vazio")
	@Length(max = 5, message = "Bairro deve possuir até 5 caracteres")
	@Schema(description= "Bairro não pode ser vazio", required = true)
	private String bairro;
	
	@NotNull
	@NotBlank(message = "cidade não pode ser vazio")
	@Length(max = 25, message = "cidade deve possuir até 25 caracteres")
	@Schema(description= "cidade não pode ser vazio", required = true)
	private String cidade;
	
	@NotNull
	@NotBlank(message = "UF não pode ser vazio")
	@Length(max = 5, message = "UF deve possuir até 5 caracteres")
	@Schema(description= "UF não pode ser vazio", required = true)
	private String uf;
	

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * 
	 */
	public EnderecoDTO() {
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
