package classes;

public class Brinco extends Item{
	private String formato;

	public Brinco(String nome, double valorCompra, double valorVenda, String formato) {
		super(nome,"Brinco",valorCompra,valorVenda);
		this.formato = formato;
	}
	public String atributesString() {
		String info = String.format("%20s (cód.: %10d | estoque: %2d | formato: %s | custo de compra: %.2f | valor de venda: %.2f)\n",
				this.getNome(),
				this.getCodigo(),
				this.getEstoque(),
				this.getFormato(),
				this.getCustoCompra(),
				this.getValorVenda());
		return info;
	}
	
	public String getFormato() {
		return formato;
	}
	
}
