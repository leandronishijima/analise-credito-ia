package analise.credito.view;

import static javafx.geometry.Pos.TOP_LEFT;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import analise.credito.perfil.Perfil;
import analise.credito.perfil.PerfilBuilder;
import analise.credito.perfil.regras.ComprovacaoDeRenda;
import analise.credito.perfil.regras.Dependentes;
import analise.credito.perfil.regras.Emprego;
import analise.credito.perfil.regras.EstadoCivil;
import analise.credito.perfil.regras.FuncionarioBanco;
import analise.credito.perfil.regras.GrauEscolaridade;
import analise.credito.perfil.regras.IdadeContaCorrente;
import analise.credito.perfil.regras.Moradia;
import analise.credito.perfil.regras.SPC;
import analise.credito.view.components.CurrencyTextField;

public class FormularioView extends VBox {

	private CurrencyTextField txtValorEmprestimo;

	private ComboBox<ComprovacaoDeRenda> cbComprovacaoRenda;
	private ComboBox<Dependentes> cbDependentes;
	private ComboBox<Emprego> cbEmprego;
	private ComboBox<EstadoCivil> cbEstadoCivil;
	private ComboBox<FuncionarioBanco> cbFuncionarioBanco;
	private ComboBox<GrauEscolaridade> cbGrauEscolaridade;
	private ComboBox<IdadeContaCorrente> cbIdadeContaCorrente;
	private ComboBox<Moradia> cbMoradia;
	private ComboBox<SPC> cbSPC;

	private GridPane gridCampos;

	public FormularioView() {
		setSpacing(5);
		setAlignment(TOP_LEFT);

		configuraComponenteValorEmprestimo();

		gridCampos = new GridPane();
		gridCampos.setAlignment(Pos.CENTER);
		gridCampos.setHgap(10);
		gridCampos.setVgap(10);
		gridCampos.setPadding(new Insets(25, 25, 25, 25));

		criaFormulario();
	}

	public Perfil getPerfil() {
		return new PerfilBuilder()
				.setComprovacaoDeRenda(cbComprovacaoRenda.getValue())
				.setDependentes(cbDependentes.getValue())
				.setEmprego(cbEmprego.getValue())
				.setEstadoCivil(cbEstadoCivil.getValue())
				.setFuncionarioBanco(cbFuncionarioBanco.getValue())
				.setGrauEscolaridade(cbGrauEscolaridade.getValue())
				.setIdadeContaCorrente(cbIdadeContaCorrente.getValue())
				.setMoradia(cbMoradia.getValue())
				.setSPC(cbSPC.getValue())
				.build();
	}

	private void configuraComponenteValorEmprestimo() {
		txtValorEmprestimo = new CurrencyTextField();
	}

	private void criaFormulario() {
		addGrid("Valor do empréstimo", txtValorEmprestimo, 0);
		adicionaFormRegras();

		getChildren().add(gridCampos);
	}

	private void adicionaFormRegras() {
		adicionaCampoComprovacaoRenda(1);
		adicionaCampoDependentes(2);
		adicionaCampoEmprego(3);
		adicionaCampoEstadoCivil(4);
		adicionaCampoFuncionarioBanco(5);
		adicionaCampoGrauEscolaridade(6);
		adicionaCampoIdadeContaCorrente(7);
		adicionaCampoMoradia(8);
		adicionaCampoSPC(9);
	}

	private void addGrid(String label, Node component, int ordem) {
		gridCampos.add(toLabel(label), 0, ordem);
		gridCampos.add(component, 1, ordem);
	}

	private void adicionaCampoSPC(int ordem) {
		cbSPC = new ComboBox<SPC>();
		cbSPC.getItems().addAll(SPC.values());

		addGrid("SPC", cbSPC, ordem);
	}

	private void adicionaCampoMoradia(int ordem) {
		cbMoradia = new ComboBox<Moradia>();
		cbMoradia.getItems().addAll(Moradia.values());

		addGrid("Moradia", cbMoradia, ordem);
	}

	private void adicionaCampoIdadeContaCorrente(int ordem) {
		cbIdadeContaCorrente = new ComboBox<IdadeContaCorrente>();
		cbIdadeContaCorrente.getItems().addAll(IdadeContaCorrente.values());

		addGrid("Idade da conta corrente", cbIdadeContaCorrente, ordem);
	}

	private void adicionaCampoGrauEscolaridade(int ordem) {
		cbGrauEscolaridade = new ComboBox<GrauEscolaridade>();
		cbGrauEscolaridade.getItems().addAll(GrauEscolaridade.values());

		addGrid("Grau de escolaridade", cbGrauEscolaridade, ordem);
	}

	private void adicionaCampoFuncionarioBanco(int ordem) {
		cbFuncionarioBanco = new ComboBox<FuncionarioBanco>();
		cbFuncionarioBanco.getItems().addAll(FuncionarioBanco.values());

		addGrid("Estado civil", cbFuncionarioBanco, ordem);
	}

	private void adicionaCampoEstadoCivil(int ordem) {
		cbEstadoCivil = new ComboBox<EstadoCivil>();
		cbEstadoCivil.getItems().addAll(EstadoCivil.values());

		addGrid("Estado civil", cbEstadoCivil, ordem);
	}

	private void adicionaCampoDependentes(int ordem) {
		cbDependentes = new ComboBox<Dependentes>();
		cbDependentes.getItems().addAll(Dependentes.values());

		addGrid("Dependentes", cbDependentes, ordem);
	}

	private void adicionaCampoEmprego(int ordem) {
		cbEmprego = new ComboBox<Emprego>();
		cbEmprego.getItems().addAll(Emprego.values());

		addGrid("Emprego", cbEmprego, ordem);
	}

	private void adicionaCampoComprovacaoRenda(int ordem) {
		cbComprovacaoRenda = new ComboBox<ComprovacaoDeRenda>();
		cbComprovacaoRenda.getItems().addAll(ComprovacaoDeRenda.values());

		addGrid("Comprovação de renda", cbComprovacaoRenda, ordem);
	}

	private Label toLabel(String text) {
		return new Label(text);
	}

}
