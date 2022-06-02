package src.com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 

Создай по аналогии AgathaChristieBook. Имя автора — [Agatha Christie].


*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output ="";
            if (this instanceof MarkTwainBook) output = markTwainOutput;
            if (this instanceof AgathaChristieBook) output = agathaChristieOutput;
            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {


        public String title;


        public MarkTwainBook(String title){
            super("Mark Twain");
            setTitle(title);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book {


        public String title;


        public AgathaChristieBook(String title){
            super("Agatha Christie");
            setTitle(title);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }
}
