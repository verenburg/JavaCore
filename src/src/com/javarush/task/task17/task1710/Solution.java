package src.com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]){
            case "-c": {
                Person person;
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                Date date = df.parse(args[3]);
                if (args[2].equals("м")){
                    person = Person.createMale(args[1],date);
                } else {
                    person = Person.createFemale(args[1],date);
                }
                allPeople.add(person);
                System.out.println(allPeople.size()-1);
                break;
            }
            case "-r": {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " +
                        (person.getSex() == Sex.MALE ? "м" : "ж") + " " +
                                new SimpleDateFormat("dd-MMМ-yyyy").format(person.getBirthDate()));
                break;
            }
            case "-u": {
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                Date date = df.parse(args[4]);
                Person person;
                if (args[3].equals("м")){
                    person = Person.createMale(args[2],date);
                } else {
                    person = Person.createFemale(args[2],date);
                }
                allPeople.add(Integer.parseInt(args[1]),person);
                break;
            }
            case "-d": {
                Person person = Person.createMale(null,null);
                person.setSex(null);
                allPeople.add(Integer.parseInt(args[1]),person);
                break;
            }
        }
    }
}
