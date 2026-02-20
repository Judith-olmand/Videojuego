import GestorPartida.GuardarPartida;
import Personajes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Turnos {
    public static void turnoJugador(Personaje jugador, Enemigo enemigo){
        Scanner sc = new Scanner(System.in);
        boolean opCorrecta;
        int opcion = 0;

        do {
            opCorrecta = false;
            try {
                System.out.println("        " + Videojuego.fondoLila + "TURNO DEL JUGADOR" + Videojuego.reset);
                System.out.println("¿Qué quieres hacer?");
                System.out.println("1. Atacar");
                System.out.println("2. Guardar partida y salir");
                System.out.println("3. Huir y salir");
                System.out.println("4. Mostrar enemigos derrotados");
                System.out.println("5. Mostrar datos de la salud");
                if (jugador instanceof Elfo || jugador instanceof Mago){
                    System.out.println("6. Curarte");
                }
                opcion = sc.nextInt();
                sc.nextLine();
                System.out.println();
                opCorrecta = true;

            }catch (InputMismatchException e){
                System.out.println("⛔ " + Videojuego.fondoRojo + "Error. Elija una opción válida." + Videojuego.reset);
                sc.nextLine();
            }
        }while (!opCorrecta);

        switch (opcion) {
            case 1:
               jugador.atacar(enemigo);
                break;
            case 2:
                GuardarPartida.guardarPartida(jugador);
                System.out.println("Partida guardada. ¡Hasta pronto!");
                System.exit(0); // -->sale del programa
                break;
            case 3:
                System.out.println("Has huído del combate.");
                System.exit(0);
                break;
            case 4:
                MostrarEnemigosDerrotados.mostrarEnemigosDerrotados(jugador);
                turnoJugador(jugador, enemigo);
                break;
            case 5:
                System.out.println("        " + Videojuego.fondoVerde + "DATOS DE LA SALUD" + Videojuego.reset);
                System.out.println("Tu salud: " + jugador.getSalud() + " HP");
                System.out.println("Salud del enemigo: " + enemigo.getSalud() + " HP");
                System.out.println();
                turnoJugador(jugador, enemigo);
                break;
            case 6:
                ((Curable)jugador).curarse();
                //↑               ↑
                // envuelve el cast para luego llamar al metodo
                break;
            default:
                System.out.println("⛔ " + Videojuego.fondoRojo + "OPCIÓN NO VÁLIDA" + Videojuego.reset);
                break;
        }
        System.out.println();
    }

    public static void turnoEnemigo(Personaje jugador, Enemigo enemigo){
        System.out.println("        " + Videojuego.fondoLila + "TURNO DEL ENEMIGO" + Videojuego.reset);
        enemigo.atacar(jugador);
        System.out.println();
    }

}