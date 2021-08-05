package SocialNetwork;

import java.util.ArrayList;

public class Publicacion {
    private final int id;
    private final String contenido;
    private final String tipoPublicacion;
    private final String fecha;
    private final String autor;
    private ArrayList<Reaccion> reacciones;

    public Publicacion(int id, String contenido, String tipoPublicacion, String fecha, String autor, ArrayList<Reaccion> reacciones){
        this.id = id;
        this.contenido = contenido;
        this.tipoPublicacion = tipoPublicacion;
        this.fecha = fecha;
        this.autor = autor;
        this.reacciones = reacciones;
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

    public String getAutor() {
        return this.autor;
    }

    public String getTipoPublicacion() {
        return this.tipoPublicacion;
    }

    public void setTipoPublicacion() {
        return this.tipoPublicacion;
    }

    public

}
