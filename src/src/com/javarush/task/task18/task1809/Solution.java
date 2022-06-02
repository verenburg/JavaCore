package src.com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourceName = reader.readLine();
        String fileRecipientName = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(fileSourceName);
        FileOutputStream fos = new FileOutputStream(fileRecipientName);

        byte[] buffer = new byte[fis.available()];
        int count = 0;
        count = fis.read(buffer);
        fis.close();

        for (int i = count; i > 0; i--){
            fos.write(buffer[i]);
        }
        fos.close();
    }
}
