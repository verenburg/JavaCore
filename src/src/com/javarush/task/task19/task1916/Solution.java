package src.com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        reader.close();

        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fn1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fn2));

        while (bufferedReader1.ready()){
            first.add(bufferedReader1.readLine());
        }
        while (bufferedReader2.ready()){
            second.add(bufferedReader2.readLine());
        }

        bufferedReader1.close();
        bufferedReader2.close();

        int i = 0; // индекс перебора по первому списку
        int j = 0; // индекс перебора по второму списку

        while (i < first.size() && j < second.size()) {
            if (first.get(i).equals(second.get(j))) {
                lines.add(new LineItem(Type.SAME, first.get(i)));
                i++;
                j++;
            } else if ((j + 1 < second.size()) && first.get(i).equals(second.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED,second.get(j)));
                j++;
            } else if ((i + 1 < first.size()) && first.get(i + 1).equals(second.get(j))){
                lines.add(new LineItem(Type.REMOVED,first.get(i)));
                i++;
            }
        }

        while (i < first.size()) {
            lines.add(new LineItem(Type.REMOVED, first.get(i)));
            i++;
        }
        while (j < second.size()) {
            lines.add(new LineItem(Type.ADDED, second.get(j)));
            j++;
        }
        /*for (LineItem line : lines){
            System.out.println(line);
        }*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        /*@Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }*/
    }
}
