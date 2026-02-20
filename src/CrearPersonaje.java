import Personajes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrearPersonaje {
    public static Personaje creaPersonaje(Scanner sc){
        boolean opCorrecta;
        int clase = 0;

        System.out.println(Videojuego.fondoVerde + "Creando un personaje nuevo." + Videojuego.reset);

        System.out.println("Introduce el nombre del personaje");
        String nombre = sc.nextLine();

        do {
            opCorrecta = false;
            try {
                System.out.println("Elige la clase.");
                System.out.println("1. Guerrero " + "🗡️");
                System.out.println("2. Mago " + "🧙🏻‍♂️");
                System.out.println("3. Elfo " + "🧝🏻");
                System.out.println("4. Arquero " + "🏹");
                clase = sc.nextInt();
                sc.nextLine();
                opCorrecta = true;

            }catch (InputMismatchException e){
                System.out.println("⛔ " + Videojuego.fondoRojo + "Error. Elija una opción válida." + Videojuego.reset);
                sc.nextLine();
            }
        }while (!opCorrecta);

        switch (clase) {
            case 1:
                return new Guerrero(nombre);

            case 2:
                return new Mago(nombre);

            case 3:
                return new Elfo(nombre);

            case 4:
                return new Arquero(nombre);

            default:
                System.out.println("⛔ " + Videojuego.fondoRojo + "OPCIÓN NO VÁLIDA" + Videojuego.reset);
                break;
        }
        return null;
    }
}