package src.com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream isr = new FileInputStream(filename);
        int max = 0;
        int byt = 0;
        while (isr.available() > 0) {
            if ((byt = isr.read()) > max) max = byt;
        }
        System.out.println(max);
    }
}
