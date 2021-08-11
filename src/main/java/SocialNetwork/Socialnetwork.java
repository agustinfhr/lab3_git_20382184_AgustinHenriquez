

package SocialNetwork;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Socialnetwork {
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Publicacion> publicaciones;
    private final ArrayList<Reaccion> reacciones;
    private final ArrayList<Usuario> usuarioActivo;

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

    public String toString() {
        return "\n\n---- Ususario registrados ----\n\n" + usuarios + "\n\n---- Publicaciones ----\n\n" + publicaciones;
    }

    public void register(Socialnetwork sn) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios();
        boolean registrar2 = false;

        while(!registrar2) {
            System.out.println("\n\n Ingrese nombre de usuario a registrar: ");
            String username = input1.next();
            System.out.println("\n Ingrese contrasenia a registrar: ");
            String password = input2.next();
            int id = getUsuarios().size() + 1;
            Usuario usuarioNuevo = new Usuario(username, password, id, (ArrayList)null, (ArrayList)null,(ArrayList)null);
            boolean encontrado = false;

            for (Usuario u : listaUsuarios) {

                if (u.getNombre().equals(usuarioNuevo.getNombre())) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("\n *** Nombre de Usuario ya registrado *** ");
            } else {
                listaUsuarios.add(usuarioNuevo);
                System.out.println("\n\n Se ha registrado con exito! ");
                registrar2 = true;
            }
        }
    }



    public static Socialnetwork sn1() {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        ArrayList<Usuario> usuarioActivo = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones = new ArrayList();
        ArrayList<Reaccion> listaReacciones = new ArrayList();

        ArrayList<String> follow1 = new ArrayList();
        ArrayList<String> follow2 = new ArrayList();
        ArrayList<String> follow3 = new ArrayList();
        ArrayList<String> follow4 = new ArrayList();
        ArrayList<String> follow5 = new ArrayList();

        follow1.add("Rodrigo");
        follow2.add("Agus");
        follow2.add("Pablo");
        follow3.add("Agus");
        follow4.add("Tefy");
        follow5.add("Rodrigo");

        Publicacion post1 = new Publicacion(1, (ArrayList)null, "texto", "Holaa", "10/Jul/2021", "Pablo");
        Publicacion post2 = new Publicacion(2, (ArrayList)null, "foto", "Hoy adopte un perrito", "12/Jul/2021", "Tefy");
        Publicacion post3 = new Publicacion(3, (ArrayList)null, "foto", "Aqui en la playaa B)", "12/Jul/2021", "Rodrigo");
        Publicacion post4 = new Publicacion(4, (ArrayList)null, "texto", "Alguien sabe usar Java?", "13/Jul/2021", "Agus");
        Publicacion post5 = new Publicacion(5, (ArrayList)null, "texto", "Nombres para un perrito gris?", "20/Jul/2021", "Tefy");
        Publicacion post6 = new Publicacion(6, (ArrayList)null, "video", "Aprendiendo a surfear", "28/Jul/2021", "Rodrigo");
        Publicacion post7 = new Publicacion(7, (ArrayList)null, "video", "Le enseñe a mi perrito a sentarse :)", "1/Ago/2021", "Tefy");
        Publicacion post8 = new Publicacion(8, (ArrayList)null, "foto", "Rico el dia para salir en bici", "1/Ago/2021", "Pablo");
        Publicacion post9 = new Publicacion(9, (ArrayList)null, "texto", "Este año habran fondas para el 18?", "2/Ago/2021", "Gaspi");
        Publicacion post10 = new Publicacion(10, (ArrayList)null, "texto", "Ya quiero puro salir de vacaciones", "3/Ago/2021", "Agus");

        Usuario user1 = new Usuario("Pablo", "4321", 1, (ArrayList)null, (ArrayList)null, follow1);
        Usuario user2 = new Usuario("Tefy", "5287", 2, (ArrayList)null, (ArrayList)null, follow2);
        Usuario user3 = new Usuario("Rodrigo", "9999", 3, (ArrayList)null, (ArrayList)null, follow3);
        Usuario user4 = new Usuario("Agus", "1234", 4, (ArrayList)null, (ArrayList)null, follow4);
        Usuario user5 = new Usuario("Gaspi", "1313", 5, (ArrayList)null, (ArrayList)null, follow5);

        ArrayList<Publicacion> listaPublicaciones1 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones2 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones3 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones4 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones5 = new ArrayList();

        Collections.addAll(listaPublicaciones1, new Publicacion[]{post1,post8});
        Collections.addAll(listaPublicaciones2, new Publicacion[]{post2,post5,post7});
        Collections.addAll(listaPublicaciones3, new Publicacion[]{post3,post6});
        Collections.addAll(listaPublicaciones4, new Publicacion[]{post4,post10});
        Collections.addAll(listaPublicaciones5, new Publicacion[]{post9});

        user1.setPublicaciones(listaPublicaciones1);
        user2.setPublicaciones(listaPublicaciones2);
        user3.setPublicaciones(listaPublicaciones3);
        user4.setPublicaciones(listaPublicaciones4);
        user5.setPublicaciones(listaPublicaciones5);

        Collections.addAll(listaUsuarios, new Usuario[]{user1,user2,user3,user4,user5});
        Collections.addAll(listaPublicaciones, new Publicacion[]{post1,post2,post3,post4,post5,post6,post7,post8,post9,post10});

        return new Socialnetwork(listaUsuarios,listaPublicaciones,listaReacciones,usuarioActivo);
    }
}
