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
	
}
