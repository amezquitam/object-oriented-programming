

public class Task {
    private static final int DEFAULT_HOURS_PER_TASK = 10;

    private final String description;
    private final int timeInHours;
    private final Phase phase;

    public Task(String description, int timeInHours, Phase phase) {
        this.description = description;
        this.timeInHours = timeInHours;
        this.phase = phase;
    }

    public Task(String description, Phase phase) {
        this(description, DEFAULT_HOURS_PER_TASK, phase);
    }

    public String getDescription() {
        return description;
    }

    public int getTimeInHours() {
        return timeInHours;
    }

    public Phase getPhase() {
        return phase;
    }

    
}
