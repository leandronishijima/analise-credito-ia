package analise.credito.view;

import static javafx.geometry.Pos.CENTER;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import analise.credito.business.AnalisadorDeCredito;
import analise.credito.perfil.Perfil;

public class ResultadosView extends VBox {
	
	private Perfil perfil;
	private AnalisadorDeCredito analisadorDeCredito;
	private HBox hLayoutResultado;
	
	public ResultadosView(Perfil perfil) {
		this.perfil = perfil;
		
		analisadorDeCredito = new AnalisadorDeCredito(perfil);
		configuraLayouts();
		adicionaLabelDeResultado();
		geraGrafico();
	}
	
	private void adicionaLabelDeResultado() {
		Label lblResultado = new Label();
		lblResultado.setStyle("-fx-text-fill: #f7f7f7;");
		ImageView icon;
		
		if(analisadorDeCredito.isCreditoAceito()) {
			lblResultado.setText("Crédito aprovado!");
			hLayoutResultado.setStyle("-fx-background-color: #83d0c9; -fx-border-color: #00b159; -fx-border-width: 2px; -fx-padding: 10; -fx-font-weight: bold;");
			icon = new ImageView(new Image("file:resources/images/OK.png"));
		} else {
			lblResultado.setText("Crédito não pode ser aprovado!");
			hLayoutResultado.setStyle("-fx-background-color: #fe8181; -fx-border-color: #fe2e2e; -fx-border-width: 2px; -fx-padding: 10; -fx-font-weight: bold;");
			icon = new ImageView(new Image("file:resources/images/x-red.gif"));
		}
		
		hLayoutResultado.getChildren().add(icon);
		hLayoutResultado.getChildren().add(lblResultado);
		getChildren().add(hLayoutResultado);
	}

	private void geraGrafico() {
		final PieChart chart = new PieChart(perfil.getPieChartData());
        chart.setTitle("Detalhes do perfil");
        
        getChildren().add(chart);
	}

	private void configuraLayouts() {
		setSpacing(5);
		setAlignment(CENTER);
		
		hLayoutResultado = new HBox();
		hLayoutResultado.setAlignment(CENTER);
		hLayoutResultado.setSpacing(5);
	}

}
