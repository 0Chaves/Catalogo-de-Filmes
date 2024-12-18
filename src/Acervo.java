import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
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
		return lista.stream().filter(filme -> filme.getAutores().stream().anyMatch(a -> a.equals(ator)))
					.collect(Collectors.toList());
	}
	
	public double mediaNotaGenero(ENUM_generos genero) {
		return lista.stream().filter(filme->filme.getGenero() == genero).mapToDouble(filme->filme.getNota()).average().orElse(0.0);
	}
	
	public List<Filme> buscaFilme(String buscaNome, ENUM_generos genero){
		return lista.stream().filter(filme -> filme.getGenero() == genero && filme.getNome().contains(buscaNome))
					.collect(Collectors.toList());
	}
	
	public List<Filme> buscaNota (int nota){
		return lista.stream().filter(filme -> filme.getNota() == nota).collect(Collectors.toList());
	}
	
}
