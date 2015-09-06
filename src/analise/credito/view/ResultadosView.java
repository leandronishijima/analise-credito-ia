package analise.credito.view;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_LEFT;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
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
		Label lblResultado;
		
		if(analisadorDeCredito.isCreditoAceito()) {
			lblResultado = new Label("Crédito aprovado!");
			hLayoutResultado.setStyle("-fx-background-color: #83d0c9;");
		} else {
			lblResultado = new Label("Crédito não pode ser aprovado!");
			hLayoutResultado.setStyle("-fx-background-color: #fe8181;");
		}
		
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
		setAlignment(TOP_LEFT);
		
		hLayoutResultado = new HBox();
		hLayoutResultado.setAlignment(CENTER);
		hLayoutResultado.setSpacing(5);
	}

}
