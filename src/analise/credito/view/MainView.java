package analise.credito.view;

import static javafx.geometry.Pos.TOP_LEFT;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import analise.credito.perfil.Perfil;

public class MainView extends Application {
	
	private Perfil perfil;
	
	private AnchorPane pane;
	
	private VBox vLayoutPrincipal;
	private HBox hLayoutHeader;
	private HBox hLayoutBody;
	private HBox hLayoutFooter;
	private Button btnAnalisar;
	
	private FormularioView formulario;
	private ResultadosView resultado;
	
	private Label lblTitle;
	
	public MainView() {
		perfil = new Perfil();
	}

	@Override
	public void start(Stage stage) throws Exception {
		inicializaLayouts();
		inicializaComponentes();
		configuraPane();
		
		configuraStage(stage);
	}
	
	private void mostraResultado() {
		resultado = new ResultadosView(perfil);
		hLayoutBody.getChildren().clear();
		hLayoutBody.getChildren().add(resultado);
	}
	

	private void inicializaComponentes() {
		lblTitle = new Label("Perfil");
		formulario = new FormularioView();
		btnAnalisar = new Button("Analisar Perfil");
		btnAnalisar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mostraResultado();
			}
		});
		
		addHeader(lblTitle);
		addBody(formulario);
		addFooter(btnAnalisar);
		addLayoutPrincipal(hLayoutHeader);
		addLayoutPrincipal(hLayoutBody);
		addLayoutPrincipal(hLayoutFooter);
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
		
		hLayoutFooter = new HBox();
		hLayoutFooter.setSpacing(5);
		hLayoutFooter.setAlignment(TOP_LEFT);
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
	
	private void addFooter(Node node) {
		hLayoutFooter.getChildren().add(node);
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
