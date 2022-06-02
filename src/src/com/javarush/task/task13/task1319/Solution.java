package src.com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String s;

        while (true){
            s = reader.readLine();
            list.add(s);
            if (s.equals("exit")) break;
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String s1 : list){
            writer.write(s1);
            if (!s1.equals("exit")) writer.write('\n');
        }
        writer.close();

    }
}
