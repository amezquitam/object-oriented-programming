import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws Exception {
        Menu<Void> menu;

        
    }
}


class Menu<Context> {
    private Map<String, MenuOption<Context>> options;

    public Menu() {
        options = new HashMap<>();
    }
    
    public void addOption(String message, Function<Context, Void> action) {
        options.put(message, new MenuOption<>(message, action));
    }
};

class MenuOption<Context> {
    private String message;
    private Function<Context, Void> action;

    public MenuOption(String message, Function<Context, Void> action) {
        this.message = message;
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void execute(Context context) {
        action.apply(context);
    }

}