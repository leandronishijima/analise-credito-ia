package analise.credito.business;

import java.util.Arrays;
import java.util.List;

import analise.credito.perfil.Perfil;
import analise.credito.perfil.regras.Regra;

public class AnalisadorDeCredito {
	
	private Perfil perfil;
	private int pontuacao;
	
	public AnalisadorDeCredito(Perfil perfil) {
		this.perfil = perfil;
		this.pontuacao = 0;
	}
	
	public Integer calculaPontuacao() {
		List<? extends Object> atributos = Arrays.asList(
				perfil.getComprovacaoDeRenda(),
				perfil.getDependentes(),
				perfil.getEmprego(),
				perfil.getEstadoCivil(),
				perfil.getFuncionarioBanco(),
				perfil.getGrauEscolaridade(),
				perfil.getIdadeContaCorrente(),
				perfil.getMoradia(),
				perfil.getSpc());
		
		for (Object regra : atributos)
			calculaPontosCampo((Regra) regra);
		
		return pontuacao;
	}

	private void calculaPontosCampo(Regra regra) {
		pontuacao += regra.getPontuacao();
	}
	
}
