import Personajes.*;

public class UsarHabilidadEspecial {
    public static void usarHabilidadEspecial (Personaje personaje){
        if (personaje instanceof Guerrero) {
            //            ↑ devuelve verdadero si el personaje es un Personajes.Guerrero
            Guerrero guerrero = (Guerrero) personaje;
            System.out.println("Bienvenido de nuevo, Personajes.Guerrero " + guerrero.getNombre());

        } else if (personaje instanceof Mago) {
            Mago mago = (Mago) personaje;
            System.out.println("Bienvenido de nuevo, Personajes.Mago " + mago.getNombre());

        } else if (personaje instanceof Elfo) {
            Elfo elfo = (Elfo) personaje;
            System.out.println("Bienvenido de nuevo, Personajes.Elfo " + elfo.getNombre());

        } else if (personaje instanceof Arquero) {
            Arquero arquero = (Arquero) personaje;
            System.out.println("Bienvenido de nuevo, Personajes.Arquero " + arquero.getNombre());

        }
    }
}