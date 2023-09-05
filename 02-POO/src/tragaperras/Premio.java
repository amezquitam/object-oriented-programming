package tragaperras;

import java.util.Arrays;

public class Premio {
    private Fruta[] combinacion;
    private double recompensa;

    public Premio(Fruta[] combinacion, double recompensa) {
        this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
        this.recompensa = recompensa;
    }

    public Fruta[] getCombinacion() {
        return Arrays.copyOf(combinacion, combinacion.length);
    }

    public double getRecompensa() {
        return recompensa;
    }
}
