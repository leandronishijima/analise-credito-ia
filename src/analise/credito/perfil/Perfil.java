package analise.credito.perfil;

import java.util.Arrays;
import java.util.List;

public class Perfil {

	public Perfil(String linha){
		getFields(linha);
	}


	private List<String> getFields(String linha) {
		return Arrays.asList(linha.split("\\|"));
	}
	
}
