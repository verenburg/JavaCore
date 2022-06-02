package src.com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Алгоритмы-числа
*/
//     Задача решена, но решена в лоб и скорость ее работы непримемлимо низкая ,
//     Нужно прочитать про числа армстронга и применть обновленный алгоритм сокращающий количество вычислений
//    https://acmp.ru/article.asp?id_text=198
//    https://github.com/shamily/ArmstrongNumbers


public class Solution {

    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        String number = "";
        for (int i = 0; i <= N; i++){
            number = i + "";
            int stepen = number.length();
            char[] chars = number.toCharArray();
            String s = "";
            long chislo = 0;
            for (char c : chars) {
                int cifra = Character.getNumericValue(c);
                chislo += Math.pow(cifra,stepen);
            }
            if (i == chislo) list.add(chislo);
        }
        long[] result =new long[list.size()];
        for (int l = 0; l < list.size(); l++) {
            result[l] = list.get(l);
        }
        return result;
    }

    public static long[][] stepencyfry(){
        long[][] matrix = new long[10][20];
        long temp = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 1; j < 20; j++){
                for (int k = 0; k < j; k++){
                    temp *= i;
                }
                matrix [i][j] = temp;
                temp = 1;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
