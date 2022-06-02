package src.com.javarush.task.task20.task2001;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("E:\\Test\\shifr.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            if (ivanov.hashCode() == somePerson.hashCode()) System.out.println("Хэшкод совпадает");
            else {
                System.out.println("Хэшкод не совпадает");
                System.out.println(somePerson.name);
                for(Asset a : somePerson.assets){
                    System.out.print(a.getName() + " ");
                    System.out.println(a.getPrice());
                }
            }

            if (ivanov.equals(somePerson)) System.out.println("Полное совпадение");
            else System.out.println("считанный объект не совпадает с записанным");


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }

    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(this.name);
            if (assets != null) {
                writer.println(("есть активы"));
                for (Asset asset : assets) {
                    writer.println(asset.getName() + " " + asset.getPrice());
                }
                writer.println("end");
            }
            else writer.write("нет активов");
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            String assets = reader.readLine();
            List<Asset> assets1 = new ArrayList<>();
            if (assets.equals("есть активы")) {
            String ass;
                while (!(ass = reader.readLine()).equals("end")){
                    String[] asss = ass.split(" ");
                    this.assets.add(new Asset(asss[0], Double.parseDouble(asss[1])));
                }
            } else assets1 = null;
            reader.close();
        }
    }
}
