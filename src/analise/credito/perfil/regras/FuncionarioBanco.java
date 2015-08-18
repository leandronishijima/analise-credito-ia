package analise.credito.perfil.regras;

public enum FuncionarioBanco {
	
	SIM(100),
	NAO(0);
	
	private int pontuacao;
	
	private FuncionarioBanco(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
	
}
