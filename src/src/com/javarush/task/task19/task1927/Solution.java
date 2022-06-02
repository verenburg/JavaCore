package src.com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Solution.testString.printSomething();
        System.setOut(printStream);

        String[] set = outputStream.toString().split("\\n");
        int count = 0;
        for (String s : set) {
            System.out.println(s);
            count++;
            if (count == 2) {
                System.out.println("JavaRush - курсы Java онлайн");
                count = 0;
            }
        }
    }



    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
