import java.io.Serializable;

public abstract class Personaje implements Serializable {
    private String nombre;
    private int salud;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public abstract void atacar(Personaje objetivo);

    /**
     * Metodo para restar a la salud el daño real, pues hay que descontar la defensa del personaje
     * @param danio
     */
    public void recibirDanio(int danio){
        int danioReal = Math.max(0, danio - defensa);
        //                   ↑ para no tener un daño negativo que sume salud.
        this.salud -= danioReal;
        System.out.println(nombre + " tiene " + salud + " HP restantes.");
    }
}