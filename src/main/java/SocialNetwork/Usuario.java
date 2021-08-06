package SocialNetwork;

import java.util.ArrayList;

public class Usuario {
    private final String nombre;
    private final String contrasenia;
    private final int id;
    private ArrayList<Publicacion> publicaciones;
    private ArrayList<String> seguidores;

    public Usuario(String nombre, String contrasenia, int id, ArrayList<Publicacion> publicaciones, ArrayList<String> seguidores) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.publicaciones = publicaciones;
        this.seguidores = seguidores;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public ArrayList<String> getSeguidores() {
        return this.seguidores;
    }

    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }

}
