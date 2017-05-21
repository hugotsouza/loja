package br.com.vitrine;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import br.com.vitrine.model.Categoria;
import br.com.vitrine.model.Marca;
import br.com.vitrine.model.Produto;
import br.com.vitrine.repository.CategoriaRepository;
import br.com.vitrine.repository.MarcaRepository;
import br.com.vitrine.repository.ProdutoRepository;

@SpringBootApplication
public class Configurador {
	
	@Bean
	public List<Marca> marcas(MarcaRepository repository) { 
		return repository.findAll();
	}
	
	@Bean
	public List<Categoria>categorias(CategoriaRepository repository){
		return repository.findAll();
	}
	
	@Bean
	@Scope("request")
	public List<Produto> produtos(ProdutoRepository repository){
		return repository.findAll();
	}
	
	@Bean
	public Statistics statistics(EntityManagerFactory emf){
		SessionFactory factory = emf.unwrap(SessionFactory.class);	
		return factory.getStatistics();
		
	}
	
	public static void main(String[] args) {

		SpringApplication.run(Configurador.class, args);
	}
	
	
}
