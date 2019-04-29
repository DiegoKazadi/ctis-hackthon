package br.com.ctis.hackathon.persistence.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.mail.imap.protocol.Status;


@Entity
@Table(name = "tb_produto", schema= "hackaton")
public class Produto extends EntidadeBase<Long>{

	private static final long serialVersionUID = 3826130311753635697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codigo", nullable = false, length = 255)
	private Long codigo;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "preco", nullable = false, length = 255)
	private Number preco;
	
	@Column(name = "data Criacao", nullable = false, length = 255)
	private String dataCriacao;
	
				
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produtos")
	private List<Categorias> listaCategorias;
	
	
	private Status status;
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the preco
	 */
	public Number getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Number preco) {
		this.preco = preco;
	}

	/**
	 * @return the dataCriacao
	 */
	public String getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the listaCategorias
	 */
	public List<Categorias> getListaCategorias() {
		return listaCategorias;
	}

	/**
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategorias(List<Categorias> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	@Override
	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
