package homework5;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Random;

public class Homework5 {

    static LocalDate date = LocalDate.now();
    static String year = String.valueOf(date.getYear());
    static int pow = (int) Math.pow(3, 7);

    static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));


        String accessCode = generateAccessCode();
        boolean validCode = isValidCode(accessCode,8);
        System.out.println(validCode);
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        String agentId1 = generateAgentId("AGENT", 42);
        System.out.println(agentId1);
        String agentId2 = generateAgentId("AGENT", 77);
        System.out.println(agentId2);
        String agentId3 = generateAgentId("AGENT", 13);
        System.out.println(agentId3);

    }


    public static String generateAccessCode() {
        return year + "-" + pow;
    }

    private static boolean isValidCode(String code, int minLength) {
        if (code != null && code.length() >= minLength && code.contains("-")) {
            return true;
        } else {
            return false;
        }
    }

    public static void logEvent(String message) {
        System.out.println("[INFO]" + "{" + message + "}");
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.println("[CRITICAL]" + "{" + message + "}");
        } else {
            logEvent(message);
        }
    }

    private static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);
        int randomInt = Math.abs(random.nextInt(1000, 10000));
        return "[" + prefix + "]-" + "{" + randomInt + "}";
    }
}
