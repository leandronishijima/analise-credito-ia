package analise.credito.perfil.regras;

public enum Moradia implements Regra {
	
	PROPRIA(30, "Pr�pria"),
	ALUGADA(0, "Alugada");
	
	private int pontuacao;
	private String label;
	
	private Moradia(int pontuacao, String label) {
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
