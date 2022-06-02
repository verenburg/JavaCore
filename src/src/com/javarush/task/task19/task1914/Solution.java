package src.com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream save = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String[] words = outputStream.toString().split(" ");
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[2]);
        int result = 0;
        if (words[1].equals("+")) result = a + b;
        if (words[1].equals("-")) result = a - b;
        if (words[1].equals("*")) result = a * b;

        System.setOut(save);
        System.out.print(a + " " + words[1] + " " + b + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

