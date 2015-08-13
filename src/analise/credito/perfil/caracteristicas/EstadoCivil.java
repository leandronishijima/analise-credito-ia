package analise.credito.perfil.caracteristicas;

public enum EstadoCivil {

	Solteiro("Solteiro(a)"),
	Viuvo("Viuvo(a)"),
	Casado("Casado(a)");
	
	private String estado;

	public String getEstado() {
		return estado;
	}

	EstadoCivil(String estado){
		this.estado = estado;
	}
	
}
