import java.util.*;

/**
 * A consultation represents an event in which you can vote on the questions that are raised. The
 * Possible voting options, or answers to the questions, are “yes”, “no” or “blank” (listed).
 * The properties that characterize a query are:
 * - Title: text string that describes the objective of the query. This property can be
 * modified.
 * - Census: set of voters.
 * - Number of questions: integer that establishes the number of questions that the question will contain.
 * consultation.
 * - Questions: list of text strings that represent the questions asked in the
 * consultation. The order in the collection determines the number of the question in the query,
 * taking into account that the question in position 0 will be question number 1, and so
 * successively.
 * - Ready: Boolean property that indicates that all questions are set and are
 * You can start the consultation.
 * - Votes: map that associates the IDs of the voters who have voted with a list that contains
 * the answers issued for each question. For example, {YES, NO, BLANK} means
 * that question 1 has been voted yes, that question 2 has been voted no, while
 * that question 3 has been left blank.
 * - Number of votes cast. It corresponds to the number of entries in the vote map.
 * - Number of voters in the census.
 * - Participation index: corresponds to the quotient between the number of votes cast
 * and the number of voters in the census.
 * The query constructor receives as parameters the title of the query and the number of
 * questions. At construction all collections must be initialized.
 */
public abstract class Consultation {
    private String title;
    protected final Set<Voter> census;
    protected final int numberOfQuestions;
    private final String[] questions;
    private boolean ready;
    private final Map<String, List<Answer>> votes;

    public Consultation(String title, int numberOfQuestions) {
        this.title = title;
        this.numberOfQuestions = numberOfQuestions;
        this.census = new HashSet<>();
        this.questions = new String[numberOfQuestions];
        this.votes = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public boolean isPrepared() {
        return Arrays.stream(questions).allMatch(Objects::nonNull);
    }

    public int numberOfVotesCast() {
        return votes.size();
    }

    public int numberOfVoters() {
        return census.size();
    }

    public float participationIndex() {
        return (float) votes.size() / census.size();
    }


    /**
     * - Add voters: receives as a parameter a variable list of voters (argument
     * variable) and adds them to the census.
     */
    public void addVoters(Voter... voters) {
        addVoters(Arrays.asList(voters));
    }

    public void addVoters(List<Voter> voters) {
        census.addAll(voters);
    }

    /**
     * - Add a question: receives the number and text of the question as parameters. In
     * First of all you have to check if the question number is within the range of
     * consultation questions. If the question number is correct it is added to the collection. If
     * the question already exists is replaced. The method returns a boolean value indicating whether the
     * question has been added successfully.
     */
    public boolean addQuestion(int position, String question) {
        if (position < 1 || position > numberOfQuestions)
            return false;
        questions[position - 1] = question;
        return true;
    }

    /**
     * - Delete a question: receives as a parameter the number of the question you want to
     * delete. Returns a boolean value to indicate whether the question has been deleted.
     */
    public boolean removeAQuestion(int position) {
        if (position < 1 || position > numberOfQuestions)
            return false;
        if (questions[position - 1] == null)
            return false;
        questions[position - 1] = null;
        return true;
    }

    /**
     * - Obtain the voter associated with an ID. If it does not find it, it will return null.
     */
    public Voter getVoterByDNI(String DNI) {
        return census.stream().filter(voter -> voter.getDNI().equals(DNI))
                .findFirst()
                .orElse(null);
    }

    /**
     * - Check if a voter is on the census. To do this, it receives the ID as a parameter and
     * returns true if there is a voter with that ID in the census, false otherwise.
     */
    public boolean censusContains(String voterID) {
        return census.stream().anyMatch(_voter -> voterID.equals(_voter.getDNI()));
    }

    /**
     * - Check if a voter has voted. It receives the ID as a parameter and checks if there is a
     * cast vote (that is, an entry in the vote map) associated with that ID.
     */
    public boolean hasVotes(String voterID) {
        return votes.containsKey(voterID);
    }

    /**
     * - Obtain the scrutiny of a question: this method receives as a parameter the number of
     * the question and returns a map that associates the number of votes with each possible answer,
     * that is, we return the number of “yeses”, the number of “noes” and the number of votes in
     * white cast for that question. For example, suppose the vote map of the
     * query that has been created is the one in the figure:
     */
    public Map<Answer, Integer> getScrutinyOfQuestions(int position) {
        if (position < 1 || position > numberOfQuestions)
            return null;

        Map<Answer, Integer> result = new HashMap<>();

        result.put(Answer.NO, 0);
        result.put(Answer.YES, 0);
        result.put(Answer.BLANK, 0);

        for (List<Answer> answers : votes.values()) {
            Answer vote = answers.get(position - 1);
            result.put(vote, result.get(vote) + 1);
        }

        return result;
    }

    /**
     * Vote. This operation receives as a parameter the ID of the voter who is going to cast their vote and
     * a list with the answers for each of the questions. This method returns a value
     * boolean to indicate whether it was possible to vote or not. In general, in order to vote,
     * must ensure that: 1) the consultation is prepared, 2) the consultation is active, 3) the voter
     * is on the census, 4) that the voter has not already voted and 5) that the size of the list of
     * answers to be voted on match the number of questions in the consultation. Whether
     * meet these conditions, a new vote is added associating the voter's ID with the list
     * of answers you vote for to each question. To implement this method,
     * You must apply the programming concept of the template method, since you have to
     * support in the implementation of the method that queries if the query is active that
     * It depends on the subclasses.
     */
    public boolean vote(String DNI, List<Answer> answers) {
        if (!isActive()) return false;
        if (!isPrepared()) return false;
        if (!censusContains(DNI)) return false;
        if (hasVotes(DNI)) return false;
        if (answers.size() != numberOfQuestions) return false;

        votes.put(DNI, answers);
        return true;
    }

    /**
     * Overloaded version of the 'vote' method that receives as a parameter the voter's ID and a
     * variable argument with the answers to each question.
     */
    public boolean vote(String DNI, Answer... answers) {
        return vote(DNI, Arrays.asList(answers));
    }

    public boolean vote(String DNI) {
        return vote(DNI, Collections.nCopies(numberOfQuestions, Answer.BLANK));
    }

    public abstract boolean isActive();
}
