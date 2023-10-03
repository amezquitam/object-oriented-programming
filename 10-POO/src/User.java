import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class User {
    private final String login;
    private String password;
    private LocalDate lastLoginDate;
    private Set<String> passwordHistory;
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.lastLoginDate = LocalDate.now();
        this.passwordHistory = new HashSet<>();
        this.passwordHistory.add(password);
    }
    
    public String getLogin() {
        return login;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public boolean setPassword(String currentPassword, String newPassword) {
        if (!currentPassword.equals(password)) return false;
        if (passwordHistory.contains(newPassword)) return false;
        password = newPassword;
        passwordHistory.add(newPassword);
        return false;
    }

    public boolean validate(String passedPassword) {
        return passedPassword.equals(password);
    }

    public void setLastLoginDate() {
        lastLoginDate = LocalDate.now();
    }
    
}
