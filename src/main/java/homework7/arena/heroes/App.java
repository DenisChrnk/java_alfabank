package homework7.arena.heroes;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        Hero[] heroes = {
                new Knight("Артур"),
                new Archer("Леголас"),
                new Mage("Гендальф")};

        for (Hero hero : heroes) {
            hero.printInfo();
            hero.attack();
            System.out.println();
        }

        final Knight knight = new Knight("Ричард");
        System.out.println(knight);
        knight.name = "Олег";
        System.out.println(knight);
    }
}
