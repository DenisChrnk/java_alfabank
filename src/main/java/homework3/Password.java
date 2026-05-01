package homework3;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Password {
    static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        String [] passwords = {"qwerty", "password21", "1234pasz"};

        boolean scoringResult;

        for (String password: passwords){
            if(password.length() >= 8 &&
               !password.startsWith("1") &&
               !password.endsWith("z") &&
               !password.contains("1234") &&
               !password.contains("qwerty")){
                scoringResult = true;
                System.out.println("Пароль " + password + " прошел проверку: " + scoringResult);
            } else {
                scoringResult = false;
                System.out.println("Пароль " + password + " прошел проверку: " + scoringResult);
            }
        }
    }
}
