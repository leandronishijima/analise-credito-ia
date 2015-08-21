package analise.credito;

import analise.credito.calculadora.CalculadoraPrestacoes;


public class Main {

	private static final String NOME_ARQUIVO = "banco.txt";
	private static final String USER_DIR = "user.dir";

	public static void main(String[] args) {
	}

//	private static void carregaDataBase() {
//		Stream<String> linhas = leArquivo();
//		
//		Stream<Perfil> perfis = linhas.map(linha -> {
//	        return new Perfil(linha);
//		});
//		
//		DataBase.getInstance().setPerfis(perfis);
//	}
//
//	private static Stream<String> leArquivo() {
//		try {
//			return Files.lines(getPathArquivo(), ISO_8859_1);
//		} catch (Exception e) {
//			throw new RuntimeException("Erro ao carregar o database");
//		}
//	}
//
//	private static Path getPathArquivo() {
//		return Paths.get(getCaminhoArquivoAbsoluto());
//	}
//
//	private static String getCaminhoArquivoAbsoluto() {
//		return getDiretorioProjeto().concat("\\").concat(NOME_ARQUIVO);
//	}
//
//	private static String getDiretorioProjeto() {
//		return System.getProperty(USER_DIR);
//	}
}
