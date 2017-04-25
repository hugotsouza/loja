package br.com.loja.model;

import java.io.Serializable;

/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
public class Marca implements Serializable{

	private static final long serialVersionUID = 5358545165682784352L;
	private long id;
	private String nome;
	
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
}
