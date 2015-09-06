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
	private double renda;
	
	public CalculadoraPrestacoes(Double valorTotal, int qtdPrestacoes, double renda) {
		this.valorTotal = valorTotal;
		this.qtdPrestacoes = qtdPrestacoes;
		this.renda = renda;
		this.prestacoes = new ArrayList<Double>();
	}
	
	public void calculaValorDeCadaPrestacao() {
		Double prestacaoInicial = (valorTotal / qtdPrestacoes) + TAXA_SELIC;
		
		prestacoes.add(prestacaoInicial);
		double totalSelic = TAXA_SELIC;
		double valorPrestacaoInicial = prestacaoInicial - TAXA_SELIC;
		
		for (int i = 0; i < qtdPrestacoes - 1; i++) {
			prestacaoInicial += + TAXA_SELIC;
			prestacoes.add(prestacaoInicial);
			totalSelic += prestacaoInicial - valorPrestacaoInicial;
		}
		
		Double prestacaoFinal = prestacoes.get(prestacoes.size() - 1);
		if (prestacaoFinal > renda / 2)
			throw new ParcelaInvalidaException(
						String.format("Valor das parcelas ultrapassam a metade da renda do solicitante.\n\n" +
						"Aumente a quantidade de parcelas ou a renda mensal.\n\n" + getPrintPrestacoes()));// sugerida: %d", (int)((valorTotal + totalSelic)/(renda/2))));
		
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
