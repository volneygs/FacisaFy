package controller;

import controllerEnum.GenerosPodcast;

public class Podcast extends Midia{
	
	GenerosPodcast genero;
	
	public Podcast(String titulo, String artista, int duracao, GenerosPodcast genero) {
		super(titulo, artista, duracao);
		this.genero = genero;
	}
	
	public GenerosPodcast getGenero() {
		return genero;
	}
	
	

}
