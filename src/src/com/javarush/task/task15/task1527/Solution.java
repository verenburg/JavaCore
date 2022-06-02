package src.com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        String s1 = url.substring(url.indexOf('?') + 1, url.indexOf('&'));
        list.add(s1);
        String newline = url.substring(url.indexOf('&') + 1);

        while (true){

            if (!newline.contains("&")) {
                list.add(newline);
                break;
            }

            list.add(newline.substring(0 , newline.indexOf('&')));
            newline = newline.substring(newline.indexOf('&') + 1);
        }
        for (String s : list){
            try {
                double d = Double.parseDouble(s);
                alert(d);
            }catch (Exception e){
                alert(s);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
