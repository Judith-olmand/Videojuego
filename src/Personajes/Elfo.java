public class Elfo extends Personaje implements Curable{
    //Constante para definir la vida inicial del mago
    private static final int vida = 110;

    /**
     *
     * @param nombre
     * @param salud --> Vida media
     * @param ataque --> Ataque bajo-medio
     * @param defensa --> Alta defensa
     */
    public Elfo(String nombre) {
        super(nombre, vida, NumeroAleatorio.numeroAleatorio(15,22), NumeroAleatorio.numeroAleatorio(15,25));
    }

    /**
     * 0.85 indica el minimo, 85% del ataque que tiene el elfo
     * 0.35 es el rango de variacion
     * @param objetivo
     */
    @Override
    public void atacar(Personaje objetivo) {
        int danio = (int)(getAtaque() * (0.85 + Math.random() * 0.35));
        //                               ↑ mínimo               ↑ máximo - mínimo (1.2 - 0.85)
        System.out.println(getNombre() + " ataca a " +  objetivo.getNombre() + " causando" + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    @Override
    public void curarse() {
        int curacion = NumeroAleatorio.numeroAleatorio(10,20);
        int saludCurada = Math.min(getSalud() + curacion, vida);
        //                ↑ nos devuelve el mínimo de los dos ↑ compara la curación con la vida inicial
        // para que nunca se cure más de la salud que tenia de inicio
        setSalud(saludCurada);
        System.out.println(getNombre() + " usa hierbas élvicas y recupera " + curacion + " HP. Salud actual: " + getSalud());
    }
}