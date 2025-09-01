package controller;
import java.util.List;
import java.util.ArrayList;


public class Playlist {
	
	
	private Usuario dono;	
	private String nome;
	private List<Midia> midias;
	

	 
	public Playlist(String nome, Usuario dono) {
		this.nome = nome;
		this.dono = dono;
		this.midias = new ArrayList<Midia>();
		
	}
	
	
	public boolean addMidia(Midia midia) {
		
		midias.add(midia);
		
		return true;
	}
	
	public boolean removeMidia(Midia midia) {
		
		for(int i = 0; i < midias.size(); i++) {
			if(midias.get(i).getTitulo().equals(midia.getTitulo())){
				midias.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public int calcularDuracaoTotal() {
		
		int duracaoTotal = 0;

		for(int i = 0; i < midias.size(); i++) {
			duracaoTotal += midias.get(i).getDuracao();
		}
		
		return duracaoTotal;
	}

	public List<Midia> getMidias(){
		return midias;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		nome = novoNome;
	}
	
}

