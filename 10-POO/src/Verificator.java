
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Verificator {
    private Map<String, User> users;
    private String challenge;

    protected Map<String, String> answerForTokens;

    public Verificator(String challenge) {
        this.challenge = challenge;
        this.users = new HashMap<>();
        this.answerForTokens = new HashMap<>();
    }

    public void addUsers(User... users) {
        for (User user : users) {
            this.users.put(user.getLogin(), user);
        }
    }

    public boolean removeUser(User user) {
        users.remove(user.getLogin());
        return true;
    }

    protected abstract String generateAnswer(User user);

    public String loginStep1(String login, String password) {
        if (!users.containsKey(login))
            return null;
        User user = users.get(login);
        if (!user.validate(password))
            return null;
        String token = UUID.randomUUID().toString();
        String answer = generateAnswer(user);

        answerForTokens.put(token, answer);

        return token;
    }
    
    protected void failAnswerBehavior(String token) {
        answerForTokens.remove(token);
    }

    public boolean loginStep2(String userToken, String userAnswer) {
        if (!answerForTokens.containsKey(userToken))
            return false;
        if (!answerForTokens.get(userToken).equals(userAnswer)) {
            failAnswerBehavior(userToken);
            return false;
        }
        answerForTokens.remove(userToken);
        return true;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public String getChallenge() {
        return challenge;
    }

    

}
