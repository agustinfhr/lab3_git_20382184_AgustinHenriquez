

package SocialNetwork;

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


}
