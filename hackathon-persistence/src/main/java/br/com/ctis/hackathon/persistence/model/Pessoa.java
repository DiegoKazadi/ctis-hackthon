package br.com.ctis.hackathon.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa", schema= "hackaton")
public class Pessoa extends EntidadeBase<Long>{

	private static final long serialVersionUID = 3826130311753635697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "Sobre Nome", nullable = false, length = 255)
	private String sobreNome;
	
	@Column(name = "CPF", nullable = false, length = 255)
	private String CPF;
	
	@Column(name = "e-mail", nullable = false, length = 255)
	private String email;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="pessoa")
	private List<Telefone> telefone;

	
	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Endereco endereco;

	
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
	 * @return the sobreNome
	 */
	public String getSobreNome() {
		return sobreNome;
	}

	/**
	 * @param sobreNome the sobreNome to set
	 */
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
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

	@Override
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
