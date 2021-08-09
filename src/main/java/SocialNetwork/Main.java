package SocialNetwork;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Socialnetwork sn = Socialnetwork.sn1();
        boolean salir = false;

        while(!salir) {
            System.out.println(" ### BIENVENIDO A JAVAGRAM ### ");
            System.out.println(" Escoja una opcion: ");
            System.out.println(" 1. Iniciar Sesion");
            System.out.println(" 2. Registrarse ");
            System.out.println(" 3. Salir del programa \n");
            System.out.println("\n Ingrese su opcion: \n");

            try {
                int opcion = scan.nextInt();
                switch(opcion) {
                    case 1:
                        System.out.println("\n\n Ha elegido la opcion Iniciar sesion ");
                        Usuario usuario = new Usuario(" ", " ", 0, (ArrayList)null, (ArrayList)null, null);
                        usuario.login(sn);
                        menu(sn);
                        break;
                    case 2:
                        System.out.println("\n\n Ha elegido la opcion REGISTRARSE ");
                        sn.register(sn);
                        System.out.println("\n\n Inicie Sesion para confirmar el Registro ");
                        break;
                    case 3:
                        System.out.println(" Ha salido del Programa ");
                        salir = true;
                        break;
                    default:
                        System.out.println("\n\n  Ingrese un numero entre 1 y 3 ");
                    }
                } catch (InputMismatchException var6) {
                    System.out.println("\n\n Debe ingresar un numero ");
                    scan.next();
                }
            }

        }


    public static void menu(Socialnetwork sn) {
        Scanner scan = new Scanner(System.in);
        Usuario usuarioActivo = (Usuario)sn.getUsuarioActivo().get(0);
        boolean salir = false;

        while(!salir) {
            PrintStream var10000 = System.out;
            ArrayList var10001 = sn.getUsuarioActivo();
            var10000.println("\n\t ### RED SOCIAL: JavaGram ## \n\n" + ((Usuario)var10001.get(0)).toString());
            System.out.println("\n\t## Registrado como: " + usuarioActivo.getNombre() + " ##");
            System.out.println("\n\tEscoja su opcion: ");
            System.out.println("\t1. Realizar publicacion");
            System.out.println("\t2. Seguir a un usuario ");
            System.out.println("\t3. Compartir publicacion ");
            System.out.println("\t4. Visualizar red social ");
            System.out.println("\t5. Cerrar sesion ");
            System.out.println("\t6. Salir del programa \n ");
            System.out.println("\tINTRODUZCA SU OPCION: \n");

            try {
                int opcion = scan.nextInt();
                switch(opcion) {
                    case 1:
                        System.out.println("\n\n Ha elegido la opcion Realizar publicacion ");
                        break;
                    case 2:
                        System.out.println(" Ha elegido la opcion Seguir a un usuario ");
                        break;
                    case 3:
                        System.out.println(" Ha elegido la opcion Compartir publicacion ");
                        break;
                    case 4:
                        System.out.println(" Ha elegido la opcion Visualizar red social \n\n");
                        break;
                    case 5:
                        System.out.println("\n\n Ha elegido la opcion Cerrar sesion \n\n");
                        usuarioActivo.logout(sn);
                        salir = true;
                        break;
                    case 6:
                        System.out.println(" Ha elegido la opcion Salir del programa ");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\n  Ingrese un numero entre 1 y 6");
                    }
                } catch (InputMismatchException var5) {
                    System.out.println("\n Debe ingresar un numero");
                    scan.next();
                }

            }
        }
    }







