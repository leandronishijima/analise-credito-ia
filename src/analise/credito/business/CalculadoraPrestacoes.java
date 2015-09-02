package analise.credito.business;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraPrestacoes {
	
	private final static Double TAXA_SELIC = 1.18;
	
	private Double valorTotal;
	private int qtdPrestacoes;
	private List<Double> prestacoes;
	
	public CalculadoraPrestacoes(Double valorTotal, int qtdPrestacoes) {
		this.valorTotal = valorTotal;
		this.qtdPrestacoes = qtdPrestacoes;
		this.prestacoes = new ArrayList<Double>();
	}
	
	public void calculaValorDeCadaPrestacao() {
		Double prestacao = (valorTotal / qtdPrestacoes) + TAXA_SELIC;
		
		prestacoes.add(prestacao);

		for (int i = 0; i < qtdPrestacoes - 1; i++) {
			prestacao += + TAXA_SELIC;
			prestacoes.add(prestacao);
		}
	}

}
