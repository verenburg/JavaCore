package src.com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {

    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(fileName);
        if (fis.available() < 1000) {
            fis.close();
            throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
