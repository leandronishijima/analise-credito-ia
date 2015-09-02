package analise.credito.view;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.geometry.Pos.TOP_LEFT;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import analise.credito.perfil.Perfil;

public class ResultadosView extends VBox {
	
	private Perfil perfil;

	public ResultadosView(Perfil perfil) {
		this.perfil = perfil;
		
		configuraLayouts();
		geraGrafico();
	}

	private void geraGrafico() {
		ObservableList<PieChart.Data> pieChartData =
                observableArrayList(
                new PieChart.Data("Dependentes", 13),
                new PieChart.Data("Emprego", 25),
                new PieChart.Data("Estado civil", 10),
                new PieChart.Data("Moradia", 22),
                new PieChart.Data("Grau de escolaridade", 30));
		
		final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Análise de crédito");
        
        getChildren().add(chart);
	}

	private void configuraLayouts() {
		setSpacing(5);
		setAlignment(TOP_LEFT);
	}

}
