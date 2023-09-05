package tragaperras;

import java.util.Arrays;
import java.util.Random;

public class Maquina {
    private int numeroCasillas;
    private double precioJugada;
    private double credito;
    private Premio[] premios;

    public Maquina(int numeroCasillas, double precioJugada, Premio... premios) {
        this.numeroCasillas = numeroCasillas;
        this.precioJugada = precioJugada;
        this.premios = premios;
    }

    public void setPrecioJugada(double precioJugada) {
        this.precioJugada = precioJugada;
    }

    public int getNumeroCasillas() {
        return numeroCasillas;
    }

    public double getPrecioJugada() {
        return precioJugada;
    }

    public double getCredito() {
        return credito;
    }

    public Premio[] getPremios() {
        return Arrays.copyOf(premios, premios.length);
    }

    public void incrementarCredito(double incremento) {
        this.credito += incremento;
    }

    public double cobrar() {
        double credito = this.credito;
        this.credito = 0;
        return credito;
    }

    public Fruta[] jugar() {
        if (this.credito < this.precioJugada) {
            return null;
        }

        this.credito -= this.precioJugada;

        Fruta[] combinacionGenerada = new Fruta[numeroCasillas];
        Random generador = new Random();

        for (int i = 0; i < numeroCasillas; ++i) {
            int numeroGenerado = generador.nextInt(Fruta.values().length);
            combinacionGenerada[i] = Fruta.values()[numeroGenerado];
        }

        var premiosObtenidos = Arrays.stream(premios).filter(
            premio -> Arrays.equals(premio.getCombinacion(), combinacionGenerada)
        );

        premiosObtenidos.forEach(
            premioObtenido -> incrementarCredito(premioObtenido.getRecompensa())
        );

        return combinacionGenerada;
    }
}
