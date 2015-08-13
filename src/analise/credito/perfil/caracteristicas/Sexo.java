package analise.credito.perfil.caracteristicas;

public enum Sexo {
	
	M("Masculino"),
	F("FEMININO");
	
	private String sexo;

	public String getSexo() {
		return sexo;
	}

	Sexo(String sexo){
		this.sexo = sexo;
	}
}
