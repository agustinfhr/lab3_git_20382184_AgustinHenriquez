package SocialNetwork;

import java.util.ArrayList;

public class Publicacion {
    private final int id;
    private ArrayList<Reaccion> reacciones;
    private final String tipoPublicacion;
    private final String contenido;
    private final String fecha;
    private final String autor;
    private String fechaShare;
    private String usuarioShare;



    public Publicacion(int id, ArrayList<Reaccion> reacciones, String tipoPublicacion, String contenido, String fecha, String autor){
        this.id = id;
        this.reacciones = reacciones;
        this.tipoPublicacion = tipoPublicacion;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
        this.fechaShare = null;
        this.usuarioShare = null;
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

    public String getContenido() {
        return this.contenido;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getFechaShare() {
        return this.fechaShare;
    }

    public void setFechaShare(String fechaShare) {
        this.fechaShare = fechaShare;
    }

    public String getUsuarioShare() {
        return this.usuarioShare;
    }

    public void setUsuarioShare(String usuarioShare) {
        this.usuarioShare = usuarioShare;
    }

    public String toString() {
        if (usuarioShare == null) {
            return " Id: " + id + " | Tipo de publicacion: " + tipoPublicacion + " | Creado por: " + autor + " | Publicado el dia: " + fecha +
                    "\n" + " Contenido: " + contenido + "\n";
        } else {
            return " Id: " + id + " | Tipo de publicacion: " + tipoPublicacion + " | Creado por: " + autor + " | Publicado el dia: " + fecha +
                    "\n" + " Contenido: " + contenido +
                    "\n" + " Compartido por el Usuario: " + usuarioShare + " | En el dia: " + fechaShare + "\n";
        }

    }


}
