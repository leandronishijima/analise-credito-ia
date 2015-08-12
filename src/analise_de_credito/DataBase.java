package analise_de_credito;

import java.util.stream.Stream;

public class DataBase {

	private static DataBase instance;
	private Stream<Perfil> perfis;

	private DataBase(){}
	
	public static DataBase getInstance(){
		if (instance != null)
			return instance;
		
		return new DataBase();
	}
	
	public void setPerfis(Stream<Perfil> perfis){
		this.perfis = perfis;
	}
	
	public Stream<Perfil> getPerfis(){
		return perfis;
	}
}
