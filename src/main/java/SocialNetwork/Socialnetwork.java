

package SocialNetwork;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Socialnetwork {
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Publicacion> publicaciones;
    private final ArrayList<Reaccion> reacciones;
    private final ArrayList<Usuario> usuarioActivo;

    public Socialnetwork() {
        this.usuarios = new ArrayList();
        this.publicaciones = new ArrayList();
        this.reacciones = new ArrayList();
        this.usuarioActivo = new ArrayList();
    }

    public Socialnetwork(ArrayList<Usuario> usuarios, ArrayList<Publicacion> publicaciones, ArrayList<Reaccion> reacciones, ArrayList<Usuario> usuarioActivo) {
        this.usuarios = usuarios;
        this.publicaciones = publicaciones;
        this.reacciones = reacciones;
        this.usuarioActivo = usuarioActivo;
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }

    public ArrayList<Reaccion> getReacciones() {
        return this.reacciones;
    }

    public ArrayList<Usuario> getUsuarioActivo() {
        return this.usuarioActivo;
    }





    public static Socialnetwork sn1() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones = new ArrayList();
        ArrayList<Reaccion> listaReacciones = new ArrayList();
        ArrayList<Usuario> usuarioActivo = new ArrayList();
        Usuario user1 = new Usuario("Pablo", "4321", 1, (ArrayList)null, (ArrayList)null);
        Usuario user2 = new Usuario("Tefy", "5287", 2, (ArrayList)null, (ArrayList)null);
        Usuario user3 = new Usuario("Rodrigo", "9999", 3, (ArrayList)null, (ArrayList)null);
        Usuario user4 = new Usuario("Agus", "1234", 4, (ArrayList)null, (ArrayList)null);
        Usuario user5 = new Usuario("Gaspi", "1313", 5, (ArrayList)null, (ArrayList)null);
        Publicacion post1 = new Publicacion(1, (ArrayList)null, )

    }
}
