package nov04classes;

public class Compra {

	int valorTotal;
	int numeroPrestacoes;
	
	// Pronto Pagamento
	public Compra(int valor) {
		valorTotal = valor;
		numeroPrestacoes = 1;
	}
	
	// A Prestações
	public Compra(int qtPrestacoes, int valorTotal) {
		numeroPrestacoes = qtPrestacoes;
		this.valorTotal = valorTotal; // Atualiza o valor total baseado na entrada
	}

	
	// Nota: clique em Source > Generate Getters and Setters, clique em Select Getters e Generate para gerar automaticamente os próximos dois blocos
	
	// Getter para valor total
	public int getValorTotal() {
		return valorTotal;
	}
	
	// Getter para número de prestações 
	public int getNumeroPrestacoes() {
		return numeroPrestacoes;
	}

	// Calcula e retorna o valor de cada prestação
	public int getValorPrestacao() {
		return valorTotal / numeroPrestacoes; //Divide o valor total pelo número de prestações
	}
}
