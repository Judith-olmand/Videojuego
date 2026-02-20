import Personajes.Personaje;

import java.util.Map;

public class MostrarEnemigosDerrotados {
    public static void mostrarEnemigosDerrotados(Personaje jugador){

        System.out.println();
        System.out.println("        " + Videojuego.fondoAzul + "ENEMIGOS DERROTADOS" + Videojuego.reset);
        if (jugador.getEnemigosDerrotados().isEmpty()){
            System.out.println("Aún no has derrotado a ningún enemigo.");
        } else {
            for (Map.Entry<String, Integer> entry : jugador.getEnemigosDerrotados().entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}