package br.com.loja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
public class Produto implements Serializable{

	
	private static final long serialVersionUID = -872830435452287489L;
	private long id;
	private String nome;
	private String urlFoto;
	private String descricao;
	private double preco;
	private List<Categoria> categorias;
	private Marca marca;
	
	public Produto(){
		categorias = new ArrayList();
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
