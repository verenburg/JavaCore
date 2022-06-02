package src.com.javarush.task.task20.task2002;

import com.javarush.task.task14.task1408.Country;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("E:\\Test\\shifr.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Иван");
            user1.setLastName("Петров");
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            Calendar bd = Calendar.getInstance();
            bd.set(1984, 6, 10);
            user1.setBirthDate(bd.getTime());

            User user2 = new User();
            user2.setFirstName("Петр");
            user2.setLastName("Федоров");
            user2.setMale(true);
            user2.setCountry(User.Country.RUSSIA);
            Calendar bd2 = Calendar.getInstance();
            bd2.set(1989, 8, 10);
            user2.setBirthDate(bd2.getTime());

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user: this.users) {
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(user.getCountry());
                writer.println(user.getBirthDate().getTime());
                writer.println(user.isMale());
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                String country = reader.readLine();
                if (country.equals("RUSSIA")) user.setCountry(User.Country.RUSSIA);
                if (country.equals("UKRAINE")) user.setCountry(User.Country.UKRAINE);
                if (country.equals("OTHER")) user.setCountry(User.Country.OTHER);
                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
