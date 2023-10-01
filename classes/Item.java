package classes;

public class Item {
	private static int LastCod = 0;
	private String nome;
	private int codigo;
	private String categoria;
	private int estoque;
	private double custoCompra;
	private double valorVenda;
	
	
	public Item(String nome, String categoria, double custoCompra, double valorVenda){
		this.setNome(nome);
		this.codigo = getLastCod();
		LastCod++;
		this.setEstoque(0);
		this.categoria = categoria;
		this.custoCompra = custoCompra;
		this.valorVenda = valorVenda;
	}
	public String atributesString() {
		String info = String.format("%20s (cód.: %10d | estoque: %2d | categoria: %s | custo de compra: %.2f | valor de venda: %.2f)\n",
				this.getNome(),
				this.getCodigo(),
				this.getEstoque(),
				this.getCategoria(),
				this.getCustoCompra(),
				this.getValorVenda());
		return info;
	}
	@Override
	public String toString() {
		String info = String.format("%20s (cód.: %10d | estoque: %2d | categoria: %s | custo de compra: %.2f | valor de venda: %.2f)\n",
				this.getNome(),
				this.getCodigo(),
				this.getEstoque(),
				this.getCategoria(),
				this.getCustoCompra(),
				this.getValorVenda());
		return info;
	}

	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected int getCodigo() {
		return codigo;
	}
	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	protected int getEstoque() {
		return estoque;
	}
	protected void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getCustoCompra() {
		return custoCompra;
	}

	public void setCustoCompra(double custoCompra) {
		this.custoCompra = custoCompra;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public static int getLastCod() {
		return LastCod;
	}

	protected void addEstoque(int n) {
		this.setEstoque(getEstoque() + n);
	}
	protected void venderEstoque(int n) {
			this.setEstoque(getEstoque() - n);
	}
	
}
