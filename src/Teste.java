import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teste {

	public static void main(String[] args) throws IOException {
		Path arquivo = Paths.get("src", "Filmes.txt");
		
		Acervo acervo = new Acervo(arquivo);
		
		for(Filme filme: acervo.buscaTopK(5)) {
			System.out.println(filme.getNome() +" "+ filme.getNota());
		}
	}

}
