package com.chen.p;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 2. Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов
public class task2 {

    public static int wordCount = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\com\\chen\\p\\test.txt");
        Scanner sc = new Scanner(file);
        int lineCount = 0;

        int symbolCount = 0;
        while (sc.hasNextLine()) {
            lineCount++;
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                symbolCount++;
                if (s.charAt(i) == ' ') {
                    wordCount++;
                }
            }
            System.out.println(s);
        }
        System.out.println();
        System.out.println("Lines " + lineCount);
        System.out.println("Words " + wordCount);
        System.out.println("Symbols " + symbolCount);
    }

}
