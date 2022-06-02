package src.com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSource = reader.readLine();
        String fileGetter = reader.readLine();
        reader.close();

        //String fileSource = "E:\\Test\\Оригинал.txt";
        //String fileGetter = "E:\\Test\\Оригинал3.txt";


        BufferedReader fileReader = new BufferedReader(new FileReader(fileSource));
        FileWriter fileWriter = new FileWriter(fileGetter);

        ArrayList<Double> numbs = new ArrayList<>();
        while (fileReader.ready()){
            numbs.addAll(stringArr(fileReader.readLine()));
        }

        for (double d : numbs) {
            fileWriter.write("" + Math.round(d) + " ");
        }

        fileReader.close();
        fileWriter.close();
    }

    public static ArrayList<Double> stringArr(String s) {
        String[] Arr = s.split(" ");
        ArrayList<Double> ArrDouble= new ArrayList<>();
        for (String unit : Arr){
            ArrDouble.add(Double.parseDouble(unit));
        }
    return ArrDouble;
    }

    public static long okrugl(double d){
        if (d > 0) return Math.round(d);
        if (d < 0) {
            long celoe = (long)d;
            double drob = d % 1;
            if (Math.round(Math.abs(drob)*100) >= 51) celoe--;
            return celoe;
        }
        return 0;
    }
}
