package Personajes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Personaje implements Serializable {
    private String nombre;
    private int salud;
    private int ataque;
    private int defensa;
    private Map<String,Integer> enemigosDerrotados = new HashMap<>();

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

    public Map<String, Integer> getEnemigosDerrotados() {
        return enemigosDerrotados;
    }

    public void setEnemigosDerrotados(Map<String, Integer> enemigosDerrotados) {
        this.enemigosDerrotados = enemigosDerrotados;
    }

    public abstract void atacar(Personaje objetivo);

    /**
     * Metodo para restar a la salud el daño real, pues hay que descontar la defensa del personaje
     * @param danio
     */
    public void recibirDanio(int danio){
        int danioReal = Math.max(1, danio - defensa);
        //                   ↑ para no tener un daño negativo que sume salud, siempre va a restar 1 mínimo.
        this.salud -= danioReal;
        System.out.println(nombre + " tiene una defensa de " + defensa + " DR y solo recibe " + danioReal + " de daño.");
        System.out.println(nombre + " tiene " + salud + " HP restantes.");
    }
}