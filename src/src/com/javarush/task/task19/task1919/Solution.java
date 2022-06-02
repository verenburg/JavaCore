package src.com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Map<String,Double> map = new HashMap<String, Double>();
        String[] line;
        while (reader.ready()){
            line = reader.readLine().split(" ");
            try {
                if (!map.get(line[0]).equals(null)) {
                    map.put(line[0], map.get(line[0]) + Double.parseDouble(line[1]));
                }
            } catch (NullPointerException e) {
                map.put(line[0], Double.parseDouble(line[1]));
            }
        }
        Map<String,Double> result = new HashMap<String, Double>();
        Set<String> set =  map.keySet();
        ArrayList<String> list = new ArrayList<>();
        for (String item : set){
            list.add(item);
        }
        Collections.sort(list);
        for (String s : list) {
            result.put(s,map.get(s));
            System.out.println(s + " " + map.get(s));
        }
    }
}
