package analise.credito.perfil.regras;

public enum EstadoCivil implements Regra {

	SOLTEIRO(10, "Solteiro(a)"),
	VIUVO(10, "Viuvo(a)"),
	CASADO(10, "Casado(a)"),
	DIVORCIADO(0, "Divorciado(a)");
	
	private int pontuacao;
	private String label;
	
	private EstadoCivil(int pontuacao, String label) {
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
		return "Estado civil";
	}
}
