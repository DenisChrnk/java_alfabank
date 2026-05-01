package homework4;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework4 {
    static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        //Задание с посланием
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите слово: ");
            String stringForBuilder = scanner.nextLine();
            if (stringForBuilder.equalsIgnoreCase("null")) {
                stringBuilder.append("XX#");
                System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...");
            } else {
                stringBuilder.append(stringForBuilder + "#");
            }
        }

        System.out.println("Расшифрованное послание: " + stringBuilder);

        //Задание "Ночная смена в QA-департаменте
        List<String> flaky = new ArrayList<>();
        List<String> bug = new ArrayList<>();
        List<String> critical = new ArrayList<>();
        List<String> pass = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 != 0){
                flaky.add("Flaky");
                System.out.printf("Тест #%d: Flaky \n", i);
            } else if (i % 5 == 0 && i % 3 != 0) {
                bug.add("Bug");
                System.out.printf("Тест #%d: Bug \n", i);
            } else if (i % 3 == 0 && i % 5 == 0) {
                critical.add("Critical");
                System.out.printf("Тест #%d: Critical! \n", i);
            } else {
                pass.add("Pass");
                System.out.printf("Тест #%d: Pass \n", i);
            }
        }

        int totalTests = pass.size() + flaky.size() + bug.size() + critical.size();

        System.out.println("===== ИТОГИ НОЧНОЙ СМЕНЫ =====");
        System.out.printf("Всего тестов %d \n", totalTests);
        System.out.printf("Pass: %d \n", pass.size());
        System.out.printf("Flaky: %d \n", flaky.size());
        System.out.printf("Bug: %d \n", bug.size());
        System.out.printf("Critical: %d \n", critical.size());
    }

}
