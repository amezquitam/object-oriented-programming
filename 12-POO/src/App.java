import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws Exception {
        List<Figure> figures = new LinkedList<>();
        Menu<List<Figure>> menu = new Menu<>(figures);

        menu.addOption("Create rectangle", (figuresList) -> {
            System.out.print("> spec the width len: ");
            int width = menu.nextInt();
            System.out.print("> spec the height len: ");
            int height = menu.nextInt();
            figuresList.add(new Rectangle(width, height));
        });

        menu.addOption("Create squad", (figuresList) -> {
            System.out.print("> spec the side len: ");
            int side = menu.nextInt();
            figuresList.add(new Square(side));
        });

        menu.addOption("Create triangle", (figuresList) -> {
            System.out.print("> spec the base side length: ");
            int sideA = menu.nextInt();
            System.out.print("> spec the height side length: ");
            int sideB = menu.nextInt();
            figuresList.add(new RightTriangle(sideA, sideB));
        });

        menu.addOption("Show figure", (figuresList) -> {

            if (figuresList.isEmpty()) {
                System.out.println("There's no figures to show");
                return;
            }

            int figureCount = 1;

            System.out.println("Press 0 to skip, any other number to show");

            for (var figure : figuresList) {
                System.out.printf("Figure(%d) \"%s\" (1/0): ", figureCount, figure.getName());

                int input = menu.nextInt("Only zero or one");

                if (input == 0)
                    continue;

                figure.drawText();
                System.out.printf("Area: %f, Perimeter: %f\n", figure.getArea(), figure.getPerimeter());

                figureCount++;
            }
        });

        boolean exitSelected = false;

        while (!exitSelected) {
            int selectedOption = menu.prompt();
            exitSelected = selectedOption == menu.exitOption();
        }
    }
}

class Menu<Context> {
    private final Scanner reader;
    private final List<MenuOption<Context>> options;
    Context context;

    public Menu(Context context) {
        this.context = context;
        options = new LinkedList<>();
        reader = new Scanner(System.in);
    }

    public void addOption(String message, Consumer<Context> action) {
        options.add(new MenuOption<>(message, action));
    }

    public int prompt() {
        int selectedOption;

        // Show menu
        int optionNumber = 1;
        for (var option : options) {
            System.out.println(optionNumber + ". " + option.getMessage());
            optionNumber++;
        }
        System.out.println(optionNumber + ". Exit");

        // Recep input
        System.out.print("\n > Choose an option: ");
        selectedOption = nextInt();

        // Exec action
        if (1 <= selectedOption && selectedOption <= options.size()) {
            options.get(selectedOption - 1).execute(context);
        }

        return selectedOption;
    }

    public int exitOption() {
        return options.size() + 1;
    }

    public int nextInt(String message) {
        int number;
        while (true) {
            try {
                String numberText = reader.nextLine();
                number = Integer.parseInt(numberText);
            } catch (NumberFormatException e) {
                System.out.println(message);
                System.out.print("> ");
                continue;
            }
            break;
        }
        return number;
    }

    public int nextInt() {
        return nextInt("The input must be a integer number :c");
    }
};

class MenuOption<Context> {
    private final String message;
    private final Consumer<Context> action;

    public MenuOption(String message, Consumer<Context> action) {
        this.message = message;
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void execute(Context context) {
        action.accept(context);
    }

}