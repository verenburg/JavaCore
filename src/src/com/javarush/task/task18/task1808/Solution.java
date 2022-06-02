package src.com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        try {
            String file = reader.readLine();
            String half1File = reader.readLine();
            String half2File = reader.readLine();
            reader.close();

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos1 = new FileOutputStream(half1File);
            FileOutputStream fos2 = new FileOutputStream(half2File);

            int half = fis.available() % 2;
            while (fis.available() > 0){
                if (fis.available() <= half){
                    fos2.write(fis.read());
                } else {
                    fos1.write(fis.read());
                }
            }

        } catch (IOException e) {

        }

    }
}
