package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Facisafy;
import controller.Midia;
import controller.Musica;
import controller.Playlist;
import controller.Usuario;
import controllerEnum.GenerosMusicais;

import static org.junit.jupiter.api.Assertions.*;

public class FacisafyTest {

	private GenerosMusicais generoMusical;
    private Facisafy facisafy;
    private Usuario usuario;
    private Playlist playlist;
    private Midia musica1;
    private Midia musica2;

    @BeforeEach
    void setUp() {
        facisafy = new Facisafy();
        usuario = new Usuario("João", "joao123");
        facisafy.cadastrarUsuario(usuario);

        playlist = new Playlist("Favoritas", usuario);
        usuario.adicionarPlaylist(playlist);

        musica1 = new Musica("Bohemian Rhapsody", "Queen", 354, generoMusical.ROCK);
        musica2 = new Musica("Billie Jean", "Michael Jackson", 293, generoMusical.POP);
    }

    @Test
    void deveCriarUsuario() {
        assertNotNull(usuario);
        assertEquals("João", usuario.getNome());
    }

    @Test
    void deveCriarPlaylistParaUsuario() {
        // Verifica se a chave "Favoritas" existe no mapa de playlists
        assertTrue(usuario.getPlaylists().containsKey("Favoritas"), "A playlist 'Favoritas' deve existir");

        // Verifica se o nome da playlist é realmente "Favoritas"
        Playlist playlistCriada = usuario.getPlaylists().get("Favoritas");
        assertEquals("Favoritas", playlistCriada.getNome());
    }

    @Test
    void deveAdicionarMusicasNaPlaylist() {
        playlist.addMidia(musica1);
        playlist.addMidia(musica2);

        assertEquals(2, playlist.getMidias().size());
        assertTrue(playlist.getMidias().contains(musica1));
        assertTrue(playlist.getMidias().contains(musica2));
    }

    @Test
    void deveListarPlaylistsDoUsuario() {
        playlist.addMidia(musica1);
        playlist.addMidia(musica2);

        // Verifica se o mapa não está vazio e tem exatamente uma playlist
        assertFalse(usuario.getPlaylists().isEmpty());
        assertEquals(1, usuario.getPlaylists().size());

        // Acessa a playlist pelo nome
        Playlist p = usuario.getPlaylists().get("Favoritas");
        assertNotNull(p, "A playlist 'Favoritas' deve existir");

        // Verifica nome e quantidade de músicas
        assertEquals("Favoritas", p.getNome());
        assertEquals(2, p.getMidias().size());
    }
    
    @Test
    void deveVisualizarPlaylists() {
        String resultado = usuario.visualizarPlaylists();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Favoritas"), "O nome da playlist deve aparecer");
    }

    // 🔹 Teste para visualizar músicas
    @Test
    void deveVisualizarMusicasDaPlaylist() {
        playlist.addMidia(musica1);
        playlist.addMidia(musica2);

        // Supondo que 'usuario' é o objeto que possui o método visualizarMusicas()
        String resultado = usuario.visualizarMusicas(playlist);

        assertNotNull(resultado);
        assertTrue(resultado.contains("Bohemian Rhapsody"), "A música 1 deve aparecer na listagem");
        assertTrue(resultado.contains("Billie Jean"), "A música 2 deve aparecer na listagem");
    }

}
