package analise.credito.perfil.regras;

public enum Emprego implements Regra {
	
	CARTEIRA_ASSINADA(30, "Carteira assinada"),
	AUTONOMO(10, "Autônomo"),
	DESEMPREGADO(-30, "Desempregado");
	
	private int pontuacao;
	private String label;
	
	private Emprego(int pontuacao, String label) {
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
