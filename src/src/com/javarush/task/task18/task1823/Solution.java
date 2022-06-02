package src.com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = reader.readLine()).equals("exit")) {
            new ReadThread(line).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(this.fileName);
                int[] arr = new int[256];
                while (fis.available() > 0){
                    arr[fis.read()]++;
                }
                fis.close();

                Arrays.sort(arr);
                resultMap.put(this.fileName,arr[255]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
