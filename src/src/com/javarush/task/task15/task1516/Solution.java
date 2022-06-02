package src.com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.io.IOException;

public class Solution {

    public int intVar = 1;
    public double doubleVar = 1.25;
    public Double DoubleVar = 1.54;
    public boolean booleanVar = true;
    public Exception ExceptionVar = new IOException();
    public String StringVar = "По умолчанию";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intVar);
        System.out.println(solution.doubleVar);
        System.out.println(solution.DoubleVar);
        System.out.println(solution.booleanVar);
        System.out.println(solution.ExceptionVar);
        System.out.println(solution.StringVar);

    }
}
