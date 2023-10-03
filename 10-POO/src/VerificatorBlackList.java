import java.util.Collection;

public class VerificatorBlackList extends Verificator {
    
    private Collection<String> blackList;
    
    public VerificatorBlackList() {
        super("Introduzca el número del mes de su último acceso");
    }

    @Override
    public String loginStep1(String login, String password) {
        if (blackList.contains(login)) return null;
        return super.loginStep1(login, password);
    }

    @Override
    protected String generateAnswer(User user) {
        return Integer.toString( user.getLastLoginDate().getMonth().getValue() );
    }
    
}
