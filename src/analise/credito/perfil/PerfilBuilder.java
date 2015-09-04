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

public class PerfilBuilder {
	
	private Perfil perfil;
	
	public PerfilBuilder() {
		perfil = new Perfil();
	}
	
	public PerfilBuilder setFuncionarioBanco(FuncionarioBanco campo) {
		perfil.funcionarioBanco = campo;
		return this;
	}
	
	public PerfilBuilder setComprovacaoDeRenda(ComprovacaoDeRenda campo) {
		perfil.comprovacaoDeRenda = campo;
		return this;
	}
	
	public PerfilBuilder setIdadeContaCorrente(IdadeContaCorrente campo) {
		perfil.idadeContaCorrente = campo;
		return this;
	}
	
	public PerfilBuilder setEstadoCivil(EstadoCivil campo) {
		perfil.estadoCivil = campo;
		return this;
	}
	
	public PerfilBuilder setMoradia(Moradia campo) {
		perfil.moradia = campo;
		return this;
	}
	
	public PerfilBuilder setGrauEscolaridade(GrauEscolaridade campo) {
		perfil.grauEscolaridade = campo;
		return this;
	}
	
	public PerfilBuilder setDependentes(Dependentes campo) {
		perfil.dependentes = campo;
		return this;
	}
	
	public PerfilBuilder setEmprego(Emprego campo) {
		perfil.emprego = campo;
		return this;
	}
	
	public PerfilBuilder setSPC(SPC campo) {
		perfil.spc = campo;
		return this;
	}
	
	public Perfil build() {
		return perfil;
	}

}
