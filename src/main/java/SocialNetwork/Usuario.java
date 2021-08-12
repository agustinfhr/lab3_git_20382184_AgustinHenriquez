package SocialNetwork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private final String nombre;
    private final String contrasenia;
    private final int id;
    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Publicacion> publicacionesCompartidas;
    private ArrayList<String> seguidores;

    public Usuario(String nombre, String contrasenia, int id, ArrayList<Publicacion> publicaciones, ArrayList<Publicacion> publicacionesCompartidas, ArrayList<String> seguidores) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.publicaciones = publicaciones;
        this.publicacionesCompartidas = publicacionesCompartidas;
        this.seguidores = seguidores;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return this.publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public ArrayList<Publicacion> getPublicacionesCompartidas() {
        return this.publicacionesCompartidas;
    }

    public void setPublicacionesCompartidas(ArrayList<Publicacion> publicacionesCompartidas) {
        this.publicacionesCompartidas = publicacionesCompartidas;
    }

    public ArrayList<String> getSeguidores() {
        return this.seguidores;
    }

    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }

    public String toString() {
        return "\t Nombre: " + nombre + "  Id: " + id + " \n Publicaciones: " + publicaciones + " \n Seguidores: " + seguidores + "\n Publicaciones Compartiedas: " + publicacionesCompartidas + "\n";
    }

    public void login(Socialnetwork sn) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios();
        ArrayList<Usuario> listaUsuarioActivo = sn.getUsuarioActivo();
        boolean logear = false;

        while(true) {
            while (!logear) {
                boolean encontrado = false;
                System.out.println("\n\n Si desea salir del programa, ingrese salir");
                System.out.println(" Ingrese nombre de Usuario : \n");
                String username = input1.next();
                if (username.equals("salir")) {
                    System.exit(0);
                }

                System.out.println("\n Ingrese Contrasenia: \n");
                String password = input2.next();

                for (int i = 0; i < listaUsuarios.size(); ++i) {
                    String Username = listaUsuarios.get(i).getNombre();
                    String Password = listaUsuarios.get(i).getContrasenia();
                    if (username.equals(Username)) {
                        encontrado = true;
                        if (password.equals(Password)) {
                            System.out.println("\n\n Ha iniciado Sesion ");
                            listaUsuarioActivo.add(listaUsuarios.get(i));
                            listaUsuarios.remove(i);
                            System.out.println(sn.toString());
                            logear = true;
                        } else {
                            System.out.printf("\n **** Contrasenia Incorrecta **** ");
                        }

                        break;
                    }
                }
                if (!logear && !encontrado) {
                    System.out.printf("\n **** Usuario no Registrado **** ");
                }
            }
            return;
        }

    }

    public void logout(Socialnetwork sn) {
        ArrayList<Usuario> usuarioActivo = sn.getUsuarioActivo();
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios();
        listaUsuarios.add(usuarioActivo.get(0));
        usuarioActivo.remove(0);
    }


    public void post(Socialnetwork sn) {

        LocalDate today = LocalDate.now();
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy"));

        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        Scanner dirigidos = new Scanner(System.in);

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        ArrayList<Usuario> listaUserDisponibles = sn.getUsuarios();
        ArrayList<Publicacion> listaPublicaciones = sn.getPublicaciones();
        ArrayList<Publicacion> listaPublicacionesUser = getPublicaciones();

        int id = sn.getPublicaciones().size() + 1;

        String nombreUsuario = UsuarioActivo.get(0).getNombre();

        System.out.println("\n\n Ingrese el Tipo de publicacion: \n");
        String tipoPublicacion = entrada1.nextLine();

        System.out.println("\n Ingrese el Contenido de la publicacion: \n");
        String contenido = entrada2.nextLine();

        Publicacion postNuevo = new Publicacion(id, (ArrayList)null, tipoPublicacion, contenido, fecha, nombreUsuario);

        ArrayList<Usuario> nuevaListUsers = new ArrayList<>();

        boolean salir = false;

        while(!salir) {

            System.out.printf("\n\n Usuarios registrados");
            for (Usuario listaUsuario : listaUserDisponibles){
                String nombreUsuarios = listaUsuario.getNombre();
                System.out.printf(" Nombre: " + nombreUsuarios);
            }

            System.out.printf("\n\n Ingrese un nombre para dirigir la publicacion ");
            System.out.printf("\n Si ya no desea dirigir la publicacion a mas usuarios, ingrese salir\n\n");
            String userDest = dirigidos.nextLine();

            Usuario u = new Usuario(userDest, null, 0, (ArrayList)null, (ArrayList)null, (ArrayList)null);

            boolean encontrado = false;

            for (Usuario u2 : listaUserDisponibles) {
                if (u2.getNombre().equals(u.getNombre())) {
                    nuevaListUsers.add(u2);
                    ArrayList<Publicacion> publicacions = u2.getPublicaciones();
                    publicacions.add(postNuevo);
                    System.out.printf("\n\n Usuarios dirigidos: \n " + nuevaListUsers.toString());
                    encontrado = true;
                }
            }

            if (!encontrado) {

                if (userDest.equals("salir")) {
                    listaPublicaciones.add(postNuevo);
                    if (listaPublicacionesUser == null) {
                        ArrayList<Publicacion> nuevasPublicaciones = new ArrayList<>();
                        nuevasPublicaciones.add(postNuevo);
                        UsuarioActivo.get(0).setPublicaciones(nuevasPublicaciones);
                    } else {
                        listaPublicacionesUser.add(postNuevo);
                    }

                    salir = true;
                    System.out.printf(sn.toString());
                    System.out.printf("\n\n ----- Publicacion creada exitosamente -----");

                } else  {
                    Scanner scan = new Scanner(System.in);

                    System.out.printf("\n *** Error, Usuario no existente ***");

                    System.out.printf("\n\n Usuarios dirigidos: \n " + nuevaListUsers.toString());
                }
            }
        }
    }

    public void follow(Socialnetwork sn){

        Scanner entrada1 = new Scanner(System.in);

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        ArrayList<Usuario> listaUserDisponibles = sn.getUsuarios();

        String nombreUsuario = UsuarioActivo.get(0).getNombre();

        boolean salir = false;

        while(!salir) {

            System.out.printf("\n\n Usuarios registrados");
            for (Usuario listaUsuario : listaUserDisponibles) {
                String nombreUsuarios = listaUsuario.getNombre();
                System.out.printf(" Nombre: " + nombreUsuarios);
            }

            System.out.println("\n\n Ingrese el nombre del Usuario a seguir: \n");
            System.out.println(" Si no desea seguir a un Usuario ingrese salir \n");
            String usuarioAseguir = entrada1.nextLine();

            Usuario u = new Usuario(usuarioAseguir, null, 0, (ArrayList)null, (ArrayList)null, (ArrayList)null);

            if (usuarioAseguir.equals("salir")) {
                break;
            }
            boolean encontrado = false;
            boolean yaSeguido = false;

            for (Usuario u2 : listaUserDisponibles) {
                if (u2.getNombre().equals(u.getNombre())) {
                    ArrayList<String> seguidoresU2 = u2.getSeguidores();
                    if (seguidoresU2 != null) {
                        for (String name : seguidoresU2) {
                            if (nombreUsuario.equals(name)) {
                                System.out.printf("\n\n *** Error, Ya sigues a este Usuario! *** \n");
                                yaSeguido = true;

                            }
                        }
                    }
                    if (!yaSeguido) {
                        if (seguidoresU2 == null) {
                            ArrayList<String> nuevosSeguidores = new ArrayList<>();
                            nuevosSeguidores.add(nombreUsuario);
                            u2.setSeguidores(nuevosSeguidores);
                        } else {
                            seguidoresU2.add(nombreUsuario);
                            u2.setSeguidores(seguidoresU2);
                        }

                        System.out.printf("\n\n Ahora sigues al Usuario " + usuarioAseguir + "! \n");
                        encontrado = true;
                        salir = true;
                    }
                }
            }

            if (!encontrado && !yaSeguido) {
                System.out.println("\n **** Error el Usuario a seguir no existe ****  ");
            }

        }

    }

    public void share(Socialnetwork sn){

        LocalDate today = LocalDate.now();
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy"));

        Scanner scan = new Scanner(System.in); //id post
        Scanner dirigidos = new Scanner(System.in);

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        ArrayList<Usuario> listaUserDisponibles = sn.getUsuarios();
        ArrayList<Publicacion> listaPublicaciones = sn.getPublicaciones();

        Publicacion postShare = new Publicacion(0, (ArrayList) null, null, null, null, null);

        String nombreUsuario = UsuarioActivo.get(0).getNombre();

        boolean salir = false;
        while (!salir) {

            System.out.printf("\n\n Publicaciones disponibles ");
            for (Publicacion Post : listaPublicaciones) {
                int idPost = Post.getId();
                String contenido = Post.getContenido();
                System.out.printf("\n ID: " + idPost + " Contenido: " + contenido);
            }

            System.out.println("\n\n Ingrese el ID de la publicacion a compartir: \n");
            int IDpost = scan.nextInt();

            Publicacion post = new Publicacion(IDpost, (ArrayList) null, null, null, null, null);

            boolean encontrado = false;

            for (Publicacion p : listaPublicaciones) {
                if (p.getId() == post.getId()) {
                    postShare = p;
                    salir = true;
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("\n\n **** Error, la Publicacion no existe **** \n");
            }
        }

        salir = false;
        while (!salir) {

            System.out.printf("\n\n Usuarios registrados ");
            for (Usuario listaUsuario : listaUserDisponibles) {
                String nombreUsuarios = listaUsuario.getNombre();
                System.out.printf(" Nombre: " + nombreUsuarios);
            }

            System.out.println("\n\n Ingrese el nombre del Usuario a compartir: \n");
            System.out.println(" Si no desea compartir la publicacion a mas Usuarios ingrese salir \n");
            String usuarioShare = dirigidos.nextLine();

            Usuario u = new Usuario(usuarioShare, null, 0, (ArrayList)null, (ArrayList)null, (ArrayList)null);

            if (usuarioShare.equals("salir")) {
                break;
            }

            ArrayList<Usuario> nuevaListUsers = new ArrayList<>();

            boolean encontrado = false;
            ArrayList<Publicacion> listaPost = new ArrayList<>();

            for (Usuario u2 : listaUserDisponibles) {
                if (u2.getNombre().equals(u.getNombre())) {
                    nuevaListUsers.add(u2);
                    ArrayList<Publicacion> listaPostShare = u2.getPublicacionesCompartidas();
                    if (listaPostShare == null){
                        postShare.setFechaShare(fecha);
                        postShare.setUsuarioShare(nombreUsuario);
                        listaPost.add(postShare);
                        u2.setPublicacionesCompartidas(listaPost);

                    } else {
                        postShare.setFechaShare(fecha);
                        postShare.setUsuarioShare(nombreUsuario);
                        listaPostShare.add(postShare);
                    }

                    System.out.printf("\n\n Usuarios a compartir: \n " + nuevaListUsers.toString());
                    encontrado = true;
                }
            }

            if (!encontrado) {

                if (usuarioShare.equals("salir")) {

                    salir = true;
                    System.out.printf("\n\n ----- Se ha compartido la Publicacion -----");

                } else  {

                    System.out.printf("\n *** Error, Usuario no existente ***");

                    System.out.printf("\n\n Usuarios a compartir: \n " + nuevaListUsers.toString());
                }
            }


        }

    }

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

    public void PrintSocialNetwork(Socialnetwork sn) {

        ArrayList<Usuario> UsuarioActivo = sn.getUsuarioActivo();
        String SN = UsuarioActivo.get(0).SocialNetworkToString(sn);
        System.out.printf(SN);

    }

  






}