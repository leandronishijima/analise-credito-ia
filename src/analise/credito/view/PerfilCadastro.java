package analise.credito.view;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_LEFT;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import analise.credito.perfil.Perfil;
import analise.credito.perfil.regras.ComprovacaoDeRenda;
import analise.credito.perfil.regras.Dependentes;
import analise.credito.perfil.regras.Emprego;
import analise.credito.perfil.regras.EstadoCivil;
import analise.credito.perfil.regras.FuncionarioBanco;
import analise.credito.perfil.regras.GrauEscolaridade;
import analise.credito.perfil.regras.IdadeContaCorrente;
import analise.credito.perfil.regras.Moradia;
import analise.credito.perfil.regras.SPC;

public class PerfilCadastro extends Application {
	
	private Perfil perfil;
	
	private AnchorPane pane;
	
	private VBox vLayout;
	private VBox formulario;
	private HBox hLayoutHeader;
	private HBox hLayoutFooter;
	private GridPane gridCampos;
	
	private Label lblTitle;
	
	private ComboBox<ComprovacaoDeRenda> cbComprovacaoRenda;
	private ComboBox<Dependentes> cbDependentes;
	private ComboBox<Emprego> cbEmprego;
	private ComboBox<EstadoCivil> cbEstadoCivil;
	private ComboBox<FuncionarioBanco> cbFuncionarioBanco;
	private ComboBox<GrauEscolaridade> cbGrauEscolaridade;
	private ComboBox<IdadeContaCorrente> cbIdadeContaCorrente;
	private ComboBox<Moradia> cbMoradia;
	private ComboBox<SPC> cbSPC;
	
	private Button btnAnalisar;
	
	public PerfilCadastro() {
		perfil = new Perfil();
	}

	@Override
	public void start(Stage stage) throws Exception {
		inicializaLayouts();
		inicializaComponentes();
		inicializaConfiguracoesPane();
		
		configuraStage(stage);
	}
	
	private void inicializaComponentes() {
		lblTitle = new Label("Perfil");
		
		criaFormulario();
		
		addHLayout(lblTitle);
		addVLayout(hLayoutHeader);
		addVLayout(formulario);
	}

	private void criaFormulario() {
		adicionaFormRegras();
		
		formulario.getChildren().add(gridCampos);
		btnAnalisar = new Button("Analisar Perfil");
		formulario.getChildren().add(btnAnalisar);
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
	
	private void addGrid(String label, @SuppressWarnings("rawtypes") ComboBox cb, int ordem) {
		gridCampos.add(toLabel(label), 0, ordem);
		gridCampos.add(cb, 1, ordem);
	}

	private Label toLabel(String text) {
		return new Label(text);
	}
	
	private void inicializaLayouts() {
		vLayout = new VBox();
		vLayout.setSpacing(5);
		vLayout.setAlignment(TOP_LEFT);
		
		hLayoutHeader = new HBox();
		hLayoutHeader.setSpacing(5);
		hLayoutHeader.setAlignment(TOP_LEFT);
		
		formulario = new VBox();
		formulario.setSpacing(5);
		formulario.setAlignment(TOP_LEFT);
		
		gridCampos = new GridPane();
		gridCampos.setAlignment(Pos.CENTER);
		gridCampos.setHgap(10);
		gridCampos.setVgap(10);
		gridCampos.setPadding(new Insets(25, 25, 25, 25));
		
		hLayoutFooter = new HBox();
		hLayoutFooter.setSpacing(5);
		hLayoutFooter.setAlignment(CENTER);
	}
	
	private void addVLayout(Node node) {
		vLayout.getChildren().add(node);
	}
	
	private void addHLayout(Node node) {
		hLayoutHeader.getChildren().add(node);
	}

	private void configuraStage(Stage stage) {
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Análise de crédito");
		stage.setResizable(true);
		stage.show();
	}
	
	private void inicializaConfiguracoesPane() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 620);
		pane.getChildren().addAll(vLayout);
	}
	
	public void show(String[] args) {
		launch(args);
	}

}
