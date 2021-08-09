package SocialNetwork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Usuario {
    private final String nombre;
    private final String contrasenia;
    private final int id;
    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Publicacion> publicacionesCompartidas;
    private String[] seguidores;

    public Usuario(String nombre, String contrasenia, int id, ArrayList<Publicacion> publicaciones, ArrayList<Publicacion> publicacionesCompartidas, String[] seguidores) {
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

    public String[] getSeguidores() {
        return this.seguidores;
    }

    public void setSeguidores(String[] seguidores) {
        this.seguidores = seguidores;
    }

    public String toString() {
        return "\t{ Nombre : '" + this.nombre + "' , Contrasenia : '" + this.contrasenia + "' , Id : " + this.id + " } \n";
    }

    public void login(Socialnetwork sn) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios();
        ArrayList<Usuario> listaUsuarioActivo = sn.getUsuarioActivo();
        boolean logear = false;

        while(true) {
            while (!logear) {
                System.out.println("\n\n Si desea salir del programa, ingrese salir");
                System.out.println(" Ingrese nombre de Usuario : \n");
                String username = input1.next();
                if (username.equals("salir")) {
                    System.exit(0);
                }

                System.out.println("\n Ingrese Contrasenia: \n");
                String password = input2.next();

                for (int i = 0; i < listaUsuarios.size(); ++i) {
                    String Username = ((Usuario) listaUsuarios.get(i)).getNombre();
                    String Password = ((Usuario) listaUsuarios.get(i)).getContrasenia();
                    if (username.equals(Username)) {
                        if (password.equals(Password)) {
                            System.out.println("\n\n Ha iniciado Sesion ");
                            listaUsuarioActivo.add((Usuario) listaUsuarios.get(i));
                            listaUsuarios.remove(i);
                            System.out.println(sn.toString());
                            logear = true;
                        }

                        break;
                    }
                }
            }
            return;
        }

    }

    public void logout(Socialnetwork sn) {
        ArrayList<Usuario> usuarioActivo = sn.getUsuarioActivo();
        ArrayList<Usuario> listaUsuarios = sn.getUsuarios();
        listaUsuarios.add((Usuario)usuarioActivo.get(0));
        usuarioActivo.remove(0);
    }

    public void post(Socialnetwork sn) {
        LocalDate today = LocalDate.now();
        String fecha = today.format(DateTimeFormatter.ofPattern("dd/MMM/yy"));


    }



}