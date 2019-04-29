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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Categorias", schema= "hackaton")
public class Categorias extends EntidadeBase<Long>{

	private static final long serialVersionUID = 3826130311753635697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "departamento", nullable = false)
	private String departamento;
	
	
	@Column(name = "setor", nullable = false)
	private String setor;
	
	@OneToMany
	private List<Produto> ListaProduto;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String categoria;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categorias")
	private List<Produto> produtos;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ListaProduto == null) ? 0 : ListaProduto.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
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
		Categorias other = (Categorias) obj;
		if (ListaProduto == null) {
			if (other.ListaProduto != null)
				return false;
		} else if (!ListaProduto.equals(other.ListaProduto))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}
	

	
}
