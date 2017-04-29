package br.com.vitrine.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.vitrine.model.Marca;
import br.com.vitrine.model.Produto;
/***
 * 
 * @author Hugo Trindade
 *
 */
public final class ProdutoSpecification {
	
	public static Specification<Produto> byNome(String nome){
		return new Specification<Produto>(){
			
			@Override
			public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> nomePath = root.<String> get("nome");		   				
			    return cb.like(nomePath, String.format("%s%", nome.trim()));
			}
		};
	
	}
		
	public static Specification<Produto> whereCategoria(Integer categoriaId){
		return new Specification<Produto>(){
			
			@Override
			public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<Integer> categoriaPath = root.join("categorias").<Integer> get("id");				
			    return cb.equal(categoriaPath, categoriaId);
			}
		};
	
	}
		
	public static Specification<Produto> whereMarca(Integer marcaId){
		return new Specification<Produto>(){
			
			@Override
			public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<Integer> marcaPath = root.<Marca> get("marca").<Integer> get("id");				
			    return cb.equal(marcaPath, marcaId);
			}
		};
	
	}
}
