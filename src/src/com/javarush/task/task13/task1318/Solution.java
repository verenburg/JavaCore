package src.com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filepath = br.readLine();
        br.close();

        FileInputStream reader = new FileInputStream(filepath);
        String s = "";
        while (reader.available() > 0) {
            char c = (char)reader.read();
            s += "" + c;
        }
        System.out.println(s);
        reader.close();
    }
}