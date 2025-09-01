package controller;
import  java.util.ArrayList;
import java.util.List;

public class Catalogo {
	
	List<Midia> midias = new ArrayList<Midia>();
	List<Midia> musicas = new ArrayList<Midia>();
	List<Midia> podcasts = new ArrayList<Midia>();
	List<Midia> audiobooks = new ArrayList<Midia>();
	
	public Catalogo() {
		
	}
	
	public boolean adicionarMidia(Midia midia) {
		
		midias.add(midia);
		
		if(midia instanceof Musica) {
			musicas.add(midia);
		} else if (midia instanceof Podcast) {
			podcasts.add(midia);
		} else if (midia instanceof Audiobook) {
			audiobooks.add(midia);
		}
		
		
		return true;
	}
	
	public void mostrarMidias() {
		
		for(int i = 0; i < midias.size(); i++) {
			System.out.println(i + ")" + " " + midias.get(i).getTitulo());
		}
	}

}
