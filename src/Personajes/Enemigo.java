public class Enemigo extends Personaje{
    private static final String[] nombres = {"Orco", "Troll", "Esqueleto", "Dragón", "Goblin"};

    public Enemigo() {
        super(nombres[(int)(Math.random() * nombres.length)], NumeroAleatorio.numeroAleatorio(80,130), NumeroAleatorio.numeroAleatorio(10,25), NumeroAleatorio.numeroAleatorio(5,15));
        //              ↑   ↑ genera un decimal     ↑ 5 elementos
        //              ↑     entre 0.0 y 4.9
        //              ↑ devuelve la parte entera
    }

    public String[] getNombres() {
        return nombres;
    }

    /**
     * 0.8 indica el minimo, 80% del ataque que tiene los enemigos
     * 0.4 es el rango de variacion
     * @param objetivo
     */
    @Override
    public void atacar(Personaje objetivo) {
        int danio = (int)(getAtaque() * (0.8 + Math.random() * 0.4));
        //                               ↑ mínimo               ↑ máximo - mínimo (1.2 - 0.8)
        System.out.println(getNombre() + " lanza un hechizo sobre " +  objetivo.getNombre() + " causando" + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }
}
