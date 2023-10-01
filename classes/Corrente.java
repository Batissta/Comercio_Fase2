package classes;

public class Corrente extends Item{
	private int tamanho;
	
	public Corrente(String nome, double custoCompra, double valorVenda, int tamanho) {
		super(nome, "Corrente", custoCompra, valorVenda);
		this.tamanho = tamanho;
	}

	public String atributesString() {
		String info = String.format("%20s (cód.: %10d | estoque: %2d | tamanho: %dcm | custo de compra: %.2f | valor de venda: %.2f)\n",
				this.getNome(),
				this.getCodigo(),
				this.getEstoque(),
				this.getTamanho(),
				this.getCustoCompra(),
				this.getValorVenda());
		return info;
	}
	public int getTamanho() {
		return tamanho;
	}
}
