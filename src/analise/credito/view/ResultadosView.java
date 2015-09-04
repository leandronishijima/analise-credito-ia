package analise.credito.view;

import static javafx.geometry.Pos.TOP_LEFT;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import analise.credito.business.AnalisadorDeCredito;
import analise.credito.perfil.Perfil;

public class ResultadosView extends VBox {
	
	private Perfil perfil;

	public ResultadosView(Perfil perfil) {
		this.perfil = perfil;
		
		System.out.println(new AnalisadorDeCredito(perfil).calculaPontuacao());
		
		configuraLayouts();
		geraGrafico();
	}
	
	private void geraGrafico() {
		final PieChart chart = new PieChart(perfil.getPieChartData());
        chart.setTitle("Análise de crédito");
        
        getChildren().add(chart);
	}

	private void configuraLayouts() {
		setSpacing(5);
		setAlignment(TOP_LEFT);
	}

}
