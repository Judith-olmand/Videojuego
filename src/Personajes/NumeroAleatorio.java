public class NumeroAleatorio {
    /**
     * Generador de números aleatorios para atributos
     * @param minimo
     * @param maximo
     * @return
     */
    public static int numeroAleatorio(int minimo, int maximo) {
        int aleatorio;
        /**
         * Math.random devuelve un double entre 0.0 y 0.99...(incluidos)
         * x rango de valores + minimo.
         */
        aleatorio = minimo + (int)(Math.random() * ((maximo - minimo) + 1));
        return aleatorio;
    }
}