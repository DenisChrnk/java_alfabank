package homework13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {
    public void demonstrateListCreation() {
        List<String> mainSquad = new ArrayList<>();
        mainSquad.add("Костя");
        mainSquad.add("Петя");
        mainSquad.add("Вася");
        mainSquad.add("Саня");

        List<String> supportSquad = Arrays.asList("Гоша","Аня","Настя");

        List<String> eliteSquad = List.of("Лена","Борат");

        try {
            mainSquad.add("Олег");
            System.out.println("Успех");
        } catch (RuntimeException e){
            throw new RuntimeException("Ошибка " + e.getMessage());
        }

        try {
            mainSquad.remove("Олег");
            System.out.println("Успех");
        } catch (RuntimeException e){
            throw new RuntimeException("Ошибка " + e.getMessage());
        }

//        try {
//            supportSquad.add("Олег");
//            System.out.println("Успех");
//        } catch (RuntimeException e){
//            throw new RuntimeException("Ошибка " + e.getMessage());
//        }
//
//        try {
//            supportSquad.remove("Олег");
//            System.out.println("Успех");
//        } catch (RuntimeException e){
//            throw new RuntimeException("Ошибка " + e.getMessage());
//        }
//
//        try {
//            eliteSquad.add("Олег");
//            System.out.println("Успех");
//        } catch (RuntimeException e){
//            throw new RuntimeException("Ошибка " + e.getMessage());
//        }
//
//        try {
//            eliteSquad.remove("Олег");
//            System.out.println("Успех");
//        } catch (RuntimeException e){
//            throw new RuntimeException("Ошибка " + e.getMessage());
//        }
    }

    public void filterOutCowards(List<String> squad){
        System.out.println("Список до фильрации: " + squad);

        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()){
            String solder = iterator.next();
            if (solder.startsWith("Трус")){
            iterator.remove();
            }
        }
        System.out.println("Список после фильтрации: " + squad);
    }
}
