package src.com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = fileNameReader.readLine();
        fileNameReader.close();

        Scanner fileReader = new Scanner(new FileInputStream(filename));
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        int num = 0;
        while (fileReader.hasNext()) {
            num = Integer.parseInt(fileReader.next());
            if (num % 2 == 0)
                evenNumbers.add(num);
        }
        fileReader.close();

        Collections.sort(evenNumbers);

        for (int n : evenNumbers){
            System.out.println(n);
        }
    }
}
