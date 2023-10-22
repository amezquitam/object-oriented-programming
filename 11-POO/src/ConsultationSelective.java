import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A selective consultation is a type of consultation that establishes a restriction when voting
 * that some questions can only be answered by people born before a certain
 * date. Or what is the same, people born on a date later than that established for the
 * consultation cannot answer certain questions, which is equivalent to leaving them “blank”.
 * 4/5
 * Therefore, this type of query adds three new properties:
 * - threshold date: date that selects which voters can answer (a response
 * other than “blank”) to certain questions.
 * - conditioned questions: set with the numbers of the questions conditioned by the
 * threshold date.
 * - Authorized census: set of voters who can answer all questions. This
 * that is, those whose date of birth is before the threshold date.
 */
public class ConsultationSelective extends Consultation {
    private LocalDate thresholdDate;
    private Set<Integer> conditionedQuestions;
    private LocalDate celebrationDate;

    public ConsultationSelective(String title, int numberOfQuestions, LocalDate thresholdDate, LocalDate celebrationDate) {
        super(title, numberOfQuestions);
        this.thresholdDate = thresholdDate;
        this.celebrationDate = celebrationDate;
        this.conditionedQuestions = new HashSet<>();
    }

    @Override
    public boolean isActive() {
        return LocalDate.now().isEqual(celebrationDate);
    }

    public void setCelebrationDate(LocalDate celebrationDate) {
        if (celebrationDate.isAfter(this.celebrationDate))
            this.celebrationDate = celebrationDate;
    }

    public List<Voter> authorizedCensus() {
        return census.stream().filter(voter -> voter.getDateOfBirth().isBefore(thresholdDate)).toList();
    }

    @Override
    public boolean vote(String DNI, List<Answer> answers) {
        Voter voter = getVoterByDNI(DNI);
        boolean isOld = voter.getDateOfBirth().isBefore(thresholdDate);

        if (!isOld)
            for (int conditionedQuestion : conditionedQuestions) {
                if (answers.get(conditionedQuestion) != Answer.BLANK) {
                    return false;
                }
            }

        return super.vote(DNI, answers);
    }

    public void setConditionedQuestions(Integer... positions) {
        conditionedQuestions = Arrays.stream(positions).map(position -> position - 1)
                .filter(position -> position >= 0 && position < numberOfQuestions)
                .collect(Collectors.toSet());
    }
}
