import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        User fperez = new User("fperez", "lechemerengada");
        fperez.setPassword("lechemerengada", "cr7comeback");
        User mlama = new User("mlama", "tururu");
        VerificatorBlackList vbl = new VerificatorBlackList();
        VerificatorByCode vbc = new VerificatorByCode(5);
        vbl.addUsers(fperez, mlama);
        vbc.addUsers(fperez, mlama);
        List<Verificator> vlist = new ArrayList<>();
        vlist.add(vbl);
        vlist.add(vbc);

        for (Verificator v : vlist) {
            if (v instanceof VerificatorBlackList vbln) {
                vbln.blockUser(mlama);
            }
        }

        Scanner sc = new Scanner(System.in);

        for (Verificator v : vlist) {
            System.out.println("Login: ");
            String login = sc.nextLine();
            System.out.println("Password: ");
            String password = sc.nextLine();

            String token = v.loginStep1(login, password);

            if (token == null)
                continue;

            System.out.println(v.getChallenge() + ": ");
            String challengeAnswer = sc.nextLine();

            boolean success = v.loginStep2(token, challengeAnswer);

            if (success)
                System.out.println("Se inicio sesion");
            else
                System.out.println("Incorrecto");
        }

    }
}
