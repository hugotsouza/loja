package br.com.vitrine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import br.com.vitrine.model.Produto;
import br.com.vitrine.repository.ProdutoRepository;
import br.com.vitrine.specification.ProdutoSpecification;

@Service
public class ProdutoService{

	@Autowired
	private ProdutoRepository repository;
	
	/*** Método para buscar todos com produtos com base nas especificações
	 * @param nome - Nome do produto
	 * @param categoriaId - Id da categoria do produto
	 * @param lojaId - Id da marca do produto
	 * @return List<Produto> - Produtos
	 */
	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer marcaId) {
		List<Specification<Produto>> specifications = new ArrayList<>();
		
		if (nome != null) 
			specifications.add(ProdutoSpecification.byNome(nome));		

		if (categoriaId != null) 
			specifications.add(ProdutoSpecification.whereCategoria(categoriaId));

		if (marcaId!= null) 
			specifications.add(ProdutoSpecification.whereMarca(marcaId));
		
		if(!specifications.isEmpty()){
			Specification<Produto> resultado = constroiQuery(specifications);
			
	        return repository.findAll(resultado);
		} else {
			return null;
		}
	}

	/***
	 * Método auxiliar para construir a query final com base nas especificacoes.
	 * @param specifications - Lista com todas as especificacoes da busca.
	 * @return Specification<Produto> - Especificação final da busca.
	 */
	private Specification<Produto> constroiQuery(List<Specification<Produto>> specifications) {
		Specification<Produto> resultado = specifications.get(0);
		
		for (int i = 1; i < specifications.size(); i++) 
		    resultado = Specifications.where(resultado).and(specifications.get(i));
		
		return resultado;
	}

	public void insere(Produto produto) {
			repository.save(produto);
	}

	public Produto getProduto(Integer id) {
		
		return repository.findOne(id);
	}

	public List<Produto> getProdutos() {
		return repository.findAll();
	}

	
}
