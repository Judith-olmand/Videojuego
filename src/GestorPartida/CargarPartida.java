package GestorPartida;

import Personajes.Personaje;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CargarPartida {
    /**
     * Metodo para cargar la partida
     * @return que devuelve un Personajes.Personaje. Si falla devuelve null
     */
    public static Personaje cargarPartida() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("partida.dat"))) {
            Personaje personaje = (Personaje) ois.readObject();
            //                        ↑ cast --> sirve para cualquier subclase
            //indica que lo que hay dentro si o si es un personaje
            System.out.println("Partida cargada correctamente.");
            return personaje;

        } catch (IOException e) {
            System.out.println("No se encontró ninguna partida guardada.");
            return null;

        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer la partida.");
            return null;
        }
    }
}