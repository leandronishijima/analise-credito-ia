package analise.credito.perfil;

import analise.credito.perfil.regras.ComprovacaoDeRenda;
import analise.credito.perfil.regras.Dependentes;
import analise.credito.perfil.regras.Emprego;
import analise.credito.perfil.regras.EstadoCivil;
import analise.credito.perfil.regras.FuncionarioBanco;
import analise.credito.perfil.regras.GrauEscolaridade;
import analise.credito.perfil.regras.IdadeContaCorrente;
import analise.credito.perfil.regras.Moradia;
import analise.credito.perfil.regras.SPC;

public class Perfil {

	private Double valorRequisitado;
	private Double renda;
	private FuncionarioBanco funcionarioBanco;
	private ComprovacaoDeRenda comprovacaoDeRenda;
	private IdadeContaCorrente idadeContaCorrente;
	private EstadoCivil estadoCivil;
	private Moradia moradia;
	private GrauEscolaridade grauEscolaridade;
	private Dependentes dependentes;
	private Emprego emprego;
	private SPC spc;
	
	public Perfil() {
	}

	public Double getValorRequisitado() {
		return valorRequisitado;
	}

	public Double getRenda() {
		return renda;
	}

	public FuncionarioBanco getFuncionarioBanco() {
		return funcionarioBanco;
	}

	public ComprovacaoDeRenda getComprovacaoDeRenda() {
		return comprovacaoDeRenda;
	}

	public IdadeContaCorrente getIdadeContaCorrente() {
		return idadeContaCorrente;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public Moradia getMoradia() {
		return moradia;
	}

	public GrauEscolaridade getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public Dependentes getDependentes() {
		return dependentes;
	}

	public Emprego getEmprego() {
		return emprego;
	}

	public SPC getSpc() {
		return spc;
	}
	
}
