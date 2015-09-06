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
		calculaPontuacao();
	}

	private Integer calculaPontuacao() {
		List<? extends Object> atributos = Arrays.asList(
				perfil.getComprovacaoDeRenda(), perfil.getDependentes(),
				perfil.getEmprego(), perfil.getEstadoCivil(),
				perfil.getFuncionarioBanco(), perfil.getGrauEscolaridade(),
				perfil.getIdadeContaCorrente(), perfil.getMoradia(),
				perfil.getSpc());

		pontuacao = atributos.stream()
				.mapToInt(r -> ((Regra) r).getPontuacao()).sum();

		return pontuacao;
	}

	public boolean isCreditoAceito() {
		return pontuacao > 130;
	}

}
