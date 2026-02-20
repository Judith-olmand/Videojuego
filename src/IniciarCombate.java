import GestorPartida.GuardarPartida;
import Personajes.Enemigo;
import Personajes.Personaje;

import java.util.Scanner;

public class IniciarCombate {
    public static void iniciarCombate(Personaje jugador) {
        Scanner sc = new Scanner(System.in);
        Enemigo enemigo = new Enemigo();

        System.out.println("⚔️⚔️⚔️" + Videojuego.fondoAzul + "INICIANDO COMBATE" + Videojuego.reset + "⚔️⚔️⚔️");
        System.out.println();
        System.out.println("Se acerca un " + enemigo.getNombre());
        System.out.println("El " + enemigo.getNombre() + " tiene " + enemigo.getSalud() + " HP de salud, " +
                enemigo.getAtaque() + " DPT de ataque y " + enemigo.getDefensa() + " DR de defensa.");

        /**
         * Mientras uno de los dos tenga salud continua el combate
         */
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0){
            Turnos.turnoJugador(jugador, enemigo);

            if (enemigo.getSalud() <= 0){
                System.out.println("¡Has derrotado al " + enemigo.getNombre() + "!");

                if (jugador.getEnemigosDerrotados().containsKey(enemigo.getNombre())){
                   int cantidadActual = jugador.getEnemigosDerrotados().get(enemigo.getNombre());
                   jugador.getEnemigosDerrotados().put(enemigo.getNombre(), cantidadActual + 1);

                   // jugador.getEnemigosDerrotados().put(enemigo.getNombre(), jugador.getEnemigosDerrotados().getOrDefault(enemigo.getNombre(),0)+1);
                    // Busca el nombre en el Map. Si ya existe devuelve el número actual, si no existe devuelve `0`. Luego suma `1`.
                } else {
                    jugador.getEnemigosDerrotados().put(enemigo.getNombre(), 1);
                }
                break;
            }

            Turnos.turnoEnemigo(jugador, enemigo);

            if (jugador.getSalud() <= 0) {
                System.out.println("☠\uFE0F☠\uFE0F" + Videojuego.fondoNaranja + "HAS SIDO DERROTADO..." + Videojuego.reset + "☠\uFE0F☠\uFE0F");
                MostrarEnemigosDerrotados.mostrarEnemigosDerrotados(jugador);
                break;
            }

        }
    }
}