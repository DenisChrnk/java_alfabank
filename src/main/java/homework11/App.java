package homework11;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        //Проверка InputMismatchException
        try {
            System.out.println("Укажите количество воды в мл");
            int amountOfWater = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        }

        //Проверка своего исключения
        try {
            coffeeMachine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            System.out.println(e);
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        //Проверка ArithmeticException
        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Размер чашки не может быть 0");
        }

        //Проверка NullPointerException
        String coffeeName = null;
        try {
            coffeeMachine.printCoffeeName(coffeeName);

        } catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутсвует");
        }
    }
}
