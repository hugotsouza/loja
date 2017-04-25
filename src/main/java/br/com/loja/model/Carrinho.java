package br.com.loja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
public class Carrinho implements Serializable{

	private static final long serialVersionUID = -170687215234972303L;
	private long id;
	private List<Produto>produtos;
	
	@SuppressWarnings("unchecked")
	public Carrinho(){
		produtos = new ArrayList();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
