package src.com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameS = reader.readLine();
        String fileNameR = reader.readLine();
        reader.close();

        FileReader freader = new FileReader(fileNameS);
        FileWriter writer = new FileWriter(fileNameR);
        String result = "";
        while (freader.ready()){
            freader.read();
            writer.write(freader.read());
        }
        freader.close();
        writer.close();
    }
}
