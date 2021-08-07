package SocialNetwork;

public class Reaccion {
    private final int id;
    private final String autor;
    private final String fecha;
    private final String tipoReaccion;
    private final String contenido;

    public Reaccion(int id, String autor, String fecha, String tipoReaccion, String contenido) {
        this.id = id;
        this.autor = autor;
        this.fecha = fecha;
        this.tipoReaccion = tipoReaccion;
        this.contenido = contenido;
    }

    public int getId() {
        return this.id;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getTipoReaccion() {
        return this.tipoReaccion;
    }

}
