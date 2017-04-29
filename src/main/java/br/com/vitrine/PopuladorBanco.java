package br.com.vitrine;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.vitrine.model.Categoria;
import br.com.vitrine.model.Marca;
import br.com.vitrine.model.Produto;
import br.com.vitrine.repository.ProdutoRepository;


@Component
public class PopuladorBanco {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	ProdutoRepository repository;
	
	@PostConstruct
	public void init() {
		
		TransactionTemplate template = new TransactionTemplate(transactionManager);
		template.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {			
				
				Marca m1 = new Marca();
				m1.setNome("Philips");
				em.persist(m1);
				
				Marca m2 = new Marca();
				m2.setNome("Braun");
				em.persist(m2);
				
				Marca m3 = new Marca();
				m3.setNome("LG");
				em.persist(m3);
				
				Marca m4 = new Marca();
				m4.setNome("Apple");
				em.persist(m4);
				
				Marca m5 = new Marca();
				m5.setNome("Dell");
				em.persist(m5);
				
				Categoria c1 = new Categoria();
				c1.setNome("Barbeadores");
				em.persist(c1);
				
				Categoria c2 = new Categoria();
				c2.setNome("Smart TV");
				em.persist(c2);
				
				Categoria c3 = new Categoria();
				c3.setNome("Notebook");
				em.persist(c3);
				
				Categoria c4 = new Categoria();
				c4.setNome("Notebooks e 2 em 1");
				em.persist(c4);
				
				Produto p1 = new Produto();
				p1.setNome("S5050/4 AquaTouch");
				p1.setDescricao("Faça um barbear rente sem cortes e arranhões. "
						+ "Nosso sistema de lâminas ComfortCut com perfil arredondado"
						+ " das cabeças desliza suavemente, além de proteger a pele.");
				p1.setPreco(522.39);
				p1.setUrlFoto("http://www.extra-imagens.com.br/BelezaSaude/cuidado"
						+ "smasculinos/BarbeadoresEletricos/10477497/744208435/Barbe"
						+ "ador-Eletrico-Philips-S5050-4-AquaTouch--Preto-Azul-1047749"
						+ "7.jpg");
				p1.setMarca(m1);
				p1.adicionaCategorias(c1);
				em.persist(p1);
				
				Produto p2 = new Produto();
				p2.setNome("Cruzer 5 Face ABC2936");
				p2.setDescricao("Este elegante barbeador, estilizador e aparador 3-e"
						+ "m-1 transforma qualquer pelo facial em barba com estilo, pro"
						+ "porcionando-lhe um barbear e aparar rentes, com contornos defi"
						+ "nidos. O Cruzer 5 rosto possui a tecnologia de ponta e o desem"
						+ "penho de um barbeador a seco da Braun, combinando-a com um apa"
						+ "rador giratorio para estilizar e um acessorio ajustavel para c"
						+ "ortar a barba em ate quatro posicoes de comprimento diferentes.");
				p2.setPreco(187.99);
				p2.setUrlFoto("https://static.wmobjects.com.br/imgres/arquivos/ids/5583809-3"
						+ "44-344/.jpg");
				p2.setMarca(m2);
				p2.adicionaCategorias(c1);
				em.persist(p2);
				
				Produto p3 = new Produto();
				p3.setNome("LED 32” LG 32LH570B");
				p3.setDescricao("A Smart TV 32LH570B, da LG, possui tela LED de 32”, em forma"
						+ "to Widescreen (16:9), com resolução de imagem HD (1366x768 pixels), "
						+ "taxa de atualização de quadros do painel com frequência de 60 Hz e p"
						+ "ainel IPS que tornam os movimentos na tela mais naturais. O espectad"
						+ "or obtém o máximo de qualidade em entretenimento em toda forma de pro"
						+ "gramação, seja assistindo filmes e seriados, jogando videogames de ú"
						+ "ltima geração com conexão HDMI ou até curtindo a programação local.");
				p3.setPreco(1249.9);
				p3.setUrlFoto("http://www.lg.com/br/images/tv/md05605509/gallery/medium04.jpg");
				p3.setMarca(m3);
				p3.adicionaCategorias(c2);
				em.persist(p3);
				
				Produto p4 = new Produto();
				p4.setNome("LED 49” Ultra HD 4K Philips");
				p4.setDescricao("A TV Ultra HD Philips 49PUG6801/78 é poderosa. Ela tem 4 vezes "
						+ "mais resolução de uma TV Full HD convencional, ou seja, são 8 milhões"
						+ " de pixels ao seu favor. E qualquer imagem fica melhor na TV 4k Phili"
						+ "ps, devido à tecnologia de refinamento de pixels, promovendo cenas co"
						+ "m maior nitidez e detalhes impressionantes.");
				p4.setPreco(3299.9);
				p4.setUrlFoto("http://shopfacil.vteximg.com.br/arquivos/ids/5911038-1000-1000/im"
						+ "age-923b7c74d70b87849f66db36f9f69632.jpg");
				p4.setMarca(m1);
				p4.adicionaCategorias(c2);
				em.persist(p4);
				
				Produto p5 = new Produto();
				p5.setNome("MacBook Pro Apple 15.4");
				p5.setDescricao("Tela de 15,4 polegadas (na diagonal) retroiluminada por LED, "
						+ "com tecnologia IPS; resolução nativa de 2880 x 1800 com 220 pixels por "
						+ "polegada e suporte a milhões de cores");
				p5.setPreco(22480.8);
				p5.setUrlFoto("https://pisces.bbystatic.com/image2/BestBuy_US/images/products/853"
						+ "2/8532502_sd.jpg");
				p5.setMarca(m4);
				p5.adicionaCategorias(c3,c4);
				em.persist(p5);
				
				Produto p6 = new Produto();
				p6.setNome("Alienware AW-15R2-A20");
				p6.setDescricao("Projetado com tudo que os hardcore gamers desejam, o Alienware "
						+ "15 inclui processador Intel® Core™ i7 da 6ª geração com overclocking"
						+ " dinâmico para a combinação ideal de tamanho da tela e intensidade máx"
						+ "ima de recursos gráficos. O Alienware 15 conta com a potência das placa"
						+ "s gráficas NVIDIA GeForce GTX 970M para oferecer ação realista em qualq"
						+ "uer lugar.");
				p6.setPreco(9849.0);
				p6.setUrlFoto("https://econovia.s3.amazonaws.com/produto_econovia_fotos/fotos/not"
						+ "ebook/notebook-dell-alienware-15-aw-15r2-a20-i7-16gb-1tb-128gb-ssd-le"
						+ "d-full-hd-15-6-57deece6a0731afcc400000e-original.jpg");
				p6.setMarca(m5);
				p6.adicionaCategorias(c3);
				em.persist(p6);	
				
			}		
		
		});

	}
}
