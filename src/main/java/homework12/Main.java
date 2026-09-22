package homework12;

import homework12.exceptions.BaggageTagPrintException;
import homework12.exceptions.FlightNotFoundException;
import homework12.exceptions.InvalidBaggageWeightException;
import homework12.exceptions.InvalidPassengerNameException;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        List<String> flights;
        flights = new ArrayList<>(List.of("SU-123", "TK-777", "KC-909", "AE-404"));

        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(flights);

        try {
            baggageDropDesk.baggageDropOff("", "KC-909", 56);
        } catch (InvalidPassengerNameException e){
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InvalidBaggageWeightException e){
            System.out.println("Ошибка: " + e.getMessage());
        } catch (FlightNotFoundException e){
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BaggageTagPrintException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
