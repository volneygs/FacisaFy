package controller;
import java.util.Map;
import java.util.HashMap;

public class Usuario {
	
	String nome;
	String email;
	Map<String, Playlist> playlists;
	
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.playlists = new HashMap<String, Playlist>();
	}
	
	public boolean adicionarPlaylist(Playlist playlist) {
		
		playlists.put(playlist.getNome(), playlist);
		
		return true;
		
	}
	
	public boolean editarPlaylist(String nome, String novoNome) {
		
		localizaPlaylist(nome).setNome(novoNome);
		
		return true;
	}
	
	public boolean removePlaylist(String nome) {
		
		for(int i = 0; i < playlists.size(); i++) {
			
			if(playlists.get(i).getNome().equals(nome)) {
				playlists.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public void adicionaMidiaPlaylist(Midia midia, String nomePlaylist) {
		
		localizaPlaylist(nomePlaylist).addMidia(midia);
	}
	
	public void removeMidiaPlaylist(Midia midia, String nomePlaylist) {
		
		localizaPlaylist(nomePlaylist).removeMidia(midia);
		
	}
	
	public String visualizarPlaylists() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Playlists:\n");
	    
	    int contador = 1;
	    for (String nomePlaylist : playlists.keySet()) {
	        sb.append(contador)
	          .append(") ")
	          .append(nomePlaylist)
	          .append("\n");
	        contador++;
	    }
	    
	    return sb.toString();
	    
	}
	
	public String visualizarMusicas(Playlist playlist) {
	    StringBuilder sb = new StringBuilder();
	    sb.append(playlist.getNome()).append(":\n");
	    
	    for (int i = 0; i < playlist.getMidias().size(); i++) {
	        sb.append(i + 1) // para começar a numeração em 1
	          .append(") ")
	          .append(playlist.getMidias().get(i).getTitulo())
	          .append("\n");
	    }
	    
	    return sb.toString();
	}
	
	private Playlist localizaPlaylist(String nomePlaylist) {
		for(int i = 0; i < playlists.size(); i++) {
			if(playlists.get(i).getNome().equals(nomePlaylist)){
				return playlists.get(i);
			}
		}
		
		return null;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Map<String, Playlist> getPlaylists(){
		return playlists;
	}
	

}
