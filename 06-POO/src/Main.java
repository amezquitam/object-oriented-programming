import auctions.Auction;
import auctions.User;

public class Main {
    public static void main(String[] args) {
        User juan = new User("Juan", 100.0);
        User pedro = new User("Pedro", 150.0);
        User enrique = new User("Enrique", 300.0);

        Auction auction = new Auction("Teléfono móvil", juan);

        auction.attempt(pedro, 100.0);

        System.out.println(auction.getGreaterAttempt());

        auction.attempt(enrique, 50.0);

        System.out.println(auction.getGreaterAttempt());

        auction.execute();

        auction.attempt(enrique, 200.0);

        System.out.println(juan);
        System.out.println(pedro);
        System.out.println(enrique);

        System.out.println(juan.getAuctions());
        System.out.println(pedro.getAuctions());
        System.out.println(enrique.getAuctions());


    }
}