package analise.credito.view;

import static java.lang.Integer.MAX_VALUE;
import static javafx.geometry.Pos.TOP_LEFT;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
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

	private GridPane gridFormularioValoresEmprestimo;
	private CurrencyTextField txtValorEmprestimo;
	private CurrencyTextField txtRenda;
	private Spinner<Integer> spQtdParcelas;
	
	private Button btnProximo;

	private ComboBox<ComprovacaoDeRenda> cbComprovacaoRenda;
	private ComboBox<Dependentes> cbDependentes;
	private ComboBox<Emprego> cbEmprego;
	private ComboBox<EstadoCivil> cbEstadoCivil;
	private ComboBox<FuncionarioBanco> cbFuncionarioBanco;
	private ComboBox<GrauEscolaridade> cbGrauEscolaridade;
	private ComboBox<IdadeContaCorrente> cbIdadeContaCorrente;
	private ComboBox<Moradia> cbMoradia;
	private ComboBox<SPC> cbSPC;
	
	private Button btnVoltar;

	private GridPane gridFormularioRegras;

	public FormularioView() {
		setSpacing(5);
		setAlignment(TOP_LEFT);

		configuraTextField();

		gridFormularioValoresEmprestimo = new GridPane();
		gridFormularioValoresEmprestimo.setAlignment(Pos.CENTER);
		gridFormularioValoresEmprestimo.setHgap(10);
		gridFormularioValoresEmprestimo.setVgap(10);
		gridFormularioValoresEmprestimo.setPadding(new Insets(25, 25, 25, 25));
		
		gridFormularioRegras = new GridPane();
		gridFormularioRegras.setAlignment(Pos.CENTER);
		gridFormularioRegras.setHgap(10);
		gridFormularioRegras.setVgap(10);
		gridFormularioRegras.setPadding(new Insets(25, 25, 25, 25));

		criaFormularios();
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

	private void configuraTextField() {
		txtValorEmprestimo = new CurrencyTextField();
		txtRenda = new CurrencyTextField();
		spQtdParcelas = new Spinner<Integer>(0, MAX_VALUE, 12);
		
		btnProximo = new Button("Próximo");
		btnProximo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alteraFormulario(gridFormularioRegras);
			}
		});
		
		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alteraFormulario(gridFormularioValoresEmprestimo);
			}
		});
	}
	
	private void alteraFormulario(GridPane showGrid) {
		getChildren().clear();
		getChildren().add(showGrid);
	}

	private void criaFormularios() {
		addGrid(gridFormularioValoresEmprestimo, "Valor do empréstimo", txtValorEmprestimo, 0);
		addGrid(gridFormularioValoresEmprestimo, "Valor da renda mensal", txtRenda, 1);
		addGrid(gridFormularioValoresEmprestimo, "Quantidade de parcelas", spQtdParcelas, 2);
		addGrid(gridFormularioValoresEmprestimo, "", btnProximo, 3);
		
		adicionaFormRegras(0);

		getChildren().add(gridFormularioValoresEmprestimo);
	}

	private void adicionaFormRegras(int initialIndex) {
		adicionaCampoComprovacaoRenda(++initialIndex);
		adicionaCampoDependentes(++initialIndex);
		adicionaCampoEmprego(++initialIndex);
		adicionaCampoEstadoCivil(++initialIndex);
		adicionaCampoFuncionarioBanco(++initialIndex);
		adicionaCampoGrauEscolaridade(++initialIndex);
		adicionaCampoIdadeContaCorrente(++initialIndex);
		adicionaCampoMoradia(++initialIndex);
		adicionaCampoSPC(++initialIndex);
		addGrid(gridFormularioRegras, "", btnVoltar, ++initialIndex);
	}

	private void addGrid(GridPane grid, String label, Node component, int ordem) {
		grid.add(toLabel(label), 0, ordem);
		grid.add(component, 1, ordem);
	}

	private void adicionaCampoSPC(int ordem) {
		cbSPC = new ComboBox<SPC>();
		cbSPC.getItems().addAll(SPC.values());

		addGrid(gridFormularioRegras, "SPC", cbSPC, ordem);
	}

	private void adicionaCampoMoradia(int ordem) {
		cbMoradia = new ComboBox<Moradia>();
		cbMoradia.getItems().addAll(Moradia.values());

		addGrid(gridFormularioRegras, "Moradia", cbMoradia, ordem);
	}

	private void adicionaCampoIdadeContaCorrente(int ordem) {
		cbIdadeContaCorrente = new ComboBox<IdadeContaCorrente>();
		cbIdadeContaCorrente.getItems().addAll(IdadeContaCorrente.values());

		addGrid(gridFormularioRegras, "Idade da conta corrente", cbIdadeContaCorrente, ordem);
	}

	private void adicionaCampoGrauEscolaridade(int ordem) {
		cbGrauEscolaridade = new ComboBox<GrauEscolaridade>();
		cbGrauEscolaridade.getItems().addAll(GrauEscolaridade.values());

		addGrid(gridFormularioRegras, "Grau de escolaridade", cbGrauEscolaridade, ordem);
	}

	private void adicionaCampoFuncionarioBanco(int ordem) {
		cbFuncionarioBanco = new ComboBox<FuncionarioBanco>();
		cbFuncionarioBanco.getItems().addAll(FuncionarioBanco.values());

		addGrid(gridFormularioRegras, "Estado civil", cbFuncionarioBanco, ordem);
	}

	private void adicionaCampoEstadoCivil(int ordem) {
		cbEstadoCivil = new ComboBox<EstadoCivil>();
		cbEstadoCivil.getItems().addAll(EstadoCivil.values());

		addGrid(gridFormularioRegras, "Estado civil", cbEstadoCivil, ordem);
	}

	private void adicionaCampoDependentes(int ordem) {
		cbDependentes = new ComboBox<Dependentes>();
		cbDependentes.getItems().addAll(Dependentes.values());

		addGrid(gridFormularioRegras, "Dependentes", cbDependentes, ordem);
	}

	private void adicionaCampoEmprego(int ordem) {
		cbEmprego = new ComboBox<Emprego>();
		cbEmprego.getItems().addAll(Emprego.values());

		addGrid(gridFormularioRegras, "Emprego", cbEmprego, ordem);
	}

	private void adicionaCampoComprovacaoRenda(int ordem) {
		cbComprovacaoRenda = new ComboBox<ComprovacaoDeRenda>();
		cbComprovacaoRenda.getItems().addAll(ComprovacaoDeRenda.values());

		addGrid(gridFormularioRegras, "Comprovação de renda", cbComprovacaoRenda, ordem);
	}

	private Label toLabel(String text) {
		return new Label(text);
	}

}
