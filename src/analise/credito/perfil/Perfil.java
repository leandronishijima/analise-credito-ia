package analise.credito.perfil;

import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
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

	protected Double valorRequisitado;
	protected Double renda;
	protected FuncionarioBanco funcionarioBanco;
	protected ComprovacaoDeRenda comprovacaoDeRenda;
	protected IdadeContaCorrente idadeContaCorrente;
	protected EstadoCivil estadoCivil;
	protected Moradia moradia;
	protected GrauEscolaridade grauEscolaridade;
	protected Dependentes dependentes;
	protected Emprego emprego;
	protected SPC spc;
	
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
	
	public ObservableList<PieChart.Data> getPieChartData() {
		return observableArrayList(
				makePieChartData(funcionarioBanco.getLabel(), funcionarioBanco.getPontuacao()),
				makePieChartData(comprovacaoDeRenda.getLabel(), comprovacaoDeRenda.getPontuacao()),
				makePieChartData(idadeContaCorrente.getLabel(), idadeContaCorrente.getPontuacao()),
				makePieChartData(estadoCivil.getLabel(), estadoCivil.getPontuacao()),
				makePieChartData(moradia.getLabel(), moradia.getPontuacao()),
				makePieChartData(grauEscolaridade.getLabel(), grauEscolaridade.getPontuacao()),
				makePieChartData(dependentes.getLabel(), dependentes.getPontuacao()),
				makePieChartData(emprego.getLabel(), emprego.getPontuacao()),
				makePieChartData(spc.getLabel(), spc.getPontuacao()));
	}

	private Data makePieChartData(String label, int pontuacao) {
		return new PieChart.Data(label, pontuacao);
	}
	
}
