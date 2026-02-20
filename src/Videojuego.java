import GestorPartida.CargarPartida;
import GestorPartida.GuardarPartida;
import Personajes.Personaje; //Al crear "carpetas" es necesario importar para poder usar

import java.util.InputMismatchException;
import java.util.Scanner;

public class Videojuego {
    public static final String reset = "\u001B[0m";
    public static final String fondoRojo = "\u001B[41m";
    public static final String fondoLila = "\u001B[45m";
    public static final String fondoVerde = "\u001B[42m";
    public static final String fondoAzul = "\u001B[46m";
    public static final String fondoNaranja = "\u001B[44m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean opCorrecta;
        String respuesta;
        
        Personaje jugador = null;

        LectorArchivo.leerArchivo();

        do {
            opCorrecta = false;
            try {
                System.out.println(fondoLila + "Elija una opción" + reset);
                System.out.println("1. Nueva partida");
                System.out.println("2. Cargar partida");
                opcion = sc.nextInt();
                sc.nextLine();
                opCorrecta = true;

            }catch (InputMismatchException e){
                System.out.println("⛔ " + fondoRojo + "Error. Elija una opción válida." + reset);
                sc.nextLine();
            }

            System.out.println();

        }while (!opCorrecta);

        switch (opcion) {
            case 1:
                jugador = CrearPersonaje.creaPersonaje(sc);
                break;
            case 2:
                jugador = CargarPartida.cargarPartida();
                if (jugador == null) {
                    System.out.println("No existe partida guardada o no se puede cargar.");
                    jugador = CrearPersonaje.creaPersonaje(sc);
                }
                break;
            default:
                System.out.println("⛔ " + Videojuego.fondoRojo + "OPCIÓN NO VÁLIDA" + Videojuego.reset);
                break;
        }

        System.out.println();

        IniciarCombate.iniciarCombate(jugador);

        do {
            if (jugador.getSalud() >= 1){
                System.out.println("Quieres seguir combatiendo? S/N");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")){
                    IniciarCombate.iniciarCombate(jugador);
                } else if (!respuesta.equalsIgnoreCase("N")) {
                    System.out.println("Respuesta no valida.");
                    respuesta = "s";
                }
            } else {
                System.out.println("¿Quieres empezar de 0?S/N");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")){
                    jugador = CrearPersonaje.creaPersonaje(sc);
                    IniciarCombate.iniciarCombate(jugador);
                } else if (!respuesta.equalsIgnoreCase("N")) {
                    System.out.println("Respuesta no valida.");
                    respuesta = "S";
                }
            }
        } while (!respuesta.equalsIgnoreCase("N"));

        do {
            System.out.println("Quieres guardar la partida y salir?");
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")){
                GuardarPartida.guardarPartida(jugador);
            } else if (!respuesta.equalsIgnoreCase("N")) {
                System.out.println("Respuesta no valida.");
            }
        }while (!respuesta.equalsIgnoreCase("N") && !respuesta.equalsIgnoreCase("S"));


        System.out.println("HASTA PRONTO!!");

    }
}