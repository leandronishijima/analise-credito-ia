package analise.credito.perfil.regras;

public enum Dependentes implements Regra {
	
	NENHUM(30, "Nenhum"),
	UM(20, "1"),
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

	@Override
	public String getLabel() {
		return "Dependentes";
	}

}
