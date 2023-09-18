import java.util.List;

public class App {
    public static void main(String[] args) {
        Binnacle basicBinnacle = new Binnacle("basic");
        SmartBinnacle smartBinnacle = new SmartBinnacle("smart", "facebook", "instagram", "tiktok");
        UndoBinnacle undoBinnacle = new UndoBinnacle("undo");

        

        var binnacles = List.of(basicBinnacle, smartBinnacle, undoBinnacle);
    }
}
