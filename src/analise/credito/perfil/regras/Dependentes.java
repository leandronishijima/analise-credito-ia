package analise.credito.perfil.regras;

public enum Dependentes implements Regra {
	
	NENHUM(10, "Nenhum"),
	UM(10, "1"),
	DOIS(10, "2"),
	TRES_OU_MAIS(0, "3 ou mais");
	
	private int pontuacao;
	private String label;
	
	private Dependentes(int pontuacao, String label) {
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
