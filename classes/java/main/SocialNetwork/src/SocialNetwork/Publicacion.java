
package SocialNetwork;

public class Publicacion {
    private final int id;
    private final String contenido;
    private final String tipoPublicacion;
    private final String fecha;
    private final String autor;
    private ArrayList<Reaccion> reacciones;

    public Publicacion(int id, String contenido, String tipoPublicacion, String fecha, String autor){
        this.id = id;
        this.contenido = contenido;
        this.tipoPublicacion = tipoPublicacion;
        this.fecha = fecha;
        this.autor = autor;

    }

    public int getId() {
        return id;
    }

}
