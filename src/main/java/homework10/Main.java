package homework10;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        Task task1 = new Task("Задача 1", false);
        Task task2 = new Task("Задача 2", false);
        TaskTracker taskTracker = new TaskTracker();

        taskTracker.addTaskToList(task1);
        System.out.println();
        taskTracker.addTaskToList(task2);
        System.out.println();
        taskTracker.getAllTasks();
        System.out.println();
        taskTracker.doTaskDone("Задача 1");
        System.out.println();
        taskTracker.statusOfTask("Задача 1");
        System.out.println();
        taskTracker.getTasksStatistics();
    }
}
