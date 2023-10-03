import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerificatorByCode extends Verificator {

    private int maxNumOfAttemps;
    private Map<String, Integer> attempsOfUser;

    public VerificatorByCode(int maxNumOfAttemps) {
        super("Introduzca el número que ha recibido por SMS");
        this.maxNumOfAttemps = maxNumOfAttemps;
        this.attempsOfUser = new HashMap<>();
    }

    @Override
    protected void failAnswerBehavior(String token) {
        if (!attempsOfUser.containsKey(token)) {
            attempsOfUser.put(token, 0);
        }
        attempsOfUser.put(token, attempsOfUser.get(token) + 1);
        if (attempsOfUser.get(token) >= maxNumOfAttemps) {
            super.failAnswerBehavior(token);
        }
    }

    @Override
    protected String generateAnswer(User user) {
        Random random = new Random(LocalTime.now().getNano());
        String answer = Integer.toString( random.nextInt(1000) );
        System.err.println(answer);
        return answer;
    }
}
