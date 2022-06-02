package src.com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            reader.close();

            InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
            int count = 0;
            while (isr.ready()) {
                if (isr.read() == ',') count++;
            }

            System.out.println(count);
            
            isr.close();
        } catch (IOException e){
            System.out.println("По указанному пути файл не найден.");
        }
    }
}
