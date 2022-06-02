package src.com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        while (fis.available() > 0) {
           byte b = (byte) fis.read();
           if (args[0].equals("-e")) b++;
           if (args[0].equals("-d")) b--;
           fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
