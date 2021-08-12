package SocialNetwork;

import java.util.ArrayList;

/**
 * Una clase para representar una publicacion dentro de la red social
 * Cada publicacion queda determinada por el id, reacciones, tipo de publicacion, contenido, fecha, autor, fecha de compartido y usuario compartido
 */
public class Publicacion {
    private final int id; //id unico de la publicacion
    private ArrayList<Reaccion> reacciones; // las reacciones de la publicacion (comentario o like)
    private final String tipoPublicacion; // el tipo de publicacion (video foto etc)
    private final String contenido; //el contenido de la publicacion
    private final String fecha; // la fecha de la publicacion
    private final String autor; // el autor de la publicacion
    private String fechaShare; //la fecha en que un usuario compartio esta publicacion hacia otro usuario(puede estar null)
    private String usuarioShare; //el usuario el cual compartio la publicacion hacia otro usuario(puede estar null)


    /**
     * Crea una publicacion a partir del id, reacciones, tipo de publicacion, contenido, fecha, autor
     * @param id id de la publicacion
     * @param reacciones reacciones de la publicacion
     * @param tipoPublicacion tipo de publicacion
     * @param contenido contenido de la publicacion
     * @param fecha fecha de la publicacion
     * @param autor autor de la publicacion
     */
    public Publicacion(int id, ArrayList<Reaccion> reacciones, String tipoPublicacion, String contenido, String fecha, String autor) {
        this.id = id;
        this.reacciones = reacciones;
        this.tipoPublicacion = tipoPublicacion;
        this.contenido = contenido;
        this.fecha = fecha;
        this.autor = autor;
        this.fechaShare = null;
        this.usuarioShare = null;
    }

    /**
     * get id
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * get reacciones
     * @return reacciones
     */
    public ArrayList<Reaccion> getReacciones() {
        return this.reacciones;
    }

    /**
     * set reacciones
     * @param reacciones
     */
    public void setReacciones(ArrayList<Reaccion> reacciones) {
        this.reacciones = reacciones;
    }

    /** get tipo de publicacion
     *
     * @return tipoPulicacion
     */
    public String getTipoPublicacion() {
        return this.tipoPublicacion;
    }

    /**
     * get contenido
      * @return contenido
     */
    public String getContenido() {
        return this.contenido;
    }

    /**
     * get autor
     * @return autor
     */
    public String getAutor() {
        return this.autor;
    }

    /** get fecha share
     *
     * @return fechaShare
     */
    public String getFechaShare() {
        return this.fechaShare;
    }

    /**
     * set fecha share
     * @param fechaShare
     */
    public void setFechaShare(String fechaShare) {
        this.fechaShare = fechaShare;
    }

    /**
     * get usuario share
     * @return usuarioShare
     */
    public String getUsuarioShare() {
        return this.usuarioShare;
    }

    /**
     * set usuario share
     * @param usuarioShare
     */
    public void setUsuarioShare(String usuarioShare) {
        this.usuarioShare = usuarioShare;
    }

    /**
     * Convierte los datos de la publicacion a String
     * @return String
     */
    public String toString() {
        //La funcionalidad puede retornar varias opciones dependiendo de la publicacion
        //Si la publicacion NO tiene usuario que la compartio y NO tiene reacciones
        if (usuarioShare == null && reacciones == null) {
            return " Id: " + id + " | Tipo de publicacion: " + tipoPublicacion + " | Creado por: " + autor + " | Publicado el dia: " + fecha +
                    "\n" + " Contenido: " + contenido +
                    "\n" + " Publicacion sin Reacciones " + "\n";
        }
        //Si la publicacion tiene a un usuario que la compartio pero NO tiene reacciones
        if (usuarioShare != null && reacciones == null) {
            return " Id: " + id + " | Tipo de publicacion: " + tipoPublicacion + " | Creado por: " + autor + " | Publicado el dia: " + fecha +
                    "\n" + " Contenido: " + contenido +
                    "\n" + " Publicacion sin Reacciones " +
                    "\n" + " Compartido por el Usuario: " + usuarioShare + " | En el dia: " + fechaShare + "\n";
        }
        //Si la publicacion NO tiene usuario que la compartio y tiene reacciones
        if (usuarioShare == null && reacciones != null) {
            return " Id: " + id + " | Tipo de publicacion: " + tipoPublicacion + " | Creado por: " + autor + " | Publicado el dia: " + fecha +
                    "\n" + " Contenido: " + contenido +
                    "\n" + " ------ Reacciones de esta Publicacion ------ " +
                    "\n" + reacciones.toString() +
                    "\n" + " ------------- Fin Reacciones --------------- " + "\n\n";

        }
        //Si la publicacion tiene a un usuario que la compartio y tiene reacciones
        if (usuarioShare != null && reacciones != null) {
            return " Id: " + id + " | Tipo de publicacion: " + tipoPublicacion + " | Creado por: " + autor + " | Publicado el dia: " + fecha +
                    "\n" + " Contenido: " + contenido +
                    "\n" + " ------ Reacciones ------ " +
                    "\n" + reacciones.toString() +
                    "\n" + " ------------------------ " +
                    "\n" + " Compartido por el Usuario: " + usuarioShare + " | En el dia: " + fechaShare + "\n";

        }
        return "";
    }
}







