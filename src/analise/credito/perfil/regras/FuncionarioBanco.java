package analise.credito.perfil.regras;

public enum FuncionarioBanco implements Regra {
	
	SIM(100),
	NAO(0);
	
	private int pontuacao;
	
	private FuncionarioBanco(int pontuacao) {
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

	@Override
	public String getLabel() {
		return "Funcionário do banco";
	}
	
}
