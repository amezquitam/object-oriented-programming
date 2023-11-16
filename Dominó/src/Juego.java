
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Juego {
    private final List<Ficha> monton;
    private final List<Ficha> fichasEnMesa;
    private final List<Ficha> fichasJugador1;
    private final List<Ficha> fichasJugador2;

    private int turno;

    public Juego() {
        monton = new LinkedList<>();
        fichasEnMesa = new LinkedList<>();
        fichasJugador1 = new LinkedList<>();
        fichasJugador2 = new LinkedList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                monton.add(new Ficha(i, j));
            }
        }

        Random random = new Random();

        Collections.shuffle(monton, random);

        while (fichasJugador1.size() < 7) {
            fichasJugador1.add(monton.remove(0));
            fichasJugador2.add(monton.remove(0));
        }


        Ficha mayorDoble1 = getMayorDoble(fichasJugador1);
        Ficha mayorDoble2 = getMayorDoble(fichasJugador2);

        if (mayorDoble1 != null && mayorDoble2 != null) { 

            if (mayorDoble1.compareTo(mayorDoble2) < 0) {
                turno = 2;
            } else {
                turno = 1;
            }

        } else if (mayorDoble1 != null) {

            turno = 1;

        } else if (mayorDoble2 != null) {
            turno = 2;
        } else {
            turno = (int)(Math.random() * 2) + 1;
        }

        System.out.println("");
    }

    Ficha getMayorDoble(List<Ficha> fichas) {
        return fichas.stream().filter(ficha -> ficha.getValorDerecho() == ficha.getValorIzquierdo())
            .max(Ficha::compareTo).orElse(null);
    }
    
    public static void main(String[] args) {
        Juego juego = new Juego();

    }
}
