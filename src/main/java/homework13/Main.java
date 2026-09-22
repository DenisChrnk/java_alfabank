package homework13;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        ArrayList<Alien> aliens = new ArrayList<>();

        aliens.add(new Alien("Олег", "Юпитер", 6));
        aliens.add(new Alien("Вася", "Сатрурн", 7));
        aliens.add(new Alien("Кирилл", "Марс", 9));
        aliens.add(new Alien("Олег", "Юпитер", 2));
        aliens.add(new Alien("Некит", "Венера", 6));


        //Проверка на дубль
        Set<Alien> unique = new HashSet<>();
        boolean alienDuplicate = false;
        for (Alien alien : aliens) {
            if (!unique.add(alien)) {  // add вернёт false, если уже есть
                alienDuplicate = true;
                break;
            }
        }
        System.out.println(alienDuplicate);

        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreation();

        List<String> cowards = new ArrayList<>();
        cowards.add("Аня");
        cowards.add("Петя");
        cowards.add("Трус Олег");
        cowards.add("Трус Петя");
        cowards.add("Трус Вася");

        squadManager.filterOutCowards(cowards);

        AssaultQueue assaultQueue = new AssaultQueue();

        assaultQueue.addRecruit("Тимур");
        assaultQueue.addRecruit("Лев");
        assaultQueue.addRecruit("Вова");
        assaultQueue.addRecruit("Саша");
        assaultQueue.addRecruit("Максим");

        assaultQueue.retreatCoward();
        assaultQueue.retreatCoward();

        assaultQueue.addRecruit("Глеб");
        assaultQueue.addRecruit("Петя");
        assaultQueue.addRecruit("Вася");

        assaultQueue.printQueue();

        MissionReport missionReport1 = new MissionReport("Штурм зоны 51", aliens, 20);
        System.out.println(missionReport1);
        MissionReport missionReport2 = new MissionReport("Штурм зоны 51", aliens, 20);

        System.out.println("Сравнение через == " + (missionReport1 == missionReport2));
        System.out.println("Сравнение через equals " + missionReport1.equals(missionReport2));

    }
}