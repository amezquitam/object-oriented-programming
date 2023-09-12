import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Project project = new Project("project");

        project.addTask("Extraccion de requisitos", 12, Phase.ANALISYS);
        project.addTask("Definicion de casos de uso", 6, Phase.ANALISYS);
        project.addTask("Diseño del modelo de datos", 10, Phase.DESIGN);
        project.addTask("Implementacion de la UI", 20, Phase.IMPLEMENTATION);
        project.addTask("Implementacion del model", 20, Phase.IMPLEMENTATION);
        project.addTask("Implementacion de las pruebas", 8, Phase.IMPLEMENTATION);
        project.addTask("Configuracion del base de datos", 4, Phase.DEPLOY);
        project.addTask("Instalacion del servidor", 6, Phase.DEPLOY);
        project.addTask("Programacion nuevos requisitos", 20, Phase.MAINTENANCE);


        ArrayList<Task> toRemove = new ArrayList<>();
        
        for (Task task : project.getAllTasks()) {
            if (task.getTimeInHours() < 7)
                toRemove.add(task);
        }

        for (Task task: toRemove) {
            project.removeTask(task);
        }

        for (Task task : project.getTasksByPhase(Phase.ANALISYS)) {
            project.completeTask(task);
        }

        System.out.println("Project");
        System.out.println("name: " + project.getName());

        System.out.println("Todas las tareas:");
        for (Task task: project.getAllTasks()) {
            System.out.println("{");
            System.out.println("\tDescripcion: " + task.getDescription());
            System.out.println("\tDuracion (horas): " + task.getTimeInHours());
            System.out.println("\tFase: " + task.getPhase());
            System.out.println("}");
        }

        System.out.println("Tareas completadas:");
        for (Task task: project.getCompletedTasks()) {
            System.out.println("{");
            System.out.println("\tDescripcion: " + task.getDescription());
            System.out.println("\tDuracion (horas): " + task.getTimeInHours());
            System.out.println("\tFase: " + task.getPhase());
            System.out.println("}");
        }

        System.out.println("Duracion del proyecto: " + project.getDurationTotalInHours() + " horas");
    }
}
