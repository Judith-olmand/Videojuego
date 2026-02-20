package Personajes;

public class Guerrero extends Personaje{
    //Constante para definir la vida inicial del guerrero
    private static final int vida = 160;

    /**
     *
     * @param nombre
     * @param salud --> Mucha vida
     * @param ataque --> Ataque medio-alto
     * @param defensa --> Buena defensa
     */
    public Guerrero(String nombre) {
        super(nombre, vida, NumeroAleatorio.numeroAleatorio(15,25), NumeroAleatorio.numeroAleatorio(10,18));
    }

    /**
     * 0.8 indica el minimo, 80% del ataque que tiene el guerrero
     * 0.4 es el rango de variacion
     * @param objetivo
     */
    @Override
    public void atacar(Personaje objetivo) {
        int danio = (int)(getAtaque() * (0.8 + Math.random() * 0.4));
        //                               ↑ mínimo               ↑ máximo - mínimo (1.2 - 0.8)
        System.out.println(getNombre() + " golpea a " +  objetivo.getNombre() + " causando" + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }
}