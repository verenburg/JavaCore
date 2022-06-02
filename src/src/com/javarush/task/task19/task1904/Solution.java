package src.com.javarush.task.task19.task1904;

import javafx.scene.control.Skin;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String line = scanner.nextLine();
            String[] rec = line.split(" ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            String bdString = rec[3] + "/" + rec[4] + "/" + rec[5];
            Date bd = sdf.parse(bdString);
            Person person = new Person(rec[1],rec[2],rec[0],bd);
            return person;
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
