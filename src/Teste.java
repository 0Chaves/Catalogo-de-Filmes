import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teste {

	public static void main(String[] args) throws IOException {
		Path arquivo = Paths.get("src", "Filmes.txt");
		
		Acervo acervo = new Acervo(arquivo);
		
		//Buscando top k
		System.out.println("----Buscando os top 5 filmes----");
		for(Filme filme: acervo.buscaTopK(5)) {
			System.out.println(filme.getNome() +" "+ filme.getNota());
		}
		System.out.println("\n");
		
		//Busca por ator
		System.out.println("----Buscando filmes do ator Elijah Wood----");
		acervo.buscaFilmesAtor("Elijah Wood").forEach(filme -> System.out.println(filme.getNome() + " - Ano: " + filme.getAno()));
		System.out.println("\n");
		
		//media por genero
		System.out.println("----Mostrando a media do genero Drama----");
		System.out.println(acervo.mediaNotaGenero(ENUM_generos.DRAMA));
		System.out.println();
		
		//pesquisar por nome e genero
		System.out.println("----Pesquisando filmes com O Grande no nome e genero Comedia----");
		acervo.buscaFilme("O Grande", ENUM_generos.COMEDIA).forEach(filme->System.out.println(filme.getNome()+", Ano: "+ filme.getAno()));
		System.out.println();
		
		//Buscar filmes por nota
		System.out.println("----Buscando filmes com nota 8----");
		acervo.buscaNota(8).forEach(filme -> System.out.println(filme.getNome() +" Nota:"+ filme.getNota()));
		
	}
}
