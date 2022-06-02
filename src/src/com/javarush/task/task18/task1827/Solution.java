package src.com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static String fildSize(int Nulls, String s) {
        String ad = "";
        for (int i = 0; i < Nulls; i++){
            ad += " ";
        }
        String line = s + ad;
        line = line.substring(0,Nulls);
        return line;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("E:\\Test\\Оригинал.txt"));
        int max = 0;
        int id = 0;
        while (reader.ready()){
            String line = reader.readLine();
            String idLine = line.substring(0,7);
            id = Integer.parseInt(idLine.trim());
            if (id > max) max = id;
        }
        reader.close();

        String Id = Solution.fildSize(8,"" + ++id);
        String productName = Solution.fildSize(30, "" + args[1]);
        String price  = Solution.fildSize(8, "" + args[2]);
        String quantity = Solution.fildSize(4, "" + args[3]);

        String lineOut = "\n" + Id + productName + price + quantity;

        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Test\\Оригинал.txt",true));
        writer.write(lineOut);
        writer.close();
    }
}
