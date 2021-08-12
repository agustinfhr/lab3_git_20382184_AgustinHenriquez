package SocialNetwork;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Una clase para representar un menu en el SocialNetwork
 * Cada menu queda determinado por el valor que ingrese el usuario al iniciar el programa
 * @version final
 * @author Agustin Henriquez
 */


public class Main {

    /**
     * El programa parte ejecutando el menu con el cual el usuario puede interactuar seleccionando las opciones de authentication
     * @param args argumentos
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Socialnetwork sn = Socialnetwork.sn1(); //Se Inicializara un SocialNetwork con elementos poblados
        boolean salir = false; //Condicion para mantener el ciclo while mientras el usuario seleccione una opcion correcta

        while(!salir) {
            System.out.println("\n BIENVENIDO A \n");
            System.out.println("      ##   #####   ##    ##   #####    ######   ######    #####   ###    ###   \n" +
                               "      ##  ##   ##  ##    ##  ##   ##  ##        ##   ##  ##   ##  ####  ####   \n" +
                               "      ##  ##   ##  ##    ##  ##   ##  ##        ##   ##  ##   ##  ####  ####   \n" +
                               "      ##  #######   ##  ##   #######  ##   ##   #####    #######  ## #### ##   \n" +
                               " ##   ##  ##   ##    ####    ##   ##  ##    ##  ##   ##  ##   ##  ##  ##  ##   \n" +
                               "  #####   ##   ##     ##     ##   ##   ######   ##   ##  ##   ##  ##      ##   \n" +
                               "                                                                        ");
            System.out.println(" Escoja una opcion: ");
            System.out.println(" 1. Iniciar Sesion");
            System.out.println(" 2. Registrarse ");
            System.out.println(" 3. Salir del programa \n");
            System.out.println("Ingrese opcion: \n");

            try {
                int opcion = scan.nextInt(); // Se guarda en 'opcion' el valor ingresado por el usuario
                switch(opcion) {
                    case 1: // opcion login
                        System.out.println("\n--> Ha elegido la opcion INICIAR SESION <--");
                        Usuario usuario = new Usuario(" ", " ", 0, (ArrayList)null, (ArrayList)null, (ArrayList)null);
                        usuario.login(sn);
                        menu(sn);
                        break;
                    case 2: // opcion register
                        System.out.println("\n--> Ha elegido la opcion REGISTRARSE <--");
                        sn.register(sn);
                        System.out.println("\n\n Inicie Sesion para confirmar el Registro ");
                        break;
                    case 3: // opcion salir
                        System.out.println("--> Ha salido del Programa <--");
                        salir = true;
                        break;
                    default: // Muestra error si usuario escoje un numero no valido en las opciones
                        System.out.println("\n\n*****  Ingrese un numero entre 1 y 3 *****");
                    }
                } catch (InputMismatchException fail) { // Muestra error si usuario no ingresa un numero
                    System.out.println("\n\n***** DEBE INGRESAR UN NUMERO *****");
                    scan.next();
                }
            }

        }


    /**
     * Crea un menu al iniciar el programa con el que Usuario puede interactuar con la red social
     * @param sn SocianNetwork (abreviado en sn)
     */
    public static void menu(Socialnetwork sn) {
        Scanner scan = new Scanner(System.in); // Scanner para la opcion del Usuario activo
        Usuario usuarioActivo = sn.getUsuarioActivo().get(0); // se obtiene al Usuario activo
        boolean salir = false; //Condicion para mantener el ciclo while mientras el Usuario activo selecciona una opcion correcta

        while(!salir) {

            System.out.println("\n ### BIENVENIDO A JAVAGRAM ### ");
            System.out.println("\n\t## Registrado como: " + usuarioActivo.getNombre() + " ##");
            System.out.println("\n\tEscoja su opcion: ");
            System.out.println("\t1. Realizar publicacion");
            System.out.println("\t2. Seguir a un usuario ");
            System.out.println("\t3. Compartir publicacion ");
            System.out.println("\t4. Realizar comentario ");
            System.out.println("\t5. Realizar un ME GUSTA ");
            System.out.println("\t6. Visualizar red social ");
            System.out.println("\t7. Cerrar sesion ");
            System.out.println("\t8. Salir del programa \n ");
            System.out.println("\tINTRODUZCA SU OPCION: \n");

            try {
                int opcion = scan.nextInt(); // Se escanea la opcion del usuario activo
                switch(opcion) {
                    case 1: // Opcion Realizar publicacion
                        System.out.println("\n\n--> Ha elegido la opcion Realizar publicacion <--");
                        usuarioActivo.post(sn);
                        break;
                    case 2: // Opcion Seguir a un usuario
                        System.out.println("--> Ha elegido la opcion Seguir a un usuario <--");
                        usuarioActivo.follow(sn);
                        break;
                    case 3: // Opcion Compartir publicacion
                        System.out.println("--> Ha elegido la opcion Compartir publicacion <--");
                        usuarioActivo.share(sn);
                        break;
                    case 4: // Opcion Realizar comentario
                        System.out.println("--> Ha elegido la opcion Realizar un Comentario <--");
                        usuarioActivo.comment(sn);
                        break;
                    case 5: // Opcion Realizar un ME GUSTA
                        System.out.println("--> Ha elegido la opcion Realizar un ME GUSTA <--");
                        usuarioActivo.like(sn);
                        break;
                    case 6: // Opcion Visualizar red social
                        System.out.println("--> Ha elegido la opcion Visualizar red social <--\n\n");
                        usuarioActivo.PrintSocialNetwork(sn);
                        break;
                    case 7: // Opcion Cerrar sesion
                        System.out.println("\n\n--> Ha elegido la opcion Cerrar sesion <--\n\n");
                        usuarioActivo.logout(sn);
                        salir = true; // Se interrumpe el ciclo while
                        break;
                    case 8:
                        System.out.println("--> Ha elegido la opcion Salir del programa <--");
                        System.exit(0); // El programa termina de ejecutarse
                        break;
                    default: // Muestra error si Usuario activo escoje un numero no valido en las opciones
                        System.out.println("\n*****  Ingrese un numero entre 1 y 8 *****");
                    }
                } catch (InputMismatchException fail) {  // Muestra error si Usuario activo no ingresa un numero
                    System.out.println("\n***** Debe ingresar un numero *****");
                    scan.next();
                }
            }
        }



    }







