package controller;
import controllerEnum.*;

public class Midia {
	
	String titulo;
	String artista;
	int duracao;
	
	public Midia(String titulo, String artista, int duracao) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracao = duracao;

	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public String getArtista() {
		return artista;
	}
	

}
