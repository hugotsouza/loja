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
	
	//habilitacao do cacheamento apenas para fins didaticos, nao é recomendado cacheamento de uma query que raramente
	//será executada novamente
	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	List<Produto> findAll(Specification<Produto> spec);
}
