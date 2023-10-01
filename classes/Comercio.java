package classes;

import java.util.ArrayList;

public class Comercio {
	private ArrayList<Item> produtos = new ArrayList<>();
	private double dinheiroDisponivel = 400.50;
	
	
	public void menu() {
		System.out.println("Seja bem-vindo à Virtus Pratas");
		int esc = 0;
		while (esc != 6){
			System.out.printf(
			"------------------------%s------------------------\n1) Listar itens disponíveis.\n"+
			"2) Cadastrar um novo item.\n"+ "3) Adicionar estoque.\n"+
			"4) Remover um item.\n"+"5) Vender estoque.\n"+
			"6) Sair\n", "Menu");
			esc = Uteis.leInt("Sua escolha: ");
			Uteis.mostrarLinha();
			switch (esc) {
			case 1:
				if (produtos.isEmpty()) {
					System.out.println("Nenhum item foi cadastrado na loja");
					break;
				}else {
					int tiposDeListagem = Uteis.leInt("Opções de listagem:\n1) Listar todos os itens\n2) Listar itens de categória específica\nSua escolha: ");
					switch(tiposDeListagem) {
					case 1:
						listar();
						break;
					case 2:
						int categoriasDeListagem = Uteis.leInt("Opções de listagem:\n"
								+ "1) Corrente\n"
								+ "2) Pulseira\n"
								+ "3) Brinco\n"
								+ "4) Pingente\n"
								+ "Sua escolha: ");
						switch(categoriasDeListagem) {
						case 1:
							listar("Corrente");
							break;
						case 2:
							listar("Pulseira");
							break;
						case 3:
							listar("Brinco");
							break;
						case 4:
							listar("Pingente");
							break;
						default:
								System.out.println("Opção inválida.");
						}
						break;
					default:
						System.out.println("Opção inválida.");
					}
				}
				break;
			case 2:
				String nomeDoProduto = Uteis.leString("Digite o nome do acessório: ");
				Item selecionado = null;
				for (Item item : produtos) {
					if (item.getNome() == nomeDoProduto) {
						selecionado = item;
					}
				}
				if(selecionado != null) {
					System.out.println("Já temos um produto com esse nome. Cadastre um novo, ou adicione estoque!");
					break;
					}
				int categoria = Uteis.leInt("Selecione a catégoria que se enquadre\n1) Corrente\n2) Pulseira\n3) Brinco\n4) Pingente\nDigite sua escolha: ");
				Uteis.mostrarLinha();
				double valorDeCompra = Uteis.leDouble("Valor de compra: ");
				double valorDeVenda = Uteis.leDouble("Valor de venda: ");
				Item novo = null;
				switch (categoria) {
				case 1:
					int tamanho = Uteis.leInt("Tamanho da corrente em cm: ");
					cadastrar(novo = new Corrente(nomeDoProduto, valorDeCompra, valorDeVenda, tamanho));
					break;
				case 2:
					tamanho = Uteis.leInt("Tamanho da pulseira em cm: ");
					cadastrar(novo = new Corrente(nomeDoProduto, valorDeCompra, valorDeVenda, tamanho));
					break;
				case 3:
					String formato = Uteis.leString("Descreva o formato do brinco: ");
					cadastrar(novo = new Brinco(nomeDoProduto, valorDeCompra, valorDeVenda, formato));
					break;
				case 4:
					formato = Uteis.leString("Descreva o formato do pingente: ");
					cadastrar(novo = new Brinco(nomeDoProduto, valorDeCompra, valorDeVenda, formato));
					break;
				}
				Uteis.mostrarLinha();
				String escolha = Uteis.leString("Deseja adicionar estoque ao novo item? ");
				if (escolha.toLowerCase().startsWith("s")) {
					int cod = novo.getCodigo();
					int qtd = Uteis.leInt("Digite quantas unidades você deseja adicionar: ");
					adicionar(cod, qtd);
				}else
					System.out.println("Você está sendo redirecionado ao menu...");
				break;
			case 3:
				if(produtos.isEmpty()) {
					System.out.println("Nenhum item foi cadastrado na loja");
				}else {
					Item i = findCod(Uteis.leInt("Digite o código de acesso do produto: "));
					if (i == null){
						System.out.println("Código inválido.\nNão temos nenhum item com esse acesso.");
					}else {
						int unidadesAModificar = Uteis.leInt("Digite quantas unidades você deseja adicionar: ");
						adicionar(i.getCodigo(), unidadesAModificar);
						}
				}
				break;
			case 4:
				if(produtos.isEmpty()) {
					System.out.println("Nenhum item foi cadastrado na loja");
				}else {
					while (true) {
						Item aRemover = findCod(Uteis.leInt("Digite o código do item: "));
						if (aRemover == null) {
							System.out.println("Código inválido.");
							break;
						}else {
							if(aRemover.getEstoque() > 0){
								String confirmacao = Uteis.leString(aRemover.getNome() + " tem "+ aRemover.getEstoque()+
										" unidades em estoque.\nDeseja remover mesmo assim? ");
								if ((confirmacao.toLowerCase()).startsWith("s")) {
									remover(aRemover);
								}
								else {
									System.out.println("Remoção cancelada. Você será redirecionado ao menu...");
									break;
								}
							}else {
								remover(aRemover); break;}
						}
					}
			}
				break;
			case 5:
				if(produtos.isEmpty()) 
					System.out.println("Nenhum item foi cadastrado na loja");
				else {
					Item i = findCod(Uteis.leInt("Digite o código de acesso do item: "));
					if (i == null){
						System.out.println("Código inválido.\nNão temos nenhum item com esse acesso.");
					}else {
						int qtd = Uteis.leInt("Digite quantas unidades você deseja vender: ");
						if(qtd > i.getEstoque()) {
							System.out.println("Impossível vender "+qtd+" unidades de "+i.getNome()+". "+i.getEstoque()+" unidades disponíveis.");
						}else {
							dinheiroDisponivel += i.getValorVenda() * qtd;
							System.out.printf("%d unidades de %s foram vendidas! Isso resultou em R$.2f%\n",
									qtd, i.getNome(), i.getValorVenda() * qtd);
						}
				}
			}
				break;
			case 6:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção inválida...");
		}
		}
}
	
	
	private void listar() {
			for (int i = 0; i < produtos.size();i++) {
				System.out.printf("%d) %s", i+1, produtos.get(i).toString());
			}}
	
	
	private void listar(String categoria) {
		int cont = 0;
		for (int i = 0; i < produtos.size();i++) {
			if(produtos.get(i).getCategoria().equalsIgnoreCase(categoria)) {
				System.out.printf("%d) %s", i+1, produtos.get(i).atributesString());
				cont = 1;
			}
		}
		if(cont == 0)
			System.out.println("Nenhum item da categoria '"+categoria+"' cadastrado no catálogo.");
		}
	
	
	private void cadastrar(Item novoProduto) {
		produtos.add(novoProduto);
		System.out.printf("%s cadastrado com sucesso! Código: %d, Estoque: %d\n",
				novoProduto.getNome(),novoProduto.getCodigo(), novoProduto.getEstoque());
	}
	
	
	private void adicionar(int cod, int qtd) {
		Item aReceberEstoque = findCod(cod);
		double valorDoCarrinho = qtd*aReceberEstoque.getCustoCompra();
		if(valorDoCarrinho>dinheiroDisponivel) {
			System.out.println("Saldo insuficiente.\nSaldo disponível: R$"+dinheiroDisponivel+" Custo: R$"+valorDoCarrinho);
		}else {
			System.out.println("Estoque adicionado com sucesso!");
			findCod(cod).addEstoque(qtd);
			dinheiroDisponivel -= valorDoCarrinho;
	}
	}
	
	
	private void remover(Item item) {
		System.out.printf("%s e todo o seu estoque foi removido.\n", item.getNome());
		produtos.remove(item);
	}
	
	
	private Item findCod(int cod) {
		Item selecionado = null;
		for (Item item : produtos) {
			if (item.getCodigo() == cod) {
				selecionado = item;
			}
		}
		return selecionado;
	}
	
	
	public static void main(String[] args) {
		Comercio c = new Comercio();
		c.menu();
	}
}