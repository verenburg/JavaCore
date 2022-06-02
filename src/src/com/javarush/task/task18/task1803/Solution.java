package src.com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        Map<Byte, Integer> map = new HashMap<>();
        FileInputStream isr = new FileInputStream(filename);
        byte b = 0;
        int Value = 0;
        while (isr.available() > 0) {
            b = (byte) isr.read();
            if (map.containsKey(b)) {
                Value = map.get(b) + 1;
                map.put(b,Value);
            } else {
                map.put(b,1);
            }
        }

        ArrayList<Integer> list = (ArrayList<Integer>) map.values();
        Collections.sort(list);
        int max = list.get(list.size() - 1);
        String result;
        for (Map.Entry<Byte,Integer> pair : map.entrySet()){
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
