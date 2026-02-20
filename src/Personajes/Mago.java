package Personajes;



public class Mago extends Personaje implements Curable {
    //Constante para definir la vida inicial del mago
    private static final int vida = 90;

    /**
     *
     * @param nombre
     * @param salud --> Poca vida
     * @param ataque --> Ataque alto
     * @param defensa --> Baja defensa
     */
    public Mago(String nombre) {
        super(nombre, vida, NumeroAleatorio.numeroAleatorio(25,40), NumeroAleatorio.numeroAleatorio(5,10));
    }

    /**
     * 0.7 indica el minimo, 70% del ataque que tiene el mago
     * 0.6 es el rango de variacion
     * @param objetivo
     */
    @Override
    public void atacar(Personaje objetivo) {
        int danio = (int)(getAtaque() * (0.7 + Math.random() * 0.6));
        //                               ↑ mínimo               ↑ máximo - mínimo (1.4 - 0.7)
        System.out.println(getNombre() + " lanza un hechizo sobre " +  objetivo.getNombre() + " de " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    @Override
    public void curarse() {
        int curacion = NumeroAleatorio.numeroAleatorio(15,30);
        int saludCurada = Math.min(getSalud() + curacion, vida);
        //                ↑ nos devuelve el mínimo de los dos ↑ compara la curación con la vida inicial
        // para que nunca se cure más de la salud que tenia de inicio
        //Suma la curación, pero si el resultado supera el máximo, quédate con el máximo
        setSalud(saludCurada);
        System.out.println(getNombre() + " se cura con magia y recupera " + curacion + " HP. Salud actual: " + getSalud());
    }
}