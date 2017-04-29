package br.com.vitrine.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
@Entity
public class Marca implements Serializable{

	private static final long serialVersionUID = 5358545165682784352L;
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	
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
}
