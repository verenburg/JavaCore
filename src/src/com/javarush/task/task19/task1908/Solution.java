package src.com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fn1);
        FileWriter fileWriter = new FileWriter(fn2);
        StringBuilder s = new StringBuilder();
        while (fileReader.ready()){
            s.append((char)fileReader.read());
        }
        String line = s.toString();
        String[] strings = line.split(" ");
        for (String str : strings){
            if (str.matches("-{0,1}\\d{1,100}")) {
                // -{0,1} знак перед цифрой, \d{1,100} число длиной от 1 до 100 цифр.
                fileWriter.write(str + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
