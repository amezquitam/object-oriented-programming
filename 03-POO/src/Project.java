import java.util.ArrayList;
import java.util.stream.Collectors;

public class Project {
    private String name;
    private ArrayList<Task> allTasks;
    private ArrayList<Task> completedTasks;
    private int durationTotalInHours;

    public Project(String name) {
        this.name = name;
        this.allTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasksByPhase(Phase phase) {
        return  allTasks.stream()
            .filter(task -> task.getPhase().equals(phase))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private void recalculateDuration() {
        durationTotalInHours = allTasks.stream().reduce(0, (subTotal, task) -> subTotal + task.getTimeInHours(), Integer::sum);
    }

    public Task addTask(String description, int timeInHours, Phase phase) {
        Task newTask = new Task(description, timeInHours, phase);
        allTasks.add(newTask);
        recalculateDuration();
        return newTask;
    }

    public boolean removeTask(Task task) {
        boolean removed = allTasks.remove(task);
        recalculateDuration();
        return removed;
    }

    public boolean completeTask(Task task) {
        if (!allTasks.contains(task)) return false;
        if (completedTasks.contains(task)) return false;
        return completedTasks.add(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }

    public int getDurationTotalInHours() {
        return durationTotalInHours;
    }

}
