package src.com.javarush.task.task17.task1711;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> sexes = new ArrayList<>();
        ArrayList<Date> bds = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat df2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        synchronized (allPeople){
            switch (args[0]) {
                case "-c":
                    int k = 1;
                    while (!(args[k].equals(""))) {
                        names.add(args[k]);
                        sexes.add(args[k + 1]);
                        bds.add(df.parse(args[k + 2]));
                        k += 3;
                    }
                    Person person;
                    for (int i = 0; i < sexes.size(); i++) {
                        if (sexes.get(i).equals("м")) {
                            person = Person.createMale(names.get(i), bds.get(i));
                        } else {
                            person = Person.createFemale(names.get(i), bds.get(i));
                        }
                        allPeople.add(person);
                    }
                    System.out.println(allPeople.size() - 1);
                    break;
                case "-u":
                    break;
                case "-d":
                    break;
                case "-i":
                    break;
            }
        }
    }
}
