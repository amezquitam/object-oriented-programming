public class Application {
    public static void main(String[] args) {
        Dominoes game = new Dominoes();

        game.addPlayer(new PersonPlayer("Miguel"));
        game.addPlayer(new BotPlayer("Robin"));

        game.startMatch();

    }
}
