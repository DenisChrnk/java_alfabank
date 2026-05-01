package homework3;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Homework3Arrays {
    static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        String[] petya = {"курица", "бананы", "творого"};
        String[] kolya = {"курица", "бананы", "творого"};
        String[] terentiy = {"пиво", "пельмени", "ласка магия черного"};

        //Сравнение ро количеству
        boolean differenceSizeBetweenPetyaAndKolya = petya.length == kolya.length;
        boolean differenceSizeBetweenPetyaAndTerentiy = petya.length == terentiy.length;

        System.out.println("Разное количество товаров в корзине у Пети и Коли: " + differenceSizeBetweenPetyaAndKolya);
        System.out.println("Разное количество товаров в корзине у Пети и Терентия: " + differenceSizeBetweenPetyaAndTerentiy);

        //Сравнение по содержимому
        boolean differenceBetweenPetyaAndKolya = Arrays.equals(petya, kolya);
        boolean differenceBetweenPetyaAndTerentiy = Arrays.equals(petya, terentiy);

        System.out.println("Совпадение товаров в корзине Пети и Коли - " + differenceBetweenPetyaAndKolya);
        System.out.println("Совпадение товаров в корзине Пети и Терентия - " + differenceBetweenPetyaAndTerentiy);

        //Задание с самым длинным словом
        ArrayList<String> allWords = new ArrayList<>();

        for (String word : petya) {
            allWords.add(word);
        }

        for (String word : kolya) {
            allWords.add(word);
        }

        for (String word : terentiy) {
            allWords.add(word);
        }

        String longestWord = "";

        for (String wordForComparison : allWords) {
            if (wordForComparison.length() > longestWord.length()) {
                longestWord = wordForComparison;
            }
        }

        System.out.println("Самое длинное слово: " + longestWord);

        //Самое короткое слово

        String shortestWord = longestWord;

        for (String wordForComparison : allWords) {
            if (wordForComparison.length() < shortestWord.length()) {
                shortestWord = wordForComparison;
            }
        }

        System.out.println("Самое короткое слово: " + shortestWord);

        //Средняя длина названия товара
        StringBuilder allStrings = new StringBuilder();
        for (String wordForComparation : allWords){
            allStrings.append(wordForComparation);
        }
        double intermediateSize = (double) allStrings.length()/allWords.size();

        System.out.println("Средняя длина слова: " + intermediateSize);
    }
}
