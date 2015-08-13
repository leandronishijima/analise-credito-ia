package analise.credito.perfil.caracteristicas;

public enum GrauEscolaridade {

	SuperiorCompleto("Superior completo"),
	SuperiorIncompleto("Superior incompleto"),
	SegundoCompleto("Segundo grau completo"),
	SegundoIncompleto("Segundo grau incompleto");
	
	private String grau;

	public String getEstado() {
		return grau;
	}

	GrauEscolaridade(String grau){
		this.grau = grau;
	}
	
}
