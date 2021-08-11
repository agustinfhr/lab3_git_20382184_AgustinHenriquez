package SocialNetwork;

import java.util.ArrayList;

public class Publicacion {
    private final int id;
    private ArrayList<Reaccion> reacciones;
    private final String tipoPublicacion;
    private final String contenido;
    private final String fecha;
    private final String autor;


    public Publicacion(int id, ArrayList<Reaccion> reacciones, String tipoPublicacion, String contenido, String fecha, String autor){
        this.id = id;
        this.reacciones = reacciones;
        this.tipoPublicacion = tipoPublicacion;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Reaccion> getReacciones() {
        return this.reacciones;
    }

    public void setReacciones(ArrayList<Reaccion> reacciones){
        this.reacciones = reacciones;
    }

    public String getTipoPublicacion() {
        return this.tipoPublicacion;
    }

    public String getAutor() {
        return this.autor;
    }

    public String toString() {
        return "\t id: " + id + "  contenido: " + contenido + "\n";
    }



}
