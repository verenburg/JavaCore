package src.com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(1.25,"Строка 1");
        labels.put(1.50,"Строка 2");
        labels.put(1.75,"Строка 3");
        labels.put(2.00,"Строка 4");
        labels.put(2.25,"Строка 5");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
