package src.com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        if (true) throw new RuntimeException(); //exception here - выбросьте эксепшн тут
    }

    public static int B = 5;

    public static void main(String[] args) throws Exception {
        System.out.println(B);
    }
}
