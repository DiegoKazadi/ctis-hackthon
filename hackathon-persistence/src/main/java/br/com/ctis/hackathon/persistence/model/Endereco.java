package br.com.ctis.hackathon.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco", schema= "hackaton")
public class Endereco extends EntidadeBase<Long>{

	private static final long serialVersionUID = 3826130311753635697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "logradouro", nullable = false, length = 255)
	private String logradouro;
	

	@Column(name = "bairro", nullable = false, length = 255)
	private String bairro;
	

	@Column(name = "cidade", nullable = false, length = 255)
	private String cidade;
	

	@Column(name = "UF", nullable = false, length = 2)
	private String UF;
	
	
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco")
	private Empresa empresas;
	
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
	 * @return the uF
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * @param uF the uF to set
	 */
	public void setUF(String uF) {
		UF = uF;
	}

	@Override
	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
