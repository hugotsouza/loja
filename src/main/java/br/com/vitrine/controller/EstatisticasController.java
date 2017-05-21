package br.com.vitrine.controller;




import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estatisticas")
public class EstatisticasController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private DataSource ds;
	@Autowired(required=false)
	private Statistics statistics;

	@GetMapping
	public String index(Model model) throws SQLException {
		System.out.println("[Tomcat pool] Implementação do pool: " + ds.getClass().getName());
		System.out.println("[Tomcat pool] conexões ativas: " + ds.getActive());
		System.out.println("[Tomcat pool] conexões ociosas: " + ds.getIdle());
		System.out.println("[Tomcat pool] tamanho inicial: " + ds.getInitialSize());
		System.out.println("[Tomcat pool] tamanho maximo de conexões ativas: " + ds.getMaxActive());
		System.out.println("[Tomcat pool] minimo de conexões ociosas" + ds.getMinIdle());
		return "estatisticas/index";
	}
	
	@GetMapping("/limpar")
	public String invalidar() {
		statistics.clear();
		
		return "redirect:/estatisticas"; 
	}
}
