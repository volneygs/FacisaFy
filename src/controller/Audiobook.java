package controller;

import controllerEnum.GenerosLiterarios;

public class Audiobook extends Midia{
	
	GenerosLiterarios genero;
	
	public Audiobook (String titulo, String artista, int duracao, GenerosLiterarios genero) {
		super(titulo, artista, duracao);
		this.genero = genero;
	}
	
	public GenerosLiterarios getGenero() {
		return genero;
	}

}
