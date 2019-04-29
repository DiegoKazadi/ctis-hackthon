/**
 * 
 */
package br.com.ctis.hackathon.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author ctis
 *
 */
public class TelefoneDTO extends BaseDTO{

	private static final long serialVersionUID = 4538327150278203065L;
	
	@NotNull
	@NotBlank(message = "numero não pode ser vazio")
	@Schema(description= "hackathon", required = true)
	private String numero;

	
	@NotNull
	@NotBlank(message = "Lista de telefone não pode ser vazio")
	@Schema(description= "hackathon", required = true)
	private List<String> telefone;

	/**
	 * @return the telefone
	 */
	public List<String> getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

