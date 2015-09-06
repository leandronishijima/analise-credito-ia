package analise.credito.view;

import static javafx.geometry.Pos.TOP_LEFT;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {
	
	private AnchorPane pane;
	
	private VBox vLayoutPrincipal;
	private HBox hLayoutHeader;
	private HBox hLayoutBody;
	
	private Button btnNovoPerfil;

	private FormularioView formulario;
	
	private Label lblTitle;
	
	public MainView() {
	}

	@Override
	public void start(Stage stage) throws Exception {
		inicializaLayouts();
		inicializaComponentes();
		configuraPane();
		
		configuraStage(stage);
	}
	
	private void inicializaComponentes() {
		lblTitle = new Label("Perfil");
		formulario = new FormularioView();
		
		btnNovoPerfil = new Button("Novo perfil");
		btnNovoPerfil.setOnAction(e -> {
			resetFormulario();
		});
		
		addHeader(lblTitle);
		addBody(btnNovoPerfil);
		addBody(formulario);
		addLayoutPrincipal(hLayoutHeader);
		addLayoutPrincipal(hLayoutBody);
	}

	private void resetFormulario() {
		hLayoutBody.getChildren().remove(formulario);
		formulario = new FormularioView();
		hLayoutBody.getChildren().add(formulario);
	}

	private void inicializaLayouts() {
		vLayoutPrincipal = new VBox();
		vLayoutPrincipal.setSpacing(5);
		vLayoutPrincipal.setAlignment(TOP_LEFT);
		
		hLayoutHeader = new HBox();
		hLayoutHeader.setSpacing(5);
		hLayoutHeader.setAlignment(TOP_LEFT);
		
		hLayoutBody = new HBox();
		hLayoutBody.setSpacing(5);
		hLayoutBody.setAlignment(TOP_LEFT);
	}
	
	private void addLayoutPrincipal(Node node) {
		vLayoutPrincipal.getChildren().add(node);
	}
	
	private void addHeader(Node node) {
		hLayoutHeader.getChildren().add(node);
	}
	
	private void addBody(Node node) {
		hLayoutBody.getChildren().add(node);
	}
	
	private void configuraStage(Stage stage) {
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Análise de crédito");
		stage.setResizable(true);
		stage.show();
	}
	
	private void configuraPane() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 620);
		pane.getChildren().addAll(vLayoutPrincipal);
	}
	
	public void show(String[] args) {
		launch(args);
	}

}
