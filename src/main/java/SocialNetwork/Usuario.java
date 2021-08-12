package SocialNetwork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Una clase para representar un Usuario dentro de la red social
 * Cada Usuario queda determinado por su Nombre, Contrasenia, Id, lista de Publicaciones, lista de Publicaciones compartidas y lista de Seguidores
 *
 */

public class Usuario {
    private final String nombre; //Nombre de usuario
    private final String contrasenia; //Contrasenia de usuario
    private final int id; //id unico del usuario
    private ArrayList<Publicacion> publicaciones; //publicaciones realizadas por el usuario o dirigidas hacia el usuario
    private ArrayList<Publicacion> publicacionesCompartidas; // publicaciones que fueron compartidas hacia el usuario
    private ArrayList<String> seguidores; // Seguidores del usuario

    /**
     * Crea un usuario a partir del nombre, contrasenia, id, publicaciones, publicaciones compartidas y seguidores
     * @param nombre nombre del usuario
     * @param contrasenia contrasenia del usuario
     * @param id id del usuario
     * @param publicaciones publicaciones del usuario
     * @param publicacionesCompartidas publicaciones compartidas del usuario
     * @param seguidores seguidores del usuario
     */
    public Usuario(String nombre, String contrasenia, int id, ArrayList<Publicacion> publicaciones, ArrayList<Publicacion> publicacionesCompartidas, ArrayList<String> seguidores) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.publicaciones = publicaciones;
        this.publicacionesCompartidas = publicacionesCompartidas;
        this.seguidores = seguidores;
    }

    /**
     * get nombre
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * get contrasenia
     * @return contrasenia
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * get publicaciones
     * @return publicaciones
     */
    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }

    /**
     * set publicaciones
     * @param publicaciones
     */
    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    /**
     * get publicaciones compartidas
     * @return publicaciones compartidas
     */
    public ArrayList<Publicacion> getPublicacionesCompartidas() {
        return this.publicacionesCompartidas;
    }

    /**
     * set publicaciones compartidas
     * @param publicacionesCompartidas
     */
    public void setPublicacionesCompartidas(ArrayList<Publicacion> publicacionesCompartidas) {
        this.publicacionesCompartidas = publicacionesCompartidas;
    }

    /**
     * get seguidores
      * @return seguidores
     */
    public ArrayList<String> getSeguidores() {
        return this.seguidores;
    }

    /**
     * set seguidores
     * @param seguidores
     */
    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }

    /**
     * Convierte los datos del Usuario a String
     * @return String
     */
    public String toString() {
        return "\t Nombre: " + nombre + "  Id: " + id + " \n Publicaciones: " + publicaciones + " \n Seguidores: " + seguidores + "\n Publicaciones Compartiedas: " + publicacionesCompartidas + "\n";
    }

    /**
     * Permite al usuario registrado en la red social ingresar a su sesion
      * @param sn SocialNetwork
     */
    public void login(Socialnetwork sn) {
        Scanner entrada1 = new Scanner(System.in); //Scanner para el nombre de usuario
        Scanner entrada2 = new Scanner(System.in); //Scanner para la contrasenia
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios(); //ArrayList con los usuarios de la red social
        ArrayList<Usuario> listaUsuarioActivo = sn.getUsuarioActivo(); //ArrayList donde estara el usuario activo
        boolean logear = false; //condicion para ciclo while

        while(true) {
            while (!logear) {
                boolean encontrado = false; //verificador para ver si el nombre de usuario se encuentra registrado en la red social
                System.out.println("\n\n Si desea salir del programa, ingrese salir");
                System.out.println(" Ingrese nombre de Usuario : \n");
                String username = entrada1.next(); //Se ingresa el nombre del usuario
                // Si el usuario ingresa salir, el programa termina de ejecutarse
                if (username.equals("salir")) {
                    System.exit(0);
                }

                System.out.println("\n Ingrese Contrasenia: \n");
                String password = entrada2.next(); //Se ingresa la contrasenia del usuario
                // Ciclo for para recorrer la lista de usuarios de la red social
                for (int i = 0; i < listaUsuarios.size(); ++i) {
                    String Username = listaUsuarios.get(i).getNombre();
                    String Password = listaUsuarios.get(i).getContrasenia();
                    // Si el nombre de usuario se encuentra registrado
                    if (username.equals(Username)) {
                        encontrado = true;
                        //Si la contrasenia del usuario se encuentra registrada
                        if (password.equals(Password)) {
                            System.out.println("\n\n--> Ha iniciado Sesion <--");
                            listaUsuarioActivo.add(listaUsuarios.get(i)); //se agrega el usuario logeado a la lista de usuario activo de la red social
                            listaUsuarios.remove(i); // se elimina el usuario logeado de la lista de usuarios de la red social

                            logear = true; //nombre y contrasenia coinciden con un usuario registrado y se termina el ciclo while
                        } else { //Mensaje de error si el usuario ingreso un nombre de usuario existente pero no una contrasenia correcta
                            System.out.printf("\n **** Contrasenia Incorrecta **** ");
                        }

                        break;
                    }
                }
                if (!logear && !encontrado) { //Mensaje de error si el usuario ingreso un nombre de usuario no existente en la red social
                    System.out.printf("\n **** Usuario no Registrado **** ");
                }
            }
            return;
        }

    }

    /**
     * Permite cerrar la sesion del usuario registrado en la red social
     * @param sn SocialNetwork
     */
    public void logout(Socialnetwork sn) {
        ArrayList<Usuario> usuarioActivo = sn.getUsuarioActivo();
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios();
        listaUsuarios.add(usuarioActivo.get(0)); //Se agrega el usuario activo a la lista de usuarios registrados
        usuarioActivo.remove(0);//Se elimina el usuario de la lista de usuarios activos
    }

    /**
     * Permite al usuario con sesion iniciada realizar una nueva publicacion
     * @param sn SocialNetwork
     */

    public void post(Socialnetwork sn) {

        LocalDate today = LocalDate.now(); //Obtener la fecha actual del sistema
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy")); //transformar la fecha a un String

        Scanner entrada1 = new Scanner(System.in); //Scanner para escanear el tipo de publicacion
        Scanner entrada2 = new Scanner(System.in); //Scanner para escanear el copntenido de la publicacion
        Scanner dirigidos = new Scanner(System.in); //Scanner para escanear a los usuarios que ira dirigido esta publicacion

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();  //ArrayList con el usuario activo de la red social
        ArrayList<Usuario> listaUserDisponibles = sn.getUsuarios(); //ArrayList con los usuarios registrados en la red social
        ArrayList<Publicacion> listaPublicaciones = sn.getPublicaciones(); //ArrayList con las publicaciones de la red social
        ArrayList<Publicacion> listaPublicacionesUser = getPublicaciones(); //ArrayList con las publicaciones del usuario activo

        int id = sn.getPublicaciones().size() + 1; //asignamos un nuevo id unico a la publicacion

        String nombreUsuario = UsuarioActivo.get(0).getNombre(); //obtenemos el nombre del usuario activo

        System.out.println("\n\n Ingrese el Tipo de publicacion: \n");
        String tipoPublicacion = entrada1.nextLine(); //Escaneamos el tipo de publicacion (texto,foto,video,etc)

        System.out.println("\n Ingrese el Contenido de la publicacion: \n");
        String contenido = entrada2.nextLine(); // Escaneamos el contenido de la publicacion

        Publicacion postNuevo = new Publicacion(id, (ArrayList)null, tipoPublicacion, contenido, fecha, nombreUsuario); //Se crea la nueva publicacion

        ArrayList<String> nuevaListUsers = new ArrayList<>(); //Creamos lista vacia para ingresar a los usuarios dirigidos

        boolean salir = false; //condicion para while

        while(!salir) {

            System.out.printf("\n\n Usuarios registrados"); //mostarmos al usuario activo todos los usuarios registrados en la red social
            for (Usuario listaUsuario : listaUserDisponibles){
                String nombreUsuarios = listaUsuario.getNombre();
                System.out.printf(" Nombre: " + nombreUsuarios);
            }

            System.out.printf("\n\n Ingrese un nombre para dirigir la publicacion ");
            System.out.printf("\n Si ya no desea dirigir la publicacion a mas usuarios, ingrese salir\n\n");
            String userDest = dirigidos.nextLine(); // El usuario activo ingresa un usuario al que quiere destinar la publicacion, si usuario no desea agregar mas usuario destinados ingresa salir

            Usuario u = new Usuario(userDest, null, 0, (ArrayList)null, (ArrayList)null, (ArrayList)null); //se crea un nuevo usuario para buscar ese usuario dirigido

            boolean encontrado = false; //verifica si se encontro al usuario dirigido

            for (Usuario u2 : listaUserDisponibles) { //se recorre la lista de usuario registrados en la red social
                if (u2.getNombre().equals(u.getNombre())) { //si el nombre del usuario dirigido coincide con un usuario registrado
                    nuevaListUsers.add(u2.getNombre());
                    ArrayList<Publicacion> publicacions = u2.getPublicaciones();
                    publicacions.add(postNuevo); //al usuario dirigido se le añade la nueva publicacion a su lista de publicaciones
                    System.out.printf("\n\n Usuarios dirigidos: \n " + nuevaListUsers.toString()); //se muestra en pantalla a la lista de usuario que fueron dirigidos
                    encontrado = true;
                }
            }
            //si el usuario ingreso salir o si ingreso un usuario no registrado en la red social
            if (!encontrado) {

                if (userDest.equals("salir")) { //se realiza la publicacion con o sin los usuarios dirigidos( si es que ingreso alguno)
                    listaPublicaciones.add(postNuevo); //se añade la nuevo publicacion a la lista de publicaciones de la red social
                    if (listaPublicacionesUser == null) { //si el usuario activo no tenia ninguna publicacion realizada
                        ArrayList<Publicacion> nuevasPublicaciones = new ArrayList<>(); // Se crea nueva lista de publicaciones
                        nuevasPublicaciones.add(postNuevo);  // se añade la nueva publicacion
                        UsuarioActivo.get(0).setPublicaciones(nuevasPublicaciones); //se hace un set a las publicaciones del usuario activo
                    } else {
                        listaPublicacionesUser.add(postNuevo); //si usuario activo ya tenia publicaciones simplemente se le añade la nueva publicacion
                    }

                    salir = true; //se termina el ciclo while
                    System.out.printf(sn.toString());
                    System.out.printf("\n\n -----> Publicacion creada exitosamente <-----");

                } else  { //si el usuario ingresado no se encuentra registrado
                    Scanner scan = new Scanner(System.in);
                    //muestra mensaje de error
                    System.out.printf("\n ***** Usuario NO existente *****");

                    System.out.printf("\n\n Usuarios dirigidos: \n " + nuevaListUsers.toString());
                }
            }
        }
    }

    /**
     * Permite al usuario con sesion iniciada seguir a un usuario registrado en la red social
     * @param sn SocialNetwork
     */
    public void follow(Socialnetwork sn){

        Scanner entrada1 = new Scanner(System.in); //Scanner para el nombre de usuario a seguir

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo(); //ArrayList con el usuario activo de la red social
        ArrayList<Usuario> listaUserDisponibles = sn.getUsuarios(); //ArrayList con los usuario registrados en la red social

        String nombreUsuario = UsuarioActivo.get(0).getNombre(); //Obtenemos nombre de usuario activo

        boolean salir = false;

        while(!salir) {

            System.out.printf("\n\n Usuarios registrados"); //mostramos al usuario activo los usuario registrados de la red social a los cuales puede seguir
            for (Usuario listaUsuario : listaUserDisponibles) {
                String nombreUsuarios = listaUsuario.getNombre();
                System.out.printf(" Nombre: " + nombreUsuarios);
            }

            System.out.println("\n\n Ingrese el nombre del Usuario a seguir: \n");
            System.out.println(" Si no desea seguir a un Usuario ingrese salir \n");
            String usuarioAseguir = entrada1.nextLine(); //Se escanea el nombre de usuario a seguir

            Usuario u = new Usuario(usuarioAseguir, null, 0, (ArrayList)null, (ArrayList)null, (ArrayList)null); // se crea usuario a seguir para buscar si se encuentra registrado

            if (usuarioAseguir.equals("salir")) { //si usuario activo no quiere seguir a otro usuario ingresa salir
                break;
            }
            boolean encontrado = false; //verifica si el usuario a seguir se encuentra registrado en la red social
            boolean yaSeguido = false; //verifica que el usuario activo no siga otra vez al mismo usuario

            for (Usuario u2 : listaUserDisponibles) { // se recorre la lista de usuarios registrados
                if (u2.getNombre().equals(u.getNombre())) {
                    ArrayList<String> seguidoresU2 = u2.getSeguidores();
                    if (seguidoresU2 != null) {
                        for (String name : seguidoresU2) {
                            if (nombreUsuario.equals(name)) {
                                //mensaje de error si el usuario a seguir ya es seguido por el usuario activo
                                System.out.printf("\n\n *** Error, Ya sigues a este Usuario! *** \n");
                                yaSeguido = true;

                            }
                        }
                    }
                    if (!yaSeguido) {
                        if (seguidoresU2 == null) { //si el usuario a seguir no tiene seguidores
                            ArrayList<String> nuevosSeguidores = new ArrayList<>();
                            nuevosSeguidores.add(nombreUsuario);
                            u2.setSeguidores(nuevosSeguidores); //se añade el nuevo seguir a la lista de seguidores del usuario a seguir
                        } else { // el usuario a seguir ya tenia seguidores
                            seguidoresU2.add(nombreUsuario);
                            u2.setSeguidores(seguidoresU2); //se añade el nuevo seguir a la lista de seguidores del usuario a seguir
                        }

                        System.out.printf("\n\n-----> Ahora sigues al Usuario " + usuarioAseguir + "! <-----\n"); //mensaje de confirmacion
                        encontrado = true;
                        salir = true;
                    }
                }
            }

            if (!encontrado && !yaSeguido) { //si el usuario a seguir no se encuentra registrado en la red social
                System.out.println("\n ***** Usuario a seguir no existe *****  ");
            }

        }

    }

    /**
     * Permite al usuario con sesion iniciada compartir una publicacion hacia otros usuarios registrados en la red social
     * @param sn SocialNetwork
     */
    public void share(Socialnetwork sn){

        LocalDate today = LocalDate.now(); //fecha del actual sistema
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy")); //fecha a String

        Scanner scan = new Scanner(System.in); //Scanner para escanear el id de la publicacion a compartir
        Scanner dirigidos = new Scanner(System.in); //Scanner para escanear el id de usuario a compartir

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo(); //ArrayList con el usuario activo de la red social
        ArrayList<Usuario> listaUserDisponibles = sn.getUsuarios(); //ArrayList con los usuario registrados en la red social
        ArrayList<Publicacion> listaPublicaciones = sn.getPublicaciones();  //ArrayList con las publicaciones de la red social

        Publicacion postShare = new Publicacion(0, (ArrayList) null, null, null, null, null); //se crea publicacion para almacenar la publicacion a buscar por su id unico

        String nombreUsuario = UsuarioActivo.get(0).getNombre(); // Se obtiene el nombre del usuario activo

        boolean salir = false;
        while (!salir) {

            System.out.printf("\n\n Publicaciones disponibles "); //Se muestra al usuario activo las publicaciones que puede compartir
            for (Publicacion Post : listaPublicaciones) {
                int idPost = Post.getId();
                String contenido = Post.getContenido();
                String autor = Post.getAutor();
                System.out.printf("\n ID: " + idPost + " | Autor: " + autor + " | Contenido: " + contenido);
            }

            System.out.println("\n\n Ingrese el ID de la publicacion a compartir: \n");
            int IDpost = scan.nextInt(); // Se escanea el id de la publicacion a compartir

            Publicacion post = new Publicacion(IDpost, (ArrayList) null, null, null, null, null); // Se crea publicacion a buscar

            boolean encontrado = false;

            for (Publicacion p : listaPublicaciones) { //se recorre la lista de publicaciones de la red social
                if (p.getId() == post.getId()) {
                    postShare = p;
                    salir = true;
                    encontrado = true; //se encuentra la publicacion
                }
            }
            if (!encontrado) { //mensaje de error si la publicacion no se encuentra en la red social
                System.out.println("\n\n ****** La Publicacion NO existe ****** \n");
            }
        }

        salir = false;
        ArrayList<String> nuevaListUsers = new ArrayList<>(); //arreglo para almacenar a los usuarios que les sera compartida la publicacion

        while (!salir) {

            System.out.printf("\n\n Usuarios registrados "); //Se muestra al usuario activo los usuario registrados a los cuales puede compartir la publicacion
            for (Usuario listaUsuario : listaUserDisponibles) {
                String nombreUsuarios = listaUsuario.getNombre();
                System.out.printf(" Nombre: " + nombreUsuarios);
            }

            System.out.println("\n\n Ingrese el nombre del Usuario a compartir: \n");
            System.out.println(" Si no desea compartir la publicacion a mas Usuarios ingrese salir \n");
            String usuarioShare = dirigidos.nextLine(); //Escanea el nombre de usuario a compartir

            Usuario u = new Usuario(usuarioShare, null, 0, (ArrayList)null, (ArrayList)null, (ArrayList)null); //se crea usuario a buscar para compartir publicacion

            if (usuarioShare.equals("salir")) { //si usuario ingresa salir
                break;
            }



            boolean encontrado = false;
            ArrayList<Publicacion> listaPost = new ArrayList<>();

            for (Usuario u2 : listaUserDisponibles) { //se recorre la lista de usuarios registrados
                if (u2.getNombre().equals(u.getNombre())) { //se encuentra al usuario registrado
                    nuevaListUsers.add(u2.getNombre());
                    ArrayList<Publicacion> listaPostShare = u2.getPublicacionesCompartidas();
                    if (listaPostShare == null){ //si el usuario a compartir no tiene ninguna publicacion compartida
                        postShare.setFechaShare(fecha);
                        postShare.setUsuarioShare(nombreUsuario);
                        listaPost.add(postShare);
                        u2.setPublicacionesCompartidas(listaPost);

                    } else { //si el usuario a compartir ya tiene publicaciones compartidas
                        postShare.setFechaShare(fecha);
                        postShare.setUsuarioShare(nombreUsuario);
                        listaPostShare.add(postShare);
                    }

                    System.out.printf("\n\n Usuarios a compartir: \n " + nuevaListUsers.toString()); //Se muestra los usuarios a compartir
                    encontrado = true;
                }
            }

            if (!encontrado) { //si el usuario a compartir no se encuentra registrado en la red social

                if (usuarioShare.equals("salir")) {

                    salir = true;
                    System.out.printf("\n\n -----> Se ha compartido la Publicacion <-----");

                } else  {
                    //Mensaje de error usuario a compartir no se encuentra registrado
                    System.out.printf("\n ****** Usuario NO existente ******");

                    System.out.printf("\n\n Usuarios a compartir: \n " + nuevaListUsers.toString());
                }
            }


        }

    }

    /**
     * Crea un Strig a partir de la red social SocialNetwork
     * @param sn SocialNetwork
     * @return String
     */
    public String SocialNetworkToString(Socialnetwork sn) {

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        ArrayList<Publicacion> publicaciones = UsuarioActivo.get(0).getPublicaciones();
        ArrayList<String> seguidores = UsuarioActivo.get(0).getSeguidores();
        ArrayList<Publicacion> publicacionesCompartidas = UsuarioActivo.get(0).getPublicacionesCompartidas();
        String nombreUsuario = UsuarioActivo.get(0).getNombre();
        String sn0 = "\n ####### Visualizando sesion de Usuario: " + nombreUsuario + " #######\n";
        String sn1;
        String sn2;
        String sn3;

        if (publicaciones == null) {
            sn1 = "\n ---- Tus Publicaciones ---- \n\n" + " No tienes Publicaciones\n";
        } else {
            sn1 = "\n ---- Tus Publicaciones ---- \n\n" + publicaciones.toString();
        }

        if (seguidores == null) {
            sn2 = "\n ---- Tus Seguidores ---- \n\n" + " No tienes Seguidores\n";
        } else {
            sn2 = "\n ---- Tus Seguidores ---- \n\n" + seguidores;
        }

        if (publicacionesCompartidas == null) {
            sn3 = "\n ---- Publicaciones que te compartieron ---- \n\n" + " No tienes Publicaciones compartidas\n";
        } else {
            sn3 = "\n ---- Publicaciones que te compartieron ---- \n\n" + publicacionesCompartidas.toString();

        }
        String socialNetwork = sn0 + sn1 + sn2 + sn3;
        return socialNetwork;
    }

    /**
     * Permite al usuario con sesion iniciada visualizar los datos de su sesion de la red social
     * @param sn SocialNetwork
     */
    public void PrintSocialNetwork(Socialnetwork sn) {

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        String SN = UsuarioActivo.get(0).SocialNetworkToString(sn);
        System.out.printf(SN);

    }

    /**
     * Permite al usuario con sesion iniciada realizar un comentario a una publicacion en la red social
     * @param sn SocialNetwork
     */
    public void comment(Socialnetwork sn) {

        LocalDate today = LocalDate.now();  //fecha del actual sistema
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy")); // fecha a String

        Scanner scan = new Scanner(System.in); //Scanner para escanear el id de la publicacion a comentar
        Scanner texto = new Scanner(System.in); //Scanner para escanear el contenido del comentario ingresado por el usuario activo

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        ArrayList<Publicacion> listaPublicaciones = sn.getPublicaciones();

        Publicacion postComment = new Publicacion(0, (ArrayList) null, null, null, null, null); // Se crea publicacion para almacenar la publicacion a buscar para comentar

        String nombreUsuario = UsuarioActivo.get(0).getNombre(); // Se obtiene nombre de usuario activo

        boolean salir = false;
        while (!salir) {

            System.out.printf("\n\n Publicaciones disponibles "); //Se muestra al usuario activo las publicaciones que puede comentar
            for (Publicacion Post : listaPublicaciones) {
                int idPost = Post.getId();
                String contenido = Post.getContenido();
                String autor = Post.getAutor();
                System.out.printf("\n ID: " + idPost + " | Autor: " + autor + " | Contenido: " + contenido);
            }

            System.out.println("\n\n Ingrese el ID de la publicacion a comentar: \n");
            int IDpost = scan.nextInt(); // se escanea el id de la publicacion a comentar

            Publicacion post = new Publicacion(IDpost, (ArrayList) null, null, null, null, null); //se crea publicacion para buscar la publicacion a comentar

            boolean encontrado = false;

            for (Publicacion p : listaPublicaciones) { // se recorre la lista de publicaciones registradas en la red social
                if (p.getId() == post.getId()) { // se encuentra la publicacion
                    postComment = p;
                    salir = true;
                    encontrado = true;
                }
            }
            if (!encontrado) { //mensaje de error la publicacion a comentar no se encuentra registrada
                System.out.println("\n\n ****** La Publicacion NO existe ****** \n");
            }
        }

        System.out.printf("\n Ingrese el Comentario: \n");
        String comentario = texto.nextLine(); // Se escanea el comentario del usuario activo

        if (postComment.getReacciones() == null) { //si la publicacion NO tiene reacciones
            if (sn.getReacciones() == null) { //si la red social NO existen reacciones
                Reaccion comment = new Reaccion(1, nombreUsuario, fecha, "comentario", comentario);
                ArrayList<Reaccion> reacciones = new ArrayList<>();
                reacciones.add(comment);
                postComment.setReacciones(reacciones); //Se añade el comentario a la publicacion
                sn.setReacciones(reacciones);  //se añade la reaccion a la lista de reacciones de la red social
            } else { // si la publicacion NO tiene reacciones Y la red social existen reacciones
                int id = sn.getReacciones().size() + 1; //id unico para el comentario
                Reaccion comment = new Reaccion(id, nombreUsuario, fecha, "comentario", comentario);
                ArrayList<Reaccion> reacciones = new ArrayList<>();
                reacciones.add(comment);
                postComment.setReacciones(reacciones); //Se añade el comentario a la publicacion
                ArrayList<Reaccion> reaccionesSn = sn.getReacciones();
                reaccionesSn.add(comment); //se añade la reaccion a la lista de reacciones de la red social
            }

        } else { //Si la publicacion tiene reacciones previas
            int id = sn.getReacciones().size() + 1; //asignar id unico
            Reaccion comment = new Reaccion(id, nombreUsuario, fecha, "comentario", comentario); //nueva reaccion
            ArrayList<Reaccion> reacciones = postComment.getReacciones();
            reacciones.add(comment); // se añade el comentario a la lista de reacciones
            ArrayList<Reaccion> reaccionesSn = sn.getReacciones();
            reaccionesSn.add(comment); //se añade la reaccion a la lista de reacciones de la red social
        }
        System.out.printf("\n\n -----> Se ha creado el Comentario <----- \n");

    }

    /**
     * Permite al usuario con sesion iniciada dar un ME GUSTA a una publicacion en la red social
     * @param sn SocialNetwork
     */
    public void like(Socialnetwork sn) {

        LocalDate today = LocalDate.now(); //fecha del actual sistema
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy")); //fecha a String

        Scanner scan = new Scanner(System.in); //Scanner para scanear el id de la publicacion a dar ME GUSTA

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        ArrayList<Publicacion> listaPublicaciones = sn.getPublicaciones();

        Publicacion postLike = new Publicacion(0, (ArrayList) null, null, null, null, null); // se crea una publicacion para almacenar la publicacion que se busca para dar ME GUSTA

        String nombreUsuario = UsuarioActivo.get(0).getNombre(); // Se obtiene el nombre del usuario activo

        boolean salir = false;
        while (!salir) {

            System.out.printf("\n\n Publicaciones disponibles "); //Se muestra al usuario activo las publicaciones que puede dar ME GUSTA
            for (Publicacion Post : listaPublicaciones) {
                int idPost = Post.getId();
                String contenido = Post.getContenido();
                String autor = Post.getAutor();
                System.out.printf("\n ID: " + idPost + " | Autor: " + autor + " | Contenido: " + contenido);
            }

            System.out.println("\n\n Ingrese el ID de la publicacion a dar ME GUSTA: \n");
            int IDpost = scan.nextInt(); // Se escanea el id de la publicacion a dar ME GUSTA

            Publicacion post = new Publicacion(IDpost, (ArrayList) null, null, null, null, null); // se crea publicacion a buscar

            boolean encontrado = false;

            for (Publicacion p : listaPublicaciones) { // se recorre la lista de publicaciones registradas en la red social
                if (p.getId() == post.getId()) { // se encuentra la publicacion
                    postLike = p;
                    salir = true;
                    encontrado = true;
                }
            }
            if (!encontrado) { //mensaje de error la publicacion no se encuentra registrada
                System.out.println("\n\n ****** La Publicacion NO existe ****** \n");
            }
        }

        if (postLike.getReacciones() == null) { //si la publicacion NO tiene reacciones
            if (sn.getReacciones() == null) { //si la red social NO existen reacciones
                Reaccion like = new Reaccion(1, nombreUsuario, fecha, "me gusta", null);
                ArrayList<Reaccion> reacciones = new ArrayList<>();
                reacciones.add(like);
                postLike.setReacciones(reacciones); //se añade el ME GUSTA a las reacciones de la publicacion
                sn.setReacciones(reacciones);   //se añade el ME GUSTA a las reacciones de la red social
            } else { // si la publicacion NO tiene reacciones Y la red social existen reacciones
                int id = sn.getReacciones().size() + 1;
                Reaccion like = new Reaccion(id, nombreUsuario, fecha, "me gusta", null);
                ArrayList<Reaccion> reacciones = new ArrayList<>();
                reacciones.add(like);
                postLike.setReacciones(reacciones); //se añade el ME GUSTA a las reacciones de la publicacion
                ArrayList<Reaccion> reaccionesSn = sn.getReacciones();
                reaccionesSn.add(like); //se añade el ME GUSTA a las reacciones de la red social
            }

        } else { //Si la publicacion tiene reacciones previas
            int id = sn.getReacciones().size() + 1;
            Reaccion like = new Reaccion(id, nombreUsuario, fecha, "me gusta", null);
            ArrayList<Reaccion> reacciones = postLike.getReacciones();
            reacciones.add(like);//se añade el ME GUSTA a las reacciones de la publicacion
            ArrayList<Reaccion> reaccionesSn = sn.getReacciones();
            reaccionesSn.add(like);//se añade el ME GUSTA a las reacciones de la red social
        }
        System.out.printf("\n\n -----> Se ha realizado un ME GUSTA <----- \n");


    }




}