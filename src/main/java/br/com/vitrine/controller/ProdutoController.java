package br.com.vitrine.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vitrine.model.Produto;
import br.com.vitrine.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService pService;

	@Transactional
	@PostMapping("cadastraProduto")
	public String salvar(@ModelAttribute("produto")@Valid Produto produto, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("erros encontrados no formulário!");
			return "produto/form";
		}
		System.out.println("metodo salvar controller chamado. produto retornado da view"
				+ " versão " + produto.getVersion());
		pService.insere(produto);

		return "redirect:/";
	}

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("produto", new Produto());
		return "produto/form";
	}

	@GetMapping("/{id}/form")
	public String update(@PathVariable Integer id, Model model) {
		Produto produto = pService.getProduto(id);
		System.out.println("getProduto chamado: produto versão " + produto.getVersion());
		model.addAttribute("produto", produto);
		return "produto/form";
	}

	@GetMapping("/{id}")
	public String detalhe(@PathVariable Integer id, Model model) {
		Produto produto = pService.getProduto(id);
		model.addAttribute("produto", produto);
		return "produto/detalhe";
	}

	@PostMapping(value = "/buscar", name = "buscarProdutos")
	public String buscarPor(Model model, @RequestParam String nome, @RequestParam(required = false) Integer categoriaId,
			@RequestParam(required = false) Integer lojaId) {
		System.out.println("buscando pelo nome: " + nome);
		List<Produto> produtos = pService.getProdutos(nome, categoriaId, lojaId);
		model.addAttribute("produtos", produtos);

		return "home";

	}
}
