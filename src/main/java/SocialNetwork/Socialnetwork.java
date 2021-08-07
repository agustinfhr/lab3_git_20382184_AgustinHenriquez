

package SocialNetwork;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

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





    public static Socialnetwork sn1() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones1 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones2 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones3 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones4 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones5 = new ArrayList();
        ArrayList<Publicacion> listaPublicacionesCompartidas1 = new ArrayList();
        ArrayList<Publicacion> listaPublicacionesCompartidas2 = new ArrayList();
        ArrayList<Publicacion> listaPublicacionesCompartidas3 = new ArrayList();
        ArrayList<Publicacion> listaPublicacionesCompartidas4 = new ArrayList();
        ArrayList<Publicacion> listaPublicacionesCompartidas5 = new ArrayList();
        ArrayList<Reaccion> listaReacciones = new ArrayList();
        ArrayList<Reaccion> listaReacciones1 = new ArrayList();
        ArrayList<Reaccion> listaReacciones2 = new ArrayList();
        ArrayList<Reaccion> listaReacciones3 = new ArrayList();
        ArrayList<Reaccion> listaReacciones4 = new ArrayList();
        ArrayList<Reaccion> listaReacciones5 = new ArrayList();
        ArrayList<Reaccion> listaReacciones6 = new ArrayList();
        ArrayList<Reaccion> listaReacciones7 = new ArrayList();
        ArrayList<Reaccion> listaReacciones8 = new ArrayList();
        ArrayList<Reaccion> listaReacciones9 = new ArrayList();
        ArrayList<Reaccion> listaReacciones10 = new ArrayList();

        ArrayList<Usuario> usuarioActivo = new ArrayList();

        String[] Follow1 = new String[1];
        String[] Follow2 = new String[2];
        String[] Follow3 = new String[1];
        String[] Follow4 = new String[1];
        String[] Follow5 = new String[1];

        Follow1[0] = "Rodrigo";
        Follow2[0] = "Agus";
        Follow2[1] = "Pablo";
        Follow3[0] = "Agus";
        Follow4[0] = "Tefy";
        Follow5[0] = "Rodrigo";

        Publicacion post1 = new Publicacion(1, listaReacciones1, "texto", "Holaa", "30/Jul/2021", "Pablo");
        Publicacion post2 = new Publicacion(2, listaReacciones2, "foto", "Hoy adopte un perrito", "02/Ago/2021", "Tefy");
        Publicacion post3 = new Publicacion(3, listaReacciones3, "foto", "Aqui en la playaa B)", "02/Ago/2021", "Rodrigo");
        Publicacion post4 = new Publicacion(4, listaReacciones4, "texto", "Alguien sabe usar Java?", "03/Ago/2021", "Agus");
        Publicacion post5 = new Publicacion(5, listaReacciones5, "texto", "Nombres para un perrito gris?", "03/Ago/2021", "Tefy");
        Publicacion post6 = new Publicacion(6, listaReacciones6, "video", "Aprendiendo a surfear", "04/Ago/2021", "Rodrigo");
        Publicacion post7 = new Publicacion(7, listaReacciones7, "video", "Le enseñe a mi perrito a sentarse :)", "08/Ago/2021", "Tefy");
        Publicacion post8 = new Publicacion(8, listaReacciones8, "foto", "Rico el dia para salir en bici", "12/Ago/2021", "Pablo");
        Publicacion post9 = new Publicacion(9, listaReacciones9, "texto", "Este año habran fondas para el 18?", "18/Ago/2021", "Gaspi");
        Publicacion post10 = new Publicacion(10, listaReacciones10, "texto", "Ya quiero puro salir de vacaciones", "19/Ago/2021", "Agus");

        Collections.addAll(listaPublicaciones1, new Publicacion[]{post1, post8});
        Collections.addAll(listaPublicaciones2, new Publicacion[]{post2, post5, post7});
        Collections.addAll(listaPublicaciones3, new Publicacion[]{post3, post6});
        Collections.addAll(listaPublicaciones4, new Publicacion[]{post4, post10});
        Collections.addAll(listaPublicaciones5, new Publicacion[]{post9});

        Usuario user1 = new Usuario("Pablo", "4321", 1, listaPublicaciones1, listaPublicacionesCompartidas1, Follow1);
        Usuario user2 = new Usuario("Tefy", "5287", 2, listaPublicaciones2, listaPublicacionesCompartidas2, Follow2);
        Usuario user3 = new Usuario("Rodrigo", "9999", 3, listaPublicaciones3, listaPublicacionesCompartidas3, Follow3);
        Usuario user4 = new Usuario("Agus", "1234", 4, listaPublicaciones4, listaPublicacionesCompartidas4, Follow4);
        Usuario user5 = new Usuario("Gaspi", "1313", 5, listaPublicaciones5, listaPublicacionesCompartidas5, Follow5);

        Collections.addAll(listaUsuarios, new Usuario[]{user1,user2,user3,user4,user5});
        Collections.addAll(listaPublicaciones, new Publicacion[]{post1,post2,post3,post4,post5,post6,post7,post8,post9,post10});

        return new Socialnetwork(listaUsuarios,listaPublicaciones,listaReacciones,usuarioActivo);
    }
}
