package src.com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try {
            while (true) {
                fileName = reader.readLine();
                FileInputStream fis = new FileInputStream(fileName);
                fis.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        } catch (IOException e1) {

        }
    }
}
