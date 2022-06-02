package src.com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fn));
        String line = "";
        String newword = "";
        String newline = "";
        while (fileReader.ready()){
            line = fileReader.readLine();
            String[] words = line.split(" ");
            for (String word : words){
                if (word.contains(".")) {
                    newword = number(word.substring(0,word.length()-1)) + ".";
                }
                else if (word.contains(",")) {
                    newword = number(word.substring(0,word.length()-1)) + ",";
                }
                else {
                    newword = number(word);
                }
                newline += newword + " ";
            }
            System.out.println(newline);
            newline = "";
        }
        fileReader.close();
    }

    public static String number(String s) {
        String result = "";
        int num = 0;
        try {
            num = Integer.parseInt(s);
            if (num <= 12 && num >= 0){
                result = map.get(num);
            }
        } catch (NumberFormatException e){
            result = s;
        }
        return result;
    }
}
