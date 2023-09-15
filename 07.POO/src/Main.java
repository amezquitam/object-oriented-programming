import auctions.*;

public class Main {
    public static void main(String[] args) {
        User juan = new User("Juan", 100.0);
        User enrique = new User("Enrique", 150.0);

        RestrictedAuction restricted = new RestrictedAuction("Disco duro multimedia", juan, 1);
        TemporaryAuction temporal = new TemporaryAuction("Teclado", juan, 3);
        MinimumAuction minimum = new MinimumAuction("Impresora Laser", juan, 100);

        restricted.attempt(enrique, 10.0);
        temporal.attempt(enrique, 10.0);
        minimum.attempt(enrique, 10.0);

        System.out.println(restricted.getPendingAttempts());

        restricted.attempt(enrique, 20.0);
        temporal.attempt(enrique, 20.0);
        minimum.attempt(enrique, 20.0);

        temporal.attempt(enrique);

        if (!restricted.execute()) System.out.println("limitada no se pudo ejecutar");
        if (!temporal.execute()) System.out.println("temporal no se pudo ejecutar");
        if (!minimum.execute()) System.out.println("minimum no se pudo ejecutar");

        System.out.println(juan);
        System.out.println(enrique);
    }
}
