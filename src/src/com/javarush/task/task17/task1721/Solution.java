package src.com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();

            BufferedReader firstReader = new BufferedReader(new FileReader(firstFileName));
            String input;
            while (firstReader.ready()){
                input = firstReader.readLine();
                allLines.add(input);
            }
            firstReader.close();

            BufferedReader secondReader = new BufferedReader(new FileReader(secondFileName));
            while (secondReader.ready()){
                input = secondReader.readLine();
                forRemoveLines.add(input);
            }            
            secondReader.close();

            new Solution().joinData();
        } catch (Exception ignore) {
        }
        
    }


    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
        
    }
}
