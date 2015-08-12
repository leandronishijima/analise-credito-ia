package analise_de_credito;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		carregaDataBase();
	}

	private static void carregaDataBase() {
		List<Perfil> perfis = new ArrayList<Perfil>();
		
		Stream<String> linhas = leArquivo();
		
		linhas.map(linha -> {
	        return perfis.add(new Perfil(linha));
		});
		//validar se preenchou perfis
		
		DataBase.getInstance().setPerfis(perfis.stream());
	}

	private static Stream<String> leArquivo() {
		try {
			return Files.lines(getCaminhoArquivo());
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar o database");
		}
	}

	private static Path getCaminhoArquivo() {
		Path path = Paths.get(System.getProperty("user.dir"));
		return path;
	}
}
