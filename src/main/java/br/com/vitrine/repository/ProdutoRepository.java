package br.com.vitrine.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import br.com.vitrine.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>, JpaSpecificationExecutor<Produto> {
	
	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	List<Produto> findAll(Specification<Produto> spec);
}
