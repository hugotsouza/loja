package br.com.vitrine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vitrine.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer>{

}
