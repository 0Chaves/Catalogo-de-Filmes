import java.util.ArrayList;
import java.util.List;

public class Filme {
	private String nome;
	private ENUM_generos genero;
	private int nota; //de 0 a 10
	private int ano;
	List<String> autores;
	
	public Filme (String nome, ENUM_generos genero, int nota, int ano, List<String> autores) {
		setNome(nome);
		setGenero(genero);
		setNota(nota);
		setAno(ano);
		setAutores(autores);
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public ENUM_generos getGenero() {
		return genero;
	}

	private void setGenero(ENUM_generos genero) {
		this.genero = genero;
	}

	public int getNota() {
		return nota;
	}

	private void setNota(int nota) {
		this.nota = nota;
	}

	public int getAno() {
		return ano;
	}

	private void setAno(int ano) {
		this.ano = ano;
	}

	public List<String> getAutores() {
		return autores;
	}

	private void setAutores(List<String> autores) {
		this.autores = autores;
	}
	
	
	/*
	 * Deverá receber uma linha do arquivo no formato
	 * Matrix; ação; 9; 1999; Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss
	 * e criar um objeto
	 */
	public static Filme fromString (String linha) {
		//Separa a linha em substrings, utilizando o separados ";"
		String[] array = linha.split(";");
		//A ultima string do array é uma string com os nomes dos autores. A função abaixo vai separar estes autores
		String[] array_autores = array[4].split(",");
		//Cria um ArrayList e adiciona os autores la dentro
		ArrayList<String> list_autores = new ArrayList<>();
		for (String autor : array_autores){
			list_autores.add(autor);
		}
		
		String nome = array[0];
		ENUM_generos genero = ENUM_generos.valueOf(array[1].toUpperCase());
		int nota = Integer.valueOf(array[2]).intValue();
		int ano = Integer.valueOf(array[3]).intValue();
		
		//Instancia um novo Filme com as informações obtidas da linha
		return new Filme(nome, genero, nota, ano, list_autores);
	}
}
