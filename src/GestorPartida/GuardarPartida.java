package GestorPartida;

import Personajes.Personaje;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarPartida {
    private static final String Archivo = "partida.dat";

    /**
     * Metodo para guardar la partida
     * @param personaje recibe por parametro el personaje a guardar
     */
    public static void guardarPartida(Personaje personaje) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Archivo))) {
            /**
             * Serializa el personaje completo y lo escribe en el archivo.
             * Guarda todos sus atributos: nombre, salud, ataque, defensa, tal como están en ese momento.
             */
            oos.writeObject(personaje);
            System.out.println("Partida guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}