package analise.credito.business;

import static java.lang.String.format;

import java.text.DecimalFormat;
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
	
	public List<Double> getPrestacoes() {
		return prestacoes;
	}
	
	public String getPrintPrestacoes() {
		StringBuilder builder = new StringBuilder();
		
		String msgPadrao = "Parcela %d - R$ %s";
		DecimalFormat df = new DecimalFormat("#,###.00");
		int contPrestacao = 1;
		
		for (Double prestacao : prestacoes) {
			builder.append(format(msgPadrao, contPrestacao, df.format(prestacao))).append("\n");
			contPrestacao++;
		}
		
		return builder.toString();
	}

}
