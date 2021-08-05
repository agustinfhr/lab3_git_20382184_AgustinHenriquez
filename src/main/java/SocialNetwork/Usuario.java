package SocialNetwork;

import java.util.ArrayList;

public class Usuario {
    private final String nombre;
    private final String contrasenia;
    private final int id;
    private ArrayList<Publicacion> publicaciones;

    public Usuario(String nombre, String contrasenia, int id, ArrayList<Publicacion> publicaciones) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.publicaciones = publicaciones;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }


}
