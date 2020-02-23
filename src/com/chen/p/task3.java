package com.chen.p;


// 3. Есть List объектов у каждого из которых 2 поля: int и String. Удалить те у которых значения int повторяются(оставить по одному из дубликатов).

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class task3 {

    private static final Random RANDOM = new Random();

    private static class Test {
        private int i = 0;
        private String s = "";

        private Test(int i, String s) {
            this.i = i;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Test)) return false;
            Test test = (Test) o;
            return i == test.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i);
        }

        @Override
        public String toString() {
            return "\nTest { " +
                    "i=" + i +
                    ", s=\" " + s + " \"" +
                    "}";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\com\\chen\\p\\test.txt");
        Scanner sc = new Scanner(file);
        String[] strings = new String[64];
        StringBuilder sb = new StringBuilder("");
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        strings = sb.toString().split("\\s+");
        ArrayList<Test> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Test(RANDOM.nextInt(5), strings[RANDOM.nextInt(64)]));
        }
        System.out.println("List size is " + list.size());
        System.out.println(list.toString());
        Set<Test> set = new HashSet<Test>(list);
        for (Test temp : set) {
            System.out.print(temp);
        }
    }

}
