package controller;

import controllerEnum.GenerosMusicais;

public class Musica extends Midia{
	GenerosMusicais genero;

	public Musica(String titulo, String artista, int duracao, GenerosMusicais genero) {
		super(titulo, artista, duracao);
		this.genero = genero;
		
	}

	public GenerosMusicais getGenero() {
		return genero;
	}


}
