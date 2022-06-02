package src.com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int[] arr = new int[128];

        while (fis.available() > 0){
            byte b = (byte) fis.read();
            try {
                arr[b]++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(b + " " );
            }
        }

        for (int i=0; i < arr.length; i++) {
            if (arr[i] != 0) System.out.println((char)i + " " + arr[i]);
        }

        fis.close();
    }
}
