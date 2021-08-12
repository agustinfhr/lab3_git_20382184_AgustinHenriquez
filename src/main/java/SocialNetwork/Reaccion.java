package SocialNetwork;

/**
 * Una clase que representa una reaccion de las publicaciones de la red social
 * Cada reaccion queda determinada por el id, autor, fecha, tipo de reaccion y contenido
 *
 */
public class Reaccion {
    private final int id; //id unico de la reaccion
    private final String autor; //autor de la reaccion
    private final String fecha; // fecha de la reaccion
    private final String tipoReaccion; //tipo de reaccion (comentario o ME GUSTA)
    private final String contenido; //contenido de la reaccion (si es ME GUSTA queda null)

    /**
     * Crea una reaccion a partir del id, autor, fecha, tipo de reaccion y contenido
     * @param id id de la reaccion
     * @param autor autor de la reaccion
     * @param fecha fecha de la reaccion
     * @param tipoReaccion tipo de reaccion (comentario o ME GUSTA)
     * @param contenido contenido de la reaccion
     */
    public Reaccion(int id, String autor, String fecha, String tipoReaccion, String contenido) {
        this.id = id;
        this.autor = autor;
        this.fecha = fecha;
        this.tipoReaccion = tipoReaccion;
        this.contenido = contenido;
    }

    public String toString() {
        //La funcionalidad puede retornar varias opciones dependiendo de la reaccion
        //Si la reaccion corresponde a un comentario
        if (contenido != null) {
            return " Id: " + id + " | Tipo de reaccion: " + tipoReaccion + " | Reaccionado por: " + autor + " | En el dia: " + fecha +
                    "\n" + " Comentario: " + contenido + "\n";
        } else {//Si la reaccion corresponde a un ME GUSTA
            return " Id: " + id + " | Tipo de reaccion: " + tipoReaccion + " | Reaccionado por: " + autor + " | En el dia: " + fecha + "\n";
        }


    }

}
