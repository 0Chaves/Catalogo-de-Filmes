import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Acervo {
	private List<Filme> lista;
	
	public Acervo (Path arquivo) throws IOException {
		lista = new ArrayList<>();
	
//		List<String> linhas = Files.readAllLines(arquivo, Charset.forName("UTF-8"));
		
		BufferedReader leitor = Files.newBufferedReader(arquivo, Charset.forName("UTF-8"));
		String linha = leitor.readLine();
		while(linha != null) {
			add(Filme.fromString(linha));
//			System.out.println(linha);
			linha = leitor.readLine();
		}
		leitor.close();
	}
	
	public boolean add(Filme filme) {
		return lista.add(filme);
	}
	
	public List<Filme> buscaTopK(int k) {
		return lista.stream().sorted(new Comparator<Filme>() {
			public int compare(Filme Filme1,Filme Filme2) {
				return Filme2.getNota() - Filme1.getNota();
 				}
			}).limit(k).collect(Collectors.toList());
	}
	
	public List<Filme> buscaFilmesAtor(String ator){
		//deve retornar todos os filmes do ator passado por parametro
		return null;
	}
	
	public int mediaNotaGenero(ENUM_generos genero) {
		//recebe um genero por parametro e retorna a media das notas
		return 0;
	}
	
	public List<Filme> buscaFilme(String buscaNome, ENUM_generos genero){
		//retorna todos os filmes do genero que tenham o nome buscaNome na busca
		return null;
	}
	
	//TODO
	//Fazer um metodo que faz alguma filtragem de filmes diferente
	
	
}
