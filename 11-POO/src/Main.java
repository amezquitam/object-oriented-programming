import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Voter> voters = List.of(
                new Voter("17456789", "Juan Martínez", LocalDate.of(1998, 12, 16)),
                new Voter("34567890", "Pedro López", LocalDate.of(1998, 3, 18)),
                new Voter("23456812", "Ana Abenza", LocalDate.of(1995, 5, 1)),
                new Voter("23754612", "María Gómez", LocalDate.of(1994, 9, 1))
        );

        ConsultationOrdinary consultationOrdinary = new ConsultationOrdinary(
                "Sobre los exámenes en la universidad",
                2
        );

        consultationOrdinary.addQuestion(1, "¿Debemos volver a la convocatoria de septiembre?");
        consultationOrdinary.addQuestion(2, "¿Se deben hacer parciales en todas las cuatrimestrales?");

        ConsultationSelective consultationSelective = new ConsultationSelective(
                "Sobre las fiestas patronales",
                2,
                LocalDate.of(1997, 12, 31),
                LocalDate.now()
        );

        consultationSelective.addQuestion(1, "¿Se debe cerrar el centro el día del patrón?");
        consultationSelective.addQuestion(2, "¿Se deben recuperar las clases que se pierden en las fiestas?");

        consultationSelective.setConditionedQuestions(1);

        List<Consultation> consultations = List.of(consultationOrdinary, consultationSelective);

        for (Consultation consultation: consultations) {
            consultation.addVoters(voters);

            if (consultation instanceof ConsultationOrdinary consultationOrdinary_) {
                consultationOrdinary_.open();
            }

            consultation.vote("17456789", List.of(Answer.YES, Answer.YES));
            consultation.vote("34567890");
            consultation.vote("23456812", List.of(Answer.YES, Answer.NO));
            consultation.vote("23754612", List.of(Answer.NO, Answer.NO));

            System.out.println("El título de la consulta: " + consultation.getTitle());
            if (consultation instanceof ConsultationSelective consultationSelective_) {
                System.out.println("Censo autorizado:");
                System.out.println(consultationSelective_.authorizedCensus());
            }
            System.out.println("El número de votos emitidos: " + consultation.numberOfVotesCast());
            System.out.println("El escrutinio para cada pregunta: ");
            for (int i = 1; i <= consultation.getNumberOfQuestions(); i++) {
                System.out.println( consultation.getScrutinyOfQuestions(i) );
            }
        }
    }
}