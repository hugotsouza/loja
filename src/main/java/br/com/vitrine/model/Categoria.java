package br.com.vitrine.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/***
 * 
 * @author Hugo Trindade
 * @version 1.0
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 6159236938320128278L;
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	public Categoria(String nome){
		this.nome = nome;
	}
	public Categoria(){}
	
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
