package Personajes;

public class Arquero extends Personaje {
    //Constante para definir la vida inicial del arquero
    private static final int vida = 120;

    /**
     *
     * @param nombre
     * @param salud --> Vida media
     * @param ataque --> Ataque medio
     * @param defensa --> Defensa media
     */
    public Arquero(String nombre) {
        super(nombre, vida, NumeroAleatorio.numeroAleatorio(18,28), NumeroAleatorio.numeroAleatorio(8,14));
    }

    /**
     * 0.9 indica el minimo, 90% del ataque que tiene el arquero
     * 0.3 es el rango de variacion
     * @param objetivo
     */
    @Override
    public void atacar(Personaje objetivo) {
        int danio = (int)(getAtaque() * (0.9 + Math.random() * 0.3));
        //                               ↑ mínimo               ↑ máximo - mínimo (1.2 - 0.9)
        System.out.println(getNombre() + " dispara una flecha a " +  objetivo.getNombre() + " de " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }
}