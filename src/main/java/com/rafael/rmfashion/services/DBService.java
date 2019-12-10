package com.rafael.rmfashion.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaFeminino;
import com.rafael.rmfashion.domain.CategoriaMasculino;
import com.rafael.rmfashion.domain.CategoriaSexShop;
import com.rafael.rmfashion.domain.Cidade;
import com.rafael.rmfashion.domain.Cliente;
import com.rafael.rmfashion.domain.Endereco;
import com.rafael.rmfashion.domain.Estado;
import com.rafael.rmfashion.domain.ItemPedidoFeminino;
import com.rafael.rmfashion.domain.ItemPedidoMasculino;
import com.rafael.rmfashion.domain.ItemPedidoSexShop;
import com.rafael.rmfashion.domain.ItemPedidoVariado;
import com.rafael.rmfashion.domain.Pagamento;
import com.rafael.rmfashion.domain.PagamentoComBoleto;
import com.rafael.rmfashion.domain.PagamentoComCartao;
import com.rafael.rmfashion.domain.Pedido;
import com.rafael.rmfashion.domain.ProdutoFeminino;
import com.rafael.rmfashion.domain.ProdutoMasculino;
import com.rafael.rmfashion.domain.ProdutoSexShop;
import com.rafael.rmfashion.domain.ProdutoVariado;
import com.rafael.rmfashion.domain.Variado;
import com.rafael.rmfashion.domain.enums.EstadoPagamento;
import com.rafael.rmfashion.domain.enums.TipoCliente;
import com.rafael.rmfashion.repositories.CategoriaFemininoRepository;
import com.rafael.rmfashion.repositories.CategoriaMasculinoRepository;
import com.rafael.rmfashion.repositories.CategoriaSexShopRepository;
import com.rafael.rmfashion.repositories.CidadeRepository;
import com.rafael.rmfashion.repositories.ClienteRepository;
import com.rafael.rmfashion.repositories.EnderecoRepository;
import com.rafael.rmfashion.repositories.EstadoRepository;
import com.rafael.rmfashion.repositories.ItemPedidoFemininoRepository;
import com.rafael.rmfashion.repositories.ItemPedidoMasculinoRepository;
import com.rafael.rmfashion.repositories.ItemPedidoSexShopRepository;
import com.rafael.rmfashion.repositories.ItemPedidoVariadoRepository;
import com.rafael.rmfashion.repositories.PagamentoRepository;
import com.rafael.rmfashion.repositories.PedidoRepository;
import com.rafael.rmfashion.repositories.ProdutoFemininoRepository;
import com.rafael.rmfashion.repositories.ProdutoMasculinoRepository;
import com.rafael.rmfashion.repositories.ProdutoSexShopRepository;
import com.rafael.rmfashion.repositories.ProdutoVariadoRepository;
import com.rafael.rmfashion.repositories.VariadoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaFemininoRepository categoriaFemininoRepository;
	
	@Autowired
	private CategoriaMasculinoRepository categoriaMasculinoRepository;
	
	@Autowired
	private VariadoRepository variadoRepository;
	
	@Autowired
	private ProdutoFemininoRepository produtoFemininoRepository;
	
	@Autowired
	private ProdutoMasculinoRepository produtoMasculinoRepository;
	
	@Autowired
	private ProdutoVariadoRepository produtoVariadoRepository;
	
	@Autowired
	private CategoriaSexShopRepository categoriaSexShopRepository;
	
	@Autowired
	private ProdutoSexShopRepository produtoSexShopRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
		
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoFemininoRepository itemPedidoFemininoRepository;
	
	@Autowired
	private ItemPedidoMasculinoRepository itemPedidoMasculinoRepository;
	
	@Autowired
	private ItemPedidoVariadoRepository itemPedidoVariadoRepository;
	
	@Autowired
	private ItemPedidoSexShopRepository itemPedidoSexShopRepository;

	public void instantiateTestDatabase() throws ParseException {
		// Categorias Feminino 
				CategoriaFeminino catfem1 = new CategoriaFeminino(null, "CALÇAS");
				CategoriaFeminino catfem2 = new CategoriaFeminino(null, "BERMUDAS E SHORTS");
				CategoriaFeminino catfem3 = new CategoriaFeminino(null, "CAMISAS");
				CategoriaFeminino catfem4 = new CategoriaFeminino(null, "BLUSAS E CAMISETAS");
				CategoriaFeminino catfem5 = new CategoriaFeminino(null, "MODA PRAIA FEMININO");
				CategoriaFeminino catfem6 = new CategoriaFeminino(null, "MODA ÍNTIMA FEMININO");
				CategoriaFeminino catfem7 = new CategoriaFeminino(null, "VESTIDOS");
				CategoriaFeminino catfem8 = new CategoriaFeminino(null, "SAIAS");
				CategoriaFeminino catfem9 = new CategoriaFeminino(null, "JEANS FEMININO");
				CategoriaFeminino catfem10 = new CategoriaFeminino(null, "ESPORTIVO");
				
				
				categoriaFemininoRepository.saveAll(Arrays.asList(catfem1,catfem2,catfem3,catfem4,
						catfem5,catfem6,catfem7,catfem8,catfem9,catfem10));
				
				//PRODUTO FEMININO CALÇAS
				ProdutoFeminino prodFemCalca1 = new ProdutoFeminino(null, "CALÇA JEANS JOGGER LISA CURVE & PLUS SIZE", "48", "AZUL", 159.90);
				ProdutoFeminino prodFemCalca2 = new ProdutoFeminino(null, "CALÇA JEANS SKINNY COM PUÍDOS CURVE & PLUS SIZE", "46", "AZUL", 139.90);
				ProdutoFeminino prodFemCalca3 = new ProdutoFeminino(null, "CALÇA JEANS SKINNY MARMORIZADA CURVE & PLUS SIZE", "46", "AZUL", 139.90);
				
				//PRODUTO FEMININO BERMUDAS E SHORTS
				ProdutoFeminino prodFemBermShort1 = new ProdutoFeminino(null, "SHORT METALIZADO FIT RUNNER", "P", "CINZA", 79.90);
				ProdutoFeminino prodFemBermShort2 = new ProdutoFeminino(null, "SHORT CLOCHARD ESTAMPADO COM CINTO CURVE & PLUS SIZE", "46", "PRETO", 99.90);
				ProdutoFeminino prodFemBermShort3 = new ProdutoFeminino(null, "SHORT JEANS BOYFRIEND COM FAIXA", "36", "BRANCO", 79.90);
				
				//PRODUTO FEMININO CAMISAS
				ProdutoFeminino prodFemCamisa1 = new ProdutoFeminino(null, "CAMISA COM BOTÕES E NÓ", "M", "BRANCO", 99.90);
				ProdutoFeminino prodFemCamisa2 = new ProdutoFeminino(null, "CAMISA ESTAMPADA MANGA CURTA", "M", "VERDE", 119.90);
				ProdutoFeminino prodFemCamisa3 = new ProdutoFeminino(null, "CAMISA COM DETALHE EM LAISE", "M", "BRANCO", 139.90);
				
				//PRODUTO FEMININO BLUSAS E CAMISETAS
				ProdutoFeminino prodFemBlusaCamiseta1 = new ProdutoFeminino(null, "CAMISETA ESPORTIVA MANGA CURTA ESTAMPA IMPOSSIBLE", "M", "ROSA", 49.90);
				ProdutoFeminino prodFemBlusaCamiseta2 = new ProdutoFeminino(null, "REGATA ESPORTIVA NADADOR EM CREPE", "M", "LARANJA", 29.90);
				ProdutoFeminino prodFemBlusaCamiseta3 = new ProdutoFeminino(null, "REGATA ESPORTIVA NADADOR EM CREPE", "M", "PRETO", 29.90);
				
				//PRODUTO FEMININO MODA PRAIA FEMININO
				ProdutoFeminino prodFemModaPraia1 = new ProdutoFeminino(null, "BIQUÍNI TOP CROPPED ESTAMPA LISTRADA NEON", "M", "preto", 39.90);
				ProdutoFeminino prodFemModaPraia2 = new ProdutoFeminino(null, "BIQUÍNI CALCINHA HOT PANTS ESTAMPE LISTRADA NEON", "M", "PRETO", 39.90);
				ProdutoFeminino prodFemModaPraia3 = new ProdutoFeminino(null, "BIQUÍNI CALCINHA TEXTURIZADO NEON", "M", "AMARELO", 59.90);
				
				//PRODUTO FEMININO MODA ÍNTIMA FEMININO
				ProdutoFeminino prodFemModaIntima1 = new ProdutoFeminino(null, "SUTIÃ TRIFIL DAILY", "M", "BRANCO", 59.90);
				ProdutoFeminino prodFemModaIntima2 = new ProdutoFeminino(null, "SUTIÃ TRIFIL DAILY", "P", "CINZA", 59.90);
				ProdutoFeminino prodFemModaIntima3 = new ProdutoFeminino(null, "SUTIÃ TRIFIL DAILY", "M", "PRETO", 59.90);
				
				//PRODUTO FEMININO VESTIDOS
				ProdutoFeminino prodFemVestido1 = new ProdutoFeminino(null, "VESTIDO ESTAMPADO COM BORBOLETAS", "M", "AMARELO", 159.90);
				ProdutoFeminino prodFemVestido2 = new ProdutoFeminino(null, "VESTIDO MIDI COM BOTÕES EM LINHO", "M", "BRANCO", 199.90);
				ProdutoFeminino prodFemVestido3 = new ProdutoFeminino(null, "VESTIDO COMBINAÇÃO COM DETALHE EM RENDA", "M", "OFF-WHITE", 49.90);
				
				//PRODUTO FEMININO SAIAS
				ProdutoFeminino prodFemSaia1 = new ProdutoFeminino(null, "SAIA MIDI LISA COM CINTO CURVE & PLUS SIZE", "G", "BEGE", 159.90);
				ProdutoFeminino prodFemSaia2 = new ProdutoFeminino(null, "SAIA EM LINHO COM BOTÕES CURVE & PLUS SIZE", "G", "AZUL", 119.90);
				ProdutoFeminino prodFemSaia3 = new ProdutoFeminino(null, "SAIA EM VELUDO COM ZÍPER", "M", "VERMELHO", 99.90);
				
				//PRODUTO FEMININO JEANS FEMININO
				ProdutoFeminino prodFemJens1 = new ProdutoFeminino(null, "JAQUETA JEANS CONFORT CURVE & PLUS SIZE", "G", "AZUL", 179.90);
				ProdutoFeminino prodFemJens2 = new ProdutoFeminino(null, "CALÇA JEANS JOGGER LISA CURVE & PLUS SIZE", "48", "AZUL", 159.90);
				ProdutoFeminino prodFemJens3 = new ProdutoFeminino(null, "SHORT JEANS BOYFRIEND COM FAIXA", "38", "BRANCO", 79.90);
				
				//PRODUTO FEMININO ESPORTIVO
				ProdutoFeminino prodFemEsportivo1 = new ProdutoFeminino(null, "TOP ESPORTIVO COM BOJO E SEM COSTURA LISO", "M", "ROSA", 39.90);
				ProdutoFeminino prodFemEsportivo2 = new ProdutoFeminino(null, "CAMISETA MANGA CURTA ESPORTIVA COM AMARRAÇÃO", "M", "ROXO", 59.90);
				ProdutoFeminino prodFemEsportivo3 = new ProdutoFeminino(null, "BERMUDA ESPORTIVA BÁSICA", "M", "PRETO", 39.90);
				
				//-------------------------------------------------------------------------------------------------------
				
				catfem1.getProdutosFeminino().addAll(Arrays.asList(prodFemCalca1,prodFemCalca2,prodFemCalca3));
				catfem2.getProdutosFeminino().addAll(Arrays.asList(prodFemBermShort1,prodFemBermShort2,prodFemBermShort3));
				catfem3.getProdutosFeminino().addAll(Arrays.asList(prodFemCamisa1,prodFemCamisa2,prodFemCamisa3));
				catfem4.getProdutosFeminino().addAll(Arrays.asList(prodFemBlusaCamiseta1,prodFemBlusaCamiseta2,prodFemBlusaCamiseta3));
				catfem5.getProdutosFeminino().addAll(Arrays.asList(prodFemModaPraia1,prodFemModaPraia2,prodFemModaPraia3));
				catfem6.getProdutosFeminino().addAll(Arrays.asList(prodFemModaIntima1,prodFemModaIntima2,prodFemModaIntima3));
				catfem7.getProdutosFeminino().addAll(Arrays.asList(prodFemVestido1,prodFemVestido2,prodFemVestido3));
				catfem8.getProdutosFeminino().addAll(Arrays.asList(prodFemSaia1,prodFemSaia2,prodFemSaia3));
				catfem9.getProdutosFeminino().addAll(Arrays.asList(prodFemJens1,prodFemJens2,prodFemJens3));
				catfem10.getProdutosFeminino().addAll(Arrays.asList(prodFemEsportivo1,prodFemEsportivo2,prodFemEsportivo3));
				//-----------------------------------------------------------------------------------------------------
				prodFemCalca1.getCategoriasFeminino().addAll(Arrays.asList(catfem1));
				prodFemCalca2.getCategoriasFeminino().addAll(Arrays.asList(catfem1));
				prodFemCalca3.getCategoriasFeminino().addAll(Arrays.asList(catfem1));
				
				prodFemBermShort1.getCategoriasFeminino().addAll(Arrays.asList(catfem2));
				prodFemBermShort2.getCategoriasFeminino().addAll(Arrays.asList(catfem2));
				prodFemBermShort3.getCategoriasFeminino().addAll(Arrays.asList(catfem2));
				
				prodFemCamisa1.getCategoriasFeminino().addAll(Arrays.asList(catfem3));
				prodFemCamisa2.getCategoriasFeminino().addAll(Arrays.asList(catfem3));
				prodFemCamisa3.getCategoriasFeminino().addAll(Arrays.asList(catfem3));
				
				prodFemBlusaCamiseta1.getCategoriasFeminino().addAll(Arrays.asList(catfem4));
				prodFemBlusaCamiseta2.getCategoriasFeminino().addAll(Arrays.asList(catfem4));
				prodFemBlusaCamiseta3.getCategoriasFeminino().addAll(Arrays.asList(catfem4));
				
				prodFemModaPraia1.getCategoriasFeminino().addAll(Arrays.asList(catfem5));
				prodFemModaPraia2.getCategoriasFeminino().addAll(Arrays.asList(catfem5));
				prodFemModaPraia3.getCategoriasFeminino().addAll(Arrays.asList(catfem5));
				
				prodFemModaIntima1.getCategoriasFeminino().addAll(Arrays.asList(catfem6));
				prodFemModaIntima2.getCategoriasFeminino().addAll(Arrays.asList(catfem6));
				prodFemModaIntima3.getCategoriasFeminino().addAll(Arrays.asList(catfem6));
				
				prodFemVestido1.getCategoriasFeminino().addAll(Arrays.asList(catfem7));
				prodFemVestido2.getCategoriasFeminino().addAll(Arrays.asList(catfem7));
				prodFemVestido3.getCategoriasFeminino().addAll(Arrays.asList(catfem7));
				
				prodFemSaia1.getCategoriasFeminino().addAll(Arrays.asList(catfem8));
				prodFemSaia2.getCategoriasFeminino().addAll(Arrays.asList(catfem8));
				prodFemSaia3.getCategoriasFeminino().addAll(Arrays.asList(catfem8));
				
				prodFemJens1.getCategoriasFeminino().addAll(Arrays.asList(catfem9));
				prodFemJens2.getCategoriasFeminino().addAll(Arrays.asList(catfem9));
				prodFemJens3.getCategoriasFeminino().addAll(Arrays.asList(catfem9));
				
				prodFemEsportivo1.getCategoriasFeminino().addAll(Arrays.asList(catfem10));
				prodFemEsportivo2.getCategoriasFeminino().addAll(Arrays.asList(catfem10));
				prodFemEsportivo3.getCategoriasFeminino().addAll(Arrays.asList(catfem10));
				
				produtoFemininoRepository.saveAll(Arrays.asList(prodFemCalca1,prodFemCalca2,prodFemCalca3,
						prodFemBermShort1,prodFemBermShort2,prodFemBermShort3,prodFemCamisa1,prodFemCamisa2,prodFemCamisa3,
						prodFemBlusaCamiseta1,prodFemBlusaCamiseta2,prodFemBlusaCamiseta3,prodFemModaPraia1,prodFemModaPraia2,prodFemModaPraia3,
						prodFemModaIntima1,prodFemModaIntima2,prodFemModaIntima3,prodFemVestido1,prodFemVestido2,prodFemVestido3,
						prodFemSaia1,prodFemSaia2,prodFemSaia3,prodFemJens1,prodFemJens2,prodFemJens3,prodFemEsportivo1,prodFemEsportivo2,prodFemEsportivo3));
				
				//------------------------------------------------------------------------------------------------
				
				//Categoria Masculino
				CategoriaMasculino catmasc1 = new CategoriaMasculino(null, "BERMUDAS E SHORTS");
				CategoriaMasculino catmasc2 = new CategoriaMasculino(null, "CALÇAS");
				CategoriaMasculino catmasc3 = new CategoriaMasculino(null, "CAMISAS");
				CategoriaMasculino catmasc4 = new CategoriaMasculino(null, "CAMISETAS");
				CategoriaMasculino catmasc5 = new CategoriaMasculino(null, "MODA ÍNTIMA MASCULINA");
				CategoriaMasculino catmasc6 = new CategoriaMasculino(null, "JEANS MASCULINO");
				CategoriaMasculino catmasc7 = new CategoriaMasculino(null, "POLOS");
				CategoriaMasculino catmasc8 = new CategoriaMasculino(null, "REGATAS");
				CategoriaMasculino catmasc9 = new CategoriaMasculino(null, "ESPORTIVO");
				CategoriaMasculino catmasc10 = new CategoriaMasculino(null, "MODA PRAIA MASCULINO");
				
				
				categoriaMasculinoRepository.saveAll(Arrays.asList(catmasc1,catmasc2,catmasc3,catmasc4,
						catmasc5,catmasc6,catmasc7,catmasc8,catmasc9,catmasc10));
				
				//PRODUTO MASCULINO BERMUDAS E SHORTS
				ProdutoMasculino prodMascBermudaShort1 = new ProdutoMasculino(null, "BERMUDA ESTAMPA FLORAL COM AMARRAÇÃO", "M", "ROXO", 69.90);
				ProdutoMasculino prodMascBermudaShort2 = new ProdutoMasculino(null, "BERMUDA ESTAMPA FLORAL COM AMARRAÇÃO", "M", "AZUL", 69.90);
				ProdutoMasculino prodMascBermudaShort3 = new ProdutoMasculino(null, "BERMUDA LISTRADA COM AMARRAÇÃO", "M", "BRANCO", 79.90);
				
				//PRODUTO MASCULINO CALÇAS
				ProdutoMasculino prodMascCalca1 = new ProdutoMasculino(null, "CALÇA CAPRI ESPORTIVA", "M", "CINZA", 89.90);
				ProdutoMasculino prodMascCalca2 = new ProdutoMasculino(null, "CALÇA JEANS SLIM", "M", "AZUL", 99.90);
				ProdutoMasculino prodMascCalca3 = new ProdutoMasculino(null, "CALÇA JEANS", "M", "AZUL", 119.90);
				
				//PRODUTO MASCULINO CAMISAS
				ProdutoMasculino prodMascCamisa1 = new ProdutoMasculino(null, "CAMISA MANGA CURTA ESTAMPA FLORAL COM FRUTAS", "M", "BRANCO", 79.90);
				ProdutoMasculino prodMascCamisa2 = new ProdutoMasculino(null, "CAMISA ESTAMPADA EM TRICOLINE", "M", "PRETO", 79.90);
				
				//PRODUTO MASCULINO CAMISETAS
				ProdutoMasculino prodMascCamiseta1 = new ProdutoMasculino(null, "CAMISETA COM ESTAMPA", "M", "PRETO", 39.90);
				ProdutoMasculino prodMascCamiseta2 = new ProdutoMasculino(null, "CAMISETA ESPORTIVA", "M", "ROSA", 39.90);
				
				//PRODUTO MASCULINO MODA ÍNTIMA MASCULINA
				ProdutoMasculino prodMascModaIntima1 = new ProdutoMasculino(null, "CUECA BOXER LISTRAS VERDES E BRANCAS", "M", "PRETO", 25.90);
				ProdutoMasculino prodMascModaIntima2 = new ProdutoMasculino(null, "CUECA BOXER POLIAMIDA SEM COSTURA DUOMO", "M", "VERMELHO", 29.90);
				
				//PRODUTO MASCULONO JEANS MASCULINO
				ProdutoMasculino prodMascJeans1 = new ProdutoMasculino(null, "BERMUDA JEANS SUPER DESTROYED", "M", "BRANCO", 99.90);
				ProdutoMasculino prodMascJeans2 = new ProdutoMasculino(null, "CALÇA JEANS", "40", "AZUL", 119.90);
				
				//PRODUTO MASCULINO POLOS
				ProdutoMasculino prodMascPolo1 = new ProdutoMasculino(null, "CAMISA POLO COM LISTRAS NAS MANGAS", "M", "VERMELHO", 99.90);
				ProdutoMasculino prodMascPolo2 = new ProdutoMasculino(null, "CAMISA POLO COM LISTRAS NAS MANGAS", "M", "BRANCO", 99.90);
				
				//PRODUTO MASCULINO REGATAS
				ProdutoMasculino prodMascRegata1 = new ProdutoMasculino(null, "REGATA COM RECORTE LISTRADA", "M", "MULTICORES", 39.90);
				ProdutoMasculino prodMascRegata2 = new ProdutoMasculino(null, "REGATA ESTAMPA URSO DA CALIFORNIA CÍRCULO SOLARIS", "M", "BRANCO", 29.90);
				
				//PRODUTO MASCULINO ESPORTIVO
				ProdutoMasculino prodMascEsport1 = new ProdutoMasculino(null, "CAMISETA ESPORTIVA", "P", "VERMELHO", 39.90);
				ProdutoMasculino prodMascEsport2 = new ProdutoMasculino(null, "CAMISETA ESPORTIVA", "M", "AZUL", 39.90);
				
				//PRODUTO MASCULINO MODA PRAIA MASCULINO
				ProdutoMasculino prodMascPraia1 = new ProdutoMasculino(null, "SUNGA ARMY LISA", "M", "VERDE", 59.00);
				ProdutoMasculino prodMascPraia2 = new ProdutoMasculino(null, "SUNGA ARMY CREPUSCULO", "M", "AZUL", 39.90);
				
				//--------------------------------------------------------------------------------------------------
				
				catmasc1.getProdutosMasculino().addAll(Arrays.asList(prodMascBermudaShort1,prodMascBermudaShort2,prodMascBermudaShort3));
				catmasc2.getProdutosMasculino().addAll(Arrays.asList(prodMascCalca1,prodMascCalca2,prodMascCalca3));
				catmasc3.getProdutosMasculino().addAll(Arrays.asList(prodMascCamisa1,prodMascCamisa2));
				catmasc4.getProdutosMasculino().addAll(Arrays.asList(prodMascCamiseta1,prodMascCamiseta2));
				catmasc5.getProdutosMasculino().addAll(Arrays.asList(prodMascModaIntima1,prodMascModaIntima2));
				catmasc6.getProdutosMasculino().addAll(Arrays.asList(prodMascJeans1,prodMascJeans2));
				catmasc7.getProdutosMasculino().addAll(Arrays.asList(prodMascPolo1,prodMascPolo2));
				catmasc8.getProdutosMasculino().addAll(Arrays.asList(prodMascRegata1,prodMascRegata2));
				catmasc9.getProdutosMasculino().addAll(Arrays.asList(prodMascEsport1,prodMascEsport2));
				catmasc10.getProdutosMasculino().addAll(Arrays.asList(prodMascPraia1,prodMascPraia2));
				
				//----------------------------------------------------------------------------------------
				prodMascBermudaShort1.getCategoriasMasculino().addAll(Arrays.asList(catmasc1));
				prodMascBermudaShort2.getCategoriasMasculino().addAll(Arrays.asList(catmasc1));
				prodMascBermudaShort3.getCategoriasMasculino().addAll(Arrays.asList(catmasc1));
				
				prodMascCalca1.getCategoriasMasculino().addAll(Arrays.asList(catmasc2));
				prodMascCalca2.getCategoriasMasculino().addAll(Arrays.asList(catmasc2));
				prodMascCalca3.getCategoriasMasculino().addAll(Arrays.asList(catmasc2));
				
				prodMascCamisa1.getCategoriasMasculino().addAll(Arrays.asList(catmasc3));
				prodMascCamisa2.getCategoriasMasculino().addAll(Arrays.asList(catmasc3));
				
				prodMascCamiseta1.getCategoriasMasculino().addAll(Arrays.asList(catmasc4));
				prodMascCamiseta2.getCategoriasMasculino().addAll(Arrays.asList(catmasc4));
				
				prodMascModaIntima1.getCategoriasMasculino().addAll(Arrays.asList(catmasc5));
				prodMascModaIntima2.getCategoriasMasculino().addAll(Arrays.asList(catmasc5));
				
				prodMascJeans1.getCategoriasMasculino().addAll(Arrays.asList(catmasc6));
				prodMascJeans2.getCategoriasMasculino().addAll(Arrays.asList(catmasc6));
				
				prodMascPolo1.getCategoriasMasculino().addAll(Arrays.asList(catmasc7));
				prodMascPolo2.getCategoriasMasculino().addAll(Arrays.asList(catmasc7));
				
				prodMascRegata1.getCategoriasMasculino().addAll(Arrays.asList(catmasc8));
				prodMascRegata2.getCategoriasMasculino().addAll(Arrays.asList(catmasc8));
				
				prodMascEsport1.getCategoriasMasculino().addAll(Arrays.asList(catmasc9));
				prodMascEsport2.getCategoriasMasculino().addAll(Arrays.asList(catmasc9));
				
				prodMascPraia1.getCategoriasMasculino().addAll(Arrays.asList(catmasc10));
				prodMascPraia2.getCategoriasMasculino().addAll(Arrays.asList(catmasc10));
				
				produtoMasculinoRepository.saveAll(Arrays.asList(prodMascBermudaShort1,prodMascBermudaShort2,prodMascBermudaShort3,
						prodMascCalca1,prodMascCalca2,prodMascCalca3,prodMascCamisa1,prodMascCamisa2,prodMascCamiseta1,prodMascCamiseta2,
						prodMascModaIntima1,prodMascModaIntima2,prodMascJeans1,prodMascJeans2,prodMascPolo1,prodMascPolo2,
						prodMascRegata1,prodMascRegata2,prodMascEsport1,prodMascEsport2,prodMascPraia1,prodMascPraia2));
				
				//---------------------------------------------------------------------------------------------------
				//VARIADOS		
				Variado catVariado1 = new Variado(null, "ACESSÓRIOS MASCULINO");
				Variado catVariado2 = new Variado(null, "ACESSÓRIOS FEMININO");
				Variado catVariado3 = new Variado(null, "PAPELARIA");
				Variado catVariado4 = new Variado(null, "VARIADOS");
				
				variadoRepository.saveAll(Arrays.asList(catVariado1,catVariado2,catVariado3,catVariado4));		
				
				//ACESSÓRIOS MASCULINOS
				ProdutoVariado acesMasc1 = new ProdutoVariado(null, "PULSEIRA MASCULINA EM METAL", 39.90);
				ProdutoVariado acesMasc2 = new ProdutoVariado(null, "BONÉ MASCULINO COM PATCH FRONTAL", 49.90);
				
				//ACESSÓRIOS FEMININO
				ProdutoVariado acesFemini1 = new ProdutoVariado(null, "CHAPÉU BUKET DE PALHA", 49.90);
				
				//PAPELARIA
				ProdutoVariado papelaria1 = new ProdutoVariado(null, "PAPEL DE PRESENTE", 9.90);
				
				//PRODUTOS VARIADOS
				ProdutoVariado variados1 = new ProdutoVariado(null, "COPO HOLOGRÁFICO COM CANUDO", 39.90);		
				
				
				catVariado1.getProdutosVariado().addAll(Arrays.asList(acesMasc1,acesMasc2));
				catVariado2.getProdutosVariado().addAll(Arrays.asList(acesFemini1));
				catVariado3.getProdutosVariado().addAll(Arrays.asList(papelaria1));
				catVariado4.getProdutosVariado().addAll(Arrays.asList(variados1));
				
				acesMasc1.getVariados().addAll(Arrays.asList(catVariado1));
				acesMasc2.getVariados().addAll(Arrays.asList(catVariado1));
				acesFemini1.getVariados().addAll(Arrays.asList(catVariado2));
				papelaria1.getVariados().addAll(Arrays.asList(catVariado3));
				variados1.getVariados().addAll(Arrays.asList(catVariado4));
				
				produtoVariadoRepository.saveAll(Arrays.asList(acesMasc1,acesMasc2,acesFemini1,papelaria1,variados1));
				//----------------------------------------------------------------------------------------------------
				//-------CATEGORIA SEX SHOP----------------
				CategoriaSexShop catSex1 = new CategoriaSexShop(null, "COMÉSTICOS");
				CategoriaSexShop catSex2 = new CategoriaSexShop(null, "ACESSÓRIOS");
				CategoriaSexShop catSex3 = new CategoriaSexShop(null, "COMESTÍVEIS");
				CategoriaSexShop catSex4 = new CategoriaSexShop(null, "ANÉIS");
				
				categoriaSexShopRepository.saveAll(Arrays.asList(catSex1,catSex2,catSex3,catSex4));
				
				//----------PRODUTOS SEX SHOP------------------------		
				//-----COMÉSTICOS-----
				ProdutoSexShop sexComestico1 = new ProdutoSexShop(null, "Gel Corporal Beijavel Sabor Morango HOT", 6.00);
				ProdutoSexShop sexComestico2 = new ProdutoSexShop(null, "Gel Corporal Sabor Menta", 5.00);
				ProdutoSexShop sexComestico3 = new ProdutoSexShop(null, "Gel Corporal Sabor Chiclete", 5.00);
				ProdutoSexShop sexComestico4 = new ProdutoSexShop(null, "Gel Corporal Sabor Amarula", 5.00);
				ProdutoSexShop sexComestico5 = new ProdutoSexShop(null, "Gel Corporal Sabor Caipirinha", 5.00);
				ProdutoSexShop sexComestico6 = new ProdutoSexShop(null, "Lubrificante Corporal", 7.50);
				ProdutoSexShop sexComestico7 = new ProdutoSexShop(null, "Sensitive Gel Corporal", 10.00);
				ProdutoSexShop sexComestico8 = new ProdutoSexShop(null,
						"Desodorante Corporal Fragrância Sensual Morango Com Champagne", 12.00);
				ProdutoSexShop sexComestico9 = new ProdutoSexShop(null, "Virgine Gel Adistringente", 10.00);
				ProdutoSexShop sexComestico10 = new ProdutoSexShop(null, "Aromatizante Bucal Morango Com Canela", 8.00);
				ProdutoSexShop sexComestico11 = new ProdutoSexShop(null, "Beijo Hot Brilho Labial Sabor Morango", 15.00);
				ProdutoSexShop sexComestico12 = new ProdutoSexShop(null, "Soft Love Mamba Negra", 7.50);
				ProdutoSexShop sexComestico13 = new ProdutoSexShop(null, "Gel para Massagem Corporal Chinesinha", 7.50);
				ProdutoSexShop sexComestico14 = new ProdutoSexShop(null, "Diaba Gel Corporal Feminino", 7.50);
				ProdutoSexShop sexComestico15 = new ProdutoSexShop(null, "Bolinha do Prazer Óleo Lubrificante", 2.50);
				ProdutoSexShop sexComestico16 = new ProdutoSexShop(null, "Retardante Gel Corporal Masculino", 10.00);
				ProdutoSexShop sexComestico17 = new ProdutoSexShop(null, "Hot & Ice Gel Para Massagem", 10.00);
				ProdutoSexShop sexComestico18 = new ProdutoSexShop(null, "Loka Sensacão Po Da Bruxinha", 5.00);
				ProdutoSexShop sexComestico19 = new ProdutoSexShop(null, "Bala Dio Loko Sabor Cereja", 2.00);
				
				//------ACESSÓRIOS------
				ProdutoSexShop sexAcess1 = new ProdutoSexShop(null, "Raspadinha Do Prazer", 1.00);
				ProdutoSexShop sexAcess2 = new ProdutoSexShop(null, "Rapadinha Kama Sutra", 1.00);
				ProdutoSexShop sexAcess3 = new ProdutoSexShop(null, "Rapadinha Strip Tease", 1.00);		
				ProdutoSexShop sexAcess4 = new ProdutoSexShop(null, "Expansor ", 5.00);
				ProdutoSexShop sexAcess5 = new ProdutoSexShop(null, "Bolinha Do Prazer", 5.00);
				ProdutoSexShop sexAcess6 = new ProdutoSexShop(null, "Jogo do Prazer", 6.00);
				
				//------COMESTÍVEIS-------		
				ProdutoSexShop sexComest1 = new ProdutoSexShop(null, "SexPaper zero açúcar", 3.50);
				
				//---ANÉIS----
				ProdutoSexShop sexAneis1 = new ProdutoSexShop(null, "Anel Peniano", 4.00);
				ProdutoSexShop sexAneis2 = new ProdutoSexShop(null, "Anel Peniano Com Vidro", 15.00);		
				
				catSex1.getSexShop().addAll(Arrays.asList(sexComestico1,sexComestico2,sexComestico3,sexComestico4,sexComestico5,sexComestico6,sexComestico7,
						sexComestico8,sexComestico9,sexComestico10,sexComestico11,sexComestico12,sexComestico13,sexComestico14,sexComestico15,sexComestico16,
						sexComestico17,sexComestico18,sexComestico19));
				catSex2.getSexShop().addAll(Arrays.asList(sexAcess1,sexAcess2,sexAcess3,sexAcess4,sexAcess5,sexAcess6));
				catSex3.getSexShop().addAll(Arrays.asList(sexComest1));
				catSex4.getSexShop().addAll(Arrays.asList(sexAneis1,sexAneis2));
				
				sexComestico1.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico2.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico3.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico4.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico5.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico6.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico7.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico8.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico9.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico10.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico11.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico12.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico13.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico14.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico15.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico16.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico17.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico18.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				sexComestico19.getCategoriaSexShop().addAll(Arrays.asList(catSex1));
				
				sexAcess1.getCategoriaSexShop().addAll(Arrays.asList(catSex2));
				sexAcess2.getCategoriaSexShop().addAll(Arrays.asList(catSex2));
				sexAcess3.getCategoriaSexShop().addAll(Arrays.asList(catSex2));
				sexAcess4.getCategoriaSexShop().addAll(Arrays.asList(catSex2));
				sexAcess5.getCategoriaSexShop().addAll(Arrays.asList(catSex2));
				sexAcess6.getCategoriaSexShop().addAll(Arrays.asList(catSex2));
						
				sexComest1.getCategoriaSexShop().addAll(Arrays.asList(catSex3));
				
				sexAneis1.getCategoriaSexShop().addAll(Arrays.asList(catSex4));
				sexAneis2.getCategoriaSexShop().addAll(Arrays.asList(catSex4));
				
				produtoSexShopRepository.saveAll(Arrays.asList(sexComestico1,sexComestico2,sexComestico3,sexComestico4,sexComestico5,sexComestico6,sexComestico7,
						sexComestico8,sexComestico9,sexComestico10,sexComestico11,sexComestico12,sexComestico13,sexComestico14,sexComestico15,sexComestico16,
						sexComestico17,sexComestico18,sexComestico19,sexAcess1,sexAcess2,sexAcess3,sexAcess4,sexAcess5,sexAcess6,sexComest1,
						sexAneis1,sexAneis2));
				
				//------------------------------------------------------------------------------------------------
				//------ESTADO-------------------------------
				Estado estado1 = new Estado(null, "Ceará");
				Estado estado2 = new Estado(null, "Maranhão");
				Estado estado3 = new Estado(null, "Rio Grande do Norte");
				Estado estado4 = new Estado(null, "São Paulo");
				
				//------Cidades---------------------------------
				//Cidades do Ceará
				Cidade cidade1 = new Cidade(null, "Fortaleza", estado1);
				Cidade cidade2 = new Cidade(null, "Sobral", estado1);
				Cidade cidade3 = new Cidade(null, "Maracanaú", estado1);
				Cidade cidade4 = new Cidade(null, "Horizonte", estado1);
				
				//cidades do Maranhão
				Cidade cidade5 = new Cidade(null, "São Luís", estado2);
				
				//Cidades do Rio Grande do Norte
				Cidade cidade6 = new Cidade(null, "Natal", estado3);
				
				//Cidades de São Paulo
				Cidade cidade7 = new Cidade(null, "São Paulo", estado4);
				
				estado1.getCidades().addAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4));
				estado2.getCidades().addAll(Arrays.asList(cidade5));
				estado3.getCidades().addAll(Arrays.asList(cidade6));
				estado4.getCidades().addAll(Arrays.asList(cidade7));
				
				estadoRepository.saveAll(Arrays.asList(estado1,estado2,estado3,estado4));
				cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4,cidade5,cidade6,cidade7));
				
				//--------------------------------------------------------------------------------------------------
				//-----CRIANDO OS CLIENTES--------
				
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				
				
				Cliente cliente1 = new Cliente(null, "Rafael Souza", "rafael-game1@hotmail.com", "41162983019", "205726604", data.parse("02/02/2000"), TipoCliente.PESSOAFISICA);
				cliente1.getTelefones().addAll(Arrays.asList("3250-6020", "3245-7026"));
				
				Cliente cliente2 = new Cliente(null, "Rafael Java", "rafael-game2@hotmail.com", "05031676060", "112201155", null, TipoCliente.PESSOAFISICA);
				cliente2.getTelefones().addAll(Arrays.asList("4250-6070", "3129-2010"));
				
				Cliente cliente3 = new Cliente(null, "Luiz Felipe", "rafael-game22@hotmail.com", "57669255000169", "478956939", null, TipoCliente.PESSOAJURIDICA);
				cliente3.getTelefones().addAll(Arrays.asList("8560-4075"));
				
				Cliente cliente4 = new Cliente(null, "Alex", "rafael-game14@hotmail.com", "58582087039", "278409908", null, TipoCliente.PESSOAFISICA);
				cliente4.getTelefones().addAll(Arrays.asList("3159-7023"));
				
				Cliente cliente5 = new Cliente(null, "Gabriela", "rafael-game12@hotmail.com", "99467488000", "133990643", null, TipoCliente.PESSOAFISICA);
				cliente5.getTelefones().addAll(Arrays.asList("98527-3010"));
				
				Cliente cliente6 = new Cliente(null, "Maria Silva", "rafael-game13@hotmail.com", "99914768067", "467160144", null, TipoCliente.PESSOAFISICA);
				cliente6.getTelefones().addAll(Arrays.asList("98510-9090"));
						
				Cliente cliente7 = new Cliente(null, "Paulo Felipe", "rafael-game5@hotmail.com", "56932563000172", "205726604", null, TipoCliente.PESSOAJURIDICA);
				cliente7.getTelefones().addAll(Arrays.asList("3260-9080", "98570-3010"));
				
				//-----CRIANDO OS ENDEREÇOS------
				
				Endereco endereco1 = new Endereco(null, "Av. 13 de Maio", "7210", "Altos", "Bemfica", "6000000", cliente1, cidade1);
				Endereco endereco2 = new Endereco(null, "Rua São Luís", "751", null, "Alto da Brasília", "6000420", cliente2, cidade2);
				Endereco endereco3 = new Endereco(null, "Rua Aracaju", "500", null, "Acaracuzinho", "6000700", cliente3, cidade3);
				Endereco endereco4 = new Endereco(null, "Rua da Coleirinha", "200", "3° Andar", "palma", "600400", cliente4, cidade4);
				Endereco endereco5 = new Endereco(null, "Avenida Vaticano", "3510", null, "Alemanha", "65085-255", cliente5, cidade5);
				Endereco endereco6 = new Endereco(null, "Rua Lagoa do Bonfim", "1000", null, "Alecrim", "59129-620", cliente6, cidade6);
				Endereco endereco7 = new Endereco(null, "Rua Nelson Ferreira", "4222", null, "Jardim Nossa Senhora Aparecida", "42580-90", cliente7, cidade7);
				Endereco endereco8 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "42570-90", cliente7, cidade7);
				
				//--------------------------------------------------------------------------------------
				cliente1.getEnderecos().addAll(Arrays.asList(endereco1));
				cliente2.getEnderecos().addAll(Arrays.asList(endereco2));
				cliente3.getEnderecos().addAll(Arrays.asList(endereco3));
				cliente4.getEnderecos().addAll(Arrays.asList(endereco4));
				cliente5.getEnderecos().addAll(Arrays.asList(endereco5));
				cliente6.getEnderecos().addAll(Arrays.asList(endereco6));
				cliente7.getEnderecos().addAll(Arrays.asList(endereco7, endereco8));
				
				clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5,cliente6,cliente7));
				enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3,endereco4,endereco5,endereco6,endereco7,endereco8));
				
				//------------------------------------------------------------------------------------------------
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				//------PEDIDOS---------------
				Pedido pedido1 = new Pedido(null, sdf.parse("05/12/2019 19:03"), cliente1, endereco1);
				
				Pedido pedido2 = new Pedido(null, sdf.parse("05/10/2019 19:03"), cliente2, endereco2);
				
				Pedido pedido3 = new Pedido(null, sdf.parse("05/09/2019 19:03"), cliente3, endereco3);	
				
				Pedido pedido4 = new Pedido(null, sdf.parse("01/11/2019 19:10"), cliente4, endereco4);
				
				Pedido pedido5 = new Pedido(null, sdf.parse("01/05/2019 19:10"), cliente5, endereco5);
				
				Pedido pedido6 = new Pedido(null, sdf.parse("01/01/2019 19:10"), cliente6, endereco6);
			
				Pedido pedido7 = new Pedido(null, sdf.parse("15/02/2019 19:10"), cliente7, endereco7);
				
				//---PAGAMENTOS-------
				Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
				pedido1.setPagamento(pagt1);
						
				Pagamento pagt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("10/12/2019 00:00"), null);
				pedido2.setPagamento(pagt2);
				
				Pagamento pagt3 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, pedido3, sdf.parse("06/12/2019 08:00"), sdf.parse("06/12/2019 12:00"));
				pedido3.setPagamento(pagt3);
				
				Pagamento pagt4 = new PagamentoComBoleto(null, EstadoPagamento.CANCELADO, pedido4, sdf.parse("06/12/2019 10:00"), null);
				pedido4.setPagamento(pagt4);
				
				Pagamento pagt5 = new PagamentoComCartao(null, EstadoPagamento.PENDENTE, pedido5, 3);
				pedido5.setPagamento(pagt5);		
				
				Pagamento pagt6 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, pedido6, sdf.parse("05/12/2019 15:20"), sdf.parse("06/12/2019 11:30"));
				pedido6.setPagamento(pagt6);
						
				Pagamento pagt7 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido7, 1);
				pedido7.setPagamento(pagt7);
				
				
				cliente1.getPedidos().addAll(Arrays.asList(pedido1));	
				
				cliente2.getPedidos().addAll(Arrays.asList(pedido2));	
				
				cliente3.getPedidos().addAll(Arrays.asList(pedido3));	
				
				cliente4.getPedidos().addAll(Arrays.asList(pedido4));
				
				cliente5.getPedidos().addAll(Arrays.asList(pedido5));
						
				cliente6.getPedidos().addAll(Arrays.asList(pedido6));
						
				cliente7.getPedidos().addAll(Arrays.asList(pedido7));
						
				pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2,pedido3,pedido4,pedido5,pedido6,pedido7));
				pagamentoRepository.saveAll(Arrays.asList(pagt1,pagt2,pagt3,pagt4,pagt5,pagt6,pagt7));
				
				//---------------------------------------------------------------------------------------------
				
				ItemPedidoFeminino itemPedFem1 = new ItemPedidoFeminino(pedido1, prodFemSaia1, 0.0, 2, 159.90);
				ItemPedidoMasculino itemPedMasc1 = new ItemPedidoMasculino(pedido2, prodMascEsport2, 0.0, 2, 39.90);
				ItemPedidoVariado itemPedVar1 = new ItemPedidoVariado(pedido3, acesFemini1, 0.00, 1, 49.90);
				ItemPedidoSexShop itemPedSex1 = new ItemPedidoSexShop(pedido4, sexAneis1, 0.00, 1, 4.00);
				
				ItemPedidoFeminino itemPedFem2 = new ItemPedidoFeminino(pedido5, prodFemVestido2, 0.00, 1, 199.90);
				ItemPedidoMasculino itemPedMasc2 = new ItemPedidoMasculino(pedido5, prodMascPolo1, 0.00, 1, 99.90 );
				ItemPedidoVariado itemPedVar2 = new ItemPedidoVariado(pedido5, acesMasc1, 0.00, 1, 39.90);
				
				ItemPedidoFeminino itemPedFem3 = new ItemPedidoFeminino(pedido6, prodFemJens3, 0.00, 1, 79.90);
				ItemPedidoVariado itemPedVar3 = new ItemPedidoVariado(pedido6, papelaria1, 0.00, 1, 9.90);
				ItemPedidoSexShop itemPedSex2 = new ItemPedidoSexShop(pedido6, sexComestico15, 0.00, 1, 2.50);
				
				ItemPedidoMasculino itemPedMasc3 = new ItemPedidoMasculino(pedido7, prodMascJeans2, 0.00, 1, 119.90);
				ItemPedidoVariado itemPedVar4 = new ItemPedidoVariado(pedido7, acesMasc2, 0.00, 1, 49.90);
				
				pedido1.getItensFeminino().addAll(Arrays.asList(itemPedFem1));
				pedido2.getItensMasculino().addAll(Arrays.asList(itemPedMasc1));
				pedido3.getItensVariado().addAll(Arrays.asList(itemPedVar1));		
				pedido4.getItensSexshop().addAll(Arrays.asList(itemPedSex1));
				
				pedido5.getItensFeminino().addAll(Arrays.asList(itemPedFem2));
				pedido5.getItensMasculino().addAll(Arrays.asList(itemPedMasc2));
				pedido5.getItensVariado().addAll(Arrays.asList(itemPedVar2));
				
				pedido6.getItensFeminino().addAll(Arrays.asList(itemPedFem3));
				pedido6.getItensVariado().addAll(Arrays.asList(itemPedVar3));
				pedido6.getItensSexshop().addAll(Arrays.asList(itemPedSex2));
				
				pedido7.getItensMasculino().addAll(Arrays.asList(itemPedMasc3));
				pedido7.getItensVariado().addAll(Arrays.asList(itemPedVar4));
				
				prodFemSaia1.getItensfeminino().addAll(Arrays.asList(itemPedFem1));
				prodFemVestido2.getItensfeminino().addAll(Arrays.asList(itemPedFem2));
				prodFemJens3.getItensfeminino().addAll(Arrays.asList(itemPedFem3));
				
				prodMascEsport2.getItensMasculino().addAll(Arrays.asList(itemPedMasc1));
				prodMascPolo1.getItensMasculino().addAll(Arrays.asList(itemPedMasc2));
				prodMascJeans2.getItensMasculino().addAll(Arrays.asList(itemPedMasc3));
				
				acesFemini1.getItensVariado().addAll(Arrays.asList(itemPedVar1));
				acesMasc1.getItensVariado().addAll(Arrays.asList(itemPedVar2));
				papelaria1.getItensVariado().addAll(Arrays.asList(itemPedVar3));
				acesMasc2.getItensVariado().addAll(Arrays.asList(itemPedVar4));
				
				sexAneis1.getItensSexShop().addAll(Arrays.asList(itemPedSex1));
				sexComestico15.getItensSexShop().addAll(Arrays.asList(itemPedSex2));
				
				itemPedidoFemininoRepository.saveAll(Arrays.asList(itemPedFem1,itemPedFem2,itemPedFem3));
				itemPedidoMasculinoRepository.saveAll(Arrays.asList(itemPedMasc1,itemPedMasc2,itemPedMasc3));
				itemPedidoVariadoRepository.saveAll(Arrays.asList(itemPedVar1,itemPedVar2,itemPedVar3,itemPedVar4));
				itemPedidoSexShopRepository.saveAll(Arrays.asList(itemPedSex1,itemPedSex2));
				
	}
}
