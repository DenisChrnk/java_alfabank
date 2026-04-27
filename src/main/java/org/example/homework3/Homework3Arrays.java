package org.example.homework3;

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

        String [] petya = {"курица", "бананы", "творого"};
        String [] kolya = {"курица", "бананы", "творого"};
        String [] terentiy = {"пиво", "пельмени", "ласка магия черного"};

        boolean differenceBetweenPetyaAndKolya = Arrays.equals(petya, kolya);
        boolean differenceBetweenPetyaAndTerentiy = Arrays.equals(petya, terentiy);

        System.out.println("Совпадение корзины Пети и Коли - " + differenceBetweenPetyaAndKolya);
        System.out.println("Совпадение корзины Пети и Терентия - " + differenceBetweenPetyaAndTerentiy);

        //Задание с самым длинным словом

        ArrayList<String> allWords = new ArrayList<>();

        for (String word: petya){
            allWords.add(word);
        }

        for (String word: kolya){
            allWords.add(word);
        }

        for (String word: terentiy){
            allWords.add(word);
        }

        String longestWord = "";

        for (String wordForComparison: allWords){
            if (wordForComparison.length() > longestWord.length()){
                longestWord = wordForComparison;
            }
        }

        System.out.println("Самое длинное слово: " + longestWord);
    }
}
