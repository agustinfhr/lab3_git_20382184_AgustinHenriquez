package SocialNetwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Una clase para representar la red social SocialNetwork
 * Cada SocialNetwork queda determinado por los Usuarios, Publicaciones, Reacciones y Usuario activo
 *
 */

public class Socialnetwork {

    private final ArrayList<Usuario> usuarios; //Usuario de la red social
    private final ArrayList<Publicacion> publicaciones; //Publicaciones de la red social
    private ArrayList<Reaccion> reacciones; //Reacciones de la red social
    private final ArrayList<Usuario> usuarioActivo; //Usuario activo de la red social

    /**
     * Crea un SocialNetwork a partir de los parametros ingresados: Usuarios, Publicaciones, Reacciones y Usuario Activo
     * @param usuarios Usuarios del SocialNetwork
     * @param publicaciones Publicaciones del SocialNetwork
     * @param reacciones Reacciones del SocialNetwork
     * @param usuarioActivo Usuario activo del SocialNetwork
     */
    public Socialnetwork(ArrayList<Usuario> usuarios, ArrayList<Publicacion> publicaciones, ArrayList<Reaccion> reacciones, ArrayList<Usuario> usuarioActivo) {
        this.usuarios = usuarios;
        this.publicaciones = publicaciones;
        this.reacciones = reacciones;
        this.usuarioActivo = usuarioActivo;
    }

    /**
     * get Usuarios
     * @return Usuarios
     */

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    /**
     * get Publicaciones
     * @return Publicaciones
     */
    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }

    /**
     * get Reacciones
     * @return Reacciones
     */
    public ArrayList<Reaccion> getReacciones() {
        return this.reacciones;
    }

    /**
     * set Reacciones
     * @param reacciones
     */
    public void setReacciones(ArrayList<Reaccion> reacciones){
        this.reacciones = reacciones;
    }

    /**
     * get Usuario activo
     * @return Usuario activo
     */
    public ArrayList<Usuario> getUsuarioActivo() {
        return this.usuarioActivo;
    }

    /**
     * Crea el registro de un nuevo Usuario a la red social
     * @param sn SocialNetwork
     */
    public void register(Socialnetwork sn) {
        Scanner entrada1 = new Scanner(System.in); //Scanner para ingresar un nombre de Usuario a registrar
        Scanner entrada2 = new Scanner(System.in); //Scanner para ingresar una contrasenia a registrar
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios(); // Se obtienen los Usuarios de la red social
        boolean registrar = false;

        while(!registrar) {
            System.out.println("\n\n Ingrese nombre de usuario a registrar: ");
            String username = entrada1.next(); // Se ingresa nombre de usuario
            System.out.println("\n Ingrese contrasenia a registrar: ");
            String password = entrada2.next(); // se ingresa contrasenia
            int id = getUsuarios().size() + 1; // se asigna un nuevo id unico al usuario
            Usuario usuarioNuevo = new Usuario(username, password, id, (ArrayList)null, (ArrayList)null,(ArrayList)null); // Se crea al nuevo usuario
            boolean encontrado = false; // 'encontrado' ayudara a verificar si el usuario ingresado ya habia sido registrado

            for (Usuario u : listaUsuarios) { // ciclo for para recorrer los usuarios de la red social

                if (u.getNombre().equals(usuarioNuevo.getNombre())) { //si el nombre de usuario coincide con uno de la red social (es decir, que ya se encuentra registrado)
                    encontrado = true;                                // el verificador 'encontrado' cambiara a true
                    break;
                }
            }

            if (encontrado) { //Muestra error por intentar registrar un nombre de usuario ya registrado
                System.out.println("\n ***** Nombre de Usuario YA REGISTRADO ***** ");
            } else {
                listaUsuarios.add(usuarioNuevo); //Muestra mensaje de que el nuevo usuario se ha registrado con exito
                System.out.println("\n\n--> Se ha registrado a JAVAGRAM! <--");
                registrar = true; //Se termina el ciclo while
            }
        }
    }


    /**
     * Crea un SocialNetwork con 5 Usuarios registrados, 10 Publicaciones, mas de 3 Follows, y 1 Follow mutuo
     * @return Socialnetwork
     */
    public static Socialnetwork sn1() {
        // Se crean ArrayList para almacenar cada atributo de Socialnetwork
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        ArrayList<Usuario> usuarioActivo = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones = new ArrayList();
        ArrayList<Reaccion> listaReacciones = new ArrayList();

        // Se crean Arraylist para almacenar los Follows de cada Usuario
        ArrayList<String> follow1 = new ArrayList();
        ArrayList<String> follow2 = new ArrayList();
        ArrayList<String> follow3 = new ArrayList();
        ArrayList<String> follow4 = new ArrayList();
        ArrayList<String> follow5 = new ArrayList();

        // Se agregan los seguidores
        follow1.add("Rodrigo");
        follow2.add("Agus");
        follow2.add("Pablo");
        follow3.add("Agus");
        follow4.add("Tefy");
        follow5.add("Rodrigo");

        // Se crean las 10 Publicaciones
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

        // Se crean los 5 Usuarios
        Usuario user1 = new Usuario("Pablo", "4321", 1, (ArrayList)null, (ArrayList)null, follow1);
        Usuario user2 = new Usuario("Tefy", "5287", 2, (ArrayList)null, (ArrayList)null, follow2);
        Usuario user3 = new Usuario("Rodrigo", "9999", 3, (ArrayList)null, (ArrayList)null, follow3);
        Usuario user4 = new Usuario("Agus", "1234", 4, (ArrayList)null, (ArrayList)null, follow4);
        Usuario user5 = new Usuario("Gaspi", "1313", 5, (ArrayList)null, (ArrayList)null, follow5);

        // Se crean las publicaiones de cada Usuario
        ArrayList<Publicacion> listaPublicaciones1 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones2 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones3 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones4 = new ArrayList();
        ArrayList<Publicacion> listaPublicaciones5 = new ArrayList();

        //Se almacenan las publicaciones ya creadas en las listas de publicaciones de cada usuario
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

        //Se almacenan los usuarios
        Collections.addAll(listaUsuarios, new Usuario[]{user1,user2,user3,user4,user5});
        //Se almacenan la publicaciones
        Collections.addAll(listaPublicaciones, new Publicacion[]{post1,post2,post3,post4,post5,post6,post7,post8,post9,post10});
        // Se retorna el Socialnetwork con todos datos ya almacenados
        return new Socialnetwork(listaUsuarios,listaPublicaciones,listaReacciones,usuarioActivo);
    }
}
