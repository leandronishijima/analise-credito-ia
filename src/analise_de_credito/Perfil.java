package analise_de_credito;

import java.util.Arrays;
import java.util.List;

public class Perfil {

	private String linha;
	private String sexo;
	private String idade;
	private String estadoCivil;
	private String grau;
	private String numeroDependentes;
	private String salario;
	private String ocupacao;
	private String possuiNomeSPC;
	private String regiao;
	private String pagou;

	public Perfil(String linha){
		List<String> fields = getFields(linha);
	}


	private List<String> getFields(String linha) {
		return Arrays.asList(linha.split("\\|"));
	}
	
}
