package br.com.vitrine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Produto implements Serializable{

	
	private static final long serialVersionUID = -872830435452287489L;
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String urlFoto;
	@Column(columnDefinition="TEXT")
	private String descricao;
	private double preco;
	@ManyToMany
	@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private List<Categoria> categorias;
	@ManyToOne
	private Marca marca;
	
	public Produto(){
		this.categorias = new ArrayList<>();
	}
	
	/*** Método para associar categorias ao produto
	 * 	 @author Hugo Trindade
	 *   @param categorias - categorias do produto
	 */
	public void adicionaCategorias(Categoria... categorias){
		for(Categoria categoria : categorias){
			this.categorias.add(categoria);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
