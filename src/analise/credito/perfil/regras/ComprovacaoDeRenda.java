package analise.credito.perfil.regras;

public enum ComprovacaoDeRenda implements Regra {
	
	SIM(10),
	NAO(-30);
	
	private int pontuacao;
	
	private ComprovacaoDeRenda(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public int getPontuacao() {
		return pontuacao;
	}
	
	@Override
	public String toString() {
		return this.name();
	}

}
