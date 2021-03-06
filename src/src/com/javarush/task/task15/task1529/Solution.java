package src.com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока

*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String parametr = reader.readLine();
            if ("helicopter".equals(parametr)) {
                result = new Helicopter();
            }
            if ("plane".equals(parametr)) {
                int kol = Integer.parseInt(reader.readLine());
                result = new Plane(kol);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
