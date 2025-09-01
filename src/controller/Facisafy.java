package controller;

import java.util.ArrayList;
import java.util.List;

public class Facisafy {
	
	List<Usuario> usuarios;
	Catalogo catalogo;
	
	public Facisafy() {
		
		this.usuarios = new ArrayList<Usuario>();
		this.catalogo = new Catalogo();
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		
		usuarios.add(usuario);
	}

}