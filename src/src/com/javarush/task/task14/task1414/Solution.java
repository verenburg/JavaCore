package src.com.javarush.task.task14.task1414;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String key;
        MovieFactory movieFactory =  new MovieFactory();
        Movie movie;
        while (true){
            key = reader.readLine();
            boolean usl = "soapOpera".equals(key) || "cartoon".equals(key) || "thriller".equals(key);
            if (!usl) break;
            movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
        }
        reader.close();
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
    static class Thriller extends Movie{

    }
    static class Cartoon extends Movie{

    }
}
