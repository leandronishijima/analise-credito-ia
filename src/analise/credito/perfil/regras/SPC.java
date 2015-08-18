package analise.credito.perfil.regras;

public enum SPC implements Regra {
	
	NOME_SPC(-80, "Nome no SPC"),
	SITUACAO_LEGAL(30, "Situação legal");

	private int pontuacao;
	private String label;
	
	private SPC(int pontuacao, String label) {
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
