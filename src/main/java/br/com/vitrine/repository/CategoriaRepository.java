package br.com.vitrine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitrine.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
