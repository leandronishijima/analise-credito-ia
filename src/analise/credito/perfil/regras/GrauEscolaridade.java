package analise.credito.perfil.regras;

public enum GrauEscolaridade implements Regra {

	SUPERIOR_COMPLETO(20, "Superior completo"),
	SUPERIOR_INCOMPLETO(10, "Superior incompleto"),
	SEGUNDO_GRAU_COMPLETO(10, "Segundo grau completo"),
	SEGUNDO_GRAU_INCOMPLETO(0, "Segundo grau incompleto"),
	PRIMEIRO_GRAU_COMPLETO(0, "Primeiro grau completo"),
	PRIMEIRO_GRAU_INCOMPLETO(-10, "Primeiro grau incompleto");
	
	private int pontuacao;
	private String label;
	
	private GrauEscolaridade(int pontuacao, String label) {
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
