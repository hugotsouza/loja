package br.com.vitrine.controller;




import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	@Autowired(required=false)
	private Statistics statistics;

	@GetMapping
	public String index(Model model) throws SQLException {
		return "estatisticas/index";
	}
	
	@GetMapping("/limpar")
	public String invalidar() {
		statistics.clear();
		
		return "redirect:/estatisticas"; 
	}
}
