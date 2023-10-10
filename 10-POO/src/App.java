import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
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

        String tokenFperez = vbc.loginStep1("fperez", "cr7comeback");
        String tokenMlama = vbc.loginStep1("mlama", "tururu");
        assert (tokenFperez != null);
        assert (tokenMlama != null);

   step:
        System.out.print(vbc.getChallenge() + ": ");
        String answerFperez = scanner.nextLine();

        System.out.print(vbc.getChallenge() + ": ");
        String answerMlama = scanner.nextLine();

        boolean mlamaSuccess = vbc.loginStep2(tokenMlama, answerMlama);
        boolean fperezSuccess = vbc.loginStep2(tokenFperez, answerFperez);

        if (!mlamaSuccess || !fperezSuccess)
            continue step;

    }
}
