package src.com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(nod(a,b));
    }

    public static int nod(int a, int b) {
        int del = 0;
        while (true) {
            if (a > b) del = a - b;
            else del = b - a;
            a = b;
            b = del;
            if (del == 0) return a;
        }
    }
}
