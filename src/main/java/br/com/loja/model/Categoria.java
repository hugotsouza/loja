package br.com.loja.model;

import java.io.Serializable;
/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
public class Categoria implements Serializable{

	private static final long serialVersionUID = 6159236938320128278L;
	private long id;
	private String nome;
	
	public Categoria(String nome){
		this.nome = nome;
	}
	public Categoria(){}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
}
