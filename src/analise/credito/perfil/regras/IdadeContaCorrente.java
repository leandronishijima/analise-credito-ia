package analise.credito.perfil.regras;

public enum IdadeContaCorrente implements Regra {
	
	MENOS_1_ANO(-10, "MENOS DE 1 ANO"),
	MENOS_5_ANOS(10, "MENOS DE 5 ANOS"),
	MENOS_10_ANOS(20, "MENOS DE 10 ANOS"),
	MAIS_10_ANOS(30, "MAIS DE 10 ANOS");
	
	private int pontuacao;
	private String label;
	
	private IdadeContaCorrente(int pontuacao, String label) {
		this.pontuacao = pontuacao;
		this.label = label;
	}

	@Override
	public int getPontuacao() {
		return pontuacao;
	}
	
	@Override
	public String toString() {
		return label;
	}

}
