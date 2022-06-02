package src.com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        int count = 0;
        int symbol = 0;
        while (fileReader.ready()){
            symbol = fileReader.read();
            if(symbol == 87 || symbol == 119){
                symbol = fileReader.read();
                if (symbol == 79 || symbol == 111){
                    symbol = fileReader.read();
                    if (symbol == 82 || symbol == 114){
                        symbol = fileReader.read();
                        if (symbol == 76 || symbol == 108){
                            symbol = fileReader.read();
                            if (symbol == 68 || symbol == 100) count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
