package br.com.vitrine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vitrine.model.Marca;
import br.com.vitrine.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	public List<Marca> getMarcas(){
		return repository.findAll();
	}
}
